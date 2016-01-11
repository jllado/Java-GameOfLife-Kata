package katas.gameoflife;

/**
 * Created by jllado on 1/11/16.
 */
public class Grid {

    private boolean isCellAlive;
    private int height;

    public static Grid create(boolean isCellAlive, int height) {
        return new Grid(isCellAlive, height);
    }

    public Grid(boolean isCellAlive, int height) {
        this.isCellAlive = isCellAlive;
        this.height = height;
    }

    public int width() {
        return 1;
    }

    public int height() {
        return height;
    }

    public int liveCellsCount() {
        return isCellAlive ? 1 : 0;
    }
}
