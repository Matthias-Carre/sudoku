import Parser.parser;
import elements.Grid;
import rules.DR2;
import rules.DeductionRule;

import java.util.List;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        List<Integer> valuesList = parser.parse("grilles\\grille2.txt");

        int[] values = valuesList.stream().mapToInt(Integer::intValue).toArray();

        Grid grid = new Grid(values);

        if (grid != null) {
            grid.printDisplay();

            DR2 d2 = new DR2();
            provisoire(values, d2);
        }
    }

    public static void provisoire(int[] liste, DeductionRule rule) {
        Grid g = new Grid(liste);
        for (int i = 0; i < liste.length; i++) {
            if(liste[i]>0){
                g.getCells()[i].setValue(liste[i]);
            }

            rule.applyRule(g.getCells()[i], g);
        }

        g.printDisplay();
    }
}
