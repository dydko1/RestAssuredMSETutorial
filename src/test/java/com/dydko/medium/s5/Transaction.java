package com.dydko.medium.s5;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
class Transaction {

    private String id;
    private double amount;
    private Date date;
}