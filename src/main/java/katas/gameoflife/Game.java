package katas.gameoflife;

/**
 * Created by jllado on 1/11/16.
 */
public class Game {

    private CellsGrid cellsGrid;

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
        CellsGrid newCellsGrid = CellsGrid.createCopy(cellsGrid);
        for (int position = 0; position < cellsGrid.height(); position++) {
            if (cellsGrid.isLeftNotAlive(position) || cellsGrid.isRightNotAlive(position)) {
                newCellsGrid.setStatus(false, position);
            }
        }
        cellsGrid = newCellsGrid;
    }
}
