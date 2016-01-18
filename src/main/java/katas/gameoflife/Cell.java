package katas.gameoflife;

/**
 * Created by jllado on 1/18/16.
 */
public class Cell {
    private boolean alive;

    public Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return alive == cell.alive;

    }

    @Override
    public int hashCode() {
        return (alive ? 1 : 0);
    }
}
