package factorymethod.aditional.impl;

import factorymethod.aditional.AdditionalMachine;
import factorymethod.aditional.GenericAdditional;

public class AdditionalCandy extends GenericAdditional implements AdditionalMachine {

    public AdditionalCandy(String name, Double price) {
        super(name, price);
    }

    public AdditionalCandy() {
    }

    @Override
    public String info() {
        return "Precio"+price +" Caramelo "+name;
    }
}
