package com.driver.services.impl;

import com.driver.Dto.ReservationResponseDto;
import com.driver.model.*;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.ReservationRepository;
import com.driver.repository.SpotRepository;
import com.driver.repository.UserRepository;
import com.driver.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    UserRepository userRepository3;
    @Autowired
    SpotRepository spotRepository3;
    @Autowired
    ReservationRepository reservationRepository3;
    @Autowired
    ParkingLotRepository parkingLotRepository3;
    @Override
    public ReservationResponseDto reserveSpot(Integer userId, Integer parkingLotId, Integer timeInHours, Integer numberOfWheels) throws Exception {
    Reservation reservation = new Reservation();
        ReservationResponseDto reservationResponseDto = new ReservationResponseDto();

//    ParkingLot parkingLot;
//    User user;
        Spot finalSpot;
        int minTotalPrice = Integer.MAX_VALUE;
    if((parkingLotRepository3.findById(parkingLotId).get() != null)  &&  (userRepository3.findById(userId).get() != null)  )
    {
        ParkingLot parkingLot = parkingLotRepository3.findById(parkingLotId).get();
        User user = userRepository3.findById(userId).get();
        List<Spot> spotList =  parkingLot.getSpotList();
        int totalPrice;
        for(Spot spot : spotList){
           if(spot.getNumberOfWheels() >= numberOfWheels){
                minTotalPrice = Math.min((spot.getPricePerHour()*timeInHours),minTotalPrice);
                finalSpot=spot;
               reservation.setSpot(finalSpot);
           }
        }
        reservation.setTimeInHours(timeInHours);
        reservation.setUser(user);
        reservationRepository3.save(reservation);

        // prepare reservation response dto
        reservationResponseDto.setTimeInHours(reservation.getTimeInHours());
        reservationResponseDto.setSpotId(reservation.getSpot().getId());
        reservationResponseDto.setUserName(reservation.getUser().getName());
        reservationResponseDto.setParkingLotId(reservation.getSpot().getParkingLot().getId());

    }

    else {
        throw new Exception("Cannot make reservation");
    }

    return reservationResponseDto;
    }
}
