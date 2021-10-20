package com.shafayetmaruf.assignment.assignment1.question4;

public class Solo extends Mode {
    private Player player1;
    private Player player2;

    public Solo(Player player1, Player player2) {
        super(2);
        this.player1 = player1;
        this.player2 = player2;
        setupPlayers();
    }

    private void setupPlayers(){
        setPlayerNo();
        setPlayerStartAndEndPoint();
        players.add(player1);
        players.add(player2);
    }

    @Override
    protected void setPlayerStartAndEndPoint(){
        player1.setStartingRow(6);
        player1.setStartingColumn(1);
        player1.setEndingRow(7);
        player1.setEndingColumn(0);

        player2.setStartingRow(1);
        player2.setStartingColumn(8);
        player2.setEndingRow(0);
        player2.setEndingColumn(7);
    }


    private void setPlayerNo() {
        player1.setPlayerNo("Player 1");
        player2.setPlayerNo("Player 2");
    }
}
