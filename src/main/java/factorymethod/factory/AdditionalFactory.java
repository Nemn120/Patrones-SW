package factorymethod.factory;

import factorymethod.aditional.AdditionalMachine;
import factorymethod.aditional.impl.AdditionalCandy;
import factorymethod.aditional.impl.AdditionalChispas;


public class AdditionalFactory {

    public static AdditionalMachine getInstance(String type,Double price,String name){

        switch (type) {
            case "1": return new AdditionalCandy(name,price);
            case "2": return new AdditionalChispas(name,price);
        }
        return null;
    }

}
