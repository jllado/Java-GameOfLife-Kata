package katas.gameoflife;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jllado on 1/20/16.
 */
public class RulesFactory {
    public static List<Rule> createRules() {
        List<Rule> rules = new ArrayList<>();
        rules.add(new HasFewerThanTwoLiveNeighbours());
        rules.add(new HasMoreThanThreeLiveNeighbours());
        rules.add(new HasThreeLiveNeighbours());
        return rules;
    }

}
