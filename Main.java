package com.shafayetmaruf.assignment.assignment1.question4;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]){
        int choice = -1;
        Player player1 = new Player("Shafayet Maruf", "Bangladeshi", "");
        Player player2 = new Player("Hridoy", "Bangladeshi", "");
        player1.setTokens("red", "+");
        player2.setTokens("Green", "-");

        Gameplay gameplay = new Gameplay(player1, player2);
        Gameplay.getBoard().viewBoard();

        while(choice != 0){
            choice = scanner.nextInt();
            int point = Gameplay.rollDice();
            System.out.println("Player 1 rolls the dice and get: " + point);
            System.out.print("Which token you want to move: " );
            int tokenNumber = scanner.nextInt();
            player1.placeToken(tokenNumber, point);
        }


//        Gameplay.getBoard().viewBoard();
    }
}
