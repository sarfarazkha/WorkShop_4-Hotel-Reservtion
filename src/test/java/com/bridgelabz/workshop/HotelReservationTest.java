package com.bridgelabz.workshop;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HotelReservationTest {

    @Test
    public void whenGivenDateRangeShouldReturnCheapestHotels(){
        Hotels hotel1 = new Hotels("Lakewood", 110, 90, 80, 80, 3);
        Hotels hotel2 = new Hotels("Bridgewood", 160, 60, 110, 50, 4);
        Hotels hotel3 = new Hotels("Ridgewood", 220, 150, 100, 40, 5);

        HotelsReservation hotelsReservation = new HotelsReservation();
        hotelsReservation.add(hotel1);
        hotelsReservation.add(hotel2);
        hotelsReservation.add(hotel3);

        Map<Integer, Hotels> result = hotelsReservation.searchFor("23May2022", "31May2022");
        result.forEach((k, v) -> System.out.println(v.getHotelName() +" " + k));
        assertNotNull(result);
    }
}
