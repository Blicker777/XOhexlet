package io.hexlet.xo.view;


import io.hexlet.xo.controller.CurrentMoveController;
import io.hexlet.xo.controller.MoveController;
import io.hexlet.xo.controller.WinnerController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();

    public void show(final Game game){

        Field field = game.getField();

        for (int x = 0; x < field.getSize(); x++) {

            if(x != 0)
                printSeparator();


            for (int y = 0; y < field.getSize(); y++) {

                if (y != 0)
                    System.out.print("|");
                System.out.print(" ");
                final Figure figure;
                try {
                    figure = field.getFigure(new Point(y, x));
                } catch (final InvalidPointException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }

                System.out.print(figure != null ? figure : " ");
                System.out.print(" ");

            }

            System.out.println();

        }

    }

    public boolean move(final Game game, final Player[] players){

        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(game.getField());

        if(winner != null){
            if (winner.equals(Figure.X))
                System.out.format("Winner is %s", "Player: " + players[0].getName() + " Figure: " + players[0].getFigure());
            else if (winner.equals(Figure.O))
                System.out.format("Winner is %s", "Player: " + players[1].getName() + " Figure: " + players[1].getFigure());
            return false;
        }

        final Figure currentFigure = currentMoveController.currentMove(field);

        if(currentFigure == null){
            System.out.println("No winner and no moves left!");
            return false;
        }

        System.out.format("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Point is invalid!");
        }

        return true;
    }

    private Point askPoint(){
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName){

        System.out.format("Please input %s:", coordinateName);
        final Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch(final InputMismatchException e){
            System.out.println("O_o olloolol!!!");
            return askCoordinate(coordinateName);
        }

    }

    private void printSeparator(){
        System.out.println("~~~~~~~~~~~");
    }


}
