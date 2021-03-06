package katas.gameoflife;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jllado on 1/18/16.
 */
public class Cell {
    private boolean alive;
    private CellPosition position;

    public Cell(boolean alive, CellPosition position) {
        this.alive = alive;
        this.position = position;
    }

    public boolean isAlive() {
        return alive;
    }

    public CellPosition getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (alive != cell.alive) return false;
        return !(position != null ? !position.equals(cell.position) : cell.position != null);

    }

    @Override
    public int hashCode() {
        int result = (alive ? 1 : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    public Cell revive() {
        return new Cell(true, position);
    }

    public Cell kill() {
        return new Cell(false, position);
    }

    public boolean isSameLine(CellsLine cellsLine) {
        return position.isSameLine(new CellPosition(0, cellsLine.getLine()));
    }

    @Override
    public String toString() {
        return isAlive() ? "*" : "_";
    }

    public CellPosition getTopLeftPosition() {
        return position.getTopLeft();
    }

    public CellPosition getTopPosition() {
        return position.getTop();
    }

    public CellPosition getTopRightPosition() {
        return position.getTopRight();
    }

    public CellPosition getLeftPosition() {
        return position.getLeft();
    }

    public CellPosition getRightPosition() {
        return position.getRight();
    }

    public CellPosition getDownLeftPosition() {
        return position.getDownLeft();
    }

    public CellPosition getDownPosition() {
        return position.getDown();
    }

    public CellPosition getDownRightPosition() {
        return position.getDownRight();
    }

    public List<CellPosition> getNeighbourPositions() {
        return Arrays.asList(
                getTopLeftPosition(),
                getTopPosition(),
                getTopRightPosition(),
                getLeftPosition(),
                getRightPosition(),
                getDownLeftPosition(),
                getDownPosition(),
                getDownRightPosition());
    }
}
