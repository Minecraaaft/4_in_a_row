import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GameView extends JFrame {
    private Background b = new Background();

    public GameView() {
        setTitle("4 in a row");
        setVisible(true);

        add(b);
//        setLayout(new FlowLayout());
        setSize(950,705);


    }

    public void moveToken() {
        for (int i = 0; i < 460; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {

            }
            b.paintGame(getGraphics(), i);
        }
    }


}
