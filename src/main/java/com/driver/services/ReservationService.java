package com.driver.services;

import com.driver.Dto.ReservationResponseDto;
import com.driver.model.Reservation;

public interface ReservationService {
    ReservationResponseDto reserveSpot(Integer userId, Integer parkingLotId, Integer timeInHours, Integer numberOfWheels) throws Exception;
}
