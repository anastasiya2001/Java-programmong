package main.java.ru.ssu.task4;

import java.util.HashMap;
import java.util.Scanner;

public class SecondDate {
    public static void main(String[] args) {
        HashMap<String, Integer> daysOfWeek = new HashMap<>();
        daysOfWeek.put("sunday", 0);
        daysOfWeek.put("monday", 1);
        daysOfWeek.put("tuesday", 2);
        daysOfWeek.put("wednesday", 3);
        daysOfWeek.put("thursday", 4);
        daysOfWeek.put("friday", 5);
        daysOfWeek.put("saturday", 6);

        Scanner input = new Scanner(System.in);
        System.out.println("Введите название дня недели и количество дней");
        String currentDay = input.next().toLowerCase();
        int daysToAdd = input.nextInt();

        int currentDayIndex = daysOfWeek.get(currentDay);
        int resultIndex = (currentDayIndex + daysToAdd) % 7;

        for (String day : daysOfWeek.keySet()) {
            if (daysOfWeek.get(day) == resultIndex) {
                System.out.println(day);
                break;
            }
        }
    }
}
