package damas.controllers;

import damas.models.*;
import damas.models.Error;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
        super(game, state);
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
}