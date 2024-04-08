
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RecursiveTask;

class SharedResource {
    static int count = 0;
}

class Incrementer implements Runnable {
    public void run() {
        for (int i = 0; i < 100000; i++) {
            synchronized (SharedResource.class) {
                SharedResource.count++;
            }
        }
    }
}

public class Streams {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Incrementer incrementer1 = new Incrementer();
        Incrementer incrementer2 = new Incrementer();

        // Создаем исполнитель для вычисления числа Фибоначчи
        ForkJoinPool pool = ForkJoinPool.commonPool();
        int n = Integer.parseInt(args[0]); // Число N передается через аргументы командной строки
        FibonacciTask task = new FibonacciTask(n);

        // Запускаем потоки инкрементации и вычисление числа Фибоначчи
        Thread thread1 = new Thread(incrementer1);
        Thread thread2 = new Thread(incrementer2);
        Future<Integer> fibonacciFuture = pool.submit(task);
        
        thread1.start();
        thread2.start();

        // Ожидаем завершения работы потоков инкрементации и вычисления числа Фибоначчи
        thread1.join();
        thread2.join();
        int fibonacci = fibonacciFuture.get();

        // Выводим результаты
        System.out.println("Final count: " + SharedResource.count);
        System.out.println("Fibonacci number " + n + ": " + fibonacci);

        // Создаем продюсера, очередь и потребителей
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Producer producer = new Producer(queue, "Apple", 100);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);

        // Запускаем продюсера и потребителей
        Thread producerThread = new Thread(producer);
        Thread consumerThread1 = new Thread(consumer1);
        Thread consumerThread2 = new Thread(consumer2);

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}

class FibonacciTask extends RecursiveTask<Integer> {
    private final int n;

    FibonacciTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1)
            return n;
        FibonacciTask f1 = new FibonacciTask(n - 1);
        f1.fork();
        FibonacciTask f2 = new FibonacciTask(n - 2);
        return f2.compute() + f1.join();
    }
}

class Producer implements Runnable {
    private final BlockingQueue<String> queue;
    private final String food;
    private final int calories;

    Producer(BlockingQueue<String> queue, String food, int calories) {
        this.queue = queue;
        this.food = food;
        this.calories = calories;
    }

    @Override
    public void run() {
        try {
            queue.put(food + " (" + calories + " kcal)");
            System.out.println("Producer produced: " + food + " (" + calories + " kcal)");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<String> queue;
    private int totalCalories = 0;

    Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String food = queue.take();
                int calories = Integer.parseInt(food.substring(food.lastIndexOf("(") + 1, food.lastIndexOf(" kcal)")));
                totalCalories += calories;
                System.out.println("Consumer consumed: " + food + ", Total calories: " + totalCalories);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
