package com.dydko.winterbe.stream1;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

public class Time1 {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);   // legacy java.util.Date

        System.out.println(legacyDate);
    }
}