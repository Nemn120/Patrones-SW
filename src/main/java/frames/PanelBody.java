package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelBody extends JPanel {
        private int widthBody;
        private int heightBody;
        private JPanel body;
        private ImagesBody imageBody;

    public PanelBody(int width, int height) {
        this.widthBody = width;
        this.heightBody = height;
        this.setLayout(new BorderLayout());
        this.body = new JPanel();
        this.createBody();
    }

    public PanelBody() { };

    public void createBody() {
        this.body.setPreferredSize(new Dimension(this.getWidthBody(), this.getHeightBody()));
        this.createBodyImages();
        this.createButtons();
        JTextArea mensaje = new JTextArea(5, 90);
        mensaje.setText("HOLA");
        //mensaje.setSize(new Dimension(900, 300));
        JTextArea ventas = new JTextArea(5, 90);
        mensaje.setText("VENTAS");
        this.getBody().add(mensaje);
        this.getBody().add(ventas);
    }

    public void createButtons() {
        JButton showIceCreams = new JButton("Lista de Helados");
        JButton orderIceCream = new JButton("Pedir Helado");
        this.getBody().add(showIceCreams);
        this.getBody().add(orderIceCream);
        orderIceCream.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    OrderIceCream orderPanel = new OrderIceCream();
                    orderPanel.OrderPanel();
                }
            }
        });
    }

    public void createBodyImages() {
        this.imageBody = new ImagesBody();
        for(int i=0; i<3; i++) {
            this.getBody().add(this.imageBody.setIcon(String.valueOf(i+1)));
        }
    }

    public int getWidthBody() {
        return widthBody;
    }

    public void setWidthBody(int widthBody) {
        this.widthBody = widthBody;
    }

    public int getHeightBody() {
        return heightBody;
    }

    public void setHeightBody(int heightBody) {
        this.heightBody = heightBody;
    }

    public JPanel getBody() {
        return body;
    }

    public void setBody(JPanel body) {
        this.body = body;
    }
}
