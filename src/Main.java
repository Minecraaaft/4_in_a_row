import view.GameView;
import view.Menu;


import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Connect 4");
        jFrame.setVisible(true);

        GameView b = new GameView();
        JPanel menu = new Menu();


        menu.setPreferredSize(new Dimension(950, 45));
        b.setPreferredSize(new Dimension(950, 705));

        jFrame.add(menu);
        jFrame.add(b);
        b.start();
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        jFrame.setSize(950,750);

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


}
