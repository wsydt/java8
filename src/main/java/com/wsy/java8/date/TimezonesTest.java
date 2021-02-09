package com.wsy.java8.date;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class TimezonesTest {

    public static void main(String[] args) {
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zoneId1 = ZoneId.of("Europe/Berlin");
        ZoneId zoneId2 = ZoneId.of("Asia/Kuala_Lumpur");

        System.out.println(zoneId1.getRules());
        System.out.println(zoneId2.getRules());

        LocalTime localTime1 = LocalTime.now(zoneId1);
        LocalTime localTime2 = LocalTime.now(zoneId2);

        System.out.println(localTime2.isBefore(localTime1));

        long hoursBetween = ChronoUnit.HOURS.between(localTime1, localTime2);
        long minutesBetween = ChronoUnit.MINUTES.between(localTime1, localTime2);

        System.out.println(" LocalTime until method:  " + localTime1.until(localTime2, ChronoUnit.HOURS));

        System.out.println(hoursBetween);
        System.out.println(minutesBetween);


        LocalTime localTime3 = LocalTime.of(23, 59,59);
        System.out.println(localTime3);
        System.out.println(localTime2);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.CHINESE);
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");

        LocalTime localTime4 = LocalTime.parse("2020-01-01 01:59:45 上午", dateTimeFormatter2);
        System.out.println(localTime4);



    }

}
