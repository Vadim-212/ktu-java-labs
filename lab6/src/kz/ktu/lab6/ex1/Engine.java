package kz.ktu.lab6.ex1;

import java.io.Serializable;

public class Engine implements Serializable {
    private final Double fuelConsumption;

    public Engine(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }
}
