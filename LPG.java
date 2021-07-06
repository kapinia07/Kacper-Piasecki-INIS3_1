
package com.company.devices;

import com.company.Human;

public class LPG extends Car{
    public LPG(String producer, String model, Integer yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value);
    }

    @Override
    void refuel() {
        System.out.println("Refuelling with LPG");
    }


}