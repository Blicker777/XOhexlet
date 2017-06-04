package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class WinnerControllerTest {

    @Test
    public void testGetWinnerWhenWinnerIsXOnRow() throws Exception {

        WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {

            Field field = new Field();

            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);

            assertEquals(Figure.X, winnerController.getWinner(field));

        }

    }

    @Test
    public void testGetWinnerWhenWinnerIsXOnColumn() throws Exception {

        WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {

            Field field = new Field();

            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);

            assertEquals(Figure.X, winnerController.getWinner(field));

        }

    }

    @Test
    public void testGetWinnerWhenWinnerIsXOnDiagonal() throws Exception {

        WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {

            Field field = new Field();

            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(1, 1), Figure.X);
            field.setFigure(new Point(2, 2), Figure.X);

            assertEquals(Figure.X, winnerController.getWinner(field));

        }

        for (int i = 0; i < 3; i++) {

            Field field = new Field();

            field.setFigure(new Point(0, 2), Figure.X);
            field.setFigure(new Point(1, 1), Figure.X);
            field.setFigure(new Point(2, 0), Figure.X);

            assertEquals(Figure.X, winnerController.getWinner(field));

        }

    }

    @Test
    public void testGetWinnerWhenWinnerIsOOnRow() throws Exception {

        WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {

            Field field = new Field();

            field.setFigure(new Point(i, 0), Figure.O);
            field.setFigure(new Point(i, 1), Figure.O);
            field.setFigure(new Point(i, 2), Figure.O);

            assertEquals(Figure.O, winnerController.getWinner(field));

        }

    }

    @Test
    public void testGetWinnerWhenWinnerIsOOnColumn() throws Exception {

        WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {

            Field field = new Field();

            field.setFigure(new Point(0, i), Figure.O);
            field.setFigure(new Point(1, i), Figure.O);
            field.setFigure(new Point(2, i), Figure.O);

            assertEquals(Figure.O, winnerController.getWinner(field));

        }

    }

    @Test
    public void testGetWinnerWhenWinnerIsOOnDiagonal() throws Exception {

        WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {

            Field field = new Field();

            field.setFigure(new Point(0, 0), Figure.O);
            field.setFigure(new Point(1, 1), Figure.O);
            field.setFigure(new Point(2, 2), Figure.O);

            assertEquals(Figure.O, winnerController.getWinner(field));

        }

        for (int i = 0; i < 3; i++) {

            Field field = new Field();

            field.setFigure(new Point(0, 2), Figure.O);
            field.setFigure(new Point(1, 1), Figure.O);
            field.setFigure(new Point(2, 0), Figure.O);

            assertEquals(Figure.O, winnerController.getWinner(field));

        }

    }

}