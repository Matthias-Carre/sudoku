package rules;

import elements.Cell;
import elements.Grid;

public class DR3 extends DeductionRule {
    // si la valeur est la seul possible dans cette case alors on la fout
    @Override
    public void applyRule(Cell c, Grid grid) {

    }
    // on met toute les possiblite dans chaque cell et si elle est seul on la set
}
