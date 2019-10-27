package damas.models;

public class Game {

	private final Turn turn;
	private final Board board;

	public Game() {
		this.turn = new Turn();
		this.board = new Board();
	}

	public Turn getTurn() {
		return null;
	}

    public Piece getPiece(Coordinate coordinate) {
		return null;
	}

	public Error move(Coordinate... coordinates) {
		return null;
	}

	public boolean isFinished() {
		return false;
	}

	public boolean isWinner() {
		return false;
	}
}