package main.java.org.lld.tictactoe.factory;

import main.java.org.lld.tictactoe.model.Piece;
import main.java.org.lld.tictactoe.model.Player;

public interface PlayerFactory {

    Player createPlayer(String name, Piece piece);

}
