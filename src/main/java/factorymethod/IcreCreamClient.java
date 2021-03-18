package factorymethod;

import java.io.IOException;
import java.util.*;

import factorymethod.aditional.AdditionalMachine;
import factorymethod.aditional.GenericAdditional;
import factorymethod.factory.AdditionalFactory;
import factorymethod.factory.IceCreamFactory;
import factorymethod.icecream.GenericIceCream;
import factorymethod.icecream.IceCreamMachine;
import factorymethod.icecream.IceCreams;
import factorymethod.icecream.impl.IceCreamFresa;
import factorymethod.icecream.impl.IceCreamVainilla;
import util.ObjectMapperJSON;

public class IcreCreamClient {

    public static void main(String[] args) throws IOException {

		System.out.println("FRABRICA DE HELADOS");
		System.out.println("_________________________");
		System.out.println("Seleccione sabor del helado ");
		System.out.println("1-chocolate, 2- vainilla, 3- fresa, 4- exit");
		Scanner scanner = new Scanner(System.in);
		String type = scanner.nextLine();
		System.out.println("\n Ingrese adicional");
		String topping = scanner.nextLine();

		IceCreamMachine iceCream = null;
		IceCreams iceCreams = new IceCreams();
		while(!type.equalsIgnoreCase("4")) {
			iceCream = IceCreamFactory.getInstance(type);
			iceCream.setTopping(topping);
			iceCream.prepareIceCream();
			iceCreams.addIceCream((GenericIceCream) iceCream);
			System.out.println("\n Ingrese si desea otro helado: 1-chocolate, 2- vainilla, 3- fresa, 4- exit");
			type = scanner.nextLine();

			if(!type.equalsIgnoreCase("4") ) {
				System.out.println("\n Ingrese adicional 1: Caramelo - 2: Chispas ");
				topping = scanner.nextLine();
				List<GenericAdditional> additionals =IcreCreamClient.generatedAdditional(topping);
				System.out.println("\n Seleccione un adicional");
				additionals.forEach(x -> System.out.println("x.: " +x.getName() +" - "+x.getPrice()+" "));
				type = scanner.nextLine();

				((GenericIceCream) iceCream).setAdditional(additionals.get(Integer.parseInt(type)-1));
			}
		}
		IcreCreamClient.saveIceCreams(iceCreams);
		System.out.println("\nThank You ");

	}

	private static List<GenericAdditional> generatedAdditional(String toppingNumber){
		return uploadAdditionalByType(toppingNumber,Arrays.asList("Limon","Fresa","Uva"));
	}



	private static List<GenericAdditional> uploadAdditionalByType(String type, List<String> namesAdditional){
		List<GenericAdditional> additionalList = new ArrayList<>();
		for (int i = 0; i < namesAdditional.size(); i++) {
			additionalList.add((GenericAdditional)AdditionalFactory.getInstance(type, Math.random()*10*i,namesAdditional.get(i)));
		}
		return additionalList;
	}

	private static void saveIceCreams(IceCreams iceCreams) throws IOException {
    	if(!iceCreams.getIceCreamList().isEmpty()) {
			ObjectMapperJSON objectMapperJSON = new ObjectMapperJSON();
			String uuid = UUID.randomUUID().toString();
			iceCreams.setId(uuid);
			String path = "src/main/resources/IceCreams/" + uuid+".json";
			objectMapperJSON.writeObject(path, iceCreams);
		}
	}



}
