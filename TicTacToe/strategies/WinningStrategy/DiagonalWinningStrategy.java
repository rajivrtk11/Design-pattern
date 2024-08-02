package TicTacToe.strategies.WinningStrategy;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.CellState;
import TicTacToe.models.Move;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        if(checkDiagonal(board, move) || checkAntiDiagonal(board, move)) return true;
        return false;
    }

    private boolean checkDiagonal(Board board, Move move) {
        // check diagonal
        int currRow = move.getCell().getRow();
        int currCol = move.getCell().getCol();
        char currChar = move.getPlayer().getSymbol().getaChar();

        if(currRow == currCol) {
            for(int row = 0, col = 0; row < board.getSize(); row++, col++) {
                Cell cell = board.getBoard().get(row).get(col);
                if(cell.getCellState().equals(CellState.EMPTY) || board.getBoard().get(row).get(col).getPlayer().getSymbol().getaChar() != currChar) return false;
            }
            return true;
        }
        return false;
    }

    private boolean checkAntiDiagonal(Board board, Move move) {
        // check diagonal
        int currRow = move.getCell().getRow();
        int currCol = move.getCell().getCol();
        char currChar = move.getPlayer().getSymbol().getaChar();
        int size = board.getSize();

        if(currRow + currCol == size-1) {
            for(int row = 0, col = size-1; row < size; row++, col--) {
                Cell cell = board.getBoard().get(row).get(col);
                if(cell.getCellState().equals(CellState.EMPTY) || board.getBoard().get(row).get(col).getPlayer().getSymbol().getaChar() != currChar) return false;
            }
            return true;
        }
        return false;
    }
}
