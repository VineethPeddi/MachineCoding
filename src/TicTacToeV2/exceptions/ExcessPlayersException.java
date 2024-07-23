package TicTacToeV2.exceptions;

public class ExcessPlayersException extends  Exception{
    public ExcessPlayersException(int maxAllowedPlayers){
        super("Max no of players allowed is "+maxAllowedPlayers);
    }
}
