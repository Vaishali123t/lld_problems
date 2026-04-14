package main.java.org.lld.tictactoe.model;

import main.java.org.lld.tictactoe.strategy.MoveStrategy;

public abstract class Player {

    String name;
    Piece piece;
    MoveStrategy moveStrategy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }
}
