package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CurrentMoveControllerTest {

    @Test
    public void testCurrentMoveWhenNextMoveIsO() throws Exception {
        
        CurrentMoveController currentMoveController = new CurrentMoveController();

        for (int i = 0; i < 3; i++) {

            final Field field = new Field();

            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);
            field.setFigure(new Point(i, 2), Figure.X);

            assertEquals(Figure.O, currentMoveController.currentMove(field));

        }

    }

    @Test
    public void testCurrentMoveWhenNextMoveIsX() throws Exception {

        CurrentMoveController currentMoveController = new CurrentMoveController();

        for (int i = 0; i < 3; i++) {

            final Field field = new Field();

            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);

            assertEquals(Figure.X, currentMoveController.currentMove(field));

        }

    }

    @Test
    public void testCurrentMoveWhenNoNextMove() throws Exception {

        CurrentMoveController currentMoveController = new CurrentMoveController();

        final Field field = new Field();

        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {

                field.setFigure(new Point(i, j), Figure.X);
                field.setFigure(new Point(i, j), Figure.O);
                field.setFigure(new Point(i, j), Figure.O);

            }
        }

        assertNull(currentMoveController.currentMove(field));
    }

}