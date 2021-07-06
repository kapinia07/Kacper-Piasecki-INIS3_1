package com.company.devices;

public class Electric extends Car{
    public Electric(String producer, String model, Integer yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value);
    }

    @Override
    void refuel() {
        System.out.println("Charging the battery");
    }
}