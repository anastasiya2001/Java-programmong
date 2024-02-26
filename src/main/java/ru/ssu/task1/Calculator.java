package main.java.ru.ssu.task1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Calculator {
     
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first big decimal number: ");
        String num1 = scanner.nextLine();
        BigDecimal bdNum1 = new BigDecimal(num1);

        System.out.println("Enter the second big decimal number: ");
        String num2 = scanner.nextLine();
        BigDecimal bdNum2 = new BigDecimal(num2);

        System.out.println("Enter the operation (ADD, SUB, MULT, DIV, REM, POW): ");
        String operation = scanner.nextLine();

        switch (operation) {
            case "ADD":
                System.out.println("Result: " + bdNum1.add(bdNum2));
                break;
            case "SUB":
                System.out.println("Result: " + bdNum1.subtract(bdNum2));
                break;
            case "MULT":
                System.out.println("Result: " + bdNum1.multiply(bdNum2));
                break;
            case "DIV":
                if (bdNum2.compareTo(BigDecimal.ZERO) != 0) {
                    System.out.println("Result: " + bdNum1.divide(bdNum2));
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;
            case "REM":
                if (bdNum2.compareTo(BigDecimal.ZERO) != 0) {
                    System.out.println("Result: " + bdNum1.remainder(bdNum2));
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;
            case "POW":
                System.out.println("Enter the integer power: ");
                int power = scanner.nextInt();
                System.out.println("Result: " + bdNum1.pow(power));
                break;
            default:
                System.out.println("Error: Invalid operation");
        }
    }
}
