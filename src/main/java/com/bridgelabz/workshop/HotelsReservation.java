package com.bridgelabz.workshop;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class HotelsReservation {

    List<Hotels> hotels = new ArrayList<>();

    public HotelsReservation(){

    }

    public HotelsReservation(List<Hotels> hotels){
        this.hotels = hotels;
    }

    void add (Hotels hotels){
        this.hotels.add(hotels);
    }

    public List<Hotels> getHotels(){
        return hotels;
    }

    public void setHotels(List<Hotels> hotels){
        this.hotels = hotels;
    }

    public Map<Integer,Hotels> searchFor(String date1, String date2){
        int totalDays = countTotalDays(date1,date2);
        int weekDays = countWeekDays(date1,date2);
        int weekEndDays = totalDays-weekDays;
        return getCheapestHotels(weekDays,weekEndDays);
    }

    public Map<Integer,Hotels> getCheapestHotels(int weekDays,int weekEndDays){
        Map<Integer,Hotels> hotelsCost = new HashMap<>();
        Map<Integer,Hotels> sortHotelsCost = new HashMap<>();
        if(hotels.size() ==0)
            return null;
        this.hotels.stream().forEach(x -> hotelsCost.put(x.getRegularweekdayRate() + weekDays + x.getRegularweekendRate() + weekEndDays, x));
        Integer cheap = hotelsCost.keySet().stream().min(Integer::compare).get();
        hotelsCost.forEach((k,v) ->{
            if (k == cheap)
                sortHotelsCost.put(k, v);
        });
    return sortHotelsCost;
    }

    public int countTotalDays(String date1,String date2){
        LocalDate startDate = toLocalDate(date1);
        LocalDate endDate = toLocalDate(date2);
        int totalDays = Period.between(startDate,endDate).getDays() +1;
        return totalDays;
    }

    public int countWeekDays(String date1, String date2){
        LocalDate startDate = toLocalDate(date1);
        LocalDate endDate = toLocalDate(date2);

        DayOfWeek startDay = startDate.getDayOfWeek();
        DayOfWeek endDay = endDate.getDayOfWeek();

        long days = ChronoUnit.DAYS.between(startDate,endDate) +1;
        long daysWithoutWeekends = days - 2 * ((days + startDay.getValue() / 7));
        int totalWeekDays = (int) daysWithoutWeekends + (startDay == DayOfWeek.SUNDAY ? 1 : 0) + (endDay == DayOfWeek.SUNDAY ? 1 : 0);
        return totalWeekDays;
    }

    public LocalDate toLocalDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

}
