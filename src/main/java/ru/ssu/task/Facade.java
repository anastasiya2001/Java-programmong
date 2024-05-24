package main.java.ru.ssu.task;

public class Facade {
    public static void main(String[] args) {
        CarFacade carFacade = new CarFacade();

        carFacade.startCar();
        carFacade.drive(100);
        carFacade.changeGear(3);
        carFacade.drive(150);
        carFacade.stopCar();
    }
}

class CarFacade {
    private Engine engine;
    private Radio radio;
    private Transmission transmission;
    private BrakeSystem brakeSystem;

    public CarFacade() {
        this.engine = new Engine();
        this.radio = new Radio();
        this.transmission = new Transmission();
        this.brakeSystem = new BrakeSystem();
    }

    public void startCar() {
        engine.start();
        radio.turnOn();
        transmission.setGear(1);
        System.out.println("���������� ����� � ��������");
    }

    public void drive(int speed) {
        transmission.setSpeed(speed);
        System.out.println(String.format("���������� �������� �� ��������� %d ��/�", speed));
    }

    public void changeGear(int gear) {
        transmission.setGear(gear);
        System.out.println(String.format("�������� ����������� �� %d", gear));
    }

    public void stopCar() {
        brakeSystem.applyBrakes();
        transmission.setGear(0);
        engine.stop();
        radio.turnOff();
        System.out.println("���������� ����������");
    }
}

class Engine {
    public void start() {
        System.out.println("��������� �������");
    }

    public void stop() {
        System.out.println("��������� ����������");
    }
}

class Radio {
    public void turnOn() {
        System.out.println("����� ��������");
    }

    public void turnOff() {
        System.out.println("����� ���������");
    }
}

class Transmission {
    public void setGear(int gear) {
        System.out.println(String.format("����������� �������� %d", gear));
    }

    public void setSpeed(int speed) {
        System.out.println(String.format("����������� �������� %d ��/�", speed));
    }
}

class BrakeSystem {
    public void applyBrakes() {
        System.out.println("������� �������������");
    }
}
