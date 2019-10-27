package damas.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardTest {

    final FactoryBoard factoryBoard;

    public BoardTest() {
        factoryBoard = new FactoryBoard();
    }

    @Test
    public void givenBoardWhenMovementRequiereCorrectThenNotError() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.INITIAL);
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        assertNull(board.move(origin, target));
        assertNull(board.getPiece(origin));
        Piece pieceTarget = board.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.BLACK);
    }

    @Test
    public void givenBoardWhenMovementRequiereIncorrectThenErrorDistance() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.INITIAL);
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(4, 2);
        Error error = board.move(origin, target);
        assertNotNull(board.getPiece(origin));
        assertNull(board.getPiece(target));
        assertEquals(error, Error.DISTANCE);
    }

    @Test
    public void givenBoardWhenMovementRequiereIncorrectThenErrorOccuped() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.SQUARE_OCCUPED);
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        Error error = board.move(origin, target);
        assertNotNull(board.getPiece(origin));
        assertNull(board.getPiece(target));
        assertEquals(error, Error.OCCUPED);
    }

    @Test
    public void givenBoardWhenMovementRequiereIncorrectThenErrorNoPiece() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.INITIAL);
        Coordinate origin = new Coordinate(3, 2);
        Coordinate target = new Coordinate(4, 3);
        Error error = board.move(origin, target);
        assertNotNull(board.getPiece(origin));
        assertNull(board.getPiece(target));
        assertEquals(error, Error.NO_PIECE);
    }

    @Test
    public void givenBoardWhenMovementRequiereIncorrectThenErrorCoordinate() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.INITIAL);
        Coordinate origin = new Coordinate(11, 2);
        Coordinate target = new Coordinate(13, 3);
        Error error = board.move(origin, target);
        assertNotNull(board.getPiece(origin));
        assertNull(board.getPiece(target));
        assertEquals(error, Error.COORDINATES);
    }

    @Test
    public void givenBoardWhenMovementRequiereIncorrectThenErrorNoDiagonalMove() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.INITIAL);
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(2, 2);
        Error error = board.move(origin, target);
        assertNotNull(board.getPiece(origin));
        assertNull(board.getPiece(target));
        assertEquals(error, Error.BAD_MOVE);
    }

    @Test
    public void givenBoardWhenMovementRequiereIncorrectThenErrorBackwardMove() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.BACKWARD_MOVE);
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(1, 2);
        Error error = board.move(origin, target);
        assertNotNull(board.getPiece(origin));
        assertNull(board.getPiece(target));
        assertEquals(error, Error.BAD_MOVE);
    }

    @Test
    public void givenBoardWhenMovementTransformThenPeonIsDama() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.TRANSFORM_DAMA);
        Coordinate origin = new Coordinate(6, 1);
        Coordinate target = new Coordinate(7, 0);
        assertNull(board.move(origin, target));
        Piece piece = board.getPiece(target);
        assertTrue(piece instanceof Dama);
        assertEquals(piece.getColor(), Color.BLACK);
    }

    @Test
    public void givenBoardWhenPeonMovementWithCaptureThenPeonCapturedRetired() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.PEON_JUMP_CAPTURE);
        givenBoardWhenPiceMovementWithCaptureThenPeonCapturedRetired(board);
    }

    @Test
    public void givenBoardWhenDamaMovementWithCaptureThenPeonCapturedRetired() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.DAMA_JUMP_CAPTURE);
        givenBoardWhenPiceMovementWithCaptureThenPeonCapturedRetired(board);
    }

    private void givenBoardWhenPiceMovementWithCaptureThenPeonCapturedRetired(Board board)
    {
        Coordinate origin1 = new Coordinate(0, 0);
        Coordinate target1 = new Coordinate(0, 0);
        Coordinate origin2 = new Coordinate(0, 0);
        Coordinate target2 = new Coordinate(0, 0);
        Coordinate origin3 = new Coordinate(0, 0);
        Coordinate target3 = new Coordinate(0, 0);
        assertNull(board.move(origin1, target1, origin2, target2, origin3, target3));
        assertNull(board.getPiece(origin1));
        Piece pieceTarget = board.getPiece(target3);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
        assertNull(board.getPiece(new Coordinate(0, 0)));
        assertNull(board.getPiece(new Coordinate(0, 0)));
        assertNull(board.getPiece(new Coordinate(0, 0)));
    }

    @Test
    public void givenBoardWhenPeonMovementWithCaptureThenCaptureExced() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.PEON_JUMP_CAPTURE);
        givenBoardWhenPieceMovementWithCaptureThenCaptureExced(board);   
    }

    @Test
    public void givenBoardWhenDamaMovementWithCaptureThenCaptureExced() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.DAMA_JUMP_CAPTURE);
        givenBoardWhenPieceMovementWithCaptureThenCaptureExced(board);   
    }

    private void givenBoardWhenPieceMovementWithCaptureThenCaptureExced(Board board) {
        Coordinate origin1 = new Coordinate(0, 0);
        Coordinate target1 = new Coordinate(0, 0);
        Coordinate origin2 = new Coordinate(0, 0);
        Coordinate target2 = new Coordinate(0, 0);
        Coordinate origin3 = new Coordinate(0, 0);
        Coordinate target3 = new Coordinate(0, 0);
        Coordinate origin4 = new Coordinate(0, 0);
        Coordinate target4 = new Coordinate(0, 0);
        Error error = board.move(origin1, target1, origin2, target2, origin3, target3, origin4, target4);
        assertNotNull(board.getPiece(origin1));
        assertNull(board.getPiece(target4));
        assertEquals(error, Error.CAPTURE_EXCED);
    }

    @Test
    public void givenBoardWhenDamaMovementRequiereButNoCaptureThenErrorImpossibleMove() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.DAMA_IMPOSSIBLE_MOV);
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(1, 2);
        Error error = board.move(origin, target);
        assertNotNull(board.getPiece(origin));
        assertNull(board.getPiece(target));
        assertEquals(error, Error.BAD_MOVE);
    }

    @Test
    public void givenBoardWhenImpossibleMovementThenNoMovementsAllowed() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.TIE);
        assertFalse(board.isMovementsAllowed());
    }

    @Test
    public void givenBoardWhenMovementIsWinnerThenNoMovementsAllowed() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.ONE_MOV_FOR_WIN);
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        assertNull(board.move(origin, target));
        assertFalse(board.isMovementsAllowed());
    }

    @Test
    public void givenBoardWhenBlockMovementThenNoMovementsAllowed() {
        Board board = factoryBoard.getBoard(FactoryBoard.Type.BLACK_BLOKED);
        assertTrue(board.isMovementsAllowed());
        assertFalse(board.isMovementsAllowed(Color.BLACK));
    }
}