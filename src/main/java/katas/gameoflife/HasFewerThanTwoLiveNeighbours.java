package katas.gameoflife;

/**
 * Created by jllado on 1/20/16.
 */
public class HasFewerThanTwoLiveNeighbours implements Rule {

    @Override
    public void apply(CellsGrid grid, Cell cell) {
        grid.killCell(cell.getPosition());
    }

    @Override
    public boolean check(CellsGrid grid, Cell cell) {
        return grid.liveNeighbourCellsCount(cell) < 2;
    }
}
