package katas.gameoflife;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jllado on 1/20/16.
 */
public class RulesFactory {
    public static List<Rule> createRules() {
        return Arrays.asList(new HasFewerThanTwoLiveNeighbours());
    }
}
