package frames;

import factorymethod.ClientService;
import factorymethod.aditional.GenericAdditional;
import factorymethod.aditional.impl.AdditionalChispas;
import factorymethod.aditional.impl.AdditionalFruits;
import factorymethod.factory.AdditionalFactory;
import factorymethod.factory.IceCreamFactory;
import factorymethod.icecream.GenericIceCream;
import factorymethod.icecream.IceCreamMachine;
import factorymethod.icecream.IceCreams;
import factorymethod.icecream.impl.IceCreamFresa;
import factorymethod.icecream.impl.IceCreamVainilla;
import factorymethod.icecream.impl.IcreCreamChocolate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderIceCream extends JPanel {

    private JPanel bodyOder;
    private String typeIceCream;
    private JButton chocolateButton;
    private JButton vainillaCreamButton;
    private JButton fresaCreamButton;
    private JButton generateOrderButton;
    private JPanel additonal1;
    private JPanel additonal2;
    private List<JButton> listSelectAdditional1;
    private String message;
    JTextArea textMessage;
    double totalPrice;
    private IceCreams iceCreams;
    GenericIceCream genericIceCream;
    GenericAdditional genericAdditional;
    List<GenericAdditional> additionalChispasList;
    List<GenericAdditional> additionalFruits;

    public OrderIceCream() {
        this.bodyOder = new JPanel();
        this.setLayout(new BorderLayout());
        this.totalPrice = 0;
        this.message = "";
        textMessage = new JTextArea(5, 40);
        this.chocolateButton = new JButton();
        this.vainillaCreamButton = new JButton();
        this.fresaCreamButton = new JButton();
        this.iceCreams = new IceCreams();
        this.additionalChispasList = ClientService.selectAdditional("1");
        this.additionalFruits = ClientService.selectAdditional("2");
    }

    public void OrderPanel() {
        this.getBodyOder().setPreferredSize(new Dimension(600, 700));
        this.createButtonIceCreams();
        this.getBodyOder().add(this.getTextMessage());
        this.showAditionals();
        this.selectIceCream();
        this.generateOrder();
        this.selectAditional();
        this.showTotalPrice();
        JFrame frameOrder = new JFrame("Crear Pedido");
        frameOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameOrder.add(this.getBodyOder(), BorderLayout.CENTER);
        frameOrder.pack();
        frameOrder.setLocationRelativeTo(null);
        frameOrder.setVisible(true);
        frameOrder.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    public void createButtonIceCreams() {
        this.setChocolateButton(new JButton("Chocolate"));
        this.setVainillaCreamButton(new JButton("Vainilla"));
        this.setFresaCreamButton(new JButton("Fresa"));
        this.getBodyOder().add(this.getChocolateButton());
        this.getBodyOder().add(this.getVainillaCreamButton());
        this.getBodyOder().add(this.getFresaCreamButton());
    }

    public void selectIceCream() {
        final IceCreamMachine[] iceCreamMachine = new IceCreamMachine[1];
        this.getChocolateButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    iceCreamMachine[0] = IceCreamFactory.getInstance("1");
                }
                genericIceCream = (IcreCreamChocolate) iceCreamMachine[0];
                System.out.println(((GenericIceCream) iceCreamMachine[0]).getFlavors());
                iceCreams.addIceCream((IcreCreamChocolate) iceCreamMachine[0]);
            }
        });

        this.getVainillaCreamButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    iceCreamMachine[0] = IceCreamFactory.getInstance("2");
                }
                genericIceCream = (IceCreamVainilla) iceCreamMachine[0];
                System.out.println(((GenericIceCream) iceCreamMachine[0]).getFlavors());
                iceCreams.addIceCream((IceCreamVainilla) iceCreamMachine[0]);
            }
        });

        this.getFresaCreamButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    iceCreamMachine[0] = IceCreamFactory.getInstance("3");
                }
                System.out.println(((GenericIceCream) iceCreamMachine[0]).getFlavors());
                genericIceCream = (IceCreamFresa) iceCreamMachine[0];
                iceCreams.addIceCream((IceCreamFresa) iceCreamMachine[0]);
            }
        });
    }

    public void showMessage() {
        this.getTextMessage().setText(this.getMessage());
    }

    public void showAditionals() {
        this.setAdditonal1(new JPanel());
        this.getAdditonal1().setPreferredSize(new Dimension(500, 280));
        this.getAdditonal1().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.getBodyOder().add(this.getAdditonal1());

        this.setAdditonal2(new JPanel());
        this.getAdditonal2().setPreferredSize(new Dimension(500, 280));
        this.getAdditonal2().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.getBodyOder().add(this.getAdditonal2());

        this.setIconAndButtonAdditonals();
    }

    public void setIconAndButtonAdditonals() {
        ImagesBody imagesBody = new ImagesBody();
        this.setListSelectAdditional1(new ArrayList<>());
        int totalAditionals = 6;
        int index = 0;
        for (int i = 0; i < totalAditionals; i++) {
            JPanel panelImage = new JPanel();
            JButton selectAditional = new JButton("Elegir");
            this.getListSelectAdditional1().add(selectAditional);
            panelImage.add(this.getListSelectAdditional1().get(i));

            if (i < 3) {
                panelImage.add(imagesBody.setIconAditionals(String.valueOf(i + 1)));
                this.getAdditonal1().add(panelImage);
            } else {
                panelImage.add(imagesBody.setIconAditionals(String.valueOf(index + 1)));
                this.getAdditonal2().add(panelImage);
                index++;
            }

        }
    }

    public void selectAditional() {
        int totalAditionals = 6;
        for (int i = 0; i < totalAditionals; i++) {
            this.addAditional(i);
        }
    }

    public void addAditional(int pos) {
        this.getListSelectAdditional1().get(pos).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    //Accion de elegir un helado
                    System.out.println("Helado " + pos + " elegido");
                    if (pos > 2) {
                        getGenericIceCream().addAdditional(getAdditionalFruits().get(pos % 3));
                    } else
                        getGenericIceCream().addAdditional(getAdditionalChispasList().get(pos));

                    textMessage.append(getGenericIceCream().toString());
                }
            }
        });
    }

    public void showTotalPrice() {
        JLabel totalPriceLabel = new JLabel();
        totalPriceLabel.setText("TOTAL A PAGAR");
        JLabel totalPrice = new JLabel();
        totalPrice.setText("22.2");
        this.getBodyOder().add(totalPriceLabel);
        this.getBodyOder().add(totalPrice);
    }

    public void generateOrder() {
        this.setGenerateOrderButton(new JButton("Generar Pedido"));
        this.getBodyOder().add(this.getGenerateOrderButton());
        this.getGenerateOrderButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    try {
                        ClientService.saveIceCreams(iceCreams);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

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

    public JButton getChocolateButton() {
        return chocolateButton;
    }

    public void setChocolateButton(JButton chocolateButton) {
        this.chocolateButton = chocolateButton;
    }

    public JButton getVainillaCreamButton() {
        return vainillaCreamButton;
    }

    public void setVainillaCreamButton(JButton vainillaCreamButton) {
        this.vainillaCreamButton = vainillaCreamButton;
    }

    public JButton getFresaCreamButton() {
        return fresaCreamButton;
    }

    public void setFresaCreamButton(JButton fresaCreamButton) {
        this.fresaCreamButton = fresaCreamButton;
    }

    public JButton getGenerateOrderButton() {
        return generateOrderButton;
    }

    public void setGenerateOrderButton(JButton generateOrderButton) {
        this.generateOrderButton = generateOrderButton;
    }

    public JPanel getAdditonal1() {
        return additonal1;
    }

    public void setAdditonal1(JPanel additonal1) {
        this.additonal1 = additonal1;
    }

    public JPanel getAdditonal2() {
        return additonal2;
    }

    public void setAdditonal2(JPanel additonal2) {
        this.additonal2 = additonal2;
    }

    public List<JButton> getListSelectAdditional1() {
        return listSelectAdditional1;
    }

    public void setListSelectAdditional1(List<JButton> listSelectAdditional1) {
        this.listSelectAdditional1 = listSelectAdditional1;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JTextArea getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(JTextArea textMessage) {
        this.textMessage = textMessage;
    }

    public List<GenericAdditional> getAdditionalChispasList() {
        return additionalChispasList;
    }

    public void setAdditionalChispasList(List<GenericAdditional> additionalChispasList) {
        this.additionalChispasList = additionalChispasList;
    }

    public List<GenericAdditional> getAdditionalFruits() {
        return additionalFruits;
    }

    public void setAdditionalFruits(List<GenericAdditional> additionalFruits) {
        this.additionalFruits = additionalFruits;
    }

    public IceCreams getIceCreams() {
        return iceCreams;
    }

    public void setIceCreams(IceCreams iceCreams) {
        this.iceCreams = iceCreams;
    }

    public GenericIceCream getGenericIceCream() {
        return genericIceCream;
    }

    public void setGenericIceCream(GenericIceCream genericIceCream) {
        this.genericIceCream = genericIceCream;
    }

    public GenericAdditional getGenericAdditional() {
        return genericAdditional;
    }

    public void setGenericAdditional(GenericAdditional genericAdditional) {
        this.genericAdditional = genericAdditional;
    }
}
