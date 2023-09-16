package com.shafayetmaruf.assignment.assignment1.question4.gameplay.solo;

import com.shafayetmaruf.assignment.assignment1.question4.board.Board;
import com.shafayetmaruf.assignment.assignment1.question4.board.ConsoleBoard;
import com.shafayetmaruf.assignment.assignment1.question4.enums.Modes;
import com.shafayetmaruf.assignment.assignment1.question4.enums.PlayerNumber;
import com.shafayetmaruf.assignment.assignment1.question4.gameplay.Mode;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.ICell;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPawn;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPlayer;

import java.util.List;

public class SoloTwoPlayer extends Mode {
    private IPlayer player1;
    private IPlayer player2;

    public SoloTwoPlayer(IPlayer player1, IPlayer player2) {
        super(2, Modes.Solo);
        this.player1 = player1;
        this.player2 = player2;
        setupPlayers();
        players.add(player1);
        players.add(player2);
    }

    @Override
    protected void assignPlayersNumber() {
        player1.setPlayerNo(PlayerNumber.PLAYER_ONE);
        player2.setPlayerNo(PlayerNumber.PLAYER_THREE);
    }

    @Override
    protected void assignPawnsToPlayers() {
        player1.setPawns("+");
        player2.setPawns("-");
    }

    @Override
    protected void setPawnInitialYardPosition() {
        setPawnsInitialYardPositionOfPlayer1(player1);
        setPawnsInitialYardPositionOfPlayer3(player2);
    }

    @Override
    protected void setPlayerStartAndEndPoint() {
       setPlayer1StartAndEndPosition(player1);
       setPlayer3StartAndEndPosition(player2);
    }

    @Override
    public void setBoardToPlayer(ConsoleBoard board) {
        player1.setBoard(board);
        player2.setBoard(board);
    }

    @Override
    public void conflictMechanism(ICell[][] board, int row, int column) {
        if (Board.isStoppage(row, column)) return;
        if (board[row][column].getPawns().size() <= 1) return;

        IPawn reservedPawn = null;
        List<IPawn> pawns = board[row][column].getPawns();

        for (IPawn pawn : pawns) {
            if (reservedPawn == null) {
                reservedPawn = pawn;
            } else {
                if (!reservedPawn.getPlayer().equals(pawn.getPlayer())) resolveConflict(reservedPawn);
                break;
            }
        }
    }

    @Override
    public IPlayer getSpecificPlayer(PlayerNumber playerNumber) {
        if (playerNumber.equals(player1.getPlayerNo())) return player1;
        if (playerNumber.equals(player2.getPlayerNo())) return player2;
        return null;
    }
}
