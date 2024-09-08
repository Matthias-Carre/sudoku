package elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Elements {
    Cell[] cells;


    public Elements(Cell[] l) {
        this.cells = l;
    }

    public List<Cell> emptyCells(){
        List<Cell> l = new ArrayList<Cell>();

        for (int i = 0; i < this.cells.length; i++) {
            if(this.cells[i].getValue() == -1){
                l.add(this.cells[i]);
            }
        }
        return l;
    }

    public List<Integer> missingValues(){
        List<Integer> l = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<Integer> lb = new ArrayList<>();
        for (int i = 0; i < this.cells.length; i++) {
            if(this.cells[i].getValue() != -1){
                lb.add(this.cells[i].getValue());
            }
        }
        l.removeAll(lb);
        return l;
    }

    public Cell[] getCells(){
        return this.cells;
    }


}
