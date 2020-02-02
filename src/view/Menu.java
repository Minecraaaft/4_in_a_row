package view;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    JButton button = new JButton("Play  again");
    JLabel label = new JLabel("Press here to play again");

    public Menu() {
        add(button);
        add(label);
        setPreferredSize(new Dimension(950, 45));
    }





    public void paintComponent(Graphics graphics) {
        graphics.setColor(new Color(200, 58, 91));
        graphics.fillRect(0,0, getWidth(), 2000);
    }
}
