package com.shafayetmaruf.assignment.assignment1.question4;

import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IUser;

public class User implements IUser {
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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getNationality() {
        return nationality;
    }

    @Override
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String getPicture() {
        return picture;
    }

    @Override
    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public int getCoin() {
        return coin;
    }

    @Override
    public void setCoin(int coin) {
        this.coin = coin;
    }

    @Override
    public int getGems() {
        return gems;
    }

    @Override
    public void setGems(int gems) {
        this.gems = gems;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int getPerformanceRating() {
        return performanceRating;
    }

    @Override
    public void setPerformanceRating(int performanceRating) {
        this.performanceRating = performanceRating;
    }
}
