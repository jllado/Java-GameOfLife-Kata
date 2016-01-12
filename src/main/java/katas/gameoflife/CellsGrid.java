package katas.gameoflife;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CellsGrid {
    private boolean[][] cells;

    public CellsGrid(int width, int height) {
        this.cells = new boolean[width][height];
    }

    public void setStatus(boolean alive, int xPosition, int yPosition) {
        cells[xPosition][yPosition] = alive;
    }

    public int height() {
        return cells[0].length;
    }

    public int liveCellsCount() {
        int liveCellsCount = 0;
        for (boolean[] lineCells : cells) {
            for (boolean cell : lineCells) {
                liveCellsCount += cell ? 1 : 0;
            }
        }
        return liveCellsCount;
    }

    public static CellsGrid createCopy(CellsGrid cellsGrid) {
        CellsGrid cellsGridCopy = new CellsGrid(cellsGrid.width(), cellsGrid.height());
        for (int i = 0; i < cellsGrid.cells.length; i++) {
            System.arraycopy(cellsGrid.cells[i], 0, cellsGridCopy.cells[i], 0, cellsGrid.height());
        }
        return cellsGridCopy;
    }

    int width() {
        return cells.length;
    }

    public boolean isTopAlive(int xPosition, int yPosition) {
        int topPosition = yPosition - 1;
        return topPosition >= 0 && cells[xPosition][topPosition];
    }

    public boolean isDownAlive(int xPosition, int yPosition) {
        int downPosition = yPosition + 1;
        return downPosition < cells[xPosition].length && cells[xPosition][downPosition];
    }

    public boolean isLeftAlive(int xPosition, int yPosition) {
        int leftPosition = xPosition - 1;
        return leftPosition >= 0 && cells[leftPosition][yPosition];
    }

    public boolean isRightAlive(int xPosition, int yPosition) {
        int rightPosition = xPosition + 1;
        return rightPosition < cells.length && cells[rightPosition][yPosition];
    }

    public boolean isTopLeftAlive(int xPosition, int yPosition) {
        int topPosition = yPosition - 1;
        int leftPosition = xPosition - 1;
        return leftPosition >= 0 && topPosition >= 0 && cells[leftPosition][topPosition];
    }

    public boolean isTopRightAlive(int xPosition, int yPosition) {
        int topPosition = yPosition - 1;
        int rightPosition = xPosition + 1;
        return rightPosition < cells.length && topPosition >= 0 && cells[rightPosition][topPosition];
    }

    public boolean isDownLeftAlive(int xPosition, int yPosition) {
        int downPosition = yPosition + 1;
        int leftPosition = xPosition - 1;
        return leftPosition >= 0 && downPosition < cells[xPosition].length && cells[leftPosition][downPosition];
    }

    public boolean isDownRightAlive(int xPosition, int yPosition) {
        int downPosition = yPosition + 1;
        int rightPosition = xPosition + 1;
        return rightPosition < cells.length && downPosition < cells[xPosition].length && cells[rightPosition][downPosition];
    }

    public boolean hasFewerThanTwoLiveNeighbours(int xPosition, int yPosition) {
        return liveNeighbourCellsCount(xPosition, yPosition).count() < 2;
    }

    private List<Boolean> getNeighboursCells(int xPosition, int yPosition) {
        return Arrays.asList(
                this.isTopLeftAlive(xPosition, yPosition),
                this.isTopAlive(xPosition, yPosition),
                this.isTopRightAlive(xPosition, yPosition),
                this.isLeftAlive(xPosition, yPosition),
                this.isRightAlive(xPosition, yPosition),
                this.isDownLeftAlive(xPosition, yPosition),
                this.isDownAlive(xPosition, yPosition),
                this.isDownRightAlive(xPosition, yPosition));
    }

    public boolean hasMoreThanThreeLiveNeighbours(int xPosition, int yPosition) {
        return liveNeighbourCellsCount(xPosition, yPosition).count() > 3;
    }

    private Stream<Boolean> liveNeighbourCellsCount(int xPosition, int yPosition) {
        return getNeighboursCells(xPosition, yPosition).stream().filter(cell -> cell);
    }
}
