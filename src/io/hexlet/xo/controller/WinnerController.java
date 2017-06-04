package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

/**
 * Created by Igor on 04.06.2017.
 */
public class WinnerController {

    public Figure getWinner(Field field){

        if(checkFigure(field, Figure.X)) return Figure.X;
        if(checkFigure(field, Figure.O)) return Figure.O;

        return null;

    }

    private boolean checkFigure(Field field, Figure figure){

        for (int i = 0; i < field.getSize(); i++) {

            if(checkLine(field, figure, i,  0, 0, 1)) return true;
            if(checkLine(field, figure, 0,  i, 1, 0)) return true;

        }

        if(checkLine(field, figure, 0,  0, 1, 1)) return true;
        if(checkLine(field, figure, 0,  2, 1, -1)) return true;

        return  false;

    }



    private boolean checkLine(Field field, Figure figure, int x, int y, int vx, int vy) {

        for (int i = 0; i < field.getSize(); i++) {

            try {
                if(field.getFigure(new Point(x + vx * i, y + vy * i)) != figure) return false;
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }

        return true;
    }
}
