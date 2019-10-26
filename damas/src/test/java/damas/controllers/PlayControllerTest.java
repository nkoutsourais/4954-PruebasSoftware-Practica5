package damas.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import damas.models.*;

public class PlayControllerTest {

    @Test
    public void givenPlayControllerWhenMovementRequiereCorrectThenNotError() {
        Game game = new Game();
        State state = new State();
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        PlayController playController = new PlayController(game, state);
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }
}