package main.java.org.lld.tictactoe.model;

import main.java.org.lld.tictactoe.model.Game;

public class PlayingState implements IState {

    Game game;

    public PlayingState(Game game) {
        this.game = game;
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public void next(Piece piece) {
        Board board = game.getBoard();
        // check if draw or win state occured
        Cell[][] cells = board.getBoard();

        if (checkIfWon(piece, cells)) return;
        checkIfDraw(cells);

    }

    private boolean checkIfDraw(Cell[][] cells) {
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[0].length; col++) {
                if (cells[row][col]==null) {
                    return false;
                }
            }
        }
        game.setCurrentState(new DrawState(game));
        return true;
    }

    private boolean checkIfWon(Piece piece, Cell[][] cells) {

        // check all rows
        for (int row = 0; row < cells.length; row++) {
            int count = 0;
            for (int col = 0; col < cells[0].length; col++) {
                if (cells[row][col]!=null && cells[row][col].getPiece().getPieceType() == piece.getPieceType()) {
                    count++;
                }
            }
            if (count == cells.length) {
                System.out.println(piece.getPieceType()+" won");
                game.setCurrentState(new WinState(game));
                return true;
            }
        }

        // check all columns
        for (int col = 0; col < cells.length; col++) {
            int count = 0;
            for (int row = 0; row < cells[0].length; row++) {
                if (cells[row][col]!=null && cells[row][col].getPiece().getPieceType() == piece.getPieceType()) {
                    count++;
                }
            }
            if (count == cells.length) {
                game.setCurrentState(new WinState(game));
                return true;
            }
        }

        // check diagonals
        // 00, 11, 22 // 02, 11, 20
        // if diagonal elements are same
        int count = 0;
        for(int i=0;i<cells.length;i++){
            if(cells[i][i]!=null && cells[i][i].getPiece()==piece){
                count++;
            }
        }
        if (count == cells.length) {
            game.setCurrentState(new WinState(game));
            return true;
        }

        int row = 0, col = 2;
        count = 0;
        while (row < cells.length && col >= 0) {
            if (cells[row][col]!=null && cells[row][col].getPiece()==piece){
                count++;
            }
            row+=1;
            col-=1;
        }
        if (count == cells.length) {
            game.setCurrentState(new WinState(game));
            return true;
        }

        return false;
    }
}
