package main.java.ru.ssu.task4;

import java.time.LocalDate;
import java.util.Scanner;

public class FirstDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите даты в формате\"год месяц день\"");
        System.out.println("Дата начала:");
        String[] start = scanner.nextLine().split(" ");
        System.out.println("Дата конца:");
        String[] end = scanner.nextLine().split(" ");

        LocalDate startDate = LocalDate.of(Integer.parseInt(start[0]), Integer.parseInt(start[1]), Integer.parseInt(start[2]));
        LocalDate endDate = LocalDate.of(Integer.parseInt(end[0]), Integer.parseInt(end[1]), Integer.parseInt(end[2]));

        long days = startDate.until(endDate).getDays();

        System.out.println("Прошло дней: " + days);
    }
}
