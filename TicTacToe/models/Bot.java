package TicTacToe.models;

import TicTacToe.strategies.BotPlayingStrategy.BotPlayingStrategy;
import TicTacToe.strategies.BotPlayingStrategy.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(BotDifficultyLevel botDifficultyLevel, String name, Symbol symbol, Long id) {
        super(name, symbol, id, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyBasedOnDifficulty(botDifficultyLevel);

    }
    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        Move move = this.botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
