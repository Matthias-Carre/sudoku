package elements;

public class Cell {
    int value;
    int line;
    int col;
    int[] possibility = new int[9];

    public Cell(int val,int pos){
        this.value = val;
        this.line =pos%9 ;
        this.col = pos/9;
    }

    public Column getCol(int[] list){
        int[] colist = new int[9];
        for (int j = 0; j < 9; j++) {
            colist[j] = list[j * 9 + this.line];
        }
        Column c = new Column(colist);
        return c;
    }
    public Row getRow(int[] list){
        int[] rowlist = new int[9];
        for(int j=0;j<9;j++){
            rowlist[j]= list[9*this.col+j];
        }
        Row r = new Row(rowlist);
        return r;
    }

    public Square getSquare(int[] list){
        int[] square = new int[9];
        int c=this.col/3;
        int l=this.line/3;
        int n=0;
        for (int j = 0; j < 9; j++) {
            if(j==3 || j==6){n+=6;}
            square[j] = list[(j+l*3+c*27)+n];
        }
        Square s = new Square(square);
        return s;
    }

}
