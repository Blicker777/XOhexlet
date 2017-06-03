package io.hexlet.xo.model;

/**
 * Created by Igor on 03.06.2017.
 */
public class Game {

    private final Player[] players;
    private final Field field;
    private final String name;

    public Game(Player[] players, Field field, String name) {
        this.players = players;
        this.field = field;
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }
}
