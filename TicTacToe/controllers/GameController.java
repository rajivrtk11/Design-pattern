package TicTacToe.controllers;

import TicTacToe.exceptions.MoreThanOneBotException;
import TicTacToe.models.Game;
import TicTacToe.models.GameState;
import TicTacToe.models.Player;
import TicTacToe.strategies.WinningStrategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game StartGame(int dimensionOfBoard, List<Player> players, List<WinningStrategy> winningStrategies) throws MoreThanOneBotException {
        return Game.getBuilder()
                .setPlayers(players)
                .setDimension(dimensionOfBoard)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    // these are game specific, so accept current game
    public void MakeMove(Game game) {
        game.makeMove(game);
    }

    public void Undo(Game game) {

    }

    public void PrintBoard(Game game) {
        game.printBoard();
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public void getWinner(Game game) {

    }


}
