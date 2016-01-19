package katas.gameoflife;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jllado on 1/18/16.
 */
public class CellsLine {

    private int line = 0;
    private List<Cell> cells;

    public CellsLine(int line) {
        cells = new ArrayList<>();
        this.line = line;
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

    @Override
    public String toString() {
        return cells.stream().map(cell -> cell.toString()).collect(Collectors.joining(" "));
    }

    public int getLine() {
        return line;
    }
}
