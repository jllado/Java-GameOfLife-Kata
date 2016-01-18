package katas.gameoflife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CellsGrid {

    private Cell[][] grid;

    public CellsGrid(int width, int height) {
        this.grid = new Cell[width][height];
        for (Cell[] cellsLine : this.grid) {
            for (int linePosition = 0; linePosition < cellsLine.length; linePosition++) {
                cellsLine[linePosition] = new Cell(false);
            }
        }
    }

    public void setStatus(boolean alive, CellPosition position) {
        grid[position.getX()][position.getY()] = new Cell(alive);
    }

    public int height() {
        return grid[0].length;
    }

    public int liveCellsCount() {
        int liveCellsCount = 0;
        for (Cell[] cellsLine : grid) {
            for (Cell cell : cellsLine) {
                liveCellsCount += cell.isAlive() ? 1 : 0;
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
        return topPosition.isValid(width(), height()) && getCell(topPosition).isAlive();
    }

    private Cell getCell(CellPosition position) {
        return grid[position.getX()][position.getY()];
    }

    public boolean isDownAlive(CellPosition position) {
        int downPosition = position.getY() + 1;
        return downPosition < height() && getCell(new CellPosition(position.getX(), downPosition)).isAlive();
    }

    public boolean isLeftAlive(CellPosition position) {
        int leftPosition = position.getX() - 1;
        return leftPosition >= 0 && getCell(new CellPosition(leftPosition, position.getY())).isAlive();
    }

    public boolean isRightAlive(CellPosition position) {
        int rightPosition = position.getX() + 1;
        return rightPosition < width() && getCell(new CellPosition(rightPosition, position.getY())).isAlive();
    }

    public boolean isTopLeftAlive(CellPosition position) {
        int topPosition = position.getY() - 1;
        int leftPosition = position.getX() - 1;
        return leftPosition >= 0 && topPosition >= 0 && getCell(new CellPosition(leftPosition, topPosition)).isAlive();
    }

    public boolean isTopRightAlive(CellPosition position) {
        int topPosition = position.getY() - 1;
        int rightPosition = position.getX() + 1;
        return rightPosition < width() && topPosition >= 0 && getCell(new CellPosition(rightPosition, topPosition)).isAlive();
    }

    public boolean isDownLeftAlive(CellPosition position) {
        int downPosition = position.getY() + 1;
        int leftPosition = position.getX() - 1;
        return leftPosition >= 0 && downPosition < height() && getCell(new CellPosition(leftPosition, downPosition)).isAlive();
    }

    public boolean isDownRightAlive(CellPosition position) {
        int downPosition = position.getY() + 1;
        int rightPosition = position.getX() + 1;
        return rightPosition < width() && downPosition < height() && getCell(new CellPosition(rightPosition, downPosition)).isAlive();
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
                    newCellsGrid.killCell(new CellPosition(xPosition, yPosition));
                }
                if (this.hasMoreThanThreeLiveNeighbours(new CellPosition(xPosition, yPosition))) {
                    newCellsGrid.killCell(new CellPosition(xPosition, yPosition));
                }
                if (this.hasThreeLiveNeighbours(new CellPosition(xPosition, yPosition))) {
                    newCellsGrid.reviveCell(new CellPosition(xPosition, yPosition));
                }
            }
        }
        return newCellsGrid;
    }

    private void reviveCell(CellPosition position) {
        setStatus(true, position);
    }

    private void killCell(CellPosition position) {
        setStatus(false, position);
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
                cellsLine.add(new Cell(getCell(position).isAlive()));
            } else {
                cellsLines.add(cellsLine);
                cellsLine = new CellsLine();
                firstLinePosition = position;
                cellsLine.add(new Cell(getCell(firstLinePosition).isAlive()));
            }
        }
        cellsLines.add(cellsLine);
        return cellsLines;
    }

}
