package com.dydko.medium.s4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private int age;
    private List<String> phoneNumbers;
    private boolean active;
    private List<String> addresses;
}