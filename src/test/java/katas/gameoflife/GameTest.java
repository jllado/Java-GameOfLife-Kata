package katas.gameoflife;

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
- Given Grid 1x3 with three live cells, When iterate, Then one live cell
 */
public class GameTest {

    @Test
    public void should_create_1x1_grid_with_one_live_cell() throws Exception {
        Game game = Game.create(1);
        game.setCellStatus(true, 0);

        assertThat(game.gridWidth(), is(1));
        assertThat(game.gridHeight(), is(1));
        assertThat(game.liveCellsCount(), is(1));
    }

    @Test
    public void should_create_1x1_grid_with_zero_live_cells() throws Exception {
        Game game = Game.create(1);

        assertThat(game.gridWidth(), is(1));
        assertThat(game.gridHeight(), is(1));
        assertThat(game.liveCellsCount(), is(0));
    }

    @Test
    public void should_create_1x2_grid_with_one_live_cell() throws Exception {
        Game game = Game.create(2);
        game.setCellStatus(true, 0);

        assertThat(game.gridWidth(), is(1));
        assertThat(game.gridHeight(), is(2));
        assertThat(game.liveCellsCount(), is(1));
    }

    @Test
    public void should_create_1x2_grid_with_two_live_cells() throws Exception {
        Game game = Game.create(2);
        game.setCellStatus(true, 0);
        game.setCellStatus(true, 1);

        assertThat(game.gridWidth(), is(1));
        assertThat(game.gridHeight(), is(2));
        assertThat(game.liveCellsCount(), is(2));
    }

    @Test
    public void should_be_zero_cells_given_1x2_grid_with_one_live_cells_when_iterate() throws Exception {
        Game game = Game.create(2);
        game.setCellStatus(true, 0);

        game.iterate();

        assertThat(game.liveCellsCount(), is(0));
    }

    @Test
    public void should_be_zero_cells_given_1x2_grid_with_two_live_cells_when_iterate() throws Exception {
        Game game = Game.create(2);
        game.setCellStatus(true, 0);
        game.setCellStatus(true, 1);

        game.iterate();

        assertThat(game.liveCellsCount(), is(0));
    }

//    @Test
//    public void should_be_one_cell_given_1x3_grid_with_three_live_cells_when_iterate() throws Exception {
//        Game game = Game.create(3);
//        game.setCellStatus(true, 0);
//        game.setCellStatus(true, 1);
//        game.setCellStatus(true, 2);
//
//        game.iterate();
//
//        assertThat(game.liveCellsCount(), is(1));
//    }
}
