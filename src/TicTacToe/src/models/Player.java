package TicTacToe.src.models;


public class Player {
    int id;
    String name;
    Symbol symbol;
    PlayerType type;

    public Player(int id, String name, Symbol symbol, PlayerType type) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.type = type;
    }
}