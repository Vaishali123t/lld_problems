package main.java.org.lld.tictactoe;

import main.java.org.lld.tictactoe.model.Game;
import main.java.org.lld.tictactoe.model.PlayingState;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.setCurrentState(new PlayingState(game));
        game.startGame();
    }

}
