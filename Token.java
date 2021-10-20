package com.shafayetmaruf.assignment.assignment1.question4;

public class Token {
    private int id;
    private String color;
    private int row;
    private int column;
    private String sign;
    private int point;

    public Token(int id, String color, String sign) {
        this.id = id;
        this.color = color;
        this.sign = sign;
        setXY();
    }

    private void setXY() {
        row = -1;
        column = -1;
    }

    public void setPosition(Player player, int point) {
        this.point = point;

//        if (player.getPlayerNo() == "Player 1") {
        if (isOpening()) {
            if (isPointSix(point)) {
                placeFirstToken(player);
                Gameplay.getBoard().placeToken(row, column, sign + this.id + " ");
            }
        } else {
            Gameplay.getBoard().placeToken(row, column, "r", sign + this.id + " ");
            calculatePosition();
//                if(isEnding(player)){
//                    enterHome(Math.abs(column - point));
//                }
            Gameplay.getBoard().placeToken(row, column, sign + this.id + " ");
        }
//        }
    }

    private boolean isEnding(Player player) {
        if (row < player.getEndingRow() && column >= player.getEndingColumn()) {
            return true;
        }
        return false;
    }

    private void enterHome() {
        column += point;
        row = 7;
    }

    private void calculatePosition() {
//        lowerLeftMechanism();
        upperLeftMechanism();
    }

    private void upperLeftMechanism() {

        if (row == 6 && (column >= 0 && column <= 5 && column + point <= 5)) {
            row = 6;
            column += point;
        } else if (row == 6 && (column >= 0 && column <= 5 && column + point > 5)) {
            row -= (column + point) - 5;
            column = 6;
        } else if ((row >= 0 && row <= 5 && row - point >= 0) && column == 6) {
            row -= point;
            column = 6;
        } else if ((row >= 0 && row <= 5) && (row - point < 0 && row - point >= -2) && column == 6) {
            column += Math.abs(row - point);
            row = 0;
        } else if ((row >= 0 && row <= 5 && row - point < -2) && column == 6) {
            row = Math.abs(row - point) - 2;
            column = 8;
        } else if (row == 0 && (column >= 6 && column <= 8 && column + point <= 8)) {
            row = 0;
            column += point;
        } else if (row == 0 && (column >= 6 && column <= 8 && column + point > 8)) {
            if (column == 8) {
                row += point;
            } else {
                row += point - (8 - column);
            }
            column = 8;
        } else {
            upperRightMechanism();
        }
    }

    private void upperRightMechanism() {
        if ((row >= 0 && row <= 5 && row + point <= 5) && column == 8) {
            row += point;
            column = 8;
        } else if ((row >= 0 && row <= 5 && row + point > 5) && column == 8) {
            column += (row + point) - 5;
            row = 6;
        } else if (row == 6 && (column >= 9 && column <= 14 && column + point <= 14)) {
            row = 6;
            column += point;
        } else if (row == 6 && (column >= 9 && column <= 14) && (column + point > 14 && column + point <= 16)) {
            row += (column + point) - 14;
            column = 14;
        } else if (row == 6 && (column >= 9 && column <= 14) && (column + point > 16)) {
            row = 8;
            column = 14 - ((column + point) - 16);
        } else if ((row >= 6 && row <= 8 && row + point <= 8) && column == 14) {
            row += point;
            column = 14;
        } else if ((row >= 6 && row <= 8 && row + point > 8) && column == 14) {
            if (row == 8) {
                column -= point;
            } else {
                column -= (row + point - 8);
            }
            row = 8;
        } else {
            lowerRightMechanism();
        }
    }

    private void lowerRightMechanism() {
        if (row == 14 && column - point >= 6) {
            row = 14;
            column -= point;
        } else if (row == 14 && column - point < 6) {
            if (column == 6) {
                row -= point;
            } else {
                row -= point - (column - 6);
            }
            column = 6;
        } else if ((row > 8 && column == 8) && (row + point > 14 && row + point <= 16)) {
            column -= (row + point) - 14;
            row = 14;
        } else if ((row > 8 && column == 8) && row + point > 16) {
            column = 6;
            row -= (row + point) - 16;
        } else if ((row > 8 && row <= 14) && column == 8) { // player 1 going down
            row += point;
            column = 8;
        } else if ((row == 8 && column > 8) && column - point < 9) { // player 1 turn left
            row += Math.abs((column - 9) - point);
            column = 8;
        } else if ((row == 8 && column > 8) && column - point > 8) { // player 1 going forward
            row = 8;
            column -= point;
        } else {
            lowerLeftMechanism();
        }
    }

    private void lowerLeftMechanism() {
        if (row == 8 && (column < 6 && column - point < -2)) {
            column = Math.abs(column - point) - 2;
            row = 6;
        } else if ((row == 8 && column < 6) && (column - point < 0 && column - point >= -2)) {
            row -= Math.abs(column - point);
            column = 0;
        } else if ((row == 8 && column < 6) && (column - point >= 0 || column - point < 6)) {
            row = 8;
            column -= point;
        } else if ((row - point < 9 && row > 8) && column == 6) {
            column = 6 - Math.abs(9 - (row - point));
            row = 8;
        } else if ((row >= 9 && row <= 14 && row - point >= 9) && column == 6) {
            row -= point;
            column = 6;
        }
    }

    private boolean isOpening() {
        if (this.row == -1 && this.column == -1) {
            return true;
        }
        return false;
    }

    private boolean isPointSix(int point) {
        if (point == 6) {
            return true;
        }
        return false;
    }

    private void placeFirstToken(Player player) {
        row = player.getStartingRow();
        column = player.getStartingColumn();
    }
}
