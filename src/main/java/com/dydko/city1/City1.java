package com.dydko.city1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City1 {

    private String name;
    private double temperature;

    @Override
    public String toString() {
        return getName() + " ---> " + getTemperature();
    }
}