package main.java.org.lld.tictactoe.model;


import main.java.org.lld.tictactoe.model.Game;

public class DrawState implements IState {

    Game game;

    public DrawState(Game game) {
        this.game = game;
    }

    @Override
    public boolean isGameOver() {
        System.out.println("Game is drawn!");
        return true;
    }

    @Override
    public void next(Piece piece) {

    }
}
