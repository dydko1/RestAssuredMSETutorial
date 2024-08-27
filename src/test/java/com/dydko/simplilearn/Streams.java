package com.dydko.simplilearn;

import java.io.IOException;

import java.io.PrintWriter;

import java.nio.file.Files;

import java.nio.file.Paths;

import java.util.stream.Stream;

class Streams {

    public static void main(String args[]) throws IOException {

        String[] message = {"Welcome", "to", "Simplilearn"};

        try (PrintWriter pw = new PrintWriter(

                Files.newBufferedWriter(Paths.get("hello.txt"))

        )) {

            Stream.of(message).forEach(pw::println);

        }

    }

}