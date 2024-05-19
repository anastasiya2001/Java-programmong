package ru.ssu.task6;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BuyerGenerator {
    private long buyerIdCounter = 0;
    private final Store store;
    private final int buyersPerInterval;
    private final int intervalSeconds;

    public BuyerGenerator(Store store, int buyersPerInterval, int intervalSeconds) {
        this.store = store;
        this.buyersPerInterval = buyersPerInterval;
        this.intervalSeconds = intervalSeconds;
    }

    public void start() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            for (int i = 0; i < buyersPerInterval; i++) {
                long id = getNextBuyerId();
                new Thread(new Buyer(id, store)).start();
            }
        }, 0, intervalSeconds, TimeUnit.SECONDS);
    }

    private synchronized long getNextBuyerId() {
        return buyerIdCounter++;
    }
}
