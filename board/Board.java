package com.shafayetmaruf.assignment.assignment1.question4.board;

import com.shafayetmaruf.assignment.assignment1.question4.gameplay.Mode;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.*;

public abstract class Board {
    protected ICell[][] board;
    protected IDice dice;
    protected Mode mode;
    protected IHomeBase homeBase;
    protected IPlayerYard playerYards;

    public Board(Mode mode, ICell[][] board) {
        this.mode = mode;
        dice = Dice.getDice();
        this.board = board;
        homeBase = new HomeBase(this);
        playerYards = new PlayerYard(this);
    }

    public abstract void generateBoard(String playerYardHomeBaseSign, String PathSign);

    public abstract void placePawn(int i, int j, String flag, IPawn sign);

    public static boolean isStoppage(int row, int column) {
        return (row == 6 && column == 1) ||
                (row == 1 && column == 8) ||
                (row == 8 && column == 13) ||
                (row == 13 && column == 6);
    }

    public IDice getDice() {
        return dice;
    }

    public Mode getMode() {
        return mode;
    }

    public IHomeBase getHomeBase() {
        return homeBase;
    }

    public IPlayerYard getPlayerYards() {
        return playerYards;
    }
}
