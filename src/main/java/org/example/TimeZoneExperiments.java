package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeZoneExperiments {

    public static void main(String[] args) {
        timeZoneChanging();
    }

    public static void timeZoneChanging() {

        Calendar time = new GregorianCalendar();
        //Задаем московское время
        time.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        time.set(Calendar.HOUR_OF_DAY, 11);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        //Выводим
        System.out.println("MSK");
        System.out.println(time.getTime());//дата + время
        System.out.println(time.getTimeInMillis());//миллисекунды
        System.out.println(time.getTimeZone().getID());//часовой пояс
        //Меняем часовой пояс
        time.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        //Выводим
        System.out.println("BER");
        System.out.println(time.getTime());
        System.out.println(time.getTimeInMillis());
        System.out.println(time.getTimeZone().getID());

    }

    public static void timeZoneChanging2() {

        Calendar time = new GregorianCalendar();
        //Задаем московское время
        time.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        time.set(Calendar.HOUR_OF_DAY, 11);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        //Выводим
        System.out.println("MSK");
        //System.out.println(time.getTime());//дата + время
        //System.out.println(time.getTimeInMillis());//миллисекунды
        //System.out.println(time.getTimeZone().getID());//часовой пояс

        //Меняем часовой пояс
        time.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        //Выводим
        System.out.println("BER");
        System.out.println(time.getTime());
        System.out.println(time.getTimeInMillis());
        System.out.println(time.getTimeZone().getID());
    }

    public static void timeZoneChanging3() {

        Calendar time = new GregorianCalendar();
        //Задаем московское время
        time.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        time.set(Calendar.HOUR_OF_DAY, 11);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        //Выводим
        System.out.println("MSK");
        System.out.println(time.get(Calendar.HOUR_OF_DAY));

        //Меняем часовой пояс
        time.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        //Выводим
        System.out.println("BER");
        System.out.println(time.getTime());
        System.out.println(time.getTimeInMillis());
        System.out.println(time.getTimeZone().getID());
    }

    public static void timeZoneChanging4() {

        Calendar time = new GregorianCalendar();
        //Задаем московское время
        time.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        time.set(Calendar.HOUR_OF_DAY, 11);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        //Выводим
        System.out.println("MSK");
        System.out.println(time.get(Calendar.HOUR_OF_DAY));
        System.out.println(time.getTimeInMillis());

        //Меняем часовой пояс
        time.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        //Выводим
        System.out.println("BER");
        System.out.println(time.getTime());
        System.out.println(time.getTimeInMillis());
        System.out.println(time.getTimeZone().getID());
        //Поменяем время
        time.set(Calendar.HOUR_OF_DAY, 11);
        System.out.println("BER v2");
        System.out.println(time.getTime());
        System.out.println(time.getTimeInMillis());
        System.out.println(time.getTimeZone().getID());

    }

    public static void dateFormating() {

        //Задаем московское время
        Calendar time = new GregorianCalendar(
                2025, Calendar.JANUARY, 20,
                11, 0, 0);
        //Задаем формат времени
        TimeZone myTZ = time.getTimeZone();
        DateFormat format = new SimpleDateFormat(
                "dd.MM.yyyy HH:mm:ss Z");
        format.setTimeZone(myTZ);
        //Выводим
        System.out.println("My TimeZone");
        System.out.println(format.format(time.getTime()));
        //Меняем часовой пояс
        TimeZone berlinTZ =
                TimeZone.getTimeZone("Europe/Berlin");
        format.setTimeZone(berlinTZ);
        //Выводим
        System.out.println("BER");
        System.out.println(format.format(time.getTime()));

    }

    public static void parsingDate() throws ParseException {

        String berlinTimeStr = "20.01.2025 11:00:00";

        DateFormat format = new SimpleDateFormat(
                "dd.MM.yyyy HH:mm:ss");
        Date time = format.parse(berlinTimeStr);

        TimeZone berlinTZ =
                TimeZone.getTimeZone("Europe/Berlin");
        TimeZone moscowTZ =
                TimeZone.getTimeZone("Europe/Moscow");

        format.setTimeZone(berlinTZ);
        System.out.println("Berlin: " + format.format(time));
        format.setTimeZone(moscowTZ);
        System.out.println("Moscow: " + format.format(time));

    }
}