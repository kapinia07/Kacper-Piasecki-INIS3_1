package com.company;

import com.company.creatures.Animal;
import com.company.creatures.Pet;
import com.company.devices.Application;
import com.company.devices.Phone;

public class Main {

    public static void main(String[] args) {

        Animal dog = new Pet("dog");

        Human human1 = new Human(dog, 2000.0);
        human1.setCash(100000.0);


        Application application = new Application("Facebook", "Pro", 15.0);
        Application application1 = new Application("Photoshop", "1.02", 55.0);
        Application application2 = new Application("Google", "1");

        Phone phone = new Phone("Apple", "IPhone 8", 2004, 1000.0, human1);

        phone.installAnApp(application);
        phone.installAnApp(application1);
        phone.installAnApp(application2);

        System.out.println(phone.isInstalled(application1));
        System.out.println(phone.isInstalled("Google"));
        System.out.println(phone.priceOfAllApps());
        phone.printAllFreeApps();
        phone.printAllAppsAlphabet();
        phone.printAllAppsPrice();


    }

}