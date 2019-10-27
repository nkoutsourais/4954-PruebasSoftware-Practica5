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

    public Error move(Coordinate origin, Coordinate target){
        return null;
    }

	public Piece getPiece(Coordinate origin) {
		return null;
	}

	public Turn getTurn() {
		return null;
	}
}