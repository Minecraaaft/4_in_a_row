import view.GameView;
import view.Menu;
import view.MyFrame;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        GameView b = new GameView();

        MyFrame jFrame = new MyFrame();
        jFrame.setTitle("4 in a row");
        jFrame.setVisible(true);

        JPanel jPanel = new JPanel();


        JButton button = new JButton("Play  again");
        JLabel label = new JLabel("Press here to play again");
//
//        button.setBounds(400, 0, 20,20);
//
        jPanel.add(label);
        jPanel.add(button);
        b.setPreferredSize(new Dimension(950, 705));




        jFrame.add(new Menu());
        jFrame.add(b);

        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        jFrame.setSize(950,750);
        b.start();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


}
