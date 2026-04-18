package com.uber.uberApp.services;

import com.uber.uberApp.entities.WalletTransaction;


public interface WalletTransactionService {
    void createNewWalletTransaction(WalletTransaction walletTransaction);
}
