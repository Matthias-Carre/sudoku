package elements;

public class Row extends Elements{


    public Row(Cell[] cells) {
        super(cells);
    }

    public void PrintRow(){
        for(int i=0;i<9;i++){
            System.out.print(this.cells[i].getValue()+" ");
        }
        System.out.println("");
    }

}
