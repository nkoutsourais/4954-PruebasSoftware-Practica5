package damas.controllers;

import damas.models.Coordinate;
import damas.models.Game;
import damas.models.Error;

public class MoveController {

    private final Game game;

    public MoveController(Game game) {
        this.game = game;
    }

    public Error move(Coordinate origin, Coordinate target){
        return null;
    }
}