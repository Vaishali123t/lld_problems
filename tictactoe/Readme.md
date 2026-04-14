Features:

1. Ability to initialize a new gameOld
2. Supports a standard 3x3 Tic Tac Toe gameOld
3. Allows 2 humans to play. Alternating turns between X and O.
4. Check if a move is valid
5. Update the board with players moves
6. Win condition: check for win condition
7. Draw condition: check for draw condition
8. Player switching: switch players after each move

Advanced:
1. Robot Playing - (extensible so that human and robot can play)
2. Extensibility for more symbols?

________

Identifying entities:

1. PieceType: enum X, O
2. Piece:
3. Board: a 3*3 grid where the gameOld is played
4. Cell: A cell in the grid. Can be empty, X or O.
5. Player: Each player choses a symbol initially.
6. org.lld.tictacToe.Game

____

Design patterns used

1. State pattern