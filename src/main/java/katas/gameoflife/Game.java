package katas.gameoflife;

/**
 * Created by jllado on 1/11/16.
 */
public class Game {

    private CellsGrid grid;

    public Game(CellsGrid grid) {
        this.grid = grid;
    }

    public int gridWidth() {
        return grid.width();
    }

    public int gridHeight() {
        return grid.height();
    }

    public int liveCellsCount() {
        return grid.liveCellsCount();
    }

    public void setCellStatus(boolean alive, int xPosition, int yPosition) {
        grid.setStatus(alive, new CellPosition(xPosition, yPosition));
    }

    public void nextGeneration() {
        grid = grid.nextGeneration();
    }
}
