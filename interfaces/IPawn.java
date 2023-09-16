package com.shafayetmaruf.assignment.assignment1.question4.interfaces;

import com.shafayetmaruf.assignment.assignment1.question4.Player;
import com.shafayetmaruf.assignment.assignment1.question4.enums.Colors;

public interface IPawn {
    boolean manipulatePosition(Player player, int point);

    void openPawn(Player player);

    void manipulate(int point, Player player);

    void placePawn(String flag);

    int getRow();

    int getColumn();

    void setRowColumn(int row, int column);

    int getId();

    String getSign();

    Colors getColor();

    int getRowInsideYard();

    IPawn setRowInsideYard(int rowInsideYard);

    int getColumnInsideYard();

    IPawn setColumnInsideYard(int columnInsideYard);

    IPlayer getPlayer();

    boolean isOpen();
}
