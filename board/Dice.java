package com.shafayetmaruf.assignment.assignment1.question4.board;

import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IDice;

import java.util.Random;

public class Dice implements IDice {
    private static IDice dice;

    private Dice() {
    }

    public static IDice getDice() {
        if (dice == null) dice = new Dice();
        return dice;
    }

    @Override
    public int roll() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
