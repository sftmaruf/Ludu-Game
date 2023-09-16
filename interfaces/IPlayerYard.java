package com.shafayetmaruf.assignment.assignment1.question4.interfaces;

import com.shafayetmaruf.assignment.assignment1.question4.board.Cell;

public interface IPlayerYard {
    static Cell setDesign(String sign) {
        return new Cell(sign);
    }

    static boolean isPlayerYard(int row, int column) {
        return ((row < 6 && column < 6) || (row < 6 && column > 8))
                || ((row > 8 && column < 6) || (row > 8 && column > 8));
    }

    void setPawnsInsideYard();

    void setPawnInsideYard(IPawn pawn);

//    void removePawnFromYard(int row, int column, String sign);
    void removePawnFromYard(int row, int column, IPawn pawn);
}
