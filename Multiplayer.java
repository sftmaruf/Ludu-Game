package com.shafayetmaruf.assignment.assignment1.question4;

public class Multiplayer extends Mode{
    public Multiplayer(Player player1, Player player2, Player player3, Player player4) {
        super(4);
        setPlayerNo(player1, player2, player3, player4);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
    }

    private void setPlayerNo(Player player1, Player player2, Player player3, Player player4){
        player1.setPlayerNo("Player 1");
        player2.setPlayerNo("Player 2");
        player3.setPlayerNo("Player 3");
        player4.setPlayerNo("Player 4");
    }

    @Override
    protected void setPlayerStartAndEndPoint() {

    }
}
