package com.shafayetmaruf.assignment.assignment1.question4;

import com.shafayetmaruf.assignment.assignment1.question4.board.Board;
import com.shafayetmaruf.assignment.assignment1.question4.board.ConsoleBoard;
import com.shafayetmaruf.assignment.assignment1.question4.gameplay.Gameplay;
import com.shafayetmaruf.assignment.assignment1.question4.gameplay.multiplayer.MultiplayerGameplay;
import com.shafayetmaruf.assignment.assignment1.question4.gameplay.solo.SoloFourPlayerGameplay;
import com.shafayetmaruf.assignment.assignment1.question4.gameplay.solo.SoloTwoPlayerGameplay;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IMatch;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPlayer;

public class Match implements IMatch {
    private Gameplay gameplay;

    public Match(Builder builder) {
        this.gameplay = builder.gameplay;
    }

    @Override
    public Gameplay getGameplay() {
        return gameplay;
    }

    @Override
    public void start() {
        gameplay.play();
    }

    public static class Builder {
        private Gameplay gameplay;

        public Builder() {
        }

        public Builder soloGame(IPlayer player1, IPlayer player2) {
            this.gameplay = new SoloTwoPlayerGameplay(player1, player2);
            return this;
        }

        public Builder soloGame(IPlayer player1, IPlayer player2, IPlayer player3, IPlayer player4) {
            this.gameplay = new SoloFourPlayerGameplay(player1, player2, player3, player4);
            return this;
        }

        public Builder multiplayerGame(IPlayer player1, IPlayer player2, IPlayer player3, IPlayer player4) {
            this.gameplay = new MultiplayerGameplay(player1, player2, player3, player4);
            return this;
        }

        public Builder forConsole() {
            Board board = new ConsoleBoard(gameplay.getMode());
            gameplay.setBoard(board);
            ((ConsoleBoard) board).viewBoard();
            return this;
        }

        public Match build() {
            return new Match(this);
        }
    }
}
