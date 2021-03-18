package frames;

import factorymethod.factory.IceCreamFactory;
import factorymethod.icecream.IceCreamMachine;
import factorymethod.icecream.impl.IcreCreamChocolate;

import javax.swing.*;
import java.awt.*;

public class ImagesBody {
    private PanelBody body;
    private String imagePath;
    private ImageIcon image;

    public ImagesBody(String imagePath) {
        this.image = new ImageIcon();
        this.imagePath = imagePath;
    }
    public ImagesBody() {

    }

    public PanelBody setIcon(String typeOfIceCream) {
        IceCreamMachine iceCream = IceCreamFactory.getInstance(typeOfIceCream);
        this.setImagePath(iceCream.getImagePath());
        PanelBody panelImage = new PanelBody();
        JLabel icon = new JLabel();
        this.setImage(new ImageIcon(this.getImagePath()));
        Image img = this.getImage().getImage();
        Image imgScale = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        icon.setIcon(scaledIcon);
        panelImage.add(icon);
        panelImage.repaint();
        return panelImage;
    }

    public PanelBody getBody() {
        return body;
    }

    public void setBody(PanelBody body) {
        this.body = body;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
}
