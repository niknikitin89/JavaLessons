package org.example;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class StringPerformance {

    private static final int NUM_STRINGS = 300000;

    public static void forString() {
        Instant start = Instant.now();
        String s = stringConcatenation();
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.printf("String - %dмс. %n",duration.toMillis());
    }
    
    public static void forBuilder() {
        Instant start = Instant.now();
        String s = builderConcatenation();
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.printf("StringBuilder - %dмс. %n",duration.toMillis());
    }

    private static String builderConcatenation() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < NUM_STRINGS; i++) {
            builder.append(getSubstring(i));
        }
        return builder.toString();
    }

    private static String getSubstring(int i) {
        return "[Подстрока "+ i +"]";
    }

    private static String stringConcatenation() {
        String string = "";
        for (int i = 0; i < NUM_STRINGS; i++) {
            string += getSubstring(i);
        }
        return string;
    }

}
