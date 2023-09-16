package com.shafayetmaruf.assignment.assignment1.question4.board;

import com.shafayetmaruf.assignment.assignment1.question4.enums.Colors;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.ICell;

public class ConsoleBoardService {

    private static ConsoleBoardService consoleBoard;

    private ConsoleBoardService(){
    }

    public static ConsoleBoardService getConsoleBoard(){
        if(consoleBoard == null) consoleBoard = new ConsoleBoardService();
        return consoleBoard;
    }

    public void viewBoard(com.shafayetmaruf.assignment.assignment1.question4.board.ConsoleBoard board) {
        lineBreak();
        for (int row = 0; row < board.getPaths().length; row++) {
            for (int column = 0; column < board.getPaths()[0].length; column++) {
                ICell cell = board.getPaths()[row][column];
                if (column == 0) padding(4);

                if (!cell.hasPawn()) {
                    System.out.print(cell.getDesign());
                } else {
                    System.out.print(cell.getLastPawnSign());
                }
            }
            lineBreak();
        }
        lineBreak();
    }

    private void lineBreak() {
        System.out.println();
    }

    private void padding(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(" ");
        }
    }

    public String getColorCode(int row, int column) {
        if (row == 7 && (column >= 1 && column <= 5) || (row == 6 && column == 1)) return Colors.RED.getCode();
        if (row == 7 && (column >= 9 && column <= 13) || (row == 8 && column == 13)) return Colors.YELLOW.getCode();
        if ((row >= 1 && row <= 5) && column == 7 || (row == 1 && column == 8)) return Colors.GREEN.getCode();
        if ((row >= 9 && row <= 13) && column == 7 || (row == 13 && column == 6)) return Colors.BLUE.getCode();
        return Colors.RESET.getCode();
    }
}
