import view.GameView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        GameView b = new GameView();

        JFrame jFrame = new JFrame();
        jFrame.setTitle("4 in a row");
        jFrame.setVisible(true);

        jFrame.add(b);
        jFrame.setSize(950,705);
        b.start();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


}
