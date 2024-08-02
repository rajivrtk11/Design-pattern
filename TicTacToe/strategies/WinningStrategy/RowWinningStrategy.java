package TicTacToe.strategies.WinningStrategy;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.CellState;
import TicTacToe.models.Move;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        for(int col = 0; col < board.getSize(); col++){
            Cell cell = board.getBoard().get(row).get(col);
            if(cell.getCellState().equals(CellState.EMPTY) || board.getBoard().get(row).get(col).getPlayer().getSymbol().getaChar() != move.getPlayer().getSymbol().getaChar())
                return false;
        }
        return true;
    }
}
