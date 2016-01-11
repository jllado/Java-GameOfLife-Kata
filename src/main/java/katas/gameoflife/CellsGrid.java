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
        return cells[1];
    }

    public boolean isLeftAlive(int position) {
        return false;
    }
}
