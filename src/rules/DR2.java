package rules;

import elements.*;

public class DR2 extends DeductionRule{
    //mettre la val si elle nest ni presente dans ligne col ou carre ???? pas sur que ce soit bon


    @Override
    public void applyRule(Cell cell, Grid g) {
        if(cell.getValue()!=-1){

            Row row = cell.getRow(g.getCells());
            update(row,cell.getValue(),g);

            Column col =cell.getCol(g.getCells());
            update(col,cell.getValue(),g);

            Square square = cell.getSquare(g.getCells());
            update(square,cell.getValue(),g);

        }


    }
    public void update(Elements e,int val,Grid g){

        for(int i=0;i<9; i++){
            Cell cellinline = e.getCells()[i];

            if(cellinline.getPossibilitys().size()==1 && cellinline.getValue()==-1){
                cellinline.setAddbyrule(true);
                cellinline.setValue(cellinline.getPossibilitys().get(0));
                cellinline.removeValue(val);
                applyRule(cellinline,g);


            }
            cellinline.removeValue(val);

        }
    }


}
