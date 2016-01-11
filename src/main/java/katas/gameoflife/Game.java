package katas.gameoflife;

/**
 * Created by jllado on 1/11/16.
 */
public class Game {

    private boolean[] cells;

    public static Game create(int height) {
        return new Game(height);
    }

    public Game(int height) {
        this.cells = new boolean[height];
    }

    public int gridWidth() {
        return 1;
    }

    public int gridHeight() {
        return cells.length;
    }

    public int liveCellsCount() {
        int liveCellsCount = 0;
        for (boolean cell : cells) {
            liveCellsCount += cell ? 1 : 0;
        }
        return liveCellsCount;
    }

    public void setCellStatus(boolean alive, int position) {
        cells[position] = alive;
    }
}
