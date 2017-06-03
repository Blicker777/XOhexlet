package io.hexlet.xo.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Igor on 03.06.2017.
 */
public class PlayerTest {
    @Test
    public void getName() throws Exception {

        final String inputValue = "Slava";
        final String expectedValue = inputValue;

        Player player = new Player(inputValue, null);

        final String actualalue = player.getName();

        assertEquals(expectedValue, actualalue);

    }

    @Test
    public void getFigure() throws Exception {

        final Figure inputValue = Figure.X;
        final Figure expectedValue = inputValue;

        Player player = new Player(null, inputValue);

        final Figure actualalue = player.getFigure();

        assertEquals(expectedValue, actualalue);

    }

}