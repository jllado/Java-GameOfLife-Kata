package katas.gameoflife;

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
        for (boolean cell : cells[0]) {
            liveCellsCount += cell ? 1 : 0;
        }
        return liveCellsCount;
    }

    public boolean isRightAlive(int position) {
        int rightPosition = position + 1;
        return rightPosition < cells[0].length && cells[0][rightPosition];
    }

    public boolean isLeftAlive(int position) {
        int leftPosition = position - 1;
        return leftPosition >= 0 && cells[0][leftPosition];
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

    public boolean isLeftNotAlive(int position) {
        return !isLeftAlive(position);
    }

    public boolean isRightNotAlive(int position) {
        return !isRightAlive(position);
    }
}
