package katas.gameoflife;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public CellsGrid createCopy() {
        CellsGrid cellsGridCopy = new CellsGrid(this.width(), this.height(), this.rules);
        for (int xPosition = 0; xPosition < this.width(); xPosition++) {
            System.arraycopy(this.grid[xPosition], 0, cellsGridCopy.grid[xPosition], 0, this.height());
        }
        return cellsGridCopy;
    }

    int width() {
        return grid.length;
    }

    private Cell getCell(CellPosition position) {
        if (!position.isValid(width(), height())) {
            return new Cell(false, position);
        }
        return grid[position.getX()][position.getY()];
    }

    private List<Cell> getNeighboursCells(Cell cell) {
        return cell.getNeighbourPositions().stream().map(position -> getCell(position)).collect(Collectors.toList());
    }

    public boolean hasMoreThanThreeLiveNeighbours(Cell cell) {
        return liveNeighbourCellsCount(cell) > 3;
    }

    public int liveNeighbourCellsCount(Cell cell) {
        return (int) getNeighboursCells(cell).stream().filter(neighbour -> neighbour.isAlive()).count();
    }

    public CellsGrid nextGeneration() {
        CellsGrid newCellsGrid = this.createCopy();
        for (Cell cell : getAllCells()) {
            for (Rule rule : rules) {
                if (rule.check(this, cell)) {
                    rule.apply(newCellsGrid, cell);
                }
            }
            if (hasMoreThanThreeLiveNeighbours(cell)) {
                newCellsGrid.killCell(cell.getPosition());
            }
            if (hasThreeLiveNeighbours(cell)) {
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
