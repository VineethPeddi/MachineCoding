package TicTacToeV2.controllers;

import TicTacToeV2.exceptions.ExcessBotsException;
import TicTacToeV2.exceptions.ExcessPlayersException;
import TicTacToeV2.models.Board;
import TicTacToeV2.models.Game;
import TicTacToeV2.models.Player;
import TicTacToeV2.models.Symbol;

import java.util.List;

public class GameController {

    int maxAllowedBots=2;
    int maxPlayers=5;
    Symbol[]symbols=new Symbol[]{Symbol.A,Symbol.B,Symbol.C,Symbol.D,Symbol.E};
    public Game createGame(List<Player> players, int rows, int cols, int numBots) throws Exception {
        if(players.size()>maxPlayers)throw new ExcessPlayersException(maxPlayers);
        if(numBots>maxAllowedBots)throw new ExcessBotsException(maxAllowedBots);
        for(int i=0;i<players.size();i++)players.get(i).setSymbol(symbols[i]);
        Board board=new Board(rows,cols);
        return new Game(players,board);
    }
    public void startGame(){}
}
