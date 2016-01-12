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
public class GameTest {

    @Test
    public void should_create_1x1_grid_with_one_live_cell() throws Exception {
        Game game = Game.create(1, 1);
        game.setCellStatus(true, 0, 0);

        assertThat(game.gridWidth(), is(1));
        assertThat(game.gridHeight(), is(1));
        assertThat(game.liveCellsCount(), is(1));
    }

    @Test
    public void should_create_1x1_grid_with_zero_live_cells() throws Exception {
        Game game = Game.create(1, 1);

        assertThat(game.gridWidth(), is(1));
        assertThat(game.gridHeight(), is(1));
        assertThat(game.liveCellsCount(), is(0));
    }

    @Test
    public void should_create_1x2_grid_with_one_live_cell() throws Exception {
        Game game = Game.create(1, 2);
        game.setCellStatus(true, 0, 0);

        assertThat(game.gridWidth(), is(1));
        assertThat(game.gridHeight(), is(2));
        assertThat(game.liveCellsCount(), is(1));
    }

    @Test
    public void should_create_1x2_grid_with_two_live_cells() throws Exception {
        Game game = Game.create(1, 2);
        game.setCellStatus(true, 0, 0);
        game.setCellStatus(true, 0, 1);

        assertThat(game.gridWidth(), is(1));
        assertThat(game.gridHeight(), is(2));
        assertThat(game.liveCellsCount(), is(2));
    }

    @Test
    public void should_be_zero_cells_given_1x2_grid_with_one_live_cells_when_iterate() throws Exception {
        Game game = Game.create(1, 2);
        game.setCellStatus(true, 0, 0);

        game.iterate();

        assertThat(game.liveCellsCount(), is(0));
    }

    @Test
    public void should_be_zero_cells_given_1x2_grid_with_two_live_cells_when_iterate() throws Exception {
        Game game = Game.create(1, 2);
        game.setCellStatus(true, 0, 0);
        game.setCellStatus(true, 0, 1);

        game.iterate();

        assertThat(game.liveCellsCount(), is(0));
    }

    @Test
    public void should_be_one_cell_given_1x3_grid_with_three_live_cells_when_iterate() throws Exception {
        Game game = Game.create(1, 3);
        game.setCellStatus(true, 0, 0);
        game.setCellStatus(true, 0, 1);
        game.setCellStatus(true, 0, 2);

        game.iterate();

        assertThat(game.liveCellsCount(), is(1));
    }


    @Test
    public void should_create_2x1_grid_with_one_live_cell() throws Exception {
        Game game = Game.create(2, 1);
        game.setCellStatus(true, 0, 0);

        assertThat(game.gridWidth(), is(2));
        assertThat(game.gridHeight(), is(1));
        assertThat(game.liveCellsCount(), is(1));
    }

    @Test
    public void should_create_3x1_grid_with_two_live_cell() throws Exception {
        Game game = Game.create(3, 1);
        game.setCellStatus(true, 1, 0);
        game.setCellStatus(true, 2, 0);

        assertThat(game.gridWidth(), is(3));
        assertThat(game.gridHeight(), is(1));
        assertThat(game.liveCellsCount(), is(2));
    }

    @Test
    public void should_be_zero_cells_given_2x1_grid_with_one_live_cells_when_iterate() throws Exception {
        Game game = Game.create(2, 1);
        game.setCellStatus(true, 1, 0);

        game.iterate();

        assertThat(game.liveCellsCount(), is(0));
    }

    @Test
    public void should_be_one_cell_given_3x1_grid_with_three_live_cells_when_iterate() throws Exception {
        Game game = Game.create(3, 1);
        game.setCellStatus(true, 0, 0);
        game.setCellStatus(true, 1, 0);
        game.setCellStatus(true, 2, 0);

        game.iterate();

        assertThat(game.liveCellsCount(), is(1));
    }

    @Test
    public void should_be_one_cell_given_3x3_grid_with_one_live_cell_at_the_middle_and_two_live_cells_at_the_top_corners_when_iterate() throws Exception {
        Game game = Game.create(3, 3);
        game.setCellStatus(true, 1, 1);
        game.setCellStatus(true, 0, 0);
        game.setCellStatus(true, 2, 0);

        game.iterate();

        assertThat(game.liveCellsCount(), is(1));
    }

    @Test
    public void should_be_one_cell_given_3x3_grid_with_one_live_cell_at_the_middle_and_two_live_cells_at_the_bottom_corners_when_iterate() throws Exception {
        Game game = Game.create(3, 3);
        game.setCellStatus(true, 1, 1);
        game.setCellStatus(true, 0, 2);
        game.setCellStatus(true, 2, 2);

        game.iterate();

        assertThat(game.liveCellsCount(), is(1));
    }

    @Test
    public void should_be_four_cells_given_3x2_grid_with_six_live_cells_when_iterate() throws Exception {
        Game game = Game.create(3, 2);
        game.setCellStatus(true, 0, 0);
        game.setCellStatus(true, 1, 0);
        game.setCellStatus(true, 2, 0);
        game.setCellStatus(true, 0, 1);
        game.setCellStatus(true, 1, 1);
        game.setCellStatus(true, 2, 1);

        game.iterate();

        assertThat(game.liveCellsCount(), is(4));
    }


}
