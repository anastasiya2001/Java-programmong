package ru.ssu.task;

class Owl extends AbstractBird {
    public Owl(float weight, int age, Location location) {
        super(weight, age, location);
    }

    @Override
    public void Hunt() {
        System.out.println("The owl flies low and swoops down on its prey");
    }

    @Override
    public void Tweet() {
        System.out.println("Low-pitched hooting noises");
    }

    @Override
    public String toString() {
        return "Owl: weight=" + weight + ", age=" + age + ", location=" + location.area;
    }

    public Owl shallowCopy() {
        return new Owl(weight, age, location);
    }

    public Owl deepCopy() {
        return new Owl(weight, age, new Location(location.area));
    }
}
