package katas.gameoflife;

import java.util.stream.Collectors;

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
            consolePrinter.print(mapToString(cellsLine, grid));
        }
        waitBetweenPrints();
    }

    private String mapToString(CellsLine cellsLine, CellsGrid grid) {
        return cellsLine.getCellPositions().stream()
                .map(cellPosition -> printCell(grid.isLiveCell(cellPosition)))
                .collect(Collectors.joining(" "));
    }

    private void waitBetweenPrints() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String printCell(boolean liveCell) {
        return liveCell ? "*" : "_";
    }

}
