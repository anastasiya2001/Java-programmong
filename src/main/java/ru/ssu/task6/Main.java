package ru.ssu.task6;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        FibonacciCalculator calculator = new FibonacciCalculator();
        int n = 10;
        long result = calculator.calculateFibonacci(n);
        System.out.println("Fibonacci number at index " + n + ": " + result);

        Counter counter = new Counter();
        counter.increment();
        System.out.println("Final Counter Value: " + counter.getCounter());

        Queue<FoodItem> queue = new LinkedList<>();
        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread1 = new Thread(consumer1);
        Thread consumerThread2 = new Thread(consumer2);

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();

        try {
            Thread.sleep(60); // Даем программе поработать некоторое время
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producer.stop();
        consumer1.stop();
        consumer2.stop();
    }
}