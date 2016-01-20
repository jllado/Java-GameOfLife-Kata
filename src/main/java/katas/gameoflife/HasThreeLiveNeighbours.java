package katas.gameoflife;

/**
 * Created by jllado on 1/20/16.
 */
public class HasThreeLiveNeighbours implements Rule {
    @Override
    public void apply(CellsGrid grid, Cell cell) {
        grid.reviveCell(cell.getPosition());
    }

    @Override
    public boolean check(CellsGrid grid, Cell cell) {
        return grid.liveNeighbourCellsCount(cell) == 3;
    }
}
