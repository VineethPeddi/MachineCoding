package TicTacToeV2.models;

public class Player {
    String name;
    PlayerType playerType;

    Symbol symbol;

    public Player(String name,PlayerType playerType){
        this.name=name;
        this.playerType=playerType;
    }

    public void setSymbol(Symbol symbol){
        this.symbol=symbol;
    }
    public Symbol getSymbol(){
        return this.symbol;
    }

    public  String getName(){
        return this.name;
    }

}
