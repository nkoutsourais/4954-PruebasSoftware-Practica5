package damas.models;

public class Game {

	private Turn turn;
	private Board board;

	public Game() {
		reset();
	}

	public Turn getTurn() {
		return this.turn;
	}

	public Piece getPiece(Coordinate coordinate) {
		return this.board.getPiece(coordinate);
	}

	public Error move(Coordinate... coordinates) {
		return this.board.move(coordinates);
	}

	public boolean isFinished() {
		return !this.board.isMovementsAllowed();
	}

	public boolean isWinner() {
		return isFinished() && !isTie() && this.board.Contains(turn.getColor());
	}

	public boolean isTie() {
		return isFinished() && this.board.Contains(Color.WHITE) && this.board.Contains(Color.BLACK);
	}

	public void reset() {
		this.turn = new Turn();
		this.board = new Board();
	}
}