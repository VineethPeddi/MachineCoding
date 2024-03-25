package TicTacToe.src.models;

public class BotEasy implements PlayerMove {
    public void makeMove(Game game) {

        if (!game.board.fillFirstEmptyCell(game.players.get(game.getNextPlayerMoveIndex())))
            game.setStatus(GameState.DRAW);
    }
}