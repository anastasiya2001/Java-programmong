package ru.ssu.task6;

import java.util.Queue;

public class Consumer implements Runnable {
    private final Queue<FoodItem> queue;
    private int totalCalories = 0;
    private volatile boolean running = true;

    public Consumer(Queue<FoodItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (running) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                FoodItem foodItem = queue.poll();
                totalCalories += foodItem.getCalories();
                System.out.println("Consumed: " + foodItem.getName() + ", Total Calories: " + totalCalories);
            }
        }
    }

    public void stop() {
        running = false;
    }
}
