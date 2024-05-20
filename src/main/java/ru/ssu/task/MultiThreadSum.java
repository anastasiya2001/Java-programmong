package ru.ssu.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class MultiThreadSum {
    private final int[] array;
    private final int numThreads;

    public MultiThreadSum(int[] array, int numThreads) {
        this.array = array;
        this.numThreads = numThreads;
    }

    @SuppressWarnings("unchecked")
    public long computeSum() {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        Future<Long>[] futures = new Future[numThreads];
        int chunkSize = array.length / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? array.length : start + chunkSize;
            futures[i] = executor.submit(new SumTask(array, start, end));
        }

        long totalSum = 0;
        try {
            for (Future<Long> future : futures) {
                totalSum += future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        return totalSum;
    }
}
