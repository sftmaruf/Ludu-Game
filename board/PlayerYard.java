package com.shafayetmaruf.assignment.assignment1.question4.board;

import com.shafayetmaruf.assignment.assignment1.question4.gameplay.Mode;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPawn;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPlayer;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPlayerYard;

public class PlayerYard implements IPlayerYard {
    private Board board;

    public PlayerYard(Board board) {
        this.board = board;
    }

    @Override
    public void setPawnsInsideYard() {
        Mode mode = board.getMode();
        for (IPlayer player : mode.getPlayers()) {
            for (IPawn pawn : player.getPawns()) {
                int row = pawn.getRowInsideYard();
                int column = pawn.getColumnInsideYard();
                board.placePawn(row, column, "a", pawn);
            }
        }
    }

    @Override
    public void setPawnInsideYard(IPawn pawn){
        board.placePawn(pawn.getRow(), pawn.getColumn(), "r", pawn);
        pawn.setRowColumn(pawn.getRowInsideYard(), pawn.getColumnInsideYard());
        board.placePawn(pawn.getRowInsideYard(), pawn.getColumnInsideYard(), "a", pawn);
    }

    @Override
    public void removePawnFromYard(int row, int column, IPawn pawn) {
        board.placePawn(row, column, "r", pawn);
    }
}
