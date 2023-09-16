package com.shafayetmaruf.assignment.assignment1.question4.interfaces;

import com.shafayetmaruf.assignment.assignment1.question4.board.Pawn;

public interface IHomeBase {
    static boolean isHomeBaseArea(int row, int column) {
        return ((row >= 6 && row <= 8)
                && (column >= 6 && column <= 8));
    }

    void enterHomeBase(Pawn pawn);

    boolean isExist(Pawn pawn);
}
