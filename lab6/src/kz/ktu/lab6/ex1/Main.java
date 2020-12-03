package kz.ktu.lab6.ex1;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Car car = new Car(new Engine(0.08), List.of(new Wheel(),new Wheel(),new Wheel(),new Wheel()), "car");
        System.out.println("Марка автомобиля:");
        car.printModel();

        try {
            System.out.println("Сериализация объекта Car...");
            Car.serialize(car, "car");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Десериализация объекта Car...");
            Car savedCar = Car.deserialize("car");
            System.out.println("Марка автомобиля:");
            savedCar.printModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
