package com.dydko.medium.s5;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class TransactionRepository {

    public static List<Transaction> generateDummyTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("T1", 120.50, new Date()));
        transactions.add(new Transaction("T2", 75.20, new Date()));
        transactions.add(new Transaction("T3", 150.0, new Date()));
        transactions.add(new Transaction("T4", 200.75, new Date()));
        //transactions.add(new Transaction("T5", 20.75, new Date()));
        return transactions;
    }
}
