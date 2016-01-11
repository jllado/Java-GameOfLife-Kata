package katas.gameoflife;

/**
 * Created by jllado on 1/11/16.
 */
public class Game {

    private final CellsGrid cellsGrid;

    public static Game create(int height) {
        return new Game(height);
    }

    public Game(int height) {
        this.cellsGrid = new CellsGrid(height);
    }

    public int gridWidth() {
        return 1;
    }

    public int gridHeight() {
        return cellsGrid.height();
    }

    public int liveCellsCount() {
        return cellsGrid.liveCellsCount();
    }

    public void setCellStatus(boolean alive, int position) {
        cellsGrid.setStatus(alive, position);
    }

    public void iterate() {
        for (int i = 0; i < cellsGrid.height(); i++) {
            cellsGrid.setStatus(false, i);
        }
    }
}
