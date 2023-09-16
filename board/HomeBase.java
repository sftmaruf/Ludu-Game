package com.shafayetmaruf.assignment.assignment1.question4.board;

import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IHomeBase;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPawn;

import java.util.HashSet;
import java.util.Set;

public class HomeBase implements IHomeBase {
    private Set<IPawn> homeBase;
    private Board board;

    public HomeBase(Board board) {
        this.homeBase = new HashSet<>();
        this.board = board;
    }

    @Override
    public void enterHomeBase(Pawn pawn) {
        homeBase.add(pawn);
    }

    @Override
    public boolean isExist(Pawn pawn){
        return homeBase.contains(pawn);
    }
}
