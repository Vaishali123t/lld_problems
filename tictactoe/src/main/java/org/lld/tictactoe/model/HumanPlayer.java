package main.java.org.lld.tictactoe.model;

import main.java.org.lld.tictactoe.strategy.HumanStrategy;

public class HumanPlayer extends Player{

    public HumanPlayer(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
        this.moveStrategy = new HumanStrategy();
    }
}
