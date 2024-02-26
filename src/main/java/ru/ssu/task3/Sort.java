package main.java.ru.ssu.task3;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целочисленные значения (через пробел):");
        Stream<Integer> stream = Stream.of(scanner.nextLine().split(" ")).map(Integer::parseInt);

        filterStream(stream);
    }

    public static void filterStream(Stream<Integer> stream) {
        stream.filter(n -> n % 2 == 0 && n > 10)
                .forEach(System.out::println);
    }
}
