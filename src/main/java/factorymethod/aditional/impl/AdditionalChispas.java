package factorymethod.aditional.impl;

import factorymethod.aditional.AdditionalMachine;
import factorymethod.aditional.GenericAdditional;

public class AdditionalChispas extends GenericAdditional implements AdditionalMachine {

    public AdditionalChispas() {
        this.type = "Chispas";
    }

    public AdditionalChispas(String name, Double price) {
        super(name, price);
        this.type = "Chispas";
    }

    @Override
    public String info() {
        return super.toString();
    }
}
