package com.company;

import com.company.creatures.Animal;
import com.company.devices.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Human {
    static final public double DEFAULT_SALARY = 2000.0;
    static final public int DEFAULT_GARAGE_SIZE = 5;
    private Animal pet;
    private Car[] garage;
    private Double salary;
    private Double cash;

    public Human() {
        this.salary = DEFAULT_SALARY;
    }

    public Human(Animal pet, Double salary) {
        this.pet = pet;
        this.garage = new Car[DEFAULT_GARAGE_SIZE];
        this.salary = salary;
    }

    public Human(Animal pet, Double salary, int garageSize) {
        this.pet = pet;
        this.garage = new Car[garageSize];
        this.salary = salary;
    }

    public Animal getPet() {
        return pet;
    }

    public void setPet(Animal pet) {
        this.pet = pet;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Car[] getGarage() {
        return garage;
    }

    public void sortGarage() {

        Arrays.sort(this.garage, (o1, o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return Integer.compare(o1.getYearOfProduction(), o2.getYearOfProduction());
        });
    }

    public Car getCar(int garageSpot) {
        if (garageSpot < 0) {
            System.out.println("A garage spot has to be a number above 0");
            throw new IllegalArgumentException();
        } else if (garageSpot > this.garage.length) {
            System.out.println("This garage can only hold up to " + this.garage.length + " cars.");
            throw new IllegalArgumentException();
        } else {
            return this.garage[garageSpot];
        }
    }

    public void setCar(Car car, int garageSpot) {
        if (garageSpot < 0) {
            System.out.println("A garage spot has to be a number above 0");
            throw new IllegalArgumentException();
        } else if (garageSpot > this.garage.length) {
            System.out.println("This garage can only hold up to " + this.garage.length + " cars.");
            throw new IllegalArgumentException();
        } else {

            this.garage[garageSpot] = car;
            if (car != null) {
                car.addOwner(this);
            }
        }
    }

    public Double getSalary() {
        Date date = new Date();

        System.out.println("Current date and time: " + date);
        System.out.println("The salary is: " + salary);

        return this.salary;
    }

    public void setSalary(Double salary) {
        if (salary < 0) {
            System.out.println("Error: salary can't be lower than zero");
        } else {

            System.out.println("New salary has been registered. The salary is : " + salary);
            System.out.println("Please take the 'aneks' from 'pani Hania z kadr'.");
            System.out.println("ZUS and US already know about the new salary, don't try to hide it");
            this.salary = salary;
        }
    }

    public Double getCarsValue() {
        Double sum = 0.0;
        for (Car car : this.garage) {
            sum += car.getValue();
        }
        return sum;
    }

    @Override
    public String toString() {
        String out = "Human{" +
                "pet=" + pet +
                ", salary=" + salary +
                ", cash=" + cash +
                ", garage= {";

        List<String> carNames = new ArrayList<>();
        for (Car car : this.garage) {
            if (car != null) {
                carNames.add(car.getModel());
            }
        }
        out = out.concat(String.valueOf(carNames));

        out = out.concat("}");

        return out;
    }
}