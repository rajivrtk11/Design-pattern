package TicTacToeTwo.Strategies;

import TicTacToeTwo.Models.Board;
import TicTacToeTwo.Models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
