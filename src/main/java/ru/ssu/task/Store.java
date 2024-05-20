package ru.ssu.task;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Store {
    private final List<Product> products = new CopyOnWriteArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product buyProduct() {
        if (products.isEmpty()) {
            return null;
        }
        return products.remove(0);
    }
}
