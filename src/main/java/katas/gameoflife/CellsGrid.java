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
        int leftPosition = yPosition - 1;
        return leftPosition >= 0 && cells[xPosition][leftPosition];
    }

    public boolean isDownAlive(int xPosition, int yPosition) {
        int rightPosition = yPosition + 1;
        return rightPosition < cells[xPosition].length && cells[xPosition][rightPosition];
    }

    public boolean isLeftAlive(int xPosition, int yPosition) {
        int leftPosition = xPosition - 1;
        return leftPosition >= 0 && cells[leftPosition][yPosition];
    }

    public boolean isRightAlive(int xPosition, int yPosition) {
        int rightPosition = xPosition + 1;
        return rightPosition < cells.length && cells[rightPosition][yPosition];
    }

}
