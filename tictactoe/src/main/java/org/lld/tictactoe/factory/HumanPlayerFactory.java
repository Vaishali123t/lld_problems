package main.java.org.lld.tictactoe.factory;

import main.java.org.lld.tictactoe.model.HumanPlayer;
import main.java.org.lld.tictactoe.model.Piece;
import main.java.org.lld.tictactoe.model.Player;

public class HumanPlayerFactory implements PlayerFactory{
    @Override
    public Player createPlayer(String name, Piece piece) {
        return new HumanPlayer(name,piece);
    }
}
