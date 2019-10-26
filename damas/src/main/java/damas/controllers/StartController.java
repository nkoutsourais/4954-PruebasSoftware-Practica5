package damas.controllers;

import damas.models.Game;
import damas.models.State;

public class StartController extends Controller {

    public StartController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void accept(AcceptController controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void start() {
    }
}