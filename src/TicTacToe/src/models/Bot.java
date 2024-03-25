package TicTacToe.src.models;

public class Bot extends Player {
    BotDifficultyLevel level;

    public Bot(int id, String name, Symbol symbol) {
        super(id, name, symbol, PlayerType.BOT);
    }
}