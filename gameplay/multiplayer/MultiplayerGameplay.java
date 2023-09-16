package com.shafayetmaruf.assignment.assignment1.question4.gameplay.multiplayer;

import com.shafayetmaruf.assignment.assignment1.question4.gameplay.Gameplay;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPlayer;

import java.util.ArrayList;
import java.util.List;

public class MultiplayerGameplay extends Gameplay {

    private IPlayer player1;
    private IPlayer player2;
    private IPlayer player3;
    private IPlayer player4;

    public MultiplayerGameplay(IPlayer player1, IPlayer player2, IPlayer player3, IPlayer player4) {
        super(new Multiplayer(player1, player2, player3, player4));
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
    }

    @Override
    public void play() {
        while (true) {
            turn(player1);
            if(isMatchDetermined()) break;
            turn(player2);
            if(isMatchDetermined()) break;
            turn(player3);
            if(isMatchDetermined()) break;
            turn(player4);
            if(isMatchDetermined()) break;
            System.out.println();
        }
    }

    @Override
    protected boolean isMatchDetermined() {
        var players = determineWinner();
        if (players == null) return false;
        System.out.println(players.get(0).getUser().getName() + " & "
                + players.get(1).getUser().getName() + " Win the match");
        return true;
    }

    protected List<IPlayer> determineWinner() {
        if (player1.getNOfHomeBasedPawn() == 4 && player3.getNOfHomeBasedPawn() == 4) {
            var players = new ArrayList<IPlayer>();
            players.add(player1);
            players.add(player3);
            return players;
        }

        if (player2.getNOfHomeBasedPawn() == 4 && player4.getNOfHomeBasedPawn() == 4) {
            var players = new ArrayList<IPlayer>();
            players.add(player2);
            players.add(player4);
            return players;
        }
        return null;
    }
}
