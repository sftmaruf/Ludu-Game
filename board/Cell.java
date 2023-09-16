package com.shafayetmaruf.assignment.assignment1.question4.board;

import com.shafayetmaruf.assignment.assignment1.question4.interfaces.ICell;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPawn;

import java.util.ArrayList;
import java.util.List;

public class Cell implements ICell {
    private String design;
    private List<IPawn> pawns;

    public Cell(String design) {
        this.design = design;
        pawns = new ArrayList<>();
    }

    public void addPawn(IPawn pawn) {
        pawns.add(pawn);
    }

    @Override
    public String getLastPawnSign() {
        int index = pawns.size() - 1;
        return this.getPawns().get(index).getSign();
    }

    public boolean hasPawn() {
        if (pawns.size() == 0) return false;
        return true;
    }

    @Override
    public String getDesign() {
        return design;
    }

    @Override
    public List<IPawn> getPawns() {
        return pawns;
    }
}
