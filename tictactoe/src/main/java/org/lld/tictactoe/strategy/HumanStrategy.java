package main.java.org.lld.tictactoe.strategy;

import main.java.org.lld.tictactoe.model.Board;
import main.java.org.lld.tictactoe.model.Piece;

import java.util.Scanner;

public class HumanStrategy implements MoveStrategy{

    @Override
    public boolean makeMove(Board board, Piece piece) {
        while (true) {
            System.out.print("Pick a row and column: ");
            Scanner scanner= new Scanner(System.in);
            int row= scanner.nextInt();
            int col= scanner.nextInt();
            if (board.checkValid(row,col)) {
                board.fillCell(row,col,piece);
                return true;
            }
            else {
                System.out.println("Invalid move. Please see the board and pick appropriate row and col");
            }
        }
    }
}
