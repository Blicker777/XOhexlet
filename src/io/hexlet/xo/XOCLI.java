package io.hexlet.xo;


import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.view.ConsoleView;

import java.util.Scanner;

public class XOCLI {

    public static void main(String[] args) {

        String gameName = "XO";
        System.out.format("Game name: %s\n", gameName);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write name one:");
        String name1 = scanner.nextLine();
        System.out.println("Write name two:");
        String name2 = scanner.nextLine();

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game game = new Game(players, new Field(), gameName);
        System.out.println("Player: " + players[0].getName() + " Figure: " + players[0].getFigure());
        System.out.println("Player: " + players[1].getName() + " Figure: " + players[1].getFigure());

        ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
        while (consoleView.move(game, players)) {
            consoleView.show(game);
        }

    }
}
