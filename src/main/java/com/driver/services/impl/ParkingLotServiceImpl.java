package com.driver.services.impl;

import com.driver.Dto.ParkingLotResponseDto;
import com.driver.Dto.SpotResponseDto;
import com.driver.model.Enums.SpotType;
import com.driver.model.ParkingLot;
import com.driver.model.Spot;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.SpotRepository;
import com.driver.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    ParkingLotRepository parkingLotRepository1;
    @Autowired
    SpotRepository spotRepository1;
    @Override
    public ParkingLot addParkingLot(String name, String address) {
        ParkingLot parkingLot = new ParkingLot();
       // parkingLot.setId(1);
        parkingLot.setName(name);
        parkingLot.setAddress(address);

        return parkingLotRepository1.save(parkingLot);
    }

    @Override
    public SpotResponseDto addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour) {
//       Spot spot = new Spot();
//
//       spot.setOccupied(false);
//       spot.setSpotType(SpotType.TWO_WHEELER);
//       spot.setNumberOfWheels(2);
//       spot.setPricePerHour(100);
//       ParkingLot parkingLot = parkingLotRepository1.findById(parkingLotId).get();
//        parkingLot.getSpotList().add(spot);
//
//        spot.setParkingLot(parkingLot);
//        parkingLotRepository1.save(parkingLot);
//        //spotRepository1.save(spot);
//       return spot;

       SpotResponseDto spotResponseDto = new SpotResponseDto();
        spotResponseDto.setOccupied(false);
        spotResponseDto.setNumberOfWheels(numberOfWheels);
        spotResponseDto.setPricePerHour(pricePerHour);

        ParkingLotResponseDto parkingLotResponseDto = new ParkingLotResponseDto();

        Spot spot = new Spot();
        spot.setOccupied(spotResponseDto.getOccupied());
        spot.setNumberOfWheels(spotResponseDto.getNumberOfWheels());
        spot.setPricePerHour(spotResponseDto.getPricePerHour());

        ParkingLot parkingLot = parkingLotRepository1.findById(parkingLotId).get();
        parkingLot.getSpotList().add(spot);

        spot.setParkingLot(parkingLot);
        parkingLotRepository1.save(parkingLot);

        parkingLotResponseDto.setName(parkingLot.getName());
        parkingLotResponseDto.setAddress(parkingLot.getAddress());
        spotResponseDto.setParkingLotResponseDto(parkingLotResponseDto);

        //spotRepository1.save(spot);
       return spotResponseDto;
    }

    @Override
    public void deleteSpot(int spotId) {
            spotRepository1.deleteById(spotId);
    }

    @Override
    public SpotResponseDto updateSpot(int parkingLotId, int spotId, int pricePerHour,boolean occupied, int numberOfWheels) {

        ParkingLot parkingLot = parkingLotRepository1.findById(parkingLotId).get();
        Spot spot = parkingLot.getSpotList().get(spotId);
        spot.setPricePerHour(pricePerHour);
        spot.setOccupied(occupied);
        spot.setNumberOfWheels(numberOfWheels);
        Spot updatedSpot = spotRepository1.save(spot);

        SpotResponseDto spotResponseDto = new SpotResponseDto();
        spotResponseDto.setPricePerHour(spot.getPricePerHour());
        spotResponseDto.setOccupied(spot.getOccupied());
        spotResponseDto.setNumberOfWheels(spot.getNumberOfWheels());
        return spotResponseDto;
    }

    @Override
    public void deleteParkingLot(int parkingLotId) {
      parkingLotRepository1.deleteById(parkingLotId);
    }
}
