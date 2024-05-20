package ru.ssu.task;

abstract class AbstractBird implements IBird {
    float weight;
    int age;
    Location location;

    @Override
    public void Hunt() {
        System.out.println("Hunting");
    }

    @Override
    public void Tweet() {
        System.out.println("Tweeting");
    }
}