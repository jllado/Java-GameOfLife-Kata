package katas.gameoflife;

public class CellsGrid {
    boolean[] cells;

    public CellsGrid(int height) {
        this.cells = new boolean[height];
    }

    public void setStatus(boolean alive, int position) {
        cells[position] = alive;
    }

    public int height() {
        return cells.length;
    }

    public int liveCellsCount() {
        int liveCellsCount = 0;
        for (boolean cell : cells) {
            liveCellsCount += cell ? 1 : 0;
        }
        return liveCellsCount;
    }

    public boolean isRightAlive(int position) {
        int rightPosition = position + 1;
        return rightPosition < cells.length && cells[(rightPosition)];
    }

    public boolean isLeftAlive(int position) {
        int leftPosition = position - 1;
        return leftPosition >= 0 && cells[(leftPosition)];
    }

    public static CellsGrid createCopy(CellsGrid cellsGrid) {
        CellsGrid cellsGridCopy = new CellsGrid(cellsGrid.height());
        System.arraycopy(cellsGrid.cells, 0, cellsGridCopy.cells, 0, cellsGrid.height());
        return cellsGridCopy;
    }

    public boolean isLeftNotAlive(int position) {
        return !isLeftAlive(position);
    }

    public boolean isRightNotAlive(int position) {
        return !isRightAlive(position);
    }
}
