package com.dydko.winterbe.stream1;

import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParallelStream {
    private static final int MAX = 1000000;

    public static void main(String[] args) {
        List<String> val1 = new ArrayList<>(MAX);

        for (int i = 0; i < MAX; i++) {
            UUID uuid = UUID.randomUUID();
            val1.add(uuid.toString());
        }

        long t0 = System.nanoTime();
        long val2 = val1.parallelStream().sorted().count();
        long t1 = System.nanoTime();

        Duration millisec =  Duration.ofNanos(t1-t0);

        System.out.println(String.format("Tu był Miro: %s, %2$s", millisec, val2));
        //val1.forEach(System.out::println);
        //val1.stream().filter((s1,s2)->s1.contains(s2)).forEach(System.out::println);
    }
}