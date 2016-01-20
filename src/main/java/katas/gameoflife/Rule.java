package katas.gameoflife;

/**
 * Created by jllado on 1/20/16.
 */
public interface Rule {
    void apply(CellsGrid grid, Cell cell);
    boolean check(CellsGrid grid, Cell cell);
}
