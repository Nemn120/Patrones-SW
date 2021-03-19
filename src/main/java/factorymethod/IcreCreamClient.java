package factorymethod;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

import frames.PanelBody;

import javax.swing.*;

import factorymethod.aditional.GenericAdditional;
import factorymethod.factory.IceCreamFactory;
import factorymethod.icecream.GenericIceCream;
import factorymethod.icecream.IceCreamMachine;
import factorymethod.icecream.IceCreams;

public class IcreCreamClient {

    public static void main(String[] args) throws IOException {
/*
        String type="";
        IceCreams iceCreams = new IceCreams();
        Scanner scanner = new Scanner(System.in);
        IceCreamMachine iceCream = null;
        System.out.println("FRABRICA DE HELADOS");
        System.out.println("_________________________");
        System.out.println("Seleccione sabor del helado ");
        System.out.println("1-chocolate, 2- vainilla, 3- fresa, 4- exit");
        type = scanner.nextLine();
        do {
            iceCream = IceCreamFactory.getInstance(type);

            IcreCreamClient.additionalInfo(scanner, iceCream);
            iceCream.prepareIceCream();
            iceCreams.addIceCream((GenericIceCream) iceCream);
            System.out.println("\n Ingrese si desea otro helado: 1-chocolate, 2- vainilla, 3- fresa, 4- exit");
            type = scanner.nextLine();
            if (type.equalsIgnoreCase("4")) {
                break;
            }
        } while (!type.equalsIgnoreCase("4"));
        ClientService.saveIceCreams(iceCreams);
        System.out.println("\nGracias por su compra ");

        System.out.println(iceCreams.toString());
        */

		JFrame frame = new JFrame("FABRICA DE HELADOS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PanelBody body = new PanelBody(1024, 520);
		frame.add(body.getBody(), BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

    }

}
