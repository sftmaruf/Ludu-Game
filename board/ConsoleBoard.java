package com.shafayetmaruf.assignment.assignment1.question4.board;

import com.shafayetmaruf.assignment.assignment1.question4.gameplay.Mode;
import com.shafayetmaruf.assignment.assignment1.question4.enums.Colors;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.ICell;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IHomeBase;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPawn;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPlayerYard;

public class ConsoleBoard extends Board {
    public ConsoleBoard(Mode mode) {
        super(mode, new Cell[15][15]);
        mode.setBoardToPlayer(this);
        generateBoard("-", "0");
    }

    public void placePawn(int i, int j, String flag, IPawn pawn) {
        if (flag == "r") {
            board[i][j].getPawns().remove(pawn);
        }

        // ar means append and refresh
        if (flag.startsWith("a")) {
            placePawn(i, j, pawn);
            mode.conflictMechanism(board, i, j);
            if (flag.endsWith("r")) viewBoard();
        }
    }

    public void generateBoard(String playerYardHomeBaseSign, String PathSign) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (isStoppage(row, column)) {
                    board[row][column] = IPlayerYard.setDesign(designedCell("x", row, column));
                } else if (IHomeBase.isHomeBaseArea(row, column) || IPlayerYard.isPlayerYard(row, column)) {
                    board[row][column] = IPlayerYard.setDesign("  " + playerYardHomeBaseSign);
                } else {
                    board[row][column] = new Cell(designedCell(PathSign, row, column));
                }
            }
        }

        playerYards.setPawnsInsideYard();
    }

    private String designedCell(String str, int row, int column) {
        return "  " + ConsoleBoardService.getConsoleBoard().getColorCode(row, column) + str + Colors.RESET.getCode();
    }

    public void viewBoard() {
        ConsoleBoardService.getConsoleBoard().viewBoard(this);
    }

    private void placePawn(int i, int j, IPawn pawn) {
        board[i][j].addPawn(pawn);
    }

    public ICell[][] getPaths() {
        return board;
    }
}
