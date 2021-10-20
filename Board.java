package com.shafayetmaruf.assignment.assignment1.question4;

public class Board {
    private Cell[][] board;
    private Dice dice;
    private Mode mode;

    public Board(Mode mode) {
        this.mode = mode;
        dice = new Dice();
        generateBoard();
    }

    public void generateBoard() {
        board = new Cell[15][15];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isPlayerYard(i, j)) {
                    board[i][j] = new Cell("- ");
                } else {
                    board[i][j] = new Cell("0 ");
                }
            }
        }
    }

    public void viewBoard() {
        Cell cell;
        int indexOfLastToken;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                cell = board[i][j];
                indexOfLastToken = cell.getNumberOfToken();
                System.out.print(cell.getTokens().get(indexOfLastToken));
            }
            System.out.println();
        }
    }

    private boolean isPlayerYard(int i, int j) {
        return (i < 6 && j < 6) || (i < 6 && j > 8) || (i > 8 && j < 6) || (i > 8 && j > 8) || ((i > 5 && i < 9) && (j > 5 && j < 9));
    }

    public Mode getMode() {
        return mode;
    }

    public Dice getDice() {
        return dice;
    }

    public void placeToken(int i, int j, String sign) {
        if (sign != "0 ") {
            board[i][j].getTokens().add(sign);
            viewBoard();
        }
    }

    public void placeToken(int i, int j, String flag, String sign) {
        if (flag == "r") {
            System.out.println(board[i][j].getTokens().indexOf(sign));
            System.out.println(board[i][j].getTokens().remove(board[i][j].getTokens().indexOf(sign)));
        }

        if(flag == "a"){
            placeToken(i, j, sign);
        }
    }
}
