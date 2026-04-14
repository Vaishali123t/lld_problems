package main.java.org.lld.tictactoe.model;

public class PlayerO implements Player {

    String name;
    Piece piece;

    public PlayerO(String name) {
        this.name = name;
        this.piece = new Piece(PieceType.O);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

}
