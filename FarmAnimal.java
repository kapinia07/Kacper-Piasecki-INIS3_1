package com.company.creatures;

public class FarmAnimal extends Animal implements Edible {

    public FarmAnimal(String species) {
        super(species);
    }

    @Override
    public void beEaten() {
        System.out.println("A " + this.getSpecies() + " got consumed");
    }
}