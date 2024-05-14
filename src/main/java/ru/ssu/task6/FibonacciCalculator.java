package ru.ssu.task6;

import java.util.concurrent.*;

public class FibonacciCalculator {
    private ForkJoinPool pool;

    public FibonacciCalculator() {
        this.pool = new ForkJoinPool();
    }

    public long calculateFibonacci(int n) {
        return pool.invoke(new FibonacciTask(n));
    }
}
