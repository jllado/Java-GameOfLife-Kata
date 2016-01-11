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
        cellsGrid.setStatus(false, 1);

        assertThat(cellsGrid.isRightAlive(0), is(false));
    }

    @Test
    public void should_right_position_be_alive_given_1x3_grid() throws Exception {
        CellsGrid cellsGrid = new CellsGrid(3);
        cellsGrid.setStatus(true, 2);

        assertThat(cellsGrid.isRightAlive(1), is(true));
    }


    @Test
    public void should_left_position_be_alive_given_1x2_grid() throws Exception {
        CellsGrid cellsGrid = new CellsGrid(2);
        cellsGrid.setStatus(true, 0);

        assertThat(cellsGrid.isLeftAlive(1), is(true));
    }

    @Test
    public void should_left_position_be_dead_given_1x2_grid() throws Exception {
        CellsGrid cellsGrid = new CellsGrid(2);
        cellsGrid.setStatus(false, 0);

        assertThat(cellsGrid.isLeftAlive(1), is(false));
    }

    @Test
    public void should_left_position_be_alive_given_1x3_grid() throws Exception {
        CellsGrid cellsGrid = new CellsGrid(2);
        cellsGrid.setStatus(true, 1);

        assertThat(cellsGrid.isLeftAlive(2), is(true));
    }
}
