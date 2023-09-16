package com.shafayetmaruf.assignment.assignment1.question4.board;

import com.shafayetmaruf.assignment.assignment1.question4.Player;
import com.shafayetmaruf.assignment.assignment1.question4.enums.Colors;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPawn;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPlayer;

public class Pawn implements IPawn {
    private int id;
    private int row;
    private int column;
    private String sign;
    private Colors color;
    private int rowInsideYard;
    private int columnInsideYard;
    private boolean isRipped;
    private Player player;
    private PawnService pawnService;

    public Pawn(int id, Player player, String sign) {
        this.id = id;
        this.player = player;
        this.color = player.getColor();
        this.sign = " " + color.getCode() + sign + id + Colors.RESET.getCode();
        isRipped = false;
        pawnService = new PawnService(this);
    }

    @Override
    public boolean manipulatePosition(Player player, int point) {
        if (pawnService.isPawnStaged()) {
            if (!pawnService.isPointSix(point)) {
                System.out.println("This Pawn isn't opened yet");
                return false;
            }
            openPawn(player);
        } else {
            boolean isInRippedArea = player.getBoard().getHomeBase().isExist(this);
            if (isInRippedArea) {
                System.out.println("Its ripped");
                return false;
            }
            manipulate(point, player);
        }
        return true;
    }

    @Override
    public void openPawn(Player player) {
        row = player.getStartingRow();
        column = player.getStartingColumn();
        player.getBoard().getPlayerYards().removePawnFromYard(rowInsideYard, columnInsideYard, this);
        placePawn("ar");

        player.setNOfOpenedPawn(player.getNOfOpenedPawn() + 1);
    }

    @Override
    public void manipulate(int point, Player player) {
        placePawn("r");
        pawnService.calculatePosition(point, player);
        placePawn("ar");
    }

    @Override
    public void placePawn(String flag) {
        player.getBoard().placePawn(row, column, flag, this);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public void setRowColumn(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String getSign() {
        return sign;
    }

    @Override
    public Colors getColor() {
        return color;
    }

    @Override
    public int getRowInsideYard() {
        return rowInsideYard;
    }

    @Override
    public IPawn setRowInsideYard(int rowInsideYard) {
        this.rowInsideYard = rowInsideYard;
        row = rowInsideYard;
        return this;
    }

    @Override
    public int getColumnInsideYard() {
        return columnInsideYard;
    }

    @Override
    public IPawn setColumnInsideYard(int columnInsideYard) {
        this.columnInsideYard = columnInsideYard;
        column = columnInsideYard;
        return this;
    }

    @Override
    public IPlayer getPlayer() {
        return player;
    }

    public boolean isOpen()
    {
        if(!pawnService.isPawnStaged() && !player.getBoard().getHomeBase().isExist(this))
            return true;

        return false;
    }
}
