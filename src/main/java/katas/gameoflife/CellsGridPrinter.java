package katas.gameoflife;

/**
 * Created by jllado on 1/12/16.
 */
public class CellsGridPrinter {

    private ConsolePrinter consolePrinter;

    public CellsGridPrinter(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public void print(CellsGrid grid, int generation) {
        consolePrinter.print(String.format("Generation %d:", generation));
        for (CellsLine cellsLine : grid.getCellsLines()) {
            consolePrinter.print(cellsLine.toString());
        }
        waitBetweenPrints();
    }

    private void waitBetweenPrints() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
