package ru.ssu.task6;

public class FoodItem {
    private final String name;
    private final int calories;

    public FoodItem(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public FoodItem generateFoodItem() {
        String foodName = foodNames[(int) (Math.random() * foodNames.length)];
        int calories = (int) (Math.random() * 100) + 50; // Генерируем случайное количество килокалорий
        return new FoodItem(foodName, calories);
    }
}
