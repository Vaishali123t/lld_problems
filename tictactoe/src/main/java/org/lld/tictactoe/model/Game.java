package main.java.org.lld.tictactoe.model;

import java.util.List;
import java.util.Scanner;

public class Game {

    Board board;
    List<Player> players;
    Player currentPlayer;
    IState currentState;

    public Game(List<Player> players) {
        board = new Board();
        this.players = players;
        Player playerO = players.get(0);
        currentPlayer = playerO;
    }

    public void startGame() {
        while (!currentState.isGameOver()) {
            System.out.println("******");
            board.showBoard();
            System.out.println(currentPlayer.getName()+"'s turn");
            currentPlayer.getMoveStrategy().makeMove(board, currentPlayer.getPiece());
            currentState.next(currentPlayer.getPiece());
            // change player -> we could have added states here as well like XTurnState , OTurnState and changed states there
            if (currentState.isGameOver()) {
                break;
            }
            else  {
                currentPlayer = currentPlayer==players.get(0)?players.get(1):players.get(0);
            }
        }
    }

    public void setCurrentState(IState state) {
        this.currentState = state;
    }

    public IState getCurrentState(){
        return this.currentState;
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
