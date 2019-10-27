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
        assertEquals(pieceTarget.getColor(), Color.WHITE);
        Turn turn = playController.getTurn();
        assertNotNull(turn);
        assertEquals(turn.getColor(), Color.BLACK);
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
        assertEquals(error, Error.DISTANCE);
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
        assertEquals(error, Error.NO_PIECE);
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
        assertEquals(error, Error.COORDINATES);
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
        assertEquals(error, Error.BAD_MOVE);
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
        assertEquals(error, Error.BAD_MOVE);
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
        assertEquals(error, Error.NO_TURN);
    }
}