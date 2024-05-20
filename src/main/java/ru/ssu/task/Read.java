package main.java.ru.ssu.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Read {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filename = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator + filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 3) {
                    String initials = parts[1] + " " + parts[0].charAt(0) + "." + parts[2].charAt(0) + ".";
                    System.out.println(parts[1]);
                    System.out.println(initials);
                }
            }
        } catch (IOException e) {
            System.out.println("Еrror reading file: " + e.getMessage());
        }
    }
}
