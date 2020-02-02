package view;

import model.GameLogic;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GameView extends Applet implements Runnable {
    private BufferedImage background, level;
    private Image screen;
    private Token token = new Token();
    public int column, row;
    public boolean addingToken;
    private GameLogic gameLogic = new GameLogic();


    public GameView() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_1:
                        if (!token.isTokenInMotion()) {
                            column = 0;
                            row = gameLogic.addToken(column);
                            if (row <7)
                                addingToken = true;
                        }
                        break;
                    case KeyEvent.VK_2:
                        if (!token.isTokenInMotion()) {
                            column = 1;
                            row = gameLogic.addToken(column);
                            if (row <7)
                                addingToken = true;
                        }
                        break;
                    case KeyEvent.VK_3:
                        if (!token.isTokenInMotion()) {
                            column = 2;
                            row = gameLogic.addToken(column);
                            if (row <7)
                                addingToken = true;
                        }
                        break;
                    case KeyEvent.VK_4:
                        if (!token.isTokenInMotion()) {
                            column = 3;
                            row = gameLogic.addToken(column);
                            if (row <7)
                                addingToken = true;
                        }
                        break;
                    case KeyEvent.VK_5:
                        if (!token.isTokenInMotion()) {
                            column = 4;
                            row = gameLogic.addToken(column);
                            if (row <7)
                                addingToken = true;
                        }
                        break;
                    case KeyEvent.VK_6:
                        if (!token.isTokenInMotion()) {
                            column = 5;
                            row = gameLogic.addToken(column);
                            if (row <7)
                                addingToken = true;
                        }
                        break;
                    case KeyEvent.VK_7:
                        if (!token.isTokenInMotion()) {
                            column = 6;
                            row = gameLogic.addToken(column);
                            if (row <7)
                                addingToken = true;
                        }
                        break;
                }
            }

        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (!token.isTokenInMotion()) {
                    if (e.getX() > 90 && e.getX() < 200) {
                        column = 0;
                        row = gameLogic.addToken(column);
                        addingToken = true;
                    } else if (e.getX() > 201 && e.getX() < 305) {
                        column = 1;
                        row = gameLogic.addToken(column);
                        addingToken = true;
                    } else if (e.getX() > 306 && e.getX() < 410) {
                        column = 2;
                        row = gameLogic.addToken(column);
                        addingToken = true;
                    } else if (e.getX() > 411 && e.getX() < 515) {
                        column = 3;
                        row = gameLogic.addToken(column);
                        addingToken = true;
                    } else if (e.getX() > 516 && e.getX() < 620) {
                        column = 4;
                        row = gameLogic.addToken(column);
                        addingToken = true;
                    } else if (e.getX() > 621 && e.getX() < 725) {
                        column = 5;
                        row = gameLogic.addToken(column);
                        addingToken = true;

                    } else if (e.getX() > 726 && e.getX() < 830) {
                        column = 6;
                        row = gameLogic.addToken(column);
                        addingToken = true;
                    }

                }
            }
        });

        try {
            background = ImageIO.read(new File("res/newLayer1.png"));
            level = ImageIO.read(new File("res/Layer2newnew.png"));
        } catch (Exception e) {e.getStackTrace();}


    }

    @Override
    public void start() {
        new Thread(this).start();
    }




    public void render() {
        Graphics graphics = screen.getGraphics();
        graphics.drawImage(background, 0, 0, background.getWidth(), background.getHeight(), null);
        double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
//        System.out.println(mouseX);
        if (addingToken && row != -1) {
            token.addToken(graphics, row, column, gameLogic.getCurrentPlayer());

            if (!token.isTokenInMotion()) {
                gameLogic.nextPlayer();
                addingToken = false;
            }
            gameLogic.checkForWin();
            if (gameLogic.getWinner() != null) {
                System.out.println(gameLogic.getWinner() + " has won");
            }
        } else {
            token.tokenHover(graphics, (int) mouseX, gameLogic.getCurrentPlayer());
        }

        token.drawTokens(graphics);
        graphics.drawImage(level, -140, 0, level.getWidth(), level.getHeight(), null);


        graphics = getGraphics();
        graphics.drawImage(screen, 0, 0, 950, 705, 0, 0, 950, 705, null);
        graphics.dispose();

    }


    @Override
    public void run() {
        screen = createVolatileImage(950,705);


        while (true) {
            render();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }

        }



    }
}
