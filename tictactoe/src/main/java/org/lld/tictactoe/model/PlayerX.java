package main.java.org.lld.tictactoe.model;

public class PlayerX implements Player {

    String name;
    Piece piece;

    public PlayerX(String name) {
        this.name = name;
        this.piece = new Piece(PieceType.X);
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

    @Override
    public String toString() {
        return "PlayerX{" +
                "name='" + name + '\'' +
                ", piece=" + piece +
                '}';
    }
}
