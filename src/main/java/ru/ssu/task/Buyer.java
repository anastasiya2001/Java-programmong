package ru.ssu.task;

public class Buyer implements Runnable {
    private final long id;
    private final Store store;
    private double totalSpent;

    public Buyer(long id, Store store) {
        this.id = id;
        this.store = store;
        this.totalSpent = 0;
    }

    @Override
    public void run() {
        Product product = store.buyProduct();
        if (product != null) {
            totalSpent += product.getPrice();
            System.out.printf("Buyer%d %s %.2f %.2f%n", id, product.getName(), product.getPrice(), totalSpent);
        }
    }
}
