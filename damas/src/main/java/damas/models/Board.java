package damas.models;

import java.util.List;

public class Board {

  private List<Piece> pieces;
  private Square[][] squares;

  public Board() {
  }

  public Error move(Coordinate... coordinates) {
    return null;
  }

  public Piece getPiece(Coordinate origin) {
    return null;
  }

  public boolean isMovementsAllowed() {
    return !isMovementsAllowed(Color.WHITE) && !isMovementsAllowed(Color.BLACK);
  }

  public boolean isMovementsAllowed(Color color) {
    return false;
  }

  public boolean Contains(Color color) {
    return false;
  }
}