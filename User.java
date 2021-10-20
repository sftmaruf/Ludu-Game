package com.shafayetmaruf.assignment.assignment1.question4;

public class User {
    private String name;
    private String nationality;
    private String picture;
    private int coin;
    private int gems;
    private int level;
    private int performanceRating;

    public User(String name, String nationality, String picture) {
        this.name = name;
        this.nationality = nationality;
        this.picture = picture;
        this.coin = 0;
        this.gems = 0;
        this.level = 0;
        this.performanceRating = 0;
    }
}
