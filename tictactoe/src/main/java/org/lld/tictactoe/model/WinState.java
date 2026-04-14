package main.java.org.lld.tictactoe.model;

import main.java.org.lld.tictactoe.model.Game;

public class WinState implements IState{

    Game game;

    public WinState(Game game) {
        this.game = game;
    }

    @Override
    public boolean isGameOver() {
        System.out.println(game.getCurrentPlayer().getName() + " won!");
        return true;
    }

    @Override
    public void next(Piece piece) {

    }
}
