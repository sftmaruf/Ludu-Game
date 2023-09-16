package com.shafayetmaruf.assignment.assignment1.question4.enums;

public enum PlayerNumber {
    PLAYER_ONE("Player 1"),
    PLAYER_TWO("Player 2"),
    PLAYER_THREE("Player 3"),
    PLAYER_FOUR("Player 4");

    public String value;

    private PlayerNumber(String value) {
        this.value = value;
    }
}
