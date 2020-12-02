package kz.ktu.lab6.ex1;

import java.io.*;
import java.util.List;

public class Car implements Serializable {
    private Engine engine;
    private List<Wheel> wheels;
    private String model;
    private Double fuel;
    private final Double FULL_TANK = 100.0;

    public Car(Engine engine, List<Wheel> wheels, String model) {
        this.engine = engine;
        this.wheels = wheels;
        this.model = model;
        fuel = FULL_TANK;
    }

    public void drive(int distance) throws Exception {
        if(fuel <= 0 || (distance * engine.getFuelConsumption()) < 0)
            throw new Exception("Not enough petrol!");
        fuel -= distance * engine.getFuelConsumption();
    }

    public void refuel(Double value) {
        if(value > FULL_TANK || (fuel + value) > FULL_TANK)
            fuel = FULL_TANK;
        else
            fuel += value;
    }

    public void changeWheel(int oldWheelIndex, Wheel newWheel) {
        wheels.set(oldWheelIndex, newWheel);
    }

    public void printModel() {
        System.out.println(model);
    }



    public static void serialize(Car car, String path) throws IOException {
        try(FileOutputStream outputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(car);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Car deserialize(String path) throws IOException {
        Car car = null;
        try (FileInputStream inputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            car = (Car) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return car;
    }
}
