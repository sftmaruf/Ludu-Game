package com.shafayetmaruf.assignment.assignment1.question4;

public class Gameplay {
    private static Board board;

    public Gameplay(Player player1, Player player2) {
        this.board = new Board(new Solo(player1, player2));
    }

    public static Board getBoard(){
        return board;
    }

    public static int rollDice(){
        return board.getDice().roll();
    }
}
