package katas.gameoflife;

import java.util.ArrayList;
import java.util.List;
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
        List<String> line = new ArrayList<>();
        CellPosition firstLinePosition = grid.getFirstPosition();
        consolePrinter.print(String.format("Generation %d:", generation));
        for (CellPosition position : grid.getAllPosition()) {
            if (position.isSameLine(firstLinePosition)) {
                line.add(printCell(grid.isLiveCell(position)));
            } else {
                consolePrinter.print(line.stream().collect(Collectors.joining(" ")));
                line.clear();
                line.add(printCell(grid.isLiveCell(position)));
                firstLinePosition = position;
            }
        }
        consolePrinter.print(line.stream().collect(Collectors.joining(" ")));
        waitBetweenPrints();
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
