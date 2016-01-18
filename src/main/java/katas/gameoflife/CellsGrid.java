package katas.gameoflife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CellsGrid {
    private boolean[][] grid;

    public CellsGrid(int width, int height) {
        this.grid = new boolean[width][height];
    }

    public void setStatus(boolean alive, CellPosition position) {
        grid[position.getX()][position.getY()] = alive;
    }

    public int height() {
        return grid[0].length;
    }

    public int liveCellsCount() {
        int liveCellsCount = 0;
        for (boolean[] lineCells : grid) {
            for (boolean cell : lineCells) {
                liveCellsCount += cell ? 1 : 0;
            }
        }
        return liveCellsCount;
    }

    public CellsGrid createCopy() {
        CellsGrid cellsGridCopy = new CellsGrid(this.width(), this.height());
        for (int xPosition = 0; xPosition < this.width(); xPosition++) {
            System.arraycopy(this.grid[xPosition], 0, cellsGridCopy.grid[xPosition], 0, this.height());
        }
        return cellsGridCopy;
    }

    int width() {
        return grid.length;
    }

    public boolean isTopAlive(CellPosition position) {
        CellPosition topPosition = position.topPosition();
        return topPosition.isValid(width(), height()) && isLiveCell(topPosition);
    }

    public boolean isLiveCell(CellPosition position) {
        return grid[position.getX()][position.getY()];
    }

    public boolean isDownAlive(CellPosition position) {
        int downPosition = position.getY() + 1;
        return downPosition < height() && isLiveCell(new CellPosition(position.getX(), downPosition));
    }

    public boolean isLeftAlive(CellPosition position) {
        int leftPosition = position.getX() - 1;
        return leftPosition >= 0 && isLiveCell(new CellPosition(leftPosition, position.getY()));
    }

    public boolean isRightAlive(CellPosition position) {
        int rightPosition = position.getX() + 1;
        return rightPosition < width() && isLiveCell(new CellPosition(rightPosition, position.getY()));
    }

    public boolean isTopLeftAlive(CellPosition position) {
        int topPosition = position.getY() - 1;
        int leftPosition = position.getX() - 1;
        return leftPosition >= 0 && topPosition >= 0 && isLiveCell(new CellPosition(leftPosition, topPosition));
    }

    public boolean isTopRightAlive(CellPosition position) {
        int topPosition = position.getY() - 1;
        int rightPosition = position.getX() + 1;
        return rightPosition < width() && topPosition >= 0 && isLiveCell(new CellPosition(rightPosition, topPosition));
    }

    public boolean isDownLeftAlive(CellPosition position) {
        int downPosition = position.getY() + 1;
        int leftPosition = position.getX() - 1;
        return leftPosition >= 0 && downPosition < height() && isLiveCell(new CellPosition(leftPosition, downPosition));
    }

    public boolean isDownRightAlive(CellPosition position) {
        int downPosition = position.getY() + 1;
        int rightPosition = position.getX() + 1;
        return rightPosition < width() && downPosition < height() && isLiveCell(new CellPosition(rightPosition, downPosition));
    }

    public boolean hasFewerThanTwoLiveNeighbours(CellPosition position) {
        return liveNeighbourCellsCount(position) < 2;
    }

    private List<Boolean> getNeighboursCells(CellPosition position) {
        return Arrays.asList(
                this.isTopLeftAlive(position),
                this.isTopAlive(position),
                this.isTopRightAlive(position),
                this.isLeftAlive(position),
                this.isRightAlive(position),
                this.isDownLeftAlive(position),
                this.isDownAlive(position),
                this.isDownRightAlive(position));
    }

    public boolean hasMoreThanThreeLiveNeighbours(CellPosition position) {
        return liveNeighbourCellsCount(position) > 3;
    }

    private long liveNeighbourCellsCount(CellPosition position) {
        return getNeighboursCells(position).stream().filter(cell -> cell).count();
    }

    public CellsGrid nextGeneration() {
        CellsGrid newCellsGrid = this.createCopy();
        for (int xPosition = 0; xPosition < this.width(); xPosition++) {
            for (int yPosition = 0; yPosition < this.height(); yPosition++) {
                if (this.hasFewerThanTwoLiveNeighbours(new CellPosition(xPosition, yPosition))) {
                    newCellsGrid.setStatus(false, new CellPosition(xPosition, yPosition));
                }
                if (this.hasMoreThanThreeLiveNeighbours(new CellPosition(xPosition, yPosition))) {
                    newCellsGrid.setStatus(false, new CellPosition(xPosition, yPosition));
                }
                if (this.hasThreeLiveNeighbours(new CellPosition(xPosition, yPosition))) {
                    newCellsGrid.setStatus(true, new CellPosition(xPosition, yPosition));
                }
            }
        }
        return newCellsGrid;
    }

    private boolean hasThreeLiveNeighbours(CellPosition position) {
        return liveNeighbourCellsCount(position) == 3;
    }

    public List<CellPosition> getAllPosition() {
        List<CellPosition> allPositions = new ArrayList<>();
        for (int y = 0; y < height(); y++) {
            for (int x = 0; x < width(); x++) {
                allPositions.add(new CellPosition(x, y));
            }
        }
        return allPositions;
    }

    public CellPosition getFirstPosition() {
        return new CellPosition(0, 0);
    }


    public List<CellsLine> getCellsLines() {
        List<CellsLine> cellsLines = new ArrayList<>();
        CellPosition firstLinePosition = getFirstPosition();
        CellsLine cellsLine = new CellsLine();
        for (CellPosition position : getAllPosition()) {
            if (position.isSameLine(firstLinePosition)) {
                cellsLine.add(position);
            } else {
                cellsLines.add(cellsLine);
                cellsLine = new CellsLine();
                firstLinePosition = position;
                cellsLine.add(firstLinePosition);
            }
        }
        cellsLines.add(cellsLine);
        return cellsLines;
    }


}
