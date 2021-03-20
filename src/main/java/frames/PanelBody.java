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
        this.body.setBackground(new Color(231,239,232));
        JLabel message = new JLabel();
        message.setPreferredSize(new Dimension(1000, 100));
        message.setOpaque(true);
        message.setBackground(new Color(231,239,232));
        message.setFont(new Font("Arial", Font.BOLD, 40));
        message.setText("  *****BIENVENIDO A LA FÁBRICA DE HELADOS*****");
        message.setForeground(Color.DARK_GRAY);
        this.getBody().add(message);
        this.createBodyImages();
        this.createButtons();
        //JTextArea mensaje = new JTextArea(5, 90);
        //mensaje.setText("HOLA");
        //mensaje.setSize(new Dimension(900, 300));
        //this.getBody().add(mensaje);
        //this.createTableSales();
    }

    public void createButtons() {
        JButton orderIceCream = new JButton("Pedir Helado");
        ImageIcon image = new ImageIcon("./icons/order.png");
        Image img = image.getImage();
        Image scaledImg = img.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        image = new ImageIcon(scaledImg);
        orderIceCream.setIcon(image);
        orderIceCream.setHorizontalAlignment(SwingConstants.LEFT);;
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

    public void createTableSales() {
        SalesHistory salesHistory = new SalesHistory();
        this.getBody().add(salesHistory.getSaleHistoryBody());
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
