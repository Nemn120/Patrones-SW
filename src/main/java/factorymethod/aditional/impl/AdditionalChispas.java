package factorymethod.aditional.impl;

import factorymethod.aditional.AdditionalMachine;
import factorymethod.aditional.GenericAdditional;

public class AdditionalChispas extends GenericAdditional implements AdditionalMachine {

    public AdditionalChispas() {
    }

    public AdditionalChispas(String name, Double price) {
        super(name, price);
    }

    @Override
    public String info() {
        return "Precio"+price +" Chispas "+name;
    }
}
