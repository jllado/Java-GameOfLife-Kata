package katas.gameoflife;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
- Generate a grid with random cells
- 1. Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
- 2. Any live cell with more than three live neighbours dies, as if by overcrowding.
- 3. Any live cell with two or three live neighbours lives on to the next generation.
- 4. Any dead cell with exactly three live neighbours becomes a live cell.
 */
@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    private CellsGridPrinter printer;

    @Test
    public void should_create_1x1_grid_with_one_live_cell() throws Exception {
        CellsGrid grid = new CellsGrid(1, 1);
        grid.setStatus(true, new CellPosition(0, 0));
        Game game = createGame(grid, printer);

        assertThat(game.gridWidth(), is(1));
        assertThat(game.gridHeight(), is(1));
        assertThat(game.liveCellsCount(), is(1));
    }

    @Test
    public void should_create_1x1_grid_with_zero_live_cells() throws Exception {
        CellsGrid grid = new CellsGrid(1, 1);
        Game game = createGame(grid, printer);

        assertThat(game.gridWidth(), is(1));
        assertThat(game.gridHeight(), is(1));
        assertThat(game.liveCellsCount(), is(0));
    }

    @Test
    public void should_create_1x2_grid_with_one_live_cell() throws Exception {
        CellsGrid grid = new CellsGrid(1, 2);
        grid.setStatus(true, new CellPosition(0, 0));
        Game game = createGame(grid, printer);

        assertThat(game.gridWidth(), is(1));
        assertThat(game.gridHeight(), is(2));
        assertThat(game.liveCellsCount(), is(1));
    }

    @Test
    public void should_create_1x2_grid_with_two_live_cells() throws Exception {
        CellsGrid grid = new CellsGrid(1, 2);
        grid.setStatus(true, new CellPosition(0, 0));
        grid.setStatus(true, new CellPosition(0, 1));
        Game game = createGame(grid, printer);

        assertThat(game.gridWidth(), is(1));
        assertThat(game.gridHeight(), is(2));
        assertThat(game.liveCellsCount(), is(2));
    }

    @Test
    public void should_be_zero_cells_given_1x2_grid_with_one_live_cells_when_iterate() throws Exception {
        CellsGrid grid = new CellsGrid(1, 2);
        grid.setStatus(true, new CellPosition(0, 0));
        Game game = createGame(grid, printer);

        game.nextGeneration();

        assertThat(game.liveCellsCount(), is(0));
    }

    @Test
    public void should_be_zero_cells_given_1x2_grid_with_two_live_cells_when_iterate() throws Exception {
        CellsGrid grid = new CellsGrid(1, 2);
        grid.setStatus(true, new CellPosition(0, 0));
        grid.setStatus(true, new CellPosition(0, 1));
        Game game = createGame(grid, printer);

        game.nextGeneration();

        assertThat(game.liveCellsCount(), is(0));
    }

    @Test
    public void should_be_one_cell_given_1x3_grid_with_three_live_cells_when_iterate() throws Exception {
        CellsGrid grid = new CellsGrid(1, 3);
        grid.setStatus(true, new CellPosition(0, 0));
        grid.setStatus(true, new CellPosition(0, 1));
        grid.setStatus(true, new CellPosition(0, 2));
        Game game = createGame(grid, printer);

        game.nextGeneration();

        assertThat(game.liveCellsCount(), is(1));
    }


    @Test
    public void should_create_2x1_grid_with_one_live_cell() throws Exception {
        CellsGrid grid = new CellsGrid(2, 1);
        grid.setStatus(true, new CellPosition(0, 0));
        Game game = createGame(grid, printer);

        assertThat(game.gridWidth(), is(2));
        assertThat(game.gridHeight(), is(1));
        assertThat(game.liveCellsCount(), is(1));
    }

    @Test
    public void should_create_3x1_grid_with_two_live_cell() throws Exception {
        CellsGrid grid = new CellsGrid(3, 1);
        grid.setStatus(true, new CellPosition(1, 0));
        grid.setStatus(true, new CellPosition(2, 0));
        Game game = createGame(grid, printer);

        assertThat(game.gridWidth(), is(3));
        assertThat(game.gridHeight(), is(1));
        assertThat(game.liveCellsCount(), is(2));
    }

    @Test
    public void should_be_zero_cells_given_2x1_grid_with_one_live_cells_when_iterate() throws Exception {
        CellsGrid grid = new CellsGrid(2, 1);
        grid.setStatus(true, new CellPosition(1, 0));
        Game game = createGame(grid, printer);

        game.nextGeneration();

        assertThat(game.liveCellsCount(), is(0));
    }

    @Test
    public void should_be_one_cell_given_3x1_grid_with_three_live_cells_when_iterate() throws Exception {
        CellsGrid grid = new CellsGrid(3, 1);
        grid.setStatus(true, new CellPosition(0, 0));
        grid.setStatus(true, new CellPosition(1, 0));
        grid.setStatus(true, new CellPosition(2, 0));
        Game game = createGame(grid, printer);

        game.nextGeneration();

        assertThat(game.liveCellsCount(), is(1));
    }

    @Test
    public void should_be_two_cell_given_3x3_grid_with_one_live_cell_at_the_middle_and_two_live_cells_at_the_top_corners_when_iterate() throws Exception {
        CellsGrid grid = new CellsGrid(3, 3);
        grid.setStatus(true, new CellPosition(1, 1));
        grid.setStatus(true, new CellPosition(0, 0));
        grid.setStatus(true, new CellPosition(2, 0));
        Game game = createGame(grid, printer);

        game.nextGeneration();

        assertThat(game.liveCellsCount(), is(2));
    }

    @Test
    public void should_be_two_cell_given_3x3_grid_with_one_live_cell_at_the_middle_and_two_live_cells_at_the_bottom_corners_when_iterate() throws Exception {
        CellsGrid grid = new CellsGrid(3, 3);
        grid.setStatus(true, new CellPosition(1, 1));
        grid.setStatus(true, new CellPosition(0, 2));
        grid.setStatus(true, new CellPosition(2, 2));
        Game game = createGame(grid, printer);

        game.nextGeneration();

        assertThat(game.liveCellsCount(), is(2));
    }

    @Test
    public void should_be_four_cells_given_3x2_grid_with_six_live_cells_when_iterate() throws Exception {
        CellsGrid grid = new CellsGrid(3, 2);
        grid.setStatus(true, new CellPosition(0, 0));
        grid.setStatus(true, new CellPosition(1, 0));
        grid.setStatus(true, new CellPosition(2, 0));
        grid.setStatus(true, new CellPosition(0, 1));
        grid.setStatus(true, new CellPosition(1, 1));
        grid.setStatus(true, new CellPosition(2, 1));
        Game game = createGame(grid, printer);

        game.nextGeneration();

        assertThat(game.liveCellsCount(), is(4));
    }

    @Test
    public void play() throws Exception {
        CellsGrid grid = new CellsGrid(3, 2);
        grid.setStatus(true, new CellPosition(0, 0));
        Game game = createGame(grid, printer);

        game.play();

        verify(printer, times(2)).print(any(), anyInt());
    }

    public Game createGame(CellsGrid grid, CellsGridPrinter printer) {
        return new Game(grid, printer);
    }

}
