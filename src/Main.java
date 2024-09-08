import Parser.parser;
import elements.Grid;
import rules.DR2;
import rules.DeductionRule;

import java.util.List;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        List<Integer> valuesList = parser.parse("src\\sudoku.txt");

        int[] values = valuesList.stream().mapToInt(Integer::intValue).toArray();

        Grid grid = new Grid(values);

        grid.printDisplay();

        DR2 d2 = new DR2();
        provisoire(values, d2);

    }

    public static void provisoire(int[] liste, DeductionRule rule) {
        Grid g = new Grid(liste);
        for (int i = 0; i < liste.length; i++) {
            g.getCells()[i].setValue(liste[i]);
            rule.applyRule(g.getCells()[i], g);
        }
        System.out.println(g.getCells()[80].getPossibilitys());
        g.getCells()[80].getSquare(g.getCells()).PrintSquare();
        System.out.println();
        g.printDisplay();
    }
}
