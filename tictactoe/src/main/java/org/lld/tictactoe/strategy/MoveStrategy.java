package main.java.org.lld.tictactoe.strategy;

import main.java.org.lld.tictactoe.model.Board;
import main.java.org.lld.tictactoe.model.Piece;

public interface MoveStrategy {

    boolean makeMove(Board board, Piece piece);

}
