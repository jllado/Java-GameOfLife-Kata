package katas.gameoflife;

import katas.gameoflife.Grid;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
- Generate a grid with random cells
- 1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
- 2. Any live cell with more than three live neighbours dies, as if by overcrowding.
- 3. Any live cell with two or three live neighbours lives on to the next generation.
- 4. Any dead cell with exactly three live neighbours becomes a live cell.
 */
/*
- Grid 1x1 with one live cell
- Grid 1x1 with zero live cell
- Grid 1x1 with one live cell
- Grid 1x2 with one live cell
- Grid 1x2 with two live cell
- Given Grid 1x2 with one live cell, When iterate, Then zero live zells
- Given Grid 1x3 with two separte live cells, When iterate, Then zero live zells
 */
public class GameTest {

    @Test
    public void should_create_1x1_grid_with_one_live_cell() throws Exception {
        Grid grid = Grid.create();

        assertThat(grid.height(), is(1));
        assertThat(grid.width(), is(1));
        assertThat(grid.liveCellsCount(), is(1));
    }
}
