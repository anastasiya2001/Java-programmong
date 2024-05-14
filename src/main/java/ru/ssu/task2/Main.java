package ru.ssu.task2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IBird> list = new ArrayList<>();
        list.add(new Eagle(0.6f, 2, new Location("Baikal")));
        list.add(new Owl(0.3f, 5, new Location("Murom")));

        for (IBird bird : list) {
            System.out.println(bird.toString());
            bird.Hunt();
            bird.Tweet();
            System.err.println("----------------------------");
        }
    }
}
