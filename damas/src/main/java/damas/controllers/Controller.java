package damas.controllers;

import damas.models.*;

public abstract class Controller {
    protected Game game;

    protected State state;

    Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public abstract void accept(AcceptController controllerVisitor);
}