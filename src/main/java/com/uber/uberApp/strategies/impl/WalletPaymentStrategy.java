package com.uber.uberApp.strategies.impl;

import com.uber.uberApp.entities.Driver;
import com.uber.uberApp.entities.Payment;
import com.uber.uberApp.entities.Rider;
import com.uber.uberApp.entities.enums.PaymentStatus;
import com.uber.uberApp.entities.enums.TransactionMethod;
import com.uber.uberApp.repositories.PaymentRepository;
import com.uber.uberApp.services.WalletService;
import com.uber.uberApp.strategies.PaymentStrategy;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// Rider -> 100%
//  Deduct 30% from wallet
@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {
    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(), payment.getAmount(), null, payment.getRide(), TransactionMethod.RIDE);
        double driverCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);
        walletService.addMoneyToWallet(driver.getUser(), driverCut, null, payment.getRide(), TransactionMethod.RIDE);


        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
