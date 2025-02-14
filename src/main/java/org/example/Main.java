package org.example;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {

            byte[] bytes = new byte[3];
            bytes[0] = 97;
            bytes[1] = 98;
            bytes[2] = 99;
            System.out.println("Байты: " + Arrays.toString(bytes));

            String str = new String(bytes, "UTF-8");
            System.out.println("Строка: " + str);

            byte[] bytes2 = str.getBytes("UTF-8");
            System.out.println("Байты снова: " + Arrays.toString(bytes2));


        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }


    }

}
