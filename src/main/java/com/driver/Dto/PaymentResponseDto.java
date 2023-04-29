package com.driver.Dto;

public class PaymentResponseDto {

    private boolean paymentCompleted;

    private String paymentMode;

    ReservationResponseDto reservationResponseDto;

    public PaymentResponseDto() {
        this.paymentCompleted = paymentCompleted;
        this.paymentMode = paymentMode;
        this.reservationResponseDto = reservationResponseDto;
    }

    public boolean isPaymentCompleted() {
        return paymentCompleted;
    }

    public void setPaymentCompleted(boolean paymentCompleted) {
        this.paymentCompleted = paymentCompleted;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public ReservationResponseDto getReservationResponseDto() {
        return reservationResponseDto;
    }

    public void setReservationResponseDto(ReservationResponseDto reservationResponseDto) {
        this.reservationResponseDto = reservationResponseDto;
    }
}
