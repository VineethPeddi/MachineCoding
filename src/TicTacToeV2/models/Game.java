package TicTacToeV2.models;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players;
    Board board;

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    Player winner;
    int moveCnt;
    int numPlayers;

    List<Move> moves;

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    GameState gameState;

    public Game(List<Player> players,Board board){
        this.players=players;
        this.board=board;
        moveCnt=0;
        gameState=GameState.NOTSTARTED;
        numPlayers=players.size();
        moves=new ArrayList<>();
    }

    public void start(){
        gameState=GameState.INPROGRESS;
    }

    public void makeMove(){
        Player currentPlayer=players.get(moveCnt%numPlayers);
        System.out.println("Player "+currentPlayer.getName()+ " please make a move");
        board.display();
        board.addSymbol(currentPlayer.getSymbol(),this);
        moveCnt++;
        if(moveCnt==board.cols*board.rows)gameState=GameState.COMPLETED;
    }

}

