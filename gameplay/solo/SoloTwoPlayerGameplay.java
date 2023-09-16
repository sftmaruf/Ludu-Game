package com.shafayetmaruf.assignment.assignment1.question4.gameplay.solo;

import com.shafayetmaruf.assignment.assignment1.question4.gameplay.Gameplay;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPlayer;

public class SoloTwoPlayerGameplay extends Gameplay {
    private IPlayer player1;
    private IPlayer player2;

    public SoloTwoPlayerGameplay(IPlayer player1, IPlayer player2) {
        super(new SoloTwoPlayer(player1, player2));
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void play() {
        while (true) {
            turn(player1);
            if(isMatchDetermined()) break;
            turn(player2);
            if(isMatchDetermined()) break;
            System.out.println();
        }
    }

    @Override
    protected boolean isMatchDetermined() {
        if (player1.getNOfHomeBasedPawn() == 4) System.out.println(player1.getUser().getName() + " Wins the match");
        if (player2.getNOfHomeBasedPawn() == 4) System.out.println(player2.getUser().getName() + " Wins the match");
        return player1.getNOfHomeBasedPawn() == 4 || player2.getNOfHomeBasedPawn() == 4;
    }
}
