package factorymethod.aditional.impl;

import factorymethod.aditional.AdditionalMachine;
import factorymethod.aditional.GenericAdditional;

public class AdditionalFruits extends GenericAdditional implements AdditionalMachine {

    public AdditionalFruits(String name, Double price) {
        super(name, price);
        this.type = "Frutas";
    }

    public AdditionalFruits() {
        this.type = "Frutas";
    }

    @Override
    public String info() {
        return super.toString();
    }
}
