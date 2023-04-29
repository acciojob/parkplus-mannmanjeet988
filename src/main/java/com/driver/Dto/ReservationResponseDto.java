package com.driver.Dto;

public class ReservationResponseDto {

   private  int timeInHours;

    private String userName;

   private  int spotId;

   private int parkingLotId;

    public ReservationResponseDto(){

    }

    public ReservationResponseDto(int timeInHours, String userName, int spotId, int parkingLotId) {
        this.timeInHours = timeInHours;
        this.userName = userName;
        this.spotId = spotId;
        this.parkingLotId = parkingLotId;
    }

    public int getTimeInHours() {
        return timeInHours;
    }

    public void setTimeInHours(int timeInHours) {
        this.timeInHours = timeInHours;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
