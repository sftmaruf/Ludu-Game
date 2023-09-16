package com.shafayetmaruf.assignment.assignment1.question4.gameplay.solo;

import com.shafayetmaruf.assignment.assignment1.question4.gameplay.Gameplay;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPlayer;

public class SoloFourPlayerGameplay extends Gameplay {
    private IPlayer player1;
    private IPlayer player2;
    private IPlayer player3;
    private IPlayer player4;

    public SoloFourPlayerGameplay(IPlayer player1, IPlayer player2, IPlayer player3, IPlayer player4) {
        super(new SoloFourPlayer(player1, player2, player3, player4));
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
    }

    @Override
    public void play() {
        while (!isMatchDetermined()) {
            turn(player1);
            turn(player2);
            turn(player3);
            turn(player4);
            System.out.println();
        }
    }

    @Override
    protected boolean isMatchDetermined() {
        if (player1.getNOfHomeBasedPawn() == 4) System.out.println(player1.getUser().getName() + " Wins the match");
        if (player2.getNOfHomeBasedPawn() == 4) System.out.println(player2.getUser().getName() + " Wins the match");
        if (player3.getNOfHomeBasedPawn() == 4) System.out.println(player3.getUser().getName() + " Wins the match");
        if (player4.getNOfHomeBasedPawn() == 4) System.out.println(player4.getUser().getName() + " Wins the match");
        return (player1.getNOfHomeBasedPawn() == 4 || player2.getNOfHomeBasedPawn() == 4 || player3.getNOfHomeBasedPawn() == 4 || player4.getNOfHomeBasedPawn() == 4);
    }
}
