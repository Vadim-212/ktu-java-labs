package kz.ktu.lab6.ex1;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Car car = new Car(new Engine(0.08), List.of(new Wheel(),new Wheel(),new Wheel(),new Wheel()), "car");
        try {
            Car.serialize(car, "car");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Car.deserialize("car").printModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
