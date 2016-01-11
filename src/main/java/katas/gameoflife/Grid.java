package katas.gameoflife;

/**
 * Created by jllado on 1/11/16.
 */
public class Grid {

    private boolean isCellAlive;

    public static Grid create(boolean isCellAlive) {
        return new Grid(isCellAlive);
    }

    public Grid(boolean isCellAlive) {
        this.isCellAlive = isCellAlive;
    }

    public int height() {
        return 1;
    }

    public int width() {
        return 1;
    }

    public int liveCellsCount() {
        return isCellAlive ? 1 : 0;
    }
}
