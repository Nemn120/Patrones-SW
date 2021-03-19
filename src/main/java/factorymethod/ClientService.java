package factorymethod;

import factorymethod.aditional.GenericAdditional;
import factorymethod.factory.AdditionalFactory;
import factorymethod.icecream.GenericIceCream;
import factorymethod.icecream.IceCreamMachine;
import factorymethod.icecream.IceCreams;
import util.ObjectMapperJSON;

import java.io.IOException;
import java.util.*;

public class ClientService {

    public static List<GenericAdditional> selectAdditional(String opcion) {
        if ("1".equalsIgnoreCase(opcion)) {
            return uploadAdditionalByType(opcion, Arrays.asList("Limon", "Fresa", "Variado"));
        } else if ("2".equalsIgnoreCase(opcion)) {
            return uploadAdditionalByType(opcion, Arrays.asList("Fresa", "Menta", "Variado"));
        } else
            return null;
    }

    public static List<GenericAdditional> uploadAdditionalByType(String type, List<String> namesAdditional) {
        List<GenericAdditional> additionalList = new ArrayList<>();
        for (int i = 0; i < namesAdditional.size(); i++) {
            additionalList.add((GenericAdditional) AdditionalFactory.getInstance(type, Math.random() * 10 * i + 1, namesAdditional.get(i)));
        }
        return additionalList;
    }

    public static void saveIceCreams(IceCreams iceCreams) throws IOException {
        if (!iceCreams.getIceCreamList().isEmpty()) {
            ObjectMapperJSON objectMapperJSON = new ObjectMapperJSON();
            String uuid = UUID.randomUUID().toString();
            iceCreams.setId(uuid);
            String path = "src/main/resources/IceCreams/" + uuid + ".json";
            objectMapperJSON.writeObject(path, iceCreams);
        }
    }

    private static void additionalInfo(Scanner scanner, IceCreamMachine iceCream) {
        String topping = "";
        System.out.println("\n Ingrese adicional 1: Frutas  - 2: Chispas");
        topping = scanner.nextLine();

        List<GenericAdditional> additionals = ClientService.selectAdditional(topping);
        System.out.println("\n Seleccione un adicional");
        additionals.forEach(x -> System.out.println(x.toString()));
        topping = scanner.nextLine();

        ((GenericIceCream) iceCream).addAdditional(additionals.get(Integer.parseInt(topping) - 1));

    }
}
