package rules;

import elements.*;

import java.util.ArrayList;
import java.util.List;

public class DR3 extends DeductionRule {
    // si la valeur est la seul possible dans cette case alors on la fout
    //puis on cherche les pair de possi dans la meme ligne ou col
    @Override
    public void applyRule(Cell cell, Grid g) {
        if(true){//cell.getValue()!=-1){


            Square square = cell.getSquare(g.getCells());
            Row row = cell.getRow(g.getCells());
            Column col =cell.getCol(g.getCells());

            update(row,cell.getValue(),g);
            update(col,cell.getValue(),g);
            update(square,cell.getValue(),g);

        }
        NakedPairs(cell.getRow(g.getCells()));
        NakedPairs(cell.getCol(g.getCells()));
        NakedPairs(cell.getRow(g.getCells()));

    }
    public void update(Elements e,int val,Grid g){
        for(int i=0;i<9; i++){
            Cell cellinline = e.getCells()[i];

            if(cellinline.getPossibilitys().size()==1 && cellinline.getValue()==-1){
                cellinline.setAddbyrule(true);
                cellinline.setValue(cellinline.getPossibilitys().get(0));
                applyRule(cellinline,g);

            }
            cellinline.removeValue(val);
        }
    }

    public void NakedPairs(Elements e) {
        List<Cell> emptyCells = new ArrayList<>();

        // On récup les cellules qui ont 2 possibilités
        for (Cell cell : e.getCells()) {
            if (cell.getValue() == -1 && cell.getPossibilitys().size() == 2) {
                emptyCells.add(cell);
            }
        }

        //On compare les cellules vides pour trouver des paires
        for (int i = 0; i < emptyCells.size(); i++) {
            for (int j = i + 1; j < emptyCells.size(); j++) {
                Cell cell1 = emptyCells.get(i);
                Cell cell2 = emptyCells.get(j);

                if (cell1.getPossibilitys().equals(cell2.getPossibilitys())) {
                    // On a trouvé une naked pair donc on enlève les possibilités des autres cellules
                    List<Integer> pairPossibilities = cell1.getPossibilitys();
                    for (Cell cell : e.getCells()) {
                        if (cell != cell1 && cell != cell2 && cell.getValue() == -1) {
                            // On retire tous les candidats de la nouvelle paire bien neuve
                            for (Integer candidate : pairPossibilities) {
                                cell.removeValue(candidate);
                            }
                        }
                    }
                }
            }
        }
    }
}
