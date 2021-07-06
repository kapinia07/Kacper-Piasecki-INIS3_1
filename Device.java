package com.company.devices;

public abstract class Device {
    final protected String producer;
    final protected String model;
    final protected Integer yearOfProduction;
    public Double value;


    public Device(String producer, String model, Integer yearOfProduction, Double value) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.value = value;
    }

    public abstract void turnOn();

    public String getProducer() {
        return producer;
    }

    public String getModel() {
        return model;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}