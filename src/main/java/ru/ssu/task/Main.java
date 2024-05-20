package ru.ssu.task;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IBird> list = new ArrayList<>();

        Eagle originalEagle = new Eagle(5.7f, 3, new Location("Mountains"));
        Eagle shallowCopyEagle = originalEagle.shallowCopy();
        Eagle deepCopyEagle = originalEagle.deepCopy();

        list.add(originalEagle);
        list.add(shallowCopyEagle);
        list.add(deepCopyEagle);

        System.out.println("Хешкод оригинального орла: " + originalEagle.hashCode());
        System.out.println("Хешкод неглубокой копии орла: " + shallowCopyEagle.hashCode());
        System.out.println("Хешкод глубокой копии орла: " + deepCopyEagle.hashCode());

        System.out.println("Сравнение оригинального и неглубокой копии: " + originalEagle.equals(shallowCopyEagle));

        for (IBird bird : list) {
            System.out.println(bird.toString());
            bird.Hunt();
            bird.Tweet();
            System.out.println("----------------------------");
        }
    }
}
