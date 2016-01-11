package katas.gameoflife;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by jllado on 1/11/16.
 */
public class GridTest {
    @Test
    public void should_right_position_be_alive_given_1x2_grid() throws Exception {
        CellsGrid cellsGrid = new CellsGrid(2);
        cellsGrid.setStatus(true, 1);

        assertThat(cellsGrid.isRightAlive(0), is(true));
    }

    @Test
    public void should_right_position_be_dead_given_1x2_grid() throws Exception {
        CellsGrid cellsGrid = new CellsGrid(2);
        cellsGrid.setStatus(true, 1);

        assertThat(cellsGrid.isRightAlive(0), is(false));
    }
}
