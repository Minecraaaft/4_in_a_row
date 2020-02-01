import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOError;
import java.io.IOException;

public class Background extends JPanel {
    private BufferedImage background, level, token;


    public Background() {

        try {
            background = ImageIO.read(new File("res/Layer1.png"));
            level = ImageIO.read(new File("res/Layer2.png"));
            token = ImageIO.read(new File("res/circles.png"));
        } catch (Exception e) {e.getStackTrace();}

    }





    public void paintGame(Graphics graphics, int y) {
        graphics.drawImage(background, 0,0, background.getWidth(), background.getHeight(), null);

        int yJump = 90;
        int xJump = 105;

        graphics.drawImage(token, 105 + xJump,110 + y, 225 + xJump,230 + y, 0,0, 100, 100, null);

        graphics.drawImage(level, -140,0, level.getWidth(), level.getHeight(), null);

        graphics.dispose();
    }
}
