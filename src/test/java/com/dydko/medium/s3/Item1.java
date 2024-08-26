package com.dydko.medium.s3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class Item1 {

    private String name;
    private int qty;
    private BigDecimal price;
}