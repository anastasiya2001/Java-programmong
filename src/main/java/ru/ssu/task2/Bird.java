package ru.ssu.task2;

public interface Bird {

    void Hunt();

    void Tweet();
}

abstract class AbstractBird implements Bird {
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

class Location {
    String area;

    Location(String area) {
        this.area = area;
    }
}

class Eagle extends AbstractBird {
    public Eagle(float weight, int age, Location location) {
        this.weight = weight;
        this.age = age;
        this.location = location;
    }

    @Override
    public void Hunt() {
        System.out.println("The eagle flies high and tracks down prey");
    }

    @Override
    public void Tweet() {
        System.out.println("High-pitched whistling noises");
    }

    public boolean equals(Object o) {
        if (o instanceof Eagle) {
            Eagle e = (Eagle) o;
            return this.weight == e.weight && this.age == e.age;
        }
        return false;
    }

    public int hashCode() {
        return (int) (weight * age);
    }

    public int compareTo(Eagle e) {
        if (this.weight > e.weight) {
            return 1;
        } else if (this.weight < e.weight) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return "Eagle: weight=" + weight + ", age=" + age;
    }

    public Eagle shallowCopy() {
        return new Eagle(weight, age, location);
    }

    public Eagle deepCopy() {
        return new Eagle(weight, age, new Location(location.area));
    }
}

class Owl extends AbstractBird {
    public Owl(float weight, int age, Location location) {
        this.weight = weight;
        this.age = age;
        this.location = location;

    }

    @Override
    public void Hunt() {
        System.out.println("The owl flies low and swoops down on its prey");
    }

    @Override
    public void Tweet() {
        System.out.println("Low-pitched hooting noises");
    }
}
