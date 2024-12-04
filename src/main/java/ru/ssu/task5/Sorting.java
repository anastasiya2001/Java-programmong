package main.java.ru.ssu.task5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Sorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();

        System.out.println("Введите данные в формате: ФИОВладельца названиеКомпании рейтингАкции");
        System.out.println("Для окончания ввода нажмите \"Enter\" дважды");

        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            input.add(line);
        }

        TreeSet<String> output = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] data1 = o1.split(" ");
                String[] data2 = o2.split(" ");
                
                int rating1 = Integer.parseInt(data1[data1.length - 1]);
                int rating2 = Integer.parseInt(data2[data2.length - 1]);
                
                if (rating1 != rating2) {
                    return Integer.compare(rating2, rating1);
                } else if (!data1[0].equals(data2[0])) {
                    return data1[0].compareTo(data2[0]);
                } else if (!data1[1].equals(data2[1])) {
                    return data2[1].compareTo(data1[1]);
                } else {
                    return data1[2].compareTo(data2[2]);
                }
            }
        });

        output.addAll(input);

        for (String line : output) {
            System.out.println(line);
        }
    }
}
