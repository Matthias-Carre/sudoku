package elements;

public class Cell {
    int value;
    int pos;
    int posx;
    int posy;
    int[] possibility = new int[9];

    public Cell(int val,int pos){
        this.value = val;
        this.pos = pos;
        this.posx = pos%9 ;
        this.posy = pos/9;
    }
    public int getPos(){
        return this.pos;
    }
    public int getValue(){
        return this.value;
    }

    public int getPosx() {
        return this.posx;
    }

    public int getPosy() {
        return this.posy;
    }

    public Column getCol(Cell[] cells){
        Cell[] colist = new Cell[9];
        for (int j = 0; j < 9; j++) {
            colist[j] = cells[j * 9 + this.posx];
        }
        return new Column(colist);
    }
    public Row getRow(Cell[] cells){
        Cell[] rowlist = new Cell[9];
        for(int j=0;j<9;j++){
            rowlist[j]= cells[9*this.posy +j];
        }
        return new Row(rowlist);
    }




    public Square getSquare(Cell[] cells){
        Cell[] square = new Cell[9];
        int c=this.posy /3;
        int l=this.posx/3;
        int n=0;
        for (int j = 0; j < 9; j++) {
            if(j==3 || j==6){n+=6;}
            square[j] = cells[(j+l*3+c*27)+n];
        }
        return new Square(square);
    }

}
