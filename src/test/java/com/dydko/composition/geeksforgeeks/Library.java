package com.dydko.composition.geeksforgeeks;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Library {

    private final List<Book> books;
}
