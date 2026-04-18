package com.uber.uberApp.services;

import com.uber.uberApp.entities.Payment;
import com.uber.uberApp.entities.Ride;
import com.uber.uberApp.entities.enums.PaymentStatus;

public interface PaymentService {
    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    Payment updatePaymentStatus(Payment payment, PaymentStatus paymentStatus);
}
