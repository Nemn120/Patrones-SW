package factorymethod;

import java.awt.*;

import frames.PanelBody;

import javax.swing.*;

public class IcreCreamClient {

    public static void main(String[] args) {
		/*System.out.println("FRABRICA DE HELADOS");
		System.out.println("_________________________");
		System.out.println("Seleccione sabor del helado ");
		System.out.println("1-chocolate, 2- vainilla, 3- fresa, 4- exit");
		Scanner scanner = new Scanner(System.in);
		String type = scanner.nextLine();
		System.out.println("\n Ingrese adicional");
		String topping = scanner.nextLine();

		IceCreamMachine iceCream = null;
		while(!type.equalsIgnoreCase("4")) {
			iceCream = IceCreamFactory.getInstance(type);
			iceCream.setTopping(topping);
			iceCream.prepareIceCream();

			System.out.println("\n Ingrese si desea otro helado: 1-chocolate, 2- vainilla, 3- fresa, 4- exit");
			type = scanner.nextLine();
			if(!type.equalsIgnoreCase("4") ) {
				System.out.println("\n Ingrese adicional");
				topping = scanner.nextLine();
			}
		}
		System.out.println("\nThank You ");*/

		JFrame frame = new JFrame("FABRICA DE HELADOS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PanelBody body = new PanelBody(1024, 780);
		frame.add(body.getBody(), BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
