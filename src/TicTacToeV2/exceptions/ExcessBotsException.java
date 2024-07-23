package TicTacToeV2.exceptions;

public class ExcessBotsException extends Exception{
    public ExcessBotsException(int maxAllowedBots){
        super("Number of Bots should not be more than "+maxAllowedBots);
    }
}
