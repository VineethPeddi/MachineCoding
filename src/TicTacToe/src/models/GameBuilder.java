//package TicTacToe.src.models;
//
//import java.util.List;
//
//public class GameBuilder {
//    public int boardSize;
//    public List<Player> playerList;
//
//    public BotDifficultyLevel difficultyLevel;
//
//    public Game build() throws BoardSizeException {
//        if (boardSize < 3) {
//            throw new BoardSizeException();
//        }
//        return new Game();
//    }
//
//    public GameBuilder setBoardSize(int boardSize) {
//        this.boardSize = boardSize;
//        return this;
//    }
//
//    public GameBuilder setDifficultyLevel(BotDifficultyLevel level) {
//        this.difficultyLevel = level;
//        return this;
//    }
//
//    public GameBuilder setPlayersList(List<Player> playerList) {
//        this.playerList = playerList;
//        return this;
//    }
//
//
//}
