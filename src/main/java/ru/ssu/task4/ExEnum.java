package main.java.ru.ssu.task4;

import java.util.Random;

public class ExEnum {
    public static void main(String[] args) {
        Random random = new Random();

        // StringBuilder
        long startTimeStringBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append(generateRandomString(random, 10));
        }
        String stringBuilderResult = stringBuilder.toString();
        long endTimeStringBuilder = System.nanoTime();
        long durationStringBuilder = (endTimeStringBuilder - startTimeStringBuilder) / 1000000; // Время в миллисекундах
        System.out.println("Time taken by StringBuilder: " + durationStringBuilder + " milliseconds");

        // StringBuffer
        long startTimeStringBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            stringBuffer.append(generateRandomString(random, 10));
        }
        String stringBufferResult = stringBuffer.toString();
        long endTimeStringBuffer = System.nanoTime();
        long durationStringBuffer = (endTimeStringBuffer - startTimeStringBuffer) / 1000000; // Время в миллисекундах
        System.out.println("Time taken by StringBuffer: " + durationStringBuffer + " milliseconds");

        // String
        long startTimeString = System.nanoTime();
        String result = "";
        for (int i = 0; i < 100000; i++) {
            result += generateRandomString(random, 10);
        }
        long endTimeString = System.nanoTime();
        long durationString = (endTimeString - startTimeString) / 1000000; // Время в миллисекундах
        System.out.println("Time taken by String: " + durationString + " milliseconds");
    }

    public static String generateRandomString(Random random, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) (random.nextInt(26) + 'a'));
        }
        return sb.toString();
    }
}
