package ru.ssu.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.task1();
        System.out.println("--------------------");
        main.task2();
        System.out.println("--------------------");
        main.task3();
    }

    public void task1() {
        SafeIncrement safeIncrement = new SafeIncrement();
        Thread thread1 = new Thread(safeIncrement::incrementTask1);
        Thread thread2 = new Thread(safeIncrement::incrementTask2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final values for Task 1: var1 = " + safeIncrement.getVar1() + ", var2 = " + safeIncrement.getVar2());
    }

    public void task2() {
        int[] array = new int[100000];
        // Инициализируем массив последовательными числами
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        int numThreads = 4;
        MultiThreadSum multiThreadSum = new MultiThreadSum(array, numThreads);
        long totalSum = multiThreadSum.computeSum();
        System.out.println("Total Sum for Task 2: " + totalSum);
    }

    public void task3() {
        Store store = new Store();

        // Добавляем товары на витрину
        store.addProduct(new Product("Apple", 1.20));
        store.addProduct(new Product("Banana", 0.80));
        store.addProduct(new Product("Orange", 1.50));
        store.addProduct(new Product("Grapes", 2.00));
        store.addProduct(new Product("Watermelon", 3.50));

        // Периодически создаем покупателей
        int M = 5; // Время в секундах между заходами покупателей
        int N = 3; // Количество покупателей, заходящих разом

        BuyerGenerator buyerGenerator = new BuyerGenerator(store, N, M);
        buyerGenerator.start();
    }
}
