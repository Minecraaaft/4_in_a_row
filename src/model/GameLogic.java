package model;

public class GameLogic {
    private String[][] board = new String[6][7];
    private String[] players = {"red", "blue"};
    private int index;

    public int addToken(int column) {
        int row = 69;
        for (int i = board.length; i != 0; i--) {
            if (board[i -1][column]== null) {
                board[i -1][column] = players[index];
                row = i - 1;
                index++;
                break;
            }
        }
        return row;
    }

    public String getCurrentPlayer() {
        return players[index];
    }
}
