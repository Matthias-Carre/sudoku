package rules;

import elements.Cell;
import elements.*;

public class DR1 extends DeductionRule{
    //idee de base mettre la valeur si il reste une seul case vide dans ligne col carre

    @Override
    public void applyRule(Cell cell, Grid g) {

        //si la taille de missingvalue est plus grande que un cest pas normal
        Row row = cell.getRow(g.getCells());
        this.tryToAdd(row);
        Column col = cell.getCol(g.getCells());
        this.tryToAdd(col);
        Square squ = cell.getSquare(g.getCells());
        this.tryToAdd(squ);
    }
    public void tryToAdd(Elements e){
        if(e.emptyCells().toArray().length == 1 ){
            System.out.println("trouver info");
            e.emptyCells().get(0).setAddbyrule(true);
            e.emptyCells().get(0).setValue(e.missingValues().get(0));
        }
    }

}
