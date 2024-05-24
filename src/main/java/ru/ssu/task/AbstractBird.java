package ru.ssu.task;

abstract class AbstractBird implements IBird {
    float weight;
    int age;
    Location location;

    public AbstractBird(float weight, int age, Location location) {
        this.weight = weight;
        this.age = age;
        this.location = location;
    }

    @Override
    public void Hunt() {
        System.out.println("Hunting");
    }

    @Override
    public void Tweet() {
        System.out.println("Tweeting");
    }
}
