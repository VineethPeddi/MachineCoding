package TicTacToe.src;

import TicTacToe.src.controllers.GameController;
import TicTacToe.src.models.*;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        GameController gc = new GameController();
        int boardSize = 3;
        List<Player> playersList = List.of(
                new Player(1, "Vineeth", Symbol.BLUE, PlayerType.HUMAN),
                new Player(2, "Nithish", Symbol.GREEN, PlayerType.HUMAN),
                new Bot(3, "Noobie", Symbol.RED)
        );
        Game game = null;
        try {
            game = gc.getGameBuilder()
                    .setBoardSize(boardSize)
                    .setPlayersList(playersList)
                    .setDifficultyLevel(BotDifficultyLevel.EASY)
                    .setWinningStrategy(WinStrategy.Column)
                    .build();
        } catch (BoardSizeException be) {
            System.out.println(be.getMessage());
            System.exit(1);
        }
        while (gc.getGameStatus(game) == GameState.IN_PROGRESS) {
            gc.makeMove(game);
            gc.displayBoard(game);
        }
    }
}
