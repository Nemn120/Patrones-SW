package frames;

import factorymethod.factory.IceCreamFactory;
import factorymethod.icecream.IceCreamMachine;
import factorymethod.icecream.impl.IcreCreamChocolate;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class OrderIceCream extends JPanel {

    private JPanel bodyOder;
    private String typeIceCream;

    public OrderIceCream() {
        this.bodyOder = new JPanel();
        this.setLayout(new BorderLayout());
    }

    public void OrderPanel() {
        this.getBodyOder().setPreferredSize(new Dimension(600,700));
        this.createButton();
        JFrame frameOrder = new JFrame("Crear Pedido");
        frameOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameOrder.add(this.getBodyOder(),BorderLayout.CENTER);
        frameOrder.pack();
        frameOrder.setLocationRelativeTo(null);
        frameOrder.setVisible(true);
        //frameOrder.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public void createButton() {
        JButton chocolateButton = new JButton("Chocolate");
        JButton vainillaCreamButton = new JButton("Vainilla");
        JButton fresaCreamButton = new JButton("Fresa");
        this.getBodyOder().add(chocolateButton);
        this.getBodyOder().add(vainillaCreamButton);
        this.getBodyOder().add(fresaCreamButton);
    }

    public JPanel getBodyOder() {
        return bodyOder;
    }

    public void setBodyOder(JPanel bodyOder) {
        this.bodyOder = bodyOder;
    }

    public String getTypeIceCream() {
        return typeIceCream;
    }

    public void setTypeIceCream(String typeIceCream) {
        this.typeIceCream = typeIceCream;
    }

}
