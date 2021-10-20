package com.shafayetmaruf.assignment.assignment1.question4;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<String> tokens;

    public Cell(String sign) {
        tokens = new ArrayList<>();
        tokens.add(sign);
    }

    public List<String> getTokens() {
        return tokens;
    }

    public int getNumberOfToken() {
        return tokens.size() - 1;
    }
}
