package view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Token {
    private String[][] board = new String[6][7];
    private Point endPosition = new Point(), currentPosition = new Point();
    private boolean positionMade = true;
    private Image token;
    private int rowPixels = 90;
    private int columnPixels = 105;
    private int fallSpeed = 10;
    private boolean tokenInMotion;


    public Token() {
        try {
            token = ImageIO.read(new File("res/circles.png"));
        } catch (Exception e)
        {e.getStackTrace();}
    }

    public void drawTokens(Graphics graphics) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != null && board[i][j].equals("red")) {
                    int rowPixels = 90;
                    int columnPixels = 105;
                    graphics.drawImage(token, 105 + j * columnPixels, 110 + i * rowPixels, 225 + j * columnPixels, 230 + i * rowPixels, 0, 0, 100, 100, null);
                } else if (board[i][j] != null && board[i][j].equals("blue")) {
                    int rowPixels = 90;
                    int columnPixels = 105;
                    graphics.drawImage(token, 100 + j * columnPixels, 110 + i * rowPixels, 220 + j * columnPixels, 230 + i * rowPixels, 100, 0, 200, 100, null);

                }
            }
        }
    }


    public void addToken(Graphics graphics, int row, int column, String player) {
        if (positionMade && !tokenInMotion) {
            currentPosition.setLocation(105 * 4, 0);
            endPosition.setLocation(columnPixels * column, rowPixels * row);
            positionMade = false;
        }
        if (currentPosition.getY() != endPosition.getY()) {
//
            currentPosition.setLocation(currentPosition.getX(), currentPosition.getY() + fallSpeed);
            if (player.equals("red")) {
                graphics.drawImage(token, 105 + column * columnPixels, 110 + (int) currentPosition.getY(), 225 + column * columnPixels, 230 + (int) currentPosition.getY(), 0, 0, 100, 100, null);

            } else {
                graphics.drawImage(token, 100 + column * columnPixels, 110 + (int) currentPosition.getY(), 220 + column * columnPixels, 230 + (int) currentPosition.getY(), 100, 0, 200, 100, null);
            }

            tokenInMotion = true;
        } else {
            board[row][column] = player;
            positionMade = true;
            tokenInMotion = false;
        }
    }

    public boolean isTokenInMotion() {
        return tokenInMotion;
    }
}
