package elements;

public class Column extends Elements{



    public Column(Cell[] cells) {
        super(cells);
    }

    public void PrintColumn(){
        for(int i=0;i<9;i++){
            System.out.println(this.cells[i].getValue());
        }
    }
    public void print(){
        for(int i=0;i<9;i++){
            System.out.println(this.cells[i].getValue());
        }
    }
}
