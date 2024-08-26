package com.dydko.composition.javatpoint;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@AllArgsConstructor
@Getter
public class University {

    private List<College> colleges;
}