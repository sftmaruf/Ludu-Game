package com.shafayetmaruf.assignment.assignment1.question4.gameplay;

import com.shafayetmaruf.assignment.assignment1.question4.board.ConsoleBoard;
import com.shafayetmaruf.assignment.assignment1.question4.enums.Modes;
import com.shafayetmaruf.assignment.assignment1.question4.enums.PlayerNumber;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.ICell;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPawn;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPlayer;

import java.util.HashSet;
import java.util.Set;

public abstract class Mode {
    protected String name;
    protected int nOfPlayer;
    protected Set<IPlayer> players;

    public Mode(int nOfPlayer, Modes modes) {
        players = new HashSet<>();
        this.nOfPlayer = nOfPlayer;
        this.name = modes.getName();
    }

    protected void setupPlayers(){
        assignPlayersNumber();
        assignPawnsToPlayers();
        setPawnInitialYardPosition();
        setPlayerStartAndEndPoint();
    }

    protected abstract void assignPlayersNumber();

    protected abstract void assignPawnsToPlayers();

    protected abstract void setPawnInitialYardPosition();

    protected abstract void setPlayerStartAndEndPoint();

    public abstract void setBoardToPlayer(ConsoleBoard board);

    public abstract void conflictMechanism(ICell[][] board, int row, int column);

    protected void resolveConflict(IPawn pawn) {
        IPlayer player = pawn.getPlayer();
        if(player.getNOfOpenedPawn() > 0) player.setNOfOpenedPawn(player.getNOfOpenedPawn() - 1);
        player.getBoard().getPlayerYards().setPawnInsideYard(pawn);
    }

    public String getName() {
        return name;
    }

    public Set<IPlayer> getPlayers() {
        return players;
    }

    protected void setPawnsInitialYardPositionOfPlayer1(IPlayer player) {
        player.getPawn(1).setRowInsideYard(1).setColumnInsideYard(1);
        player.getPawn(2).setRowInsideYard(1).setColumnInsideYard(4);
        player.getPawn(3).setRowInsideYard(4).setColumnInsideYard(1);
        player.getPawn(4).setRowInsideYard(4).setColumnInsideYard(4);
    }

    protected void setPawnsInitialYardPositionOfPlayer2(IPlayer player) {
        player.getPawn(1).setRowInsideYard(1).setColumnInsideYard(10);
        player.getPawn(2).setRowInsideYard(1).setColumnInsideYard(13);
        player.getPawn(3).setRowInsideYard(4).setColumnInsideYard(10);
        player.getPawn(4).setRowInsideYard(4).setColumnInsideYard(13);
    }

    protected void setPawnsInitialYardPositionOfPlayer3(IPlayer player) {
        player.getPawn(1).setRowInsideYard(10).setColumnInsideYard(10);
        player.getPawn(2).setRowInsideYard(10).setColumnInsideYard(13);
        player.getPawn(3).setRowInsideYard(13).setColumnInsideYard(10);
        player.getPawn(4).setRowInsideYard(13).setColumnInsideYard(13);
    }

    protected void setPawnsInitialYardPositionOfPlayer4(IPlayer player) {
        player.getPawn(1).setRowInsideYard(10).setColumnInsideYard(1);
        player.getPawn(2).setRowInsideYard(10).setColumnInsideYard(4);
        player.getPawn(3).setRowInsideYard(13).setColumnInsideYard(1);
        player.getPawn(4).setRowInsideYard(13).setColumnInsideYard(4);
    }

    protected void setPlayer1StartAndEndPosition(IPlayer player){
        player.setStartingRow(6);
        player.setStartingColumn(1);
        player.setEndingRow(7);
        player.setEndingColumn(0);
    }

    protected void setPlayer2StartAndEndPosition(IPlayer player){
        player.setStartingRow(1);
        player.setStartingColumn(8);
        player.setEndingRow(6);
        player.setEndingColumn(7);
    }

    protected void setPlayer3StartAndEndPosition(IPlayer player){
        player.setStartingRow(8);
        player.setStartingColumn(13);
        player.setEndingRow(7);
        player.setEndingColumn(8);
    }

    protected void setPlayer4StartAndEndPosition(IPlayer player){
        player.setStartingRow(13);
        player.setStartingColumn(6);
        player.setEndingRow(8);
        player.setEndingColumn(7);
    }

    public abstract IPlayer getSpecificPlayer(PlayerNumber playerNumber);
}
