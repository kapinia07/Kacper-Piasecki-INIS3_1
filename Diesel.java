package com.company.devices;

public class Diesel extends Car{
    public Diesel(String producer, String model, Integer yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value);
    }

    @Override
    void refuel() {
        System.out.println("Refueling with Diesel fuel");
    }
}