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

    public boolean isValid(int width, int height) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public boolean isSameLine(CellPosition position) {
        return this.getY() == position.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CellPosition that = (CellPosition) o;

        if (x != that.x) return false;
        return y == that.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "CellPosition{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public CellPosition getTop() {
        return new CellPosition(x, y - 1);
    }

    public CellPosition getTopLeft() {
        return new CellPosition(x - 1, y - 1);
    }

    public CellPosition getTopRight() {
        return new CellPosition(x + 1, y - 1);
    }

    public CellPosition getDownLeft() {
        return new CellPosition(x - 1, y + 1);
    }

    public CellPosition getDownRight() {
        return new CellPosition(x + 1, y + 1);
    }

    public CellPosition getRight() {
        return new CellPosition(x + 1, y);
    }

    public CellPosition getDown() {
        return new CellPosition(x, y + 1);
    }

    public CellPosition getLeft() {
        return new CellPosition(x - 1, y);
    }
}
