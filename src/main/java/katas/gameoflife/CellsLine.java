package katas.gameoflife;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jllado on 1/18/16.
 */
public class CellsLine {

    private List<Cell> cells;

    public CellsLine() {
        cells = new ArrayList<>();
    }

    public int size() {
        return cells.size();
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void add(Cell cell) {
        cells.add(cell);
    }
}
