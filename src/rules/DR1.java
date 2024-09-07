package rules;

import elements.Cell;
import elements.*;

public class DR1 extends DeductionRule{
    //idee de base mettre la valeur si elle nest pas dans la ligne ni col ni carre

    @Override
    public void applyRule(Cell cell, Grid g) {
        Row row = cell.getRow(g.getCells());
        System.out.println("val de empty: "+row.emptyCells().toArray().length);
        if(row.emptyCells().toArray().length == 1 ){
            System.out.println("val def en X="+ row.emptyCells().get(0).getPosx()+" Y="+row.emptyCells().get(0).getPosy()+" et valeur = "+ row.missingValues().get(0) );


        }
    }

}
