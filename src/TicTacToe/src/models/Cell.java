package TicTacToe.src.models;

public class Cell {
    int row;
    int col;
    CellState state;
    Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        state = CellState.EMPTY;
    }
}