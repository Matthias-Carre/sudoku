import elements.Column;
import elements.Row;
import elements.Square;

public class Grid {
    int[] grid;
    Row[] rows;
    Column[] columns;
    Square[] squares;

    public Grid(int[] liste) {
        this.grid = liste;
        this.rows = new Row[9];
        this.columns = new Column[9];
        this.squares = new Square[9];

        for (int i = 0; i < 9; i++) {
            int[] row = new int[9];
            for (int j = 0; j < 9; j++) {
                row[j] = liste[i * 9 + j];
            }
            Row r = new Row(row);
            rows[i] = r;
        }
        for (int i = 0; i < 9; i++) {
            int[] column = new int[9];
            for (int j = 0; j < 9; j++) {
                column[j] = liste[j * 9 + i];
            }
            Column c = new Column(column);
            columns[i] = c;

        }
        int c = 0;
        for (int i = 0; i < 9; i++) {
            if(i==3||i==6){c+=18;}
            int[] square = new int[9];
            for (int j = 0; j < 9; j++) {
                if(j<3){
                    square[j] = liste[j+i*3+c];
                } else if (j<6) {
                    square[j] = liste[j+6+i*3+c];
                }else {
                    square[j] = liste[j+12+i*3+c];
                }
            }
            Square s = new Square(square);
            squares[i] = s;
        }
    }
    public Row[] getRows(){
        return this.rows;
    }
    public Column[] getColumns(){
        return this.columns;
    }
    public Square[] getSquares(){
        return this.squares;
    }

    public int[] getList() {
        return this.grid;
    }

    public void printDisplay(){
        int[] liste = this.grid;
        System.out.println("┏━━━┯━━━┯━━━┳━━━┯━━━┯━━━┳━━━┯━━━┯━━━┓");

        for(int i=0;i<9;i++){

            if(i==3 || i==6){
                System.out.println("┣━━━┿━━━┿━━━╋━━━┿━━━┿━━━╋━━━┿━━━┿━━━┫");
            }
            System.out.print("┃");

            for(int j=0;j<9;j++) {
                if(j==3 || j==6){
                    System.out.print("┃");
                }else if(j>0){
                    System.out.print("│");
                }

                if (liste[i * 9 + j] == -1) {
                    System.out.print("   ");
                } else {
                    System.out.print(" "+liste[i * 9 + j]+" ");
                }
            }
            System.out.println("┃");
        }
        System.out.println("┗━━━┷━━━┷━━━┻━━━┷━━━┷━━━┻━━━┷━━━┷━━━┛");
    }
}
