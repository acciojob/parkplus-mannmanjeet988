package com.driver.services;

import com.driver.Dto.PaymentResponseDto;
import com.driver.model.Payment;

public interface PaymentService {
    PaymentResponseDto pay(Integer reservationId, int amountSent, String mode) throws Exception;
}
