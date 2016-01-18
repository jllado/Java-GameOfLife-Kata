package katas.gameoflife;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jllado on 1/18/16.
 */
public class CellsLine {

    private List<CellPosition> cellPositions;

    public CellsLine() {
        cellPositions = new ArrayList<>();
    }

    public int size() {
        return cellPositions.size();
    }

    public List<CellPosition> getCellPositions() {
        return cellPositions;
    }

    public void add(CellPosition position) {
        cellPositions.add(position);
    }
}
