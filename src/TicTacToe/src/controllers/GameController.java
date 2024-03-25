package TicTacToe.src.controllers;

import TicTacToe.src.models.Game;
import TicTacToe.src.models.Game.GameBuilder;
import TicTacToe.src.models.GameState;

public class GameController {
    public GameBuilder getGameBuilder() {
        return Game.getGameBuilder();
    }

    public GameState getGameStatus(Game game) {
        return game.getStatus();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public void displayBoard(Game game) {
        game.displayBoard();
    }


}