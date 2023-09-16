package com.shafayetmaruf.assignment.assignment1.question4.interfaces;

import java.util.List;

public interface ICell {
//    List<String> getPawns();

    String getLastPawnSign();

//    String getLastPawn();

    boolean hasPawn();

    void addPawn(IPawn pawn);

    List<IPawn> getPawns();

    String getDesign();
}
