package com.shafayetmaruf.assignment.assignment1.question4;

import java.util.HashSet;
import java.util.Set;

public abstract class Mode {
    protected int nOfPlayer;
    protected Set<Player> players;

    public Mode(int nOfPlayer) {
        players = new HashSet<>();
        this.nOfPlayer = nOfPlayer;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    protected abstract void setPlayerStartAndEndPoint();
}
