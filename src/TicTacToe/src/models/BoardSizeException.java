package TicTacToe.src.models;

public class BoardSizeException extends Exception{
    public BoardSizeException(){
        super("Board size cannot be less than 3");
    }
}
