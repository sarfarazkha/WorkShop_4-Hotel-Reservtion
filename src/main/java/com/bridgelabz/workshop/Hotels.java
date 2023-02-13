package com.bridgelabz.workshop;

public class Hotels {
    private String hotelName;
    private int regularweekdayRate;
    private int regularweekendRate;
    private int rewardWeekdayRate;
    private int rewardWeekendRate;
    private int ratings;

    Hotels(){

    }

    public Hotels(String hotelName, int regularweekdayRate, int regularweekendRate, int rewardWeekdayRate, int rewardWeekendRate, int ratings) {
        this.hotelName = hotelName;
        this.regularweekdayRate = regularweekdayRate;
        this.regularweekendRate = regularweekendRate;
        this.rewardWeekdayRate = rewardWeekdayRate;
        this.rewardWeekendRate = rewardWeekendRate;
        this.ratings = ratings;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRegularweekdayRate() {
        return regularweekdayRate;
    }

    public void setRegularweekdayRate(int regularweekdayRate) {
        this.regularweekdayRate = regularweekdayRate;
    }

    public int getRegularweekendRate() {
        return regularweekendRate;
    }

    public void setRegularweekendRate(int regularweekendRate) {
        this.regularweekendRate = regularweekendRate;
    }

    public int getRewardWeekdayRate() {
        return rewardWeekdayRate;
    }

    public void setRewardWeekdayRate(int rewardWeekdayRate) {
        this.rewardWeekdayRate = rewardWeekdayRate;
    }

    public int getRewardWeekendRate() {
        return rewardWeekendRate;
    }

    public void setRewardWeekendRate(int rewardWeekendRate) {
        this.rewardWeekendRate = rewardWeekendRate;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
}
