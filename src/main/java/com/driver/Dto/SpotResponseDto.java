package com.driver.Dto;

import com.driver.model.Enums.SpotType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class SpotResponseDto {

    private int pricePerHour;

    private Boolean occupied;

    private int numberOfWheels;

    ParkingLotResponseDto parkingLotResponseDto;

    public SpotResponseDto() {
        this.numberOfWheels = numberOfWheels;
        this.pricePerHour = pricePerHour;
        this.occupied = occupied;
        this.parkingLotResponseDto = parkingLotResponseDto;
    }



    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public ParkingLotResponseDto getParkingLotResponseDto() {
        return parkingLotResponseDto;
    }

    public void setParkingLotResponseDto(ParkingLotResponseDto parkingLotResponseDto) {
        this.parkingLotResponseDto = parkingLotResponseDto;
    }
}
