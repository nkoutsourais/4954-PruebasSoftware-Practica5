package damas.models;

public abstract class Piece {

	private Color color;

	Piece(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}
}