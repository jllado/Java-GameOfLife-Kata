package katas.gameoflife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CellsGrid {

    private Cell[][] grid;

    public CellsGrid(int width, int height) {
        this.grid = new Cell[width][height];
        for (int x = 0; x < this.grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = new Cell(false, new CellPosition(x, y));
            }
        }
    }

    public int height() {
        return grid[0].length;
    }

    public int liveCellsCount() {
        int liveCellsCount = 0;
        for (Cell cell : getAllCells()) {
            liveCellsCount += cell.isAlive() ? 1 : 0;
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
        CellPosition downPosition = new CellPosition(position.getX(), position.getY() + 1);
        return downPosition.isValid(width(), height()) && getCell(downPosition).isAlive();
    }

    public boolean isLeftAlive(CellPosition position) {
        CellPosition leftPosition = new CellPosition(position.getX() - 1, position.getY());
        return leftPosition.isValid(width(), height()) && getCell(leftPosition).isAlive();
    }

    public boolean isRightAlive(CellPosition position) {
        CellPosition rightPosition = new CellPosition(position.getX() + 1, position.getY());
        return rightPosition.isValid(width(), height()) && getCell(rightPosition).isAlive();
    }

    public boolean isTopLeftAlive(CellPosition position) {
        CellPosition topLeftPosition = new CellPosition(position.getX() - 1, position.getY() - 1);
        return topLeftPosition.isValid(width(), height()) && getCell(topLeftPosition).isAlive();
    }

    public boolean isTopRightAlive(CellPosition position) {
        CellPosition topRightPosition = new CellPosition(position.getX() + 1, position.getY() - 1);
        return topRightPosition.isValid(width(), height()) && getCell(topRightPosition).isAlive();
    }

    public boolean isDownLeftAlive(CellPosition position) {
        CellPosition downLeftPosition = new CellPosition(position.getX() - 1, position.getY() + 1);
        return downLeftPosition.isValid(width(), height()) && getCell(downLeftPosition).isAlive();
    }

    public boolean isDownRightAlive(CellPosition position) {
        CellPosition downRightPosition = new CellPosition(position.getX() + 1, position.getY() + 1);
        return downRightPosition.isValid(width(), height()) && getCell(downRightPosition).isAlive();
    }

    public boolean hasFewerThanTwoLiveNeighbours(Cell cell) {
        return liveNeighbourCellsCount(cell) < 2;
    }

    private List<Boolean> getNeighboursCells(Cell cell) {
        return Arrays.asList(
                this.isTopLeftAlive(cell.getPosition()),
                this.isTopAlive(cell.getPosition()),
                this.isTopRightAlive(cell.getPosition()),
                this.isLeftAlive(cell.getPosition()),
                this.isRightAlive(cell.getPosition()),
                this.isDownLeftAlive(cell.getPosition()),
                this.isDownAlive(cell.getPosition()),
                this.isDownRightAlive(cell.getPosition()));
    }

    public boolean hasMoreThanThreeLiveNeighbours(Cell cell) {
        return liveNeighbourCellsCount(cell) > 3;
    }

    private long liveNeighbourCellsCount(Cell cell) {
        return getNeighboursCells(cell).stream().filter(alive -> alive).count();
    }

    public CellsGrid nextGeneration() {
        CellsGrid newCellsGrid = this.createCopy();
        for (Cell cell : getAllCells()) {
            if (this.hasFewerThanTwoLiveNeighbours(cell)) {
                newCellsGrid.killCell(cell.getPosition());
            }
            if (this.hasMoreThanThreeLiveNeighbours(cell)) {
                newCellsGrid.killCell(cell.getPosition());
            }
            if (this.hasThreeLiveNeighbours(cell)) {
                newCellsGrid.reviveCell(cell.getPosition());
            }
        }
        return newCellsGrid;
    }

    public void reviveCell(CellPosition position) {
        setCell(getCell(position).revive());
    }

    public void killCell(CellPosition position) {
        setCell(getCell(position).kill());
    }

    private void setCell(Cell cell) {
        grid[cell.getPosition().getX()][cell.getPosition().getY()] = cell;
    }

    private boolean hasThreeLiveNeighbours(Cell cell) {
        return liveNeighbourCellsCount(cell) == 3;
    }

    public List<Cell> getAllCells() {
        List<Cell> cells = new ArrayList<>();
        for (int y = 0; y < height(); y++) {
            for (int x = 0; x < width(); x++) {
                cells.add(getCell(new CellPosition(x, y)));
            }
        }
        return cells;
    }

    public Cell getFirstCell() {
        return getCell(new CellPosition(0, 0));
    }

    public List<CellsLine> getCellsLines() {
        List<CellsLine> cellsLines = new ArrayList<>();
        Cell firstLineCell = getFirstCell();
        CellsLine cellsLine = new CellsLine();
        for (Cell cell : getAllCells()) {
            if (cell.isSameLine(firstLineCell)) {
                cellsLine.add(cell);
            } else {
                cellsLines.add(cellsLine);
                cellsLine = new CellsLine();
                firstLineCell = cell;
                cellsLine.add(firstLineCell);
            }
        }
        cellsLines.add(cellsLine);
        return cellsLines;
    }

}
