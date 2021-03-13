package factorymethod;

import java.util.Scanner;

import factorymethod.factory.IceCreamFactory;
import factorymethod.icecream.IceCreamMachine;

public class IcreCreamClient {
    
    public static void main(String[] args) {
		System.out.println("Enter your choice of ice cream");
		System.out.println("1-chocolate, 2- vainilla, 3- fresa, 4- exit");
		Scanner scanner = new Scanner(System.in);
		String type = scanner.nextLine();
		System.out.println("\n Enter your choice of toppings");
		String topping = scanner.nextLine();

		IceCreamMachine iceCream = null;
		while(!type.equalsIgnoreCase("4")) {
			iceCream = IceCreamFactory.getInstance(type);
			iceCream.setTopping(topping);
			iceCream.prepareIceCream();
			
			System.out.println("\n Enter your choice of ice cream again");
			type = scanner.nextLine();
			if(!type.equalsIgnoreCase("4") ) {
				System.out.println("\n Enter your choice of toppings again");
				topping = scanner.nextLine();
			}
		}
		System.out.println("\nThank You ");

	}


}
