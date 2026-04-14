package main.java.org.lld.tictactoe.model;

public interface IState {

    boolean isGameOver();
    void next(Piece piece);

}
