package TicTacToeV2.models;

import java.util.Scanner;

public class Board {
    int rows,cols;
    Symbol[][]cells;

    Pair[] colStates,rowStates;
    public Board(int rows,int cols){
        this.rows=rows;
        this.cols=cols;
        cells=new Symbol[rows][cols];
        for(int i=0;i<rows;i++)for(int j=0;j<cols;j++)cells[i][j]=Symbol.EMPTY;
        colStates=new Pair[cols];
        rowStates=new Pair[rows];
        for(int i=0;i<rows;i++)rowStates[i]=new Pair(Symbol.EMPTY,rows);
        for(int j=0;j<cols;j++)colStates[j]=new Pair(Symbol.EMPTY,cols);
    }

    public void display(){
        for(Symbol []row:cells){
            for(Symbol cell:row){
                System.out.print(cell+" | ");
            }
            System.out.println();
        }
    }

    public void addSymbol(Symbol symbol, Game game){
        int x,y;
        while(true) {
            System.out.println("Enter position to place the symbol");
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter row number: ");
            x = scanner.nextInt()-1;
            System.out.println("Enter column number: ");
            y = scanner.nextInt()-1;
            if(x>=rows || y>=cols || x<0 || y<0 || cells[x][y]!=Symbol.EMPTY){
                System.out.println("Invalid position, please try again");
                continue;
            }
            break;
        }
        cells[x][y]=symbol;
        updateStates(rowStates,x,symbol,game);
        updateStates(colStates,y,symbol,game);
        game.moves.add(new Move(x,y));
    }

    public void updateStates(Pair[] state,int position,Symbol symbol,Game game){
        if(state[position].symbol==Symbol.EMPTY || state[position].symbol==symbol){
            state[position].symbol=symbol;
            state[position].cnt--;
            if(state[position].cnt==0){
                game.gameState= GameState.COMPLETED;
                game.winner=game.players.get(game.moveCnt%game.numPlayers);
            }
        }
    }
}

