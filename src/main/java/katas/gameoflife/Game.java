package katas.gameoflife;

/**
 * Created by jllado on 1/11/16.
 */
public class Game {

    private CellsGrid cellsGrid;

    public static Game create(int width, int height) {
        return new Game(width, height);
    }

    public Game(int width, int height) {
        this.cellsGrid = new CellsGrid(width, height);
    }

    public int gridWidth() {
        return cellsGrid.width();
    }

    public int gridHeight() {
        return cellsGrid.height();
    }

    public int liveCellsCount() {
        return cellsGrid.liveCellsCount();
    }

    public void setCellStatus(boolean alive, int xPosition, int position) {
        cellsGrid.setStatus(alive, xPosition, position);
    }

    public void iterate() {
        CellsGrid newCellsGrid = CellsGrid.createCopy(cellsGrid);
        for (int xPosition = 0; xPosition < cellsGrid.width(); xPosition++) {
            for (int yPosition = 0; yPosition < cellsGrid.height(); yPosition++) {
                if (cellsGrid.hasFewerThanTwoLiveNeighbours(xPosition, yPosition)) {
                    newCellsGrid.setStatus(false, xPosition, yPosition);
                }
                if (cellsGrid.hasMoreThanThreeLiveNeighbours(xPosition, yPosition)) {
                    newCellsGrid.setStatus(false, xPosition, yPosition);
                }
            }
        }
        cellsGrid = newCellsGrid;
    }
}
