package ru.ssu.task6;

import java.util.Queue;

public class Producer implements Runnable {
    private final Queue<FoodItem> queue;
    private final String[] foodNames = { "Apple", "Banana", "Orange" };
    private volatile boolean running = true;

    public Producer(Queue<FoodItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (running) {
            FoodItem foodItem = generateFoodItem();
            synchronized (queue) {
                queue.add(foodItem);
                System.out.println("Produced: " + foodItem.getName() + " (" + foodItem.getCalories() + " calories)");
                queue.notifyAll();
            }
            try {
                Thread.sleep(1000); // Добавляем задержку для наглядности
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop() {
        running = false;
    }

    private FoodItem generateFoodItem() {
        String foodName = foodNames[(int) (Math.random() * foodNames.length)];
        int calories = (int) (Math.random() * 100) + 50; // Генерируем случайное количество килокалорий
        return new FoodItem(foodName, calories);
    }
}
