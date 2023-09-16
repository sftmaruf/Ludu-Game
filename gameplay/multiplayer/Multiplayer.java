package com.shafayetmaruf.assignment.assignment1.question4.gameplay.multiplayer;

import com.shafayetmaruf.assignment.assignment1.question4.board.Board;
import com.shafayetmaruf.assignment.assignment1.question4.board.ConsoleBoard;
import com.shafayetmaruf.assignment.assignment1.question4.enums.Modes;
import com.shafayetmaruf.assignment.assignment1.question4.enums.PlayerNumber;
import com.shafayetmaruf.assignment.assignment1.question4.gameplay.Mode;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.ICell;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPawn;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPlayer;

import java.util.List;

public class Multiplayer extends Mode {
    private IPlayer player1;
    private IPlayer player2;
    private IPlayer player3;
    private IPlayer player4;


    public Multiplayer(IPlayer player1, IPlayer player2, IPlayer player3, IPlayer player4) {
        super(4, Modes.Multiplayer);
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
        player3.setPawns("*");
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
    public void setBoardToPlayer(ConsoleBoard board) {
        player1.setBoard(board);
        player2.setBoard(board);
        player3.setBoard(board);
        player4.setBoard(board);
    }

    @Override
    public void conflictMechanism(ICell[][] board, int row, int column) {
        if (Board.isStoppage(row, column)) return;
        if (board[row][column].getPawns().size() <= 1) return;

        List<IPawn> pawns = board[row][column].getPawns();
        IPawn reservedPawn = pawns.get(pawns.size() - 2);

        for (IPawn pawn : pawns) {
            PlayerNumber reservedPlayerNumber = reservedPawn.getPlayer().getPlayerNo();
            PlayerNumber playerNumber = pawn.getPlayer().getPlayerNo();

            if (reservedPlayerNumber.equals(PlayerNumber.PLAYER_ONE) && playerNumber.equals(PlayerNumber.PLAYER_THREE) ||
                    reservedPlayerNumber.equals(PlayerNumber.PLAYER_THREE) && playerNumber.equals(PlayerNumber.PLAYER_ONE))
                continue;

            if (reservedPlayerNumber.equals(PlayerNumber.PLAYER_TWO) && playerNumber.equals(PlayerNumber.PLAYER_FOUR)
                    || reservedPlayerNumber.equals(PlayerNumber.PLAYER_FOUR) && playerNumber.equals(PlayerNumber.PLAYER_TWO))
                continue;

            if(!reservedPlayerNumber.equals(playerNumber)) {
                resolveConflict(reservedPawn);
                break;
            }
        }
    }

    @Override
    public IPlayer getSpecificPlayer(PlayerNumber playerNumber) {
        if (playerNumber.equals(player1.getPlayerNo())) return player1;
        if (playerNumber.equals(player2.getPlayerNo())) return player2;
        if (playerNumber.equals(player3.getPlayerNo())) return player3;
        if (playerNumber.equals(player4.getPlayerNo())) return player4;
        return null;
    }
}
