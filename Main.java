package com.shafayetmaruf.assignment.assignment1.question4;

import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IMatch;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.println("Please choose a match: <1> SoloWithTwoPlayer <2> SoloWithFourPlayer <3> Multiplayer");
        System.out.println("Type the full name. For example, 'SoloWithTwoPlayer' for a 1 vs 1 match");
        System.out.print("Type here: ");
        String type = scanner.nextLine();
        MatchFactory matchFactory = new MatchFactory();
        IMatch match = matchFactory.createMatch(type);
        match.start();
    }
}
