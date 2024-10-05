package TicTacToeTwo.Models;

import TicTacToeTwo.Strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private int currentPlayerIdx;
    private GameState gameState;
    private List<WinningStrategy> winningStrategies;
    private Player winner;

    Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.moves = new ArrayList<>();
        this.currentPlayerIdx = 0;
        this.gameState = GameState.IN_PROGRESS;

    }


}
