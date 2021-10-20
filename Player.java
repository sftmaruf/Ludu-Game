package com.shafayetmaruf.assignment.assignment1.question4;

import java.util.ArrayList;
import java.util.List;

public class Player extends User{
    private String playerNo;
    private List<Token> tokens;
    private int startingRow;
    private int startingColumn;
    private int endingRow;
    private int endingColumn;

    public Player(String name, String nationality, String picture) {
        super(name, nationality, picture);
        tokens = new ArrayList<>();
        playerNo = "";
    }

    public void placeToken(int index, int point){
        Token token = getToken(index);
        token.setPosition(this, point);
    }

    public void setTokens(String color, String sign){
        for(int i = 1; i <= 4; i++){
            tokens.add(new Token(i, color, sign));
        }
    }

    public void setPlayerNo(String playerNo) {
        this.playerNo = playerNo;
    }

    public void setStartingRow(int startingRow) {
        this.startingRow = startingRow;
    }

    public void setStartingColumn(int startingColumn) {
        this.startingColumn = startingColumn;
    }

    public void setEndingRow(int endingRow) {
        this.endingRow = endingRow;
    }

    public void setEndingColumn(int endingColumn) {
        this.endingColumn = endingColumn;
    }

    public String getPlayerNo() {
        return playerNo;
    }

    public void viewProfile(){
        System.out.println();
    }

    private Token getToken(int index){
        return tokens.get(index - 1);
    }

    public int getStartingRow() {
        return startingRow;
    }

    public int getStartingColumn() {
        return startingColumn;
    }

    public int getEndingRow() {
        return endingRow;
    }

    public int getEndingColumn() {
        return endingColumn;
    }
}
