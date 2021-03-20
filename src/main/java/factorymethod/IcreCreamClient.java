package factorymethod;

import java.awt.*;
import java.io.IOException;

import frames.PanelBody;

import javax.swing.*;

public class IcreCreamClient {

    public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame("FABRICA DE HELADOS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PanelBody body = new PanelBody(1024, 520);
		frame.add(body.getBody(), BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

    }

}
