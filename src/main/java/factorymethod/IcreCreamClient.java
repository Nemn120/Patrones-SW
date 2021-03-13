package factorymethod;

import factorymethod.factory.IceCreamFactory;
import factorymethod.icecream.impl.IceCream;
import util.ObjectMapperJSON;

import java.io.IOException;

public class IcreCreamClient {



    public static void main(String[] args) throws IOException {
         IceCreamFactory factory;
         ObjectMapperJSON objectMapperJSON = new ObjectMapperJSON();
        IceCream iceCream =objectMapperJSON.readMapperObjectToPath("src/main/resources/icre-creams.json", IceCream.class);
        System.out.println(iceCream.getPrice());
        System.out.println(iceCream.getType());


    }

}
