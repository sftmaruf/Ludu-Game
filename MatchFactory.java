package com.shafayetmaruf.assignment.assignment1.question4;

import com.shafayetmaruf.assignment.assignment1.question4.enums.Colors;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IMatch;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IPlayer;
import com.shafayetmaruf.assignment.assignment1.question4.interfaces.IUser;

public class MatchFactory {
    public IMatch createMatch(String type) {
        IMatch match = null;
        switch (type) {
            case "SoloWithTwoPlayer":
                match = createSoloMatchWithTwoPlayer();
                break;
            case "SoloWithFourPlayer":
                match = createSoloMatchWithFourPlayer();
                break;
            case "Multiplayer":
                match = createMultiplayerMatch();
                break;
            default:
                throw new IllegalArgumentException("This isn't a valid type");
        }
        return match;
    }

    private Match createSoloMatchWithTwoPlayer() {
        System.out.print("Who is the player 1: ");
        String userName1 = Main.scanner.nextLine();
        System.out.print("Who is the player 2: ");
        String userName2 = Main.scanner.nextLine();

        IUser user1 = new User(userName1, "Bangladeshi", "");
        IUser user2 = new User(userName2, "Bangladeshi", "");

        IPlayer player1 = new Player(user1, Colors.RED);
        IPlayer player2 = new Player(user2, Colors.YELLOW);
        return new Match.Builder().soloGame(player1, player2).forConsole().build();
    }

    private Match createSoloMatchWithFourPlayer() {
        System.out.print("Who is the player 1: ");
        String userName1 = Main.scanner.nextLine();
        System.out.print("Who is the player 2: ");
        String userName2 = Main.scanner.nextLine();
        System.out.print("Who is the player 3: ");
        String userName3 = Main.scanner.nextLine();
        System.out.print("Who is the player 4: ");
        String userName4 = Main.scanner.nextLine();

        IUser user1 = new User(userName1, "Bangladeshi", "");
        IUser user2 = new User(userName2, "Bangladeshi", "");
        IUser user3 = new User(userName3, "Bangladeshi", "");
        IUser user4 = new User(userName4, "Bangladeshi", "");

        IPlayer player1 = new Player(user1, Colors.RED);
        IPlayer player2 = new Player(user2, Colors.GREEN);
        IPlayer player3 = new Player(user3, Colors.YELLOW);
        IPlayer player4 = new Player(user4, Colors.BLUE);
        return new Match.Builder().soloGame(player1, player2, player3, player4).forConsole().build();
    }

    private Match createMultiplayerMatch() {
        System.out.print("Who is the player 1: ");
        String userName1 = Main.scanner.nextLine();
        System.out.print("Who is the player 2: ");
        String userName2 = Main.scanner.nextLine();
        System.out.print("Who is the player 3: ");
        String userName3 = Main.scanner.nextLine();
        System.out.print("Who is the player 4: ");
        String userName4 = Main.scanner.nextLine();

        IUser user1 = new User(userName1, "Bangladeshi", "");
        IUser user2 = new User(userName2, "Bangladeshi", "");
        IUser user3 = new User(userName3, "Bangladeshi", "");
        IUser user4 = new User(userName4, "Bangladeshi", "");

        IPlayer player1 = new Player(user1, Colors.RED);
        IPlayer player2 = new Player(user2, Colors.GREEN);
        IPlayer player3 = new Player(user3, Colors.YELLOW);
        IPlayer player4 = new Player(user4, Colors.BLUE);
        return new Match.Builder().multiplayerGame(player1, player2, player3, player4).forConsole().build();
    }
}
