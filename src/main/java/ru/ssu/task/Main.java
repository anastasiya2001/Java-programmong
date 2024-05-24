package ru.ssu.task;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IBird> list = new ArrayList<>();

        Eagle originalEagle = new Eagle(5.7f, 3, new Location("Mountains"));
        Eagle shallowCopyEagle = originalEagle.shallowCopy();
        Eagle deepCopyEagle = originalEagle.deepCopy();

        Owl originalOwl = new Owl(1.2f, 5, new Location("Forest"));
        Owl shallowCopyOwl = originalOwl.shallowCopy();
        Owl deepCopyOwl = originalOwl.deepCopy();

        list.add(originalEagle);
        list.add(shallowCopyEagle);
        list.add(deepCopyEagle);
        list.add(originalOwl);
        list.add(shallowCopyOwl);
        list.add(deepCopyOwl);

        list.add(new Eagle(0.6f, 2, new Location("Baikal")));
        list.add(new Owl(0.3f, 5, new Location("Murom")));

        System.out.println("Хешкод оригинального орла: " + originalEagle.hashCode());
        System.out.println("Хешкод неглубокой копии орла: " + shallowCopyEagle.hashCode());
        System.out.println("Хешкод глубокой копии орла: " + deepCopyEagle.hashCode());

        System.out.println("Хешкод оригинальной совы: " + originalOwl.hashCode());
        System.out.println("Хешкод неглубокой копии совы: " + shallowCopyOwl.hashCode());
        System.out.println("Хешкод глубокой копии совы: " + deepCopyOwl.hashCode());

        System.out.println("Сравнение оригинального орла и неглубокой копии: " + originalEagle.equals(shallowCopyEagle));

        for (IBird bird : list) {
            System.out.println(bird.toString());
            bird.Hunt();
            bird.Tweet();
            System.out.println("----------------------------");
        }
    }
}
