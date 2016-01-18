package katas.gameoflife;

import junit.framework.TestCase;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

/**
 * Created by jllado on 1/18/16.
 */
public class CellsGridTest extends TestCase {

    public void testGetCellsLines() throws Exception {
        CellsGrid cellsGrid = new CellsGrid(3, 3);
        cellsGrid.setStatus(true, new CellPosition(0, 0));
        cellsGrid.setStatus(true, new CellPosition(2, 0));

        List<CellsLine> cellsLines = cellsGrid.getCellsLines();

        assertThat(cellsLines, hasSize(3));
        assertThat(cellsLines.get(0).size(), is(3));
        assertThat(cellsLines.get(0).getCells().get(0), is(new Cell(true)));
        assertThat(cellsLines.get(0).getCells().get(1), is(new Cell(false)));
        assertThat(cellsLines.get(0).getCells().get(2), is(new Cell(true)));
        assertThat(cellsLines.get(1).size(), is(3));
        assertThat(cellsLines.get(2).size(), is(3));
    }
}
