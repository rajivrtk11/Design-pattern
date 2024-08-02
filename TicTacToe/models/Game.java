package TicTacToe.models;

import TicTacToe.exceptions.MoreThanOneBotException;
import TicTacToe.strategies.WinningStrategy.WinningStrategy;
import abstractClass.B;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private int nextMovePlayerIndex;
    private GameState gameState;
    private List<WinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.nextMovePlayerIndex = 0;
        this.gameState = GameState.IN_PROGRESS;

    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        private Builder() {
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimension = 0;
        }

        public Game build() throws MoreThanOneBotException {
            try {
                validate();
            }
            catch (Exception e) {
                throw e;
            }
            return new Game(this.dimension, this.players, this.winningStrategies);
        }

        private void validate() throws MoreThanOneBotException {
            validateBotCount();
        }

        private void validateBotCount() throws MoreThanOneBotException {
            int botCount = 0;
            for(Player player: this.players) {
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }

            if(botCount > 1) throw new MoreThanOneBotException();
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
    }

    public void printBoard() {
        board.printBoard();
    }

    public void makeMove(Game game) {
        Player currentMovePlayer = players.get(nextMovePlayerIndex);
        System.out.println("It is "+currentMovePlayer.getName()+"'s turn");

        Move move = currentMovePlayer.makeMove(board);

        // based on move do these changes in game
        if(!validateMove(move)) {
            return;
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cellToChange = board.getBoard().get(row).get(col);
        cellToChange.setCellState(CellState.FILLED);
        cellToChange.setPlayer(currentMovePlayer);

        Move finalMoveObject = new Move(cellToChange, currentMovePlayer);
        moves.add(finalMoveObject);
        nextMovePlayerIndex += 1;
        nextMovePlayerIndex %= players.size();

        if(checkWinner(board, finalMoveObject)) {
            this.gameState = GameState.WIN;
            this.winner = currentMovePlayer;
            System.out.println(currentMovePlayer.getName()+" is the winner!!");
        }
        if(moves.size() == board.getSize()*board.getSize()){
            this.gameState = GameState.DRAW;
        }

    }

    private boolean checkWinner(Board board, Move move) {
        for(WinningStrategy winningStrategy: winningStrategies) {
            if(winningStrategy.checkWinner(board, move)) return true;
        }
        return false;
    }

    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row >= board.getSize() || col >= board.getSize() || row < 0 || col < 0) {
            return false;
        }
        if(board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)){
            return true;
        }
        return false;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
