package katas.gameoflife;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by jllado on 1/12/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class CellsGridPrinterTest {

    @Mock
    private ConsolePrinter consolePrinter ;

    @Test
    public void print() throws Exception {
        CellsGridPrinter printer = new CellsGridPrinter(consolePrinter);
        CellsGrid grid = new CellsGrid(3, 3, RulesFactory.createRules());
        grid.reviveCell(new CellPosition(0, 0));
        grid.reviveCell(new CellPosition(1, 1));
        grid.reviveCell(new CellPosition(2, 2));

        printer.print(grid, 0);

        verify(consolePrinter, times(1)).print("Generation 0:");
        verify(consolePrinter, times(1)).print("* _ _");
        verify(consolePrinter, times(1)).print("_ * _");
        verify(consolePrinter, times(1)).print("_ _ *");
    }
}
