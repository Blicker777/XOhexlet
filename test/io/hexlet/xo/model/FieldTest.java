package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Igor on 03.06.2017.
 */
public class FieldTest {
    @Test
    public void getSize() throws Exception {

        final Field  field = new Field();
        assertEquals(3, field.getSize());

    }

    @Test
    public void setFigure() throws Exception {

        final Field  field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);

    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {

        final Field  field = new Field();
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);

    }

    @Test
    public void testGetFigureWhenXIsLessThenZero() throws Exception {

        final Field  field = new Field();
        final Point inputPoint = new Point(-1,0);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch(InvalidPointException e){

        }

    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() throws Exception {

        final Field  field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1,0);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch(InvalidPointException e){

        }

    }

    @Test
    public void testGetFigureWhenYIsLessThenZero() throws Exception {

        final Field  field = new Field();
        final Point inputPoint = new Point(0,-1);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch(InvalidPointException e){

        }

    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() throws Exception {

        final Field  field = new Field();
        final Point inputPoint = new Point(0,field.getSize() + 1);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch(InvalidPointException e){

        }

    }

    public void testGetFigureWhenXandYIsLessThenZero() throws Exception {

        final Field  field = new Field();
        final Point inputPoint = new Point(-1,-1);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch(InvalidPointException e){

        }

    }

    @Test
    public void testGetFigureWhenXandYIsMoreThenSize() throws Exception {

        final Field  field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1,field.getSize() + 1);
        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch(InvalidPointException e){

        }

    }






}