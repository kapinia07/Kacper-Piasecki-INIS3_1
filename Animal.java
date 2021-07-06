package com.company.creatures;

import com.company.Human;
import com.company.Sellable;

public abstract class Animal implements Sellable, Feedable{
    final private String species;
    private Double weight;

    static final public double DEFAULT_ANIMAL_WEIGHT = 2.0;
    static final public double DEFAULT_DOG_WEIGHT = 5.0;
    static final public double DEFAULT_CAT_WEIGHT = 2.0;
    static final public double DEFAULT_COW_WEIGHT = 300.0;

    public Animal(String species) {
        this.species = species;

        switch (this.species) {
            case "dog": {
                this.weight = DEFAULT_DOG_WEIGHT;
                break;
            }
            case "cat": {
                this.weight = DEFAULT_CAT_WEIGHT;
                break;
            }
            case "cow": {
                this.weight = DEFAULT_COW_WEIGHT;
                break;
            }
            default: {
                this.weight = DEFAULT_ANIMAL_WEIGHT;
            }

        }


    }

    @Override
    public void feed() {
        if (weight > 0) {
            this.weight += 1;
            System.out.println("Thx for the food, bro, weight = " + this.weight);
            System.out.println("Im happy " + this.species);
        } else {
            System.out.println("I'm a dead " + this.species + " bro, why are u feedin me? weight = " + this.weight);
        }
    }

    @Override
    public void feed(int foodWeight) {
        if (weight > 0) {
            this.weight += foodWeight;
            System.out.println("Thx for the food, bro, weight = " + this.weight);
            System.out.println("Im happy " + this.species);
        } else {
            System.out.println("I'm a dead " + this.species + " bro, why are u feedin me? weight = " + this.weight);
        }
    }

    public void takeForAWalk() {
        if (weight > 0) {
            this.weight -= 1;
            System.out.println("Thx for the walk, bro, weight = " + this.weight);
            System.out.println("Im happy " + this.species);
        } else {
            System.out.println("I'm a dead " + this.species + " bro, what do u want? weight = " + this.weight);
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (this != seller.getPet()) {
            System.out.println("You can't sell what you don't have");
        } else if (buyer.getCash() < price) {
            System.out.println("THe buyer doesn't have enough cash");
        } else {
            seller.setCash(seller.getCash() + price);
            buyer.setCash(buyer.getCash() - price);
            buyer.setPet(seller.getPet());
            seller.setPet(null);
            System.out.println(this + " was sold successfully for " + price);
        }
    }

    public String getSpecies() {
        return species;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}