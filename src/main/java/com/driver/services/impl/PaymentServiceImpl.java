package com.driver.services.impl;

import com.driver.model.Enums.PaymentMode;
import com.driver.model.Payment;
import com.driver.model.Reservation;
import com.driver.model.Spot;
import com.driver.repository.PaymentRepository;
import com.driver.repository.ReservationRepository;
import com.driver.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    ReservationRepository reservationRepository2;
    @Autowired
    PaymentRepository paymentRepository2;

    @Override
    public Payment pay(Integer reservationId, int amountSent, String mode) throws Exception {
        Payment payment = new Payment();

        Reservation reservation = reservationRepository2.findById(reservationId).get();
        int bill = (reservation.getSpot().getPricePerHour()) * (reservation.getTimeInHours()) ;

        if (bill > amountSent) {
            throw new Exception("Insufficient Amount");
        }
        if((payment.getPaymentMode().toString() != mode) ) {
            throw new Exception("Payment mode not detected");
        }

        payment.setPaymentCompleted(true);
        payment.setPaymentMode(PaymentMode.CARD);
        payment.setReservation(reservation);

        return  payment;
    }
}
