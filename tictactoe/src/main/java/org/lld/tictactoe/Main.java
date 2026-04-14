package main.java.org.lld.tictactoe;

import main.java.org.lld.tictactoe.factory.HumanPlayerFactory;
import main.java.org.lld.tictactoe.factory.PlayerFactory;
import main.java.org.lld.tictactoe.model.*;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PlayerFactory playerFactory = new HumanPlayerFactory();
        Player player0 = playerFactory.createPlayer("player0", new Piece(PieceType.O));
        Player player1 = playerFactory.createPlayer("player1", new Piece(PieceType.X));
        List<Player> players = Arrays.asList(player0,player1);
        Game game = new Game(players);
        game.setCurrentState(new PlayingState(game));
        game.startGame();
    }
}
