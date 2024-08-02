package TicTacToe;

import TicTacToe.controllers.GameController;
import TicTacToe.exceptions.MoreThanOneBotException;
import TicTacToe.models.*;
import TicTacToe.strategies.WinningStrategy.ColumnWinningStrategy;
import TicTacToe.strategies.WinningStrategy.DiagonalWinningStrategy;
import TicTacToe.strategies.WinningStrategy.RowWinningStrategy;
import TicTacToe.strategies.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class client {
    public static void main(String[] args) throws MoreThanOneBotException {
        GameController gameController = new GameController();

        // prepare the data for game
        int dimension = 3;
        List<Player> players = new ArrayList<>();
        players.add(new Player("Rajiv", new Symbol('O'), 1L, PlayerType.HUMAN));
        players.add(new Bot(BotDifficultyLevel.EASY, "Subhu", new Symbol('X'), 2L));

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new ColumnWinningStrategy());
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = gameController.StartGame(dimension, players, winningStrategies);
        System.out.println("Game has been created "+game.getPlayers().get(1).getName());

        while(gameController.checkState(game).equals(GameState.IN_PROGRESS)) {
            // 1. print board
            // 2. X's turn
            // 3. Ask to make move
            gameController.PrintBoard(game);
            gameController.MakeMove(game);
        }
        gameController.PrintBoard(game);
    }
}

// StartGame()
// makeMove()
// displayBoard()
// undo()
// checkState()
// getWinner()