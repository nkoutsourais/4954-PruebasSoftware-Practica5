package damas.controllers;

import damas.models.Game;
import damas.models.State;

public class ResumeController extends Controller {

    public ResumeController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void accept(AcceptController controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void resume(boolean newGame) {
    }
}