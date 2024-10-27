package rules;

import elements.*;

public class DR2 extends DeductionRule{
    //mettre la val si elle nest ni presente dans ligne col ou carre


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


}
