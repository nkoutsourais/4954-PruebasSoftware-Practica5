package damas.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import damas.models.*;
import damas.models.Error;

public class PlayControllerTest {

    @Test
    public void givenPlayControllerWhenMovementRequiereCorrectThenNotError() {
        Game game = new Game();
        State state = new State();
        PlayController playController = new PlayController(game, state);
        Coordinate origin = new Coordinate(0, 5);
        Coordinate target = new Coordinate(1, 4);
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(Color.WHITE, pieceTarget.getColor());
        Turn turn = playController.getTurn();
        assertNotNull(turn);
        assertEquals(Color.BLACK, turn.getColor());
    }

    @Test
    public void givenPlayControllerWhenMovementRequiereIncorrectThenErrorDistance() {
        Game game = new Game();
        State state = new State();
        PlayController playController = new PlayController(game, state);
        Coordinate origin = new Coordinate(0, 5);
        Coordinate target = new Coordinate(2, 4);
        Error error = playController.move(origin, target);
        assertNotNull(playController.getPiece(origin));
        assertNull(playController.getPiece(target));
        assertEquals(Error.DISTANCE, error);
    }

    @Test
    public void givenPlayControllerWhenMovementRequiereIncorrectThenErrorNoPiece() {
        Game game = new Game();
        State state = new State();
        PlayController playController = new PlayController(game, state);
        Coordinate origin = new Coordinate(1, 5);
        Coordinate target = new Coordinate(2, 4);
        Error error = playController.move(origin, target);
        assertNotNull(playController.getPiece(origin));
        assertNull(playController.getPiece(target));
        assertEquals(Error.NO_PIECE, error);
    }

    @Test
    public void givenPlayControllerWhenMovementRequiereIncorrectThenErrorCoordinate() {
        Game game = new Game();
        State state = new State();
        PlayController playController = new PlayController(game, state);
        Coordinate origin = new Coordinate(11, 2);
        Coordinate target = new Coordinate(13, 3);
        Error error = playController.move(origin, target);
        assertNotNull(playController.getPiece(origin));
        assertNull(playController.getPiece(target));
        assertEquals(Error.COORDINATES, error);
    }

    @Test
    public void givenPlayControllerWhenMovementRequiereIncorrectThenErrorNoDiagonalMove() {
        Game game = new Game();
        State state = new State();
        PlayController playController = new PlayController(game, state);
        Coordinate origin = new Coordinate(0, 5);
        Coordinate target = new Coordinate(0, 4);
        Error error = playController.move(origin, target);
        assertNotNull(playController.getPiece(origin));
        assertNull(playController.getPiece(target));
        assertEquals(Error.BAD_MOVE, error);
    }

    @Test
    public void givenPlayControllerWhenMovementRequiereIncorrectThenErrorBackwardMove() {
        Game game = new Game();
        State state = new State();
        PlayController playController = new PlayController(game, state);
        Coordinate origin = new Coordinate(0, 5);
        Coordinate target = new Coordinate(0, 6);
        Error error = playController.move(origin, target);
        assertNotNull(playController.getPiece(origin));
        assertNull(playController.getPiece(target));
        assertEquals(Error.BAD_MOVE, error);
    }

    @Test
    public void givenPlayControllerWhenMovementRequiereThenErrorNoTurn() {
        Game game = new Game();
        State state = new State();
        PlayController playController = new PlayController(game, state);
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        Error error = playController.move(origin, target);
        assertNotNull(playController.getPiece(origin));
        assertNull(playController.getPiece(target));
        assertEquals(Error.NO_TURN, error);
    }

    @Test
    public void givenPlayControllerWhenCancelUserThenFinalState() {
        State state = new State();
        state.next(); //Play
        PlayController playController = new PlayController(new Game(), state);
        playController.cancel();
        assertEquals(StateValue.FINAL, state.getValueState());
    }
}