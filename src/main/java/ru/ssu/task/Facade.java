package main.java.ru.ssu.task;

public class Facade {
    public static void main(String[] args) {
        CarFacade carFacade = new CarFacade();

        carFacade.startEngine();
        carFacade.turnOnRadio();
        carFacade.setSpeed(100);
        carFacade.brake();
    }
}

class CarFacade {
    public void startEngine() {
        System.out.println("Запустить двигатель");
    }

    public void turnOnRadio() {
        System.out.println("Включить радио");
    }

    public void setSpeed(int speed) {
        System.out.println(String.format("Установить скорость %d", speed));
    }

    public void brake() {
        System.out.println("Тормизить");
    }
}
