package com.dydko.composition.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class GFGLibrary {
    public static void main(String[] args) {

        List<Book> books = new ArrayList<>(List.of(
                new Book("EffectiveJ Java", "Joshua Bloch"),
                new Book("Java: The Complete Reference", "Herbert Schildt")));
        Library library = new Library(books);

        library
                .getBooks()
                .forEach(s -> System.out.println(s.getAuthor() + "\t" + s.getTitle()));
    }
}
