package com.shafayetmaruf.assignment.assignment1.question4;

import com.shafayetmaruf.assignment.assignment1.question4.board.*;
import com.shafayetmaruf.assignment.assignment1.question4.enums.Colors;
import com.shafayetmaruf.assignment.assignment1.question4.enums.PlayerNumber;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPawn;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPlayer;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IUser;

import java.util.ArrayList;
import java.util.List;

public class Player implements IPlayer {
    private IUser user;
    private PlayerNumber playerNo;
    private Colors color;
    private List<IPawn> pawns;
    private int startingRow;
    private int startingColumn;
    private int endingRow;
    private int endingColumn;
    private int nOfOpenedPawn = 0;
    private int nOfHomeBasedPawn = 0;
    private Board board;

    public Player(IUser user, Colors color) {
        this.user = user;
        this.color = color;
        pawns = new ArrayList<>();
    }

    @Override
    public boolean movePawn(int index, int point) {
        if (pawns.size() == 4 && (index > 4 || index < 1)) return false;
        if (point > 6 || point < 1) return false;

        IPawn pawn = getPawn(index);
        return pawn.manipulatePosition(this, point);
    }

    @Override
    public boolean hasAnyOpenedPawn() {
        return getNOfOpenedPawn() > 0;
    }

    @Override
    public IPawn getPawn(int index) {
        return pawns.get(index - 1);
    }

    @Override
    public IUser getUser() {
        return user;
    }

    @Override
    public PlayerNumber getPlayerNo() {
        return playerNo;
    }

    @Override
    public void setPlayerNo(PlayerNumber playerNo) {
        this.playerNo = playerNo;
    }

    @Override
    public Colors getColor() {
        return color;
    }

    @Override
    public List<IPawn> getPawns() {
        return pawns;
    }

    @Override
    public void setPawns(String sign) {
        for (int i = 1; i <= 4; i++) {
            pawns.add(new Pawn(i, this, sign));
        }
    }

    @Override
    public int getStartingRow() {
        return startingRow;
    }

    @Override
    public void setStartingRow(int startingRow) {
        this.startingRow = startingRow;
    }

    @Override
    public void setStartingColumn(int startingColumn) {
        this.startingColumn = startingColumn;
    }

    @Override
    public int getStartingColumn() {
        return startingColumn;
    }

    @Override
    public int getEndingRow() {
        return endingRow;
    }

    @Override
    public void setEndingRow(int endingRow) {
        this.endingRow = endingRow;
    }

    @Override
    public int getEndingColumn() {
        return endingColumn;
    }

    @Override
    public void setEndingColumn(int endingColumn) {
        this.endingColumn = endingColumn;
    }

    public int getNOfOpenedPawn() {
        return nOfOpenedPawn;
    }

    public void setNOfOpenedPawn(int nOfOpenedPawn) {
        this.nOfOpenedPawn = nOfOpenedPawn;
    }

    @Override
    public int getNOfHomeBasedPawn() {
        return nOfHomeBasedPawn;
    }

    @Override
    public void setNOfHomeBasedPawn(int nOfHomeBasedPawn) {
        this.nOfHomeBasedPawn = nOfHomeBasedPawn;
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public void setBoard(ConsoleBoard board) {
        this.board = board;
    }

}
