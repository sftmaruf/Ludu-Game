package com.shafayetmaruf.assignment.assignment1.question4.board;

import com.shafayetmaruf.assignment.assignment1.question4.Player;

public class PawnService {
    private Pawn pawn;
    private int row;
    private int column;

    public PawnService(Pawn pawn) {
        this.pawn = pawn;
    }

    public boolean isPawnStaged() {
        if (pawn.getRow() == pawn.getRowInsideYard() && pawn.getColumn() == pawn.getColumnInsideYard()) {
            return true;
        }
        return false;
    }

    public boolean isPointSix(int point) {
        if (point == 6) {
            return true;
        }
        return false;
    }

    public void calculatePosition(int point, Player player) {
        row = pawn.getRow();
        column = pawn.getColumn();
        upperLeftMechanism(point, player);
    }

    private void upperLeftMechanism(int point, Player player) {
        if (row == 6 && (column >= 0 && column <= 5 && column + point <= 5)) {
            row = 6;
            column += point;
            pawn.setRowColumn(row, column);
        } else if (row == 6 && (column >= 0 && column <= 5 && column + point > 5)) {
            row -= (column + point) - 5;
            column = 6;
            pawn.setRowColumn(row, column);
        } else if ((row >= 0 && row <= 5 && row - point >= 0) && column == 6) {
            row -= point;
            column = 6;
            pawn.setRowColumn(row, column);
        } else if (row == 0 && (column >= 6 && column <= 8 && column + point <= 8)) {
            if (isPlayer(player, "Player 2")) {
                enterHomeRowOfPlayer2(point);
            } else {
                row = 0;
                column += point;
                pawn.setRowColumn(row, column);
            }
        } else if (row == 0 && (column >= 6 && column < 8 && column + point > 8)) {
            if (isPlayer(player, "Player 2")) {
                enterHomeRowOfPlayer2(point);
            } else {
                row += point - (8 - column);
                column = 8;
                pawn.setRowColumn(row, column);
            }
        } else if ((row >= 0 && row <= 5) && (row - point < 0 && row - point >= -2) && column == 6) {
            if (isPlayer(player, "Player 2") && (row - point == -2)) {
                enterHomeRowOfPlayer2(point);
            } else {
                column += Math.abs(row - point);
                row = 0;
                pawn.setRowColumn(row, column);
            }
        } else if ((row >= 0 && row <= 5 && row - point < -2) && column == 6) {
            if (isPlayer(player, "Player 2")) {
                enterHomeRowOfPlayer2(point);
            } else {
                row = Math.abs(row - point) - 2;
                column = 8;
                pawn.setRowColumn(row, column);
            }
        } else {
            upperRightMechanism(point, player);
        }
    }

    private void enterHomeRowOfPlayer2(int point) {
        int tempRow = Math.abs(row - point);
        if (column != 7) tempRow -= 1;
        row = tempRow;
        column = 7;
        pawn.setRowColumn(row, column);
    }

    private void upperRightMechanism(int point, Player player) {
        if ((row >= 0 && row <= 5 && row + point <= 5) && column == 8) {
            row += point;
            column = 8;
            pawn.setRowColumn(row, column);
        } else if ((row >= 0 && row <= 5 && row + point > 5) && column == 8) {
            column += (row + point) - 5;
            row = 6;
            pawn.setRowColumn(row, column);
        } else if (row == 6 && (column >= 9 && column <= 14 && column + point <= 14)) {
            row = 6;
            column += point;
            pawn.setRowColumn(row, column);
        } else if (row == 6 && (column >= 9 && column <= 14) && (column + point > 14 && column + point <= 16)) {
            if (isPlayer(player, "Player 3") && (column + point == 16)) {
                enterHomeRowOfPlayer3(point);
            } else {
                row += (column + point) - 14;
                column = 14;
                pawn.setRowColumn(row, column);
            }
        } else if (row == 6 && (column >= 9 && column <= 14 && column + point > 16)) {
            if (isPlayer(player, "Player 3")) {
                enterHomeRowOfPlayer3(point);
            } else {
                row = 8;
                column = 14 - ((column + point) - 16);
                pawn.setRowColumn(row, column);
            }
        } else if ((row >= 6 && row <= 8 && row + point <= 8) && column == 14) {
            if (isPlayer(player, "Player 3")) {
                enterHomeRowOfPlayer3(point);
            } else {
                row += point;
                column = 14;
                pawn.setRowColumn(row, column);
            }
        } else if ((row >= 6 && row < 8 && row + point > 8) && column == 14) {
            if (isPlayer(player, "Player 3")) {
                enterHomeRowOfPlayer3(point);
            } else {
                column -= (row + point) - 8;
                row = 8;
                pawn.setRowColumn(row, column);
            }
        } else {
            lowerRightMechanism(point, player);
        }
    }

    private void enterHomeRowOfPlayer3(int point) {
        int tempColumn = 14 - ((column + point) - 15);
        if (row == 7 && column == 14) tempColumn -= 1;
        row = 7;
        column = tempColumn;
        pawn.setRowColumn(row, column);
    }

