package katas.gameoflife;

/**
 * Created by jllado on 1/11/16.
 */
public class Game {

    private CellsGrid grid;
    private CellsGridPrinter printer;

    public Game(CellsGrid grid, CellsGridPrinter printer) {
        this.grid = grid;
        this.printer = printer;
    }

    public int gridWidth() {
        return grid.width();
    }

    public int gridHeight() {
        return grid.height();
    }

    public int liveCellsCount() {
        return grid.liveCellsCount();
    }

    public void nextGeneration() {
        grid = grid.nextGeneration();
    }

    public void play() {
        int generation = 0;
        printer.print(grid, generation);
        while (grid.liveCellsCount() > 0) {
            nextGeneration();
            generation++;
            printer.print(grid, generation);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CellsGrid grid = new CellsGrid(5, 5);
        grid.setStatus(true, new CellPosition(0, 0));
        grid.setStatus(true, new CellPosition(1, 0));
        grid.setStatus(true, new CellPosition(0, 1));
        grid.setStatus(true, new CellPosition(1, 1));
        grid.setStatus(true, new CellPosition(2, 1));
        Game game = new Game(grid, new CellsGridPrinter(new ConsolePrinter()));
        game.play();

    }

}
