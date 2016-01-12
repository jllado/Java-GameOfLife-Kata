package katas.gameoflife;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by jllado on 1/11/16.
 */
public class GridTest {
    @Test
    public void should_down_position_be_alive_given_1x2_grid() throws Exception {
        CellsGrid cellsGrid = new CellsGrid(1, 2);
        cellsGrid.setStatus(true, 0, 1);

        assertThat(cellsGrid.isDownAlive(0, 0), is(true));
    }

    @Test
    public void should_down_position_be_dead_given_1x2_grid() throws Exception {
        CellsGrid cellsGrid = new CellsGrid(1, 2);
        cellsGrid.setStatus(false, 0, 1);

        assertThat(cellsGrid.isDownAlive(0, 0), is(false));
    }

    @Test
    public void should_down_position_be_alive_given_1x3_grid() throws Exception {
        CellsGrid cellsGrid = new CellsGrid(1, 3);
        cellsGrid.setStatus(true, 0, 2);

        assertThat(cellsGrid.isDownAlive(0, 1), is(true));
    }


    @Test
    public void should_top_position_be_alive_given_1x2_grid() throws Exception {
        CellsGrid cellsGrid = new CellsGrid(1, 2);
        cellsGrid.setStatus(true, 0, 0);

        assertThat(cellsGrid.isTopAlive(0, 1), is(true));
    }

    @Test
    public void should_left_position_be_dead_given_1x2_grid() throws Exception {
        CellsGrid cellsGrid = new CellsGrid(1, 2);
        cellsGrid.setStatus(false, 0, 0);

        assertThat(cellsGrid.isTopAlive(0, 1), is(false));
    }

    @Test
    public void should_left_position_be_alive_given_1x3_grid() throws Exception {
        CellsGrid cellsGrid = new CellsGrid(1, 2);
        cellsGrid.setStatus(true, 0, 1);

        assertThat(cellsGrid.isTopAlive(0, 2), is(true));
    }

    @Test
    public void should_left_and_right_position_be_dead_given_1x1_grid() throws Exception {
        CellsGrid cellsGrid = new CellsGrid(1, 1);

        assertThat(cellsGrid.isTopAlive(0, 0), is(false));
        assertThat(cellsGrid.isDownAlive(0, 0), is(false));
    }


}
