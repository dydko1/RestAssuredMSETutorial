package com.dydko.programmingheadache;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Animal {

    private String name;
    private String type;
    private Double weight;
    private Double height;
}