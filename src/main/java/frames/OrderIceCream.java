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
import org.w3c.dom.css.RGBColor;

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
    private boolean enableButtonSelect;
    private IceCreams iceCreams;
    GenericIceCream genericIceCream;
    GenericAdditional genericAdditional;
    List<GenericAdditional> additionalChispasList;
    List<GenericAdditional> additionalFruits;
    private boolean enableReporteButton;

    public OrderIceCream() {
        this.bodyOder = new JPanel();
        this.setLayout(new BorderLayout());
        this.bodyOder.setBackground(new Color(201	, 126, 0));
        this.totalPrice = 0;
        this.message = "";
        textMessage = new JTextArea(5, 40);
        this.textMessage.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.listSelectAdditional1 = new ArrayList<>();
        this.enableButtonSelect = false;
        this.enableReporteButton = false;
        this.chocolateButton = new JButton();
        this.vainillaCreamButton = new JButton();
        this.fresaCreamButton = new JButton();
        this.iceCreams = new IceCreams();
        this.additionalChispasList = ClientService.selectAdditional("1");
        this.additionalFruits = ClientService.selectAdditional("2");
    }

    public void OrderPanel() {
        this.getBodyOder().setPreferredSize(new Dimension(600, 750));
        this.createButtonIceCreams();
        this.selectIceCream();
        this.showAditionals();
        this.getBodyOder().add(this.getTextMessage());
        this.generateOrder();
        this.selectAditional();
        //this.showTotalPrice();
        JFrame frameOrder = new JFrame("Crear Pedido");
        frameOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameOrder.add(this.getBodyOder(), BorderLayout.CENTER);
        frameOrder.pack();
        frameOrder.setLocationRelativeTo(null);
        frameOrder.setVisible(true);
        frameOrder.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    }

    public void setImageBackground() {
        ImageIcon image = new ImageIcon("./icons/adicionales/variado.png");
        JLabel label = new JLabel("", image, JLabel.CENTER);
        this.getBodyOder().add( label, BorderLayout.CENTER );
    }

    public void createButtonIceCreams() {
        this.setChocolateButton(new JButton("Chocolate"));
        this.setIconOnButton(this.getChocolateButton(), "chocolateIcon");
        this.setVainillaCreamButton(new JButton("Vainilla"));
        this.setIconOnButton(this.getVainillaCreamButton(), "vainillaIcon");
        this.setFresaCreamButton(new JButton("Fresa"));
        this.setIconOnButton(this.getFresaCreamButton(), "fresaIcon");
        this.getBodyOder().add(this.getChocolateButton());
        this.getBodyOder().add(this.getVainillaCreamButton());
        this.getBodyOder().add(this.getFresaCreamButton());
    }

    public void setIconOnButton(JButton button, String name) {
        String path = ("./icons/").concat(name).concat(".png");
        ImageIcon image = new ImageIcon(path);
        Image img = image.getImage();
        Image scaledImg = img.getScaledInstance(20, 30, Image.SCALE_SMOOTH);
        image = new ImageIcon(scaledImg);
        button.setIcon(image);
        button.setHorizontalAlignment(SwingConstants.LEFT);;
        this.getBodyOder().add(button);
    }

    public void selectIceCream() {
        final IceCreamMachine[] iceCreamMachine = new IceCreamMachine[1];
        this.getChocolateButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    iceCreamMachine[0] = IceCreamFactory.getInstance("1");
                    getListSelectAdditional1().get(0).setEnabled(false);
                    enableButtonSelect();
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
                    enableButtonSelect();
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
                    enableButtonSelect();
                }
                System.out.println(((GenericIceCream) iceCreamMachine[0]).getFlavors());
                genericIceCream = (IceCreamFresa) iceCreamMachine[0];
                iceCreams.addIceCream((IceCreamFresa) iceCreamMachine[0]);
            }
        });
    }

    public void enableButtonSelect() {
        for(int i=0; i<6; i++) {
            this.getListSelectAdditional1().get(i).setEnabled(true);
        }
        this.setEnableButtonSelect(true);
    }

    public void showMessage() {
        this.getTextMessage().setText(this.getMessage());
    }

    public void showAditionals() {
        this.setAdditonal1(new JPanel());
        this.getAdditonal1().setPreferredSize(new Dimension(500, 280));
        this.getAdditonal1().setBackground(new Color(201	, 126, 0));
        this.getAdditonal1().setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.getBodyOder().add(this.getAdditonal1());

        this.setAdditonal2(new JPanel());
        this.getAdditonal2().setPreferredSize(new Dimension(500, 280));
        this.getAdditonal2().setBackground(new Color(201	, 126, 0));
        this.getAdditonal2().setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.getBodyOder().add(this.getAdditonal2());

        this.setIconAndButtonAdditonals();
    }

    public void setIconAndButtonAdditonals() {
        ImagesBody imagesBody = new ImagesBody();
        this.setListSelectAdditional1(new ArrayList<>());
        int totalAditionals = 6;
        for (int i = 0; i < totalAditionals; i++) {
            JPanel panelImage = new JPanel();
            JButton selectAditional = new JButton("Elegir");
            this.setIconOnButton(selectAditional, "selectIcon");
            this.getListSelectAdditional1().add(selectAditional);
            panelImage.add(this.getListSelectAdditional1().get(i));
            panelImage.setBackground(new Color(201,126, 0));
            this.getListSelectAdditional1().get(i).setEnabled(false);

            if (i < 3) {
                panelImage.add(imagesBody.setIconAditionals(String.valueOf(i + 1)));
                this.getAdditonal1().add(panelImage);
            } else {
                panelImage.add(imagesBody.setIconAditionals(String.valueOf(i + 1)));
                this.getAdditonal2().add(panelImage);
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
                if (SwingUtilities.isLeftMouseButton(e) && isEnableButtonSelect()) {
                    //Accion de elegir un helado
                    //System.out.println("Helado " + pos + " elegido");
                    setEnableReporteButton(true);
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
        this.setIconOnButton(this.getGenerateOrderButton(), "report");
        this.getBodyOder().add(this.getGenerateOrderButton());
        this.getGenerateOrderButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e) && isEnableReporteButton()) {
                    try {
                        ClientService.saveIceCreams(iceCreams);
                        JOptionPane.showMessageDialog(null, "Su reporte se ha generado");
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

    public boolean isEnableButtonSelect() {
        return enableButtonSelect;
    }

    public void setEnableButtonSelect(boolean enableButtonSelect) {
        this.enableButtonSelect = enableButtonSelect;
    }

    public boolean isEnableReporteButton() {
        return enableReporteButton;
    }

    public void setEnableReporteButton(boolean enableReporteButton) {
        this.enableReporteButton = enableReporteButton;
    }
}
