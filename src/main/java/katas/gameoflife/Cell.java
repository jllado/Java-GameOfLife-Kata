package katas.gameoflife;

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

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
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

    public boolean isSameLine(Cell cell) {
        return position.isSameLine(cell.position);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "alive=" + alive +
                ", position=" + position +
                '}';
    }
}
