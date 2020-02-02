package model;

import java.awt.*;

public class GameLogic {
    private String[][] board = new String[6][7];
    private String[] players = {"red", "blue"};
    private int index;
    private String winner;

    public GameLogic() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = "";
            }
        }
    }

    public int addToken(int column) {
        int row = 69;
        for (int i = board.length; i != 0; i--) {
            if (board[i -1][column].equals("")) {
                board[i -1][column] = players[index];
                row = i - 1;
                checkForWin();
                index = (index + 1) % players.length;

                break;
            }
        }
        return row;
    }

    public String getWinner() {
        return winner;
    }

    public void checkForWin() {

        // horizontal
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (!board[i][j].equals("") && board[i][j].equals(board[i][j + 1]) && board[i][j + 1].equals(board[i][j + 2]) && board[i][j + 2].equals(board[i][j + 3])) {
                    winner = board[i][j];
                }
            }
        }

        // Vertical
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (!board[i][j].equals("") && board[i][j].equals(board[i+1][j]) && board[i+1][j].equals(board[i+2][j]) && board[i+2][j].equals(board[i+3][j])) {
                    winner = board[i][j];
                }
            }
        }

        // cross
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (!board[i][j].equals("") && board[i][j].equals(board[i+1][j+1]) && board[i+1][j+1].equals(board[i+2][j+2]) && board[i+2][j+2].equals(board[i+3][j+3])) {
                    winner = board[i][j];
                }
            }
        }

        // the other cross
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                if (!board[i][j].equals("") && board[i][j].equals(board[i+1][j-1]) && board[i+1][j-1].equals(board[i+2][j-2]) && board[i+2][j-2].equals(board[i+3][j-3])) {
                    winner = board[i][j];
                }
            }
        }

    }

    public String getCurrentPlayer() {
        return players[index];
    }
}
