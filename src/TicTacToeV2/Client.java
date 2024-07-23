package TicTacToeV2;

import TicTacToeV2.controllers.GameController;
import TicTacToeV2.exceptions.ExcessBotsException;
import TicTacToeV2.exceptions.ExcessPlayersException;
import TicTacToeV2.models.Game;
import TicTacToeV2.models.GameState;
import TicTacToeV2.models.Player;
import TicTacToeV2.models.PlayerType;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        GameController gameController=new GameController();

        Player player1=new Player("P1", PlayerType.HUMAN);
        Player player2=new Player("P2",PlayerType.HUMAN);
        Player player3=new Player("P3",PlayerType.BOT);
        List<Player> players=new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        int rows=3,cols=3,numBots=2;

        try {
            Game game = gameController.createGame(players, rows, cols, numBots);
            game.start();
            while (game.getGameState()!= GameState.COMPLETED) {
                game.makeMove();
            }
            if(game.getWinner()!=null)
                System.out.println("Congratulations "+ game.getWinner().getName() + " you are the winner");
            else System.out.println("Match Tied");
        }catch (ExcessBotsException | ExcessPlayersException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("general exception: "+e.getMessage());
        }
    }
}
