package TicTacToe.src.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    List<List<Cell>> cells;

    public Board(int boardSize) {
        this.size = boardSize;
        cells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Cell> list = new ArrayList<Cell>();
            for (int j = 0; j < size; j++) list.add(new Cell(i, j));
            cells.add(list);
        }
    }

    public boolean fillFirstEmptyCell(Player player) {
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                if (cell.state == CellState.EMPTY) {
                    cell.state = CellState.FILLED;
                    cell.player = player;
                    return true;
                }
            }
        }
        return false;
    }

    public void printAllCells() {
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                if (cell.state == CellState.FILLED) {
                    System.out.println(cell.player.symbol);
                }
            }
        }
    }

}