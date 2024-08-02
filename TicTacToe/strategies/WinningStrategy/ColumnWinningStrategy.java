package TicTacToe.strategies.WinningStrategy;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.CellState;
import TicTacToe.models.Move;

public class ColumnWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        for(int row = 0; row < board.getSize(); row++){
            Cell cell = board.getBoard().get(row).get(col);
            if(cell.getCellState().equals(CellState.EMPTY) || board.getBoard().get(row).get(col).getPlayer().getSymbol().getaChar() != move.getPlayer().getSymbol().getaChar())
                return false;
        }
        return true;
    }
}
