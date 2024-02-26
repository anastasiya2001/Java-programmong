package main.java.ru.ssu.task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Search {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целочисленные значения (через пробел):");
        int[] array = Stream.of(scanner.nextLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();

        findSecondLargestAndThirdSmallest(array);
    }

    public static void findSecondLargestAndThirdSmallest(int[] array) {
        if (array.length < 3) {
            System.out.println("Массив содержит менее трех элементов");
            return;
        }

        int secondLargest = Arrays.stream(array)
                                  .boxed()
                                  .sorted(Comparator.reverseOrder())
                                  .distinct()
                                  .skip(1)
                                  .findFirst()
                                  .orElse(array[0]);

        int thirdSmallest = Arrays.stream(array)
                                  .boxed()
                                  .sorted()
                                  .distinct()
                                  .skip(2)
                                  .findFirst()
                                  .orElse(array[0]);

        System.out.println("Второе наибольшее число: " + secondLargest);
        System.out.println("Третье наименьшее число: " + thirdSmallest);
    }
}
