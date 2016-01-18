package katas.gameoflife;

/**
 * Created by jllado on 1/12/16.
 */
public class CellPosition {

    private final int x;
    private final int y;

    public CellPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CellPosition topPosition() {
        return new CellPosition(x, y - 1);
    }

    public boolean isValid(int width, int height) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public boolean isSameLine(CellPosition position) {
        return this.getY() == position.getY();
    }

}
