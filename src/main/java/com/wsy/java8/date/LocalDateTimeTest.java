package com.wsy.java8.date;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

public class LocalDateTimeTest {

    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        LocalDateTime sylvester = LocalDateTime.of(2019, Month.JUNE, 29, 16, 0, 0);
        DayOfWeek dayOfWeek = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek);

        Month month = sylvester.getMonth();
        System.out.println(month);

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);

        Instant instant = sylvester.atZone(ZoneId.systemDefault()).toInstant();
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM yyyy dd  mm-ss-HH");
        LocalDateTime formatterDateTime = LocalDateTime.parse("06 2019 29  10-00-16", dateTimeFormatter);
        System.out.println(formatterDateTime);
    }

}
