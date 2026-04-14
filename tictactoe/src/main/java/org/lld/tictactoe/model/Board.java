package main.java.org.lld.tictactoe.model;

public class Board {

    Cell[][] boardCells;

    public Board() {
        boardCells = new Cell[3][3];
    }

    Cell[][] getBoard() {
        return boardCells;
    }

    public boolean checkValid(int row, int col) {
        if (row < boardCells.length && row >= 0 && col < boardCells.length && col >= 0) {
            if (boardCells[row][col] == null) {
                return true;
            }
        }
        return false;
    }

    public void fillCell(int row, int col, Piece piece) {
        boardCells[row][col] = new Cell(piece);
    }

    public void showBoard() {
        for (int i=0; i<boardCells.length; i++) {
            for (int j =0; j<boardCells[0].length; j++) {
                System.out.print(boardCells[i][j]+" ");
            }
            System.out.println();
        }
    }

}