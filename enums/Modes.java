package com.shafayetmaruf.assignment.assignment1.question4.enums;

public enum Modes {
    Solo("solo"),
    Multiplayer("multiplayer");

    private String name;
    private Modes(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
