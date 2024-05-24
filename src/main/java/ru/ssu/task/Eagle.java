package ru.ssu.task;

class Eagle extends AbstractBird {
    public Eagle(float weight, int age, Location location) {
        super(weight, age, location);
    }

    @Override
    public void Hunt() {
        System.out.println("The eagle flies high and tracks down prey");
    }

    @Override
    public void Tweet() {
        System.out.println("High-pitched whistling noises");
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Eagle) {
            Eagle e = (Eagle) o;
            return this.weight == e.weight && this.age == e.age && this.location.area.equals(e.location.area);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) (weight * age);
    }

    public int compareTo(Eagle e) {
        return Float.compare(this.weight, e.weight);
    }

    @Override
    public String toString() {
        return "Eagle: weight=" + weight + ", age=" + age + ", location=" + location.area;
    }

    public Eagle shallowCopy() {
        return new Eagle(weight, age, location);
    }

    public Eagle deepCopy() {
        return new Eagle(weight, age, new Location(location.area));
    }
}
