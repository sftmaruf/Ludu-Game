package com.shafayetmaruf.assignment.assignment1.question4.interfaces;

import com.shafayetmaruf.assignment.assignment1.question4.enums.PlayerNumber;
import com.shafayetmaruf.assignment.assignment1.question4.board.Board;
import com.shafayetmaruf.assignment.assignment1.question4.enums.Colors;
import com.shafayetmaruf.assignment.assignment1.question4.board.ConsoleBoard;

import java.util.List;

public interface IPlayer {
    boolean movePawn(int index, int point);

    boolean hasAnyOpenedPawn();

    IPawn getPawn(int index);

    IUser getUser();

    PlayerNumber getPlayerNo();

    void setPlayerNo(PlayerNumber playerNo);

    Colors getColor();

    List<IPawn> getPawns();

    void setPawns(String sign);

    int getStartingRow();

    void setStartingRow(int startingRow);

    void setStartingColumn(int startingColumn);

    int getStartingColumn();

    int getEndingRow();

    void setEndingRow(int endingRow);

    int getEndingColumn();

    void setEndingColumn(int endingColumn);

    int getNOfOpenedPawn();

    void setNOfOpenedPawn(int nOfOpenedPawn);

    int getNOfHomeBasedPawn();

    void setNOfHomeBasedPawn(int nOfHomeBasedPawn);

    Board getBoard();

    void setBoard(ConsoleBoard board);
}
