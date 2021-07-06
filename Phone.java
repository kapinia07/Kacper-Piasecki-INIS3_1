package com.company.devices;

import com.company.Human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Phone extends Device {

    static final String DEFAULT_SERVER_ADDRESS = "www.google.com";
    static final String DEFAULT_PROTOCOL = "HTTP";
    private List<Application> applications;
    private Human owner;

    public Phone(String producer, String model, Integer yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value);
        this.applications = new ArrayList<>();
    }

    public Phone(String producer, String model, Integer yearOfProduction, Double value, Human owner) {
        super(producer, model, yearOfProduction, value);
        this.owner = owner;
        this.applications = new ArrayList<>();
    }

    @Override
    public void turnOn() {
        System.out.println("This phone is now on");
    }

    public void installAnApp(Application application) {
        if (this.owner.getCash() < application.getPrice()) {
            System.out.println("The owner of this phone doesn't have enough money to install this app");
            throw new IllegalArgumentException();
        }

        if (this.applications.contains(application)) {
            System.out.println("This app is already installed on this phone");
            throw new IllegalArgumentException();
        }

        this.applications.add(application);

        this.owner.setCash(this.owner.getCash() - application.getPrice());

    }

    @Override
    public String toString() {
        return "Phone{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", value=" + value +
                ", applications=" + applications +
                ", owner=" + owner +
                '}';
    }

    public boolean isInstalled(Application application) {
        return this.applications.contains(application);
    }

    public boolean isInstalled(String applicationName) {
        for (Application application : this.applications) {
            if (application.getName().equals(applicationName)) return true;
        }
        return false;
    }

    public void printAllFreeApps() {
        for (Application application : this.applications) {
            if (application.getPrice() == 0.0) System.out.println(application);
        }
    }

    public Double priceOfAllApps() {
        Double sum = 0.0;
        for (Application application : this.applications) {
            sum += application.getPrice();
        }
        return sum;
    }

    public void printAllAppsAlphabet() {
        this.applications.sort(new Comparator<Application>() {
            @Override
            public int compare(Application o1, Application o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println(this.applications);
    }

    public void printAllAppsPrice() {
        this.applications.sort(new Comparator<Application>() {
            @Override
            public int compare(Application o1, Application o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });

        System.out.println(this.applications);
    }
}