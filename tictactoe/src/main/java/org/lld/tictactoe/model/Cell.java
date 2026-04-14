package main.java.org.lld.tictactoe.model;

public class Cell {

    Piece piece;

    public Cell(Piece piece) {
        this.piece = piece;
    }

    Piece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return piece.getPieceType().toString();
    }
}
