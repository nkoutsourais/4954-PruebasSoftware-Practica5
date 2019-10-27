package damas.models;

public class Turn {

    private Color color;

    public Turn() {
        this.color = Color.WHITE;
    }

    public void next() {
        this.color = this.color == Color.WHITE ? Color.BLACK : Color.WHITE;
    }

    public Color getColor() {
        return this.color;
    }
}