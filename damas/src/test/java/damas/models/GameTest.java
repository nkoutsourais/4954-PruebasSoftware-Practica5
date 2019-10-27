package damas.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class GameTest {

    @Test
    public void givenGameWhenMovementRequiereCorrectThenNotError() {
        Game game = new Game();
        Coordinate origin = new Coordinate(0, 5);
        Coordinate target = new Coordinate(1, 4);
        assertNull(game.move(origin, target));
        assertNull(game.getPiece(origin));
        Piece pieceTarget = game.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
        Turn turn = game.getTurn();
        assertNotNull(turn);
        assertEquals(turn.getColor(), Color.BLACK);
    }

    @Test
    public void givenGameWhenMovementRequiereIncorrectThenErrorDistance() {
        Game game = new Game();
        Coordinate origin = new Coordinate(0, 5);
        Coordinate target = new Coordinate(2, 4);
        Error error = game.move(origin, target);
        assertNotNull(game.getPiece(origin));
        assertNull(game.getPiece(target));
        assertEquals(error, Error.DISTANCE);
    }

    @Test
    public void givenGameWhenMovementRequiereIncorrectThenErrorNoPiece() {
        Game game = new Game();
        Coordinate origin = new Coordinate(1, 5);
        Coordinate target = new Coordinate(2, 4);
        Error error = game.move(origin, target);
        assertNotNull(game.getPiece(origin));
        assertNull(game.getPiece(target));
        assertEquals(error, Error.NO_PIECE);
    }

    @Test
    public void givenGameWhenMovementRequiereIncorrectThenErrorCoordinate() {
        Game game = new Game();
        Coordinate origin = new Coordinate(11, 2);
        Coordinate target = new Coordinate(13, 3);
        Error error = game.move(origin, target);
        assertNotNull(game.getPiece(origin));
        assertNull(game.getPiece(target));
        assertEquals(error, Error.COORDINATES);
    }

    @Test
    public void givenGameWhenMovementRequiereIncorrectThenErrorNoDiagonalMove() {
        Game game = new Game();
        Coordinate origin = new Coordinate(0, 5);
        Coordinate target = new Coordinate(0, 4);
        Error error = game.move(origin, target);
        assertNotNull(game.getPiece(origin));
        assertNull(game.getPiece(target));
        assertEquals(error, Error.BAD_MOVE);
    }

    @Test
    public void givenGameWhenMovementRequiereIncorrectThenErrorBackwardMove() {
        Game game = new Game();
        Coordinate origin = new Coordinate(0, 5);
        Coordinate target = new Coordinate(0, 6);
        Error error = game.move(origin, target);
        assertNotNull(game.getPiece(origin));
        assertNull(game.getPiece(target));
        assertEquals(error, Error.BAD_MOVE);
    }

    @Test
    public void givenGameWhenMovementRequiereThenErrorNoTurn() {
        Game game = new Game();
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        Error error = game.move(origin, target);
        assertNotNull(game.getPiece(origin));
        assertNull(game.getPiece(target));
        assertEquals(error, Error.NO_TURN);
    }
}