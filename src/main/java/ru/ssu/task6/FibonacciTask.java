package ru.ssu.task6;

import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Long> {
    private final int n;

    public FibonacciTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n <= 1)
            return (long) n;
        FibonacciTask task1 = new FibonacciTask(n - 1);
        task1.fork();
        FibonacciTask task2 = new FibonacciTask(n - 2);
        return task2.compute() + task1.join();
    }
}
