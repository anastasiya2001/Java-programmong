package main.java.ru.ssu.task;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Search {
    public void findSecondLargestAndThirdSmallest(int[] array) {
        if (array.length < 3) {
            System.out.println("������ �������� ����� ���� ���������");
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

        System.out.println("������ ���������� �����: " + secondLargest);
        System.out.println("������ ���������� �����: " + thirdSmallest);
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� ������������� �������� (����� ������):");
        int[] array = Stream.of(scanner.nextLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();

        findSecondLargestAndThirdSmallest(array);
    }

    public static void main(String[] args) {
        Search search = new Search();
        search.execute();
    }

}
