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

public class SoloFourPlayer extends Mode {
    private IPlayer player1;
    private IPlayer player2;
    private IPlayer player3;
    private IPlayer player4;

    public SoloFourPlayer(IPlayer player1, IPlayer player2, IPlayer player3, IPlayer player4) {
        super(4, Modes.Solo);
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        setupPlayers();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
    }

    @Override
    protected void assignPlayersNumber() {
        player1.setPlayerNo(PlayerNumber.PLAYER_ONE);
        player2.setPlayerNo(PlayerNumber.PLAYER_TWO);
        player3.setPlayerNo(PlayerNumber.PLAYER_THREE);
        player4.setPlayerNo(PlayerNumber.PLAYER_FOUR);
    }

    @Override
    protected void assignPawnsToPlayers() {
        player1.setPawns("+");
        player2.setPawns("-");
        player3.setPawns("#");
        player4.setPawns("@");
    }

    @Override
    protected void setPawnInitialYardPosition() {
        setPawnsInitialYardPositionOfPlayer1(player1);
        setPawnsInitialYardPositionOfPlayer2(player2);
        setPawnsInitialYardPositionOfPlayer3(player3);
        setPawnsInitialYardPositionOfPlayer4(player4);
    }

    @Override
    protected void setPlayerStartAndEndPoint() {
       setPlayer1StartAndEndPosition(player1);
       setPlayer2StartAndEndPosition(player2);
       setPlayer3StartAndEndPosition(player3);
       setPlayer4StartAndEndPosition(player4);
    }

    @Override
    public void conflictMechanism(ICell[][] board, int row, int column) {
        if(Board.isStoppage(row, column)) return;
        if (board[row][column].getPawns().size() <= 1) return;

        IPawn reservedPawn = null;
        List<IPawn> pawns = board[row][column].getPawns();

        for(IPawn pawn: pawns){
            if(reservedPawn == null){
                reservedPawn = pawn;
            }else{
                if(!reservedPawn.getPlayer().equals(pawn.getPlayer())) resolveConflict(reservedPawn);
            }
        }
    }

    @Override
    public IPlayer getSpecificPlayer(PlayerNumber playerNumber) {
        if(player1.getPlayerNo().equals(playerNumber)) return player1;
        if(player2.getPlayerNo().equals(playerNumber)) return player2;
        if(player3.getPlayerNo().equals(playerNumber)) return player3;
        if(player4.getPlayerNo().equals(playerNumber)) return player4;
        return null;
    }

    @Override
    public void setBoardToPlayer(ConsoleBoard board) {
       player1.setBoard(board);
       player2.setBoard(board);
       player3.setBoard(board);
       player4.setBoard(board);
    }
}
