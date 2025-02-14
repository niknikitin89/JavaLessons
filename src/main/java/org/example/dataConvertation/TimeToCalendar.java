package org.example.dataConvertation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeToCalendar {
    public static void main(String[] args) {

        variant1();
        variant2_1();
        variant2_2();
        variant2_3();
    }

    private static void variant1() {
        LocalDate localDate = LocalDate.now();
        Calendar calendar = new GregorianCalendar();
        //Наполняем календарь
        calendar.set(Calendar.YEAR, localDate.getYear());
        calendar.set(Calendar.MONTH, localDate.getMonthValue() - 1);
        calendar.set(Calendar.DAY_OF_MONTH, localDate.getDayOfMonth());

        System.out.println("LocalDate: " + localDate);
        System.out.println("Calendar: " + calendar.getTime());
    }

    private static void variant2_1() {
        //Текущая дата
        LocalDate localDate = LocalDate.now();
        // Текущий часовой пояс
        ZoneId myZoneId = ZoneId.systemDefault();
        //Генерим ZonedDateTime на начало дня в нужном часовом поясе
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(myZoneId);
        //Конвертируем в календарь
        Calendar calendar = GregorianCalendar.from(zonedDateTime);

        System.out.println("LocalDate: " + localDate);
        System.out.println("Calendar: " + calendar.getTime());
    }

    private static void variant2_2() {
        //Текущая дата
        LocalDate localDate = LocalDate.now();
        // Текущий часовой пояс
        ZoneId berlinZoneId = ZoneId.of("Europe/Berlin");
        //Генерим ZonedDateTime на начало дня в нужном часовом поясе
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(berlinZoneId);
        //Конвертируем в календарь
        Calendar calendar = GregorianCalendar.from(zonedDateTime);

        System.out.println("LocalDate: " + localDate);
        System.out.println("Calendar: " + calendar.getTime());
        System.out.println("ZoneId: " + calendar.getTimeZone().getID());
    }

    private static void variant2_3() {
        //Текущая дата
        LocalDateTime localDateTime = LocalDateTime.now();
        // Текущий часовой пояс
        ZoneId berlinZoneId = ZoneId.of("Europe/Berlin");
        //Генерим ZonedDateTime на начало дня в нужном часовом поясе
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, berlinZoneId);
        //Конвертируем в календарь
        Calendar calendar = GregorianCalendar.from(zonedDateTime);

        System.out.println("LocalDate: " + localDateTime);
        System.out.println("Calendar: " + calendar.getTime());
        System.out.println("ZoneId: " + calendar.getTimeZone().getID());
    }
}
