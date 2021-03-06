package katas.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class CellsGrid {

    private final List<Rule> rules;
    private Cell[][] grid;

    public CellsGrid(int width, int height, List<Rule> rules) {
        this.rules = rules;
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
        return (int) getAllCells().stream().filter(Cell::isAlive).count();
    }

    private CellsGrid createCopy() {
        CellsGrid cellsGridCopy = new CellsGrid(this.width(), this.height(), this.rules);
        for (int xPosition = 0; xPosition < this.width(); xPosition++) {
            System.arraycopy(this.grid[xPosition], 0, cellsGridCopy.grid[xPosition], 0, this.height());
        }
        return cellsGridCopy;
    }

    public int width() {
        return grid.length;
    }

    private Cell getCell(CellPosition position) {
        if (!position.isValid(width(), height())) {
            return new Cell(false, position);
        }
        return grid[position.getX()][position.getY()];
    }

    public int liveNeighbourCellsCount(Cell cell) {
        return (int) cell.getNeighbourPositions().stream().map(position -> getCell(position)).filter(Cell::isAlive).count();
    }

    public CellsGrid nextGeneration() {
        CellsGrid newCellsGrid = this.createCopy();
        for (Cell cell : getAllCells()) {
            for (Rule rule : rules) {
                if (rule.check(this, cell)) {
                    rule.apply(newCellsGrid, cell);
                }
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

    private List<Cell> getAllCells() {
        List<Cell> cells = new ArrayList<>();
        for (int y = 0; y < height(); y++) {
            for (int x = 0; x < width(); x++) {
                cells.add(getCell(new CellPosition(x, y)));
            }
        }
        return cells;
    }

    private Cell getFirstCell() {
        return getCell(new CellPosition(0, 0));
    }

    public List<CellsLine> getCellsLines() {
        List<CellsLine> cellsLines = new ArrayList<>();
        CellsLine cellsLine = new CellsLine(getFirstCell().getPosition().getY());
        for (Cell cell : getAllCells()) {
            if (cell.isSameLine(cellsLine)) {
                cellsLine.add(cell);
                continue;
            }
            cellsLines.add(cellsLine);
            cellsLine = new CellsLine(cell.getPosition().getY());
            cellsLine.add(cell);
        }
        cellsLines.add(cellsLine);
        return cellsLines;
    }

}
