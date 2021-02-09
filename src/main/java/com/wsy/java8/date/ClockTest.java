package com.wsy.java8.date;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

public class ClockTest {

    public static void main(String [] args) {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        long millis2 = System.currentTimeMillis();

        Instant instant = clock.instant();
        Date date = Date.from(instant);

        System.out.println(date);
        System.out.println(instant);
        System.out.println(millis);
        System.out.println(millis2);


    }

}
