package com.shafayetmaruf.assignment.assignment1.question4.gameplay;

import com.shafayetmaruf.assignment.assignment1.question4.Main;
import com.shafayetmaruf.assignment.assignment1.question4.board.Board;
import com.shafayetmaruf.assignment.assignment1.question4.enums.Colors;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPlayer;

public abstract class Gameplay {
    private Board board;
    private Mode mode;

    public Gameplay(Mode mode) {
        this.mode = mode;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public abstract void play();

    protected abstract boolean isMatchDetermined();

    protected void turn(IPlayer player) {
        int count = -1;
        int[] points = new int[4];

        do {
            count++;
            writePlayerTurn(player, count);
            writeRolling();
            int point = rollDice();
            points[count] = point;
            writeAllPoints(player, count, points);

            if (count == 2 && point == 6) {
                points = new int[4];
                count = 0;
                break;
            }
        } while (points[count] == 6);

        assignPointToPawn(count, player, points);
    }

    protected void writePlayerTurn(IPlayer player, int count) {
        StringBuilder prompt = new StringBuilder();

        if (count <= 0) prompt.append("\n");
        prompt
                .append("( ")
                .append(getColoredPlayerName(player))
                .append(" ) Press any key to roll the dice: ");
        System.out.print(prompt);
    }

    protected void writeRolling() {
        Main.scanner.next();
        System.out.println("Rolling...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int rollDice() {
        return board.getDice().roll();
    }

    protected void writeAllPoints(IPlayer player, int count, int[] points) {
        System.out.print("( " + getColoredPlayerName(player) + " ) rolls the dice and get: ");
        for (int i = 0; i <= count; i++) {
            System.out.print(player.getColor().getCode() + points[i] + Colors.RESET.getCode() + " ");
        }
        System.out.println();
    }

    protected void assignPointToPawn(int count, IPlayer player, int[] points) {
        int pawnNumber;
        for (int i = 0; i <= count; i++) {
            if (player.hasAnyOpenedPawn() || points[0] == 6) {
                do {
                    if(player.getNOfOpenedPawn() == 1 && points[i] != 6) {
                        var pawns = player.getPawns().stream().filter(pawn -> pawn.isOpen());
                        pawnNumber = pawns.findFirst().get().getId();
                        continue;
                    }

                    System.out.print("Which Pawn you want to move: ");
                    pawnNumber = Main.scanner.nextInt();
                } while (!player.movePawn(pawnNumber, points[i]));
            }
        }
    }

//    protected String getColoredPlayerNo(IPlayer player) {
//        String coloredPlayerNo = Colors.RESET.getCode();
//        if (player.getPlayerNo().value == "Player 1")
//            coloredPlayerNo = Colors.RED.getCode() + player.getPlayerNo() + Colors.RESET.getCode();
//        if (player.getPlayerNo().value == "Player 3")
//            coloredPlayerNo = Colors.YELLOW.getCode() + player.getPlayerNo() + Colors.RESET.getCode();
//        return coloredPlayerNo;
//    }

    protected String getColoredPlayerName(IPlayer player) {
        return player.getColor().getCode() + player.getUser().getName() + Colors.RESET.getCode();
    }

    public Board getBoard() {
        return board;
    }

    public Mode getMode() {
        return mode;
    }
}
