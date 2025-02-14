package org.example.dataConvertation;


import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.TimeZone;

public class CalendarToTime {

    public static void main(String[] args) {

        variant1();
    }

    static void variant1() {
        // Инициализация календаря
        Calendar calendar = Calendar.getInstance(
                TimeZone.getTimeZone("Europe/Berlin"));
        //Приведение календаря к Instant
        Instant instant = calendar.toInstant();
        //Определяем часовой пояс
        ZoneId calendarZoneId = calendar.getTimeZone().toZoneId();
        //Приведение Instant к ZonedDateTime
        ZonedDateTime zonedDateTime = instant.atZone(calendarZoneId);

        System.out.println("Calendar: " + calendar.getTime());
        System.out.println("ZonedDateTime: " + zonedDateTime);
    }
}
