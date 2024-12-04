package ru.ssu.task;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeIncrement {
    private int var1 = 0;
    private int var2 = 0;
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void incrementTask1() {
        for (int i = 0; i < 1000000; i++) {
            lock1.lock();
            try {
                var1++;
            } finally {
                lock1.unlock();
            }
        }
        for (int i = 0; i < 1000000; i++) {
            lock2.lock();
            try {
                var2++;
            } finally {
                lock2.unlock();
            }
        }
    }

    public void incrementTask2() {
        for (int i = 0; i < 1000000; i++) {
            lock2.lock();
            try {
                var2++;
            } finally {
                lock2.unlock();
            }
        }
        for (int i = 0; i < 1000000; i++) {
            lock1.lock();
            try {
                var1++;
            } finally {
                lock1.unlock();
            }
        }
    }

    public int getVar1() {
        return var1;
    }

    public int getVar2() {
        return var2;
    }
}