    private void lowerRightMechanism(int point, Player player) {
        if (row == 8 && (column >= 9 && column <= 14 && column - point >= 9)) {
            row = 8;
            column -= point;
            pawn.setRowColumn(row, column);
        } else if (row == 8 && (column >= 9 && column <= 14 && column - point < 9)) {
            row += 9 - (column - point);
            column = 8;
            pawn.setRowColumn(row, column);
        } else if ((row >= 9 && row <= 14 && row + point <= 14) && column == 8) {
            row += point;
            column = 8;
            pawn.setRowColumn(row, column);
        } else if ((row >= 9 && row <= 14) && (row + point > 14 && row + point <= 16) && column == 8) {
            if (isPlayer(player, "Player 4") && (row + point == 16)) {
                enterHomeRowOfPlayer4(point);
            } else {
                column -= (row + point) - 14;
                row = 14;
                pawn.setRowColumn(row, column);
            }
        } else if ((row >= 9 && row <= 14 && row + point > 16) && column == 8) {
            if (isPlayer(player, "Player 4")) {
                enterHomeRowOfPlayer4(point);
            } else {
                column = 6;
                row = 14 - ((row + point) - 16);
                pawn.setRowColumn(row, column);
            }
        } else if (row == 14 && (column >= 6 && column <= 8 && column - point >= 6)) {
            if (isPlayer(player, "Player 4")) {
                enterHomeRowOfPlayer4(point);
            } else {
                row = 14;
                column -= point;
                pawn.setRowColumn(row, column);
            }
        } else if (row == 14 && (column >= 7 && column <= 8 && column - point < 6)) {
            if (isPlayer(player, "Player 4")) {
                enterHomeRowOfPlayer4(point);
            } else {
                row -= 6 - (column - point);
                column = 6;
                pawn.setRowColumn(row, column);
            }
        } else {
            lowerLeftMechanism(point, player);
        }
    }

    private void enterHomeRowOfPlayer4(int point) {
        int tempRow = 14 - ((row + point) - 14);
        if (column != 7) tempRow += 1;
        column = 7;
        row = tempRow;
        pawn.setRowColumn(row, column);
    }

    private void lowerLeftMechanism(int point, Player player) {
        if ((row >= 9 && row <= 14 && row - point >= 9) && column == 6) {
            row -= point;
            column = 6;
            pawn.setRowColumn(row, column);
        } else if ((row >= 9 && row <= 14 && row - point < 9) && column == 6) {
            column -= 9 - (row - point);
            row = 8;
            pawn.setRowColumn(row, column);
        } else if (row == 8 && (column >= 0 && column <= 5 && column - point >= 0)) {
            row = 8;
            column -= point;
            pawn.setRowColumn(row, column);
        } else if (row == 8 && (column <= 5 && column - point < 0 && column - point >= -2)) {
            if (isPlayer(player, "Player 1") && (column - point == -2)) {
                enterHomeRowOfPlayer1(point);
            } else {
                row -= Math.abs(column - point);
                column = 0;
                pawn.setRowColumn(row, column);
            }
        } else if (row == 8 && (column < 6 && column - point < -2)) {
            if (isPlayer(player, "Player 1")) {
                enterHomeRowOfPlayer1(point);
            } else {
                column = Math.abs(column - point) - 2;
                row = 6;
                pawn.setRowColumn(row, column);
            }
        } else if ((row >= 6 && row <= 8 && row - point >= 6) && column == 0) {
            if (isPlayer(player, "Player 1")) {
                enterHomeRowOfPlayer1(point);
            } else {
                column = 0;
                row -= point;
                pawn.setRowColumn(row, column);
            }
        } else if ((row > 6 && row <= 8 && row - point < 6) && column == 0) {
            if (isPlayer(player, "Player 1")) {
                enterHomeRowOfPlayer1(point);
            } else {
                column += 6 - (row - point);
                row = 6;
                pawn.setRowColumn(row, column);
            }
        } else {
            homeRowMechanism(point, player);
        }
    }

    private void enterHomeRowOfPlayer1(int point) {
        int tempColumn = Math.abs(column - point) - 1;
        if (row == 7 && column == 0) tempColumn += 1;
        row = 7;
        column = tempColumn;
        pawn.setRowColumn(row, column);
    }

    private void homeRowMechanism(int point, Player player) {
        if (row == 7 && (column >= 1 && column <= 5 && column + point <= 6)) {
            row = 7;
            column += point;
            pawn.setRowColumn(row, column);
            if (column == 6) enterHomeBase(player);
        } else if ((row >= 1 && row <= 5 && row + point <= 6) && column == 7) {
            row += point;
            column = 7;
            pawn.setRowColumn(row, column);
            if (row == 6) enterHomeBase(player);
        } else if (row == 7 && (column >= 9 && column <= 13 && column - point >= 8)) {
            row = 7;
            column -= point;
            pawn.setRowColumn(row, column);
            if (column == 8) enterHomeBase(player);
        } else if ((row >= 9 && row <= 13 && row - point >= 8) && column == 7) {
            row -= point;
            column = 7;
            pawn.setRowColumn(row, column);
            if (row == 8) enterHomeBase(player);
        }
    }

    private void enterHomeBase(Player player) {
        player.getBoard().getHomeBase().enterHomeBase(pawn);
        player.setNOfHomeBasedPawn(player.getNOfHomeBasedPawn() + 1);
    }

    private boolean isPlayer(Player player, String playerNo) {
        if (player.getPlayerNo().value == playerNo) {
            return true;
        }
        return false;
    }
}
