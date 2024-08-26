package com.dydko.howtodoinjava.a;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Car {

  String model;
  String fuel;
  Integer capacity;
}