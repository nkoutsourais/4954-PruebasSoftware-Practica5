package damas.controllers;

import damas.models.*;
import damas.models.Error;

public class PlayController extends Controller {

    private final MoveController moveController;
    private final CancelController cancelController;

    public PlayController(Game game, State state) {
        super(game, state);

        this.cancelController = new CancelController(state);
        this.moveController = new MoveController(game);
    }

    @Override
    public void accept(AcceptController controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public Error move(Coordinate... coordinates) {
        return moveController.move(coordinates);
    }

    public Piece getPiece(Coordinate origin) {
        return this.game.getPiece(origin);
    }

    public Turn getTurn() {
        return this.game.getTurn();
    }

    public void cancel() {
        cancelController.cancel();
    }
}