import elements.Cell;
import elements.Square;

public class Main {
    public static void main(String[] args) {


        int[] liste = {3,4,2,-1,8,-1,-1,-1,-1,5,-1,-1,9,-1,-1,-1,2,-1,-1,9,-1,-1,-1,4,3,8,-1,-1,2,-1,3,-1,5,1,-1,-1,-1,5,-1,7,-1,6,-1,4,-1,-1,7,-1,-1,9,1,6,5,2,6,-1,-1,-1,7,9,2,3,1,7,-1,-1,-1,6,-1,8,-1,-1,2,-1,-1,5,3,-1,4,-1,-1};
        int[] liste2 = {-1,2,-1,-1,-1,9,5,-1,-1,9,-1,-1,7,-1,-1,3,2,-1,6,-1,-1,4,5,-1,1,-1,-1,8,-1,1,5,-1,-1,-1,6,2,3,4,-1,6,-1,-1,-1,1,-1,2,5,6,1,-1,-1,4,3,-1,1,-1,-1,-1,-1,4,-1,-1,8,-1,-1,4,8,3,5,2,-1,-1,5,-1,8,-1,-1,-1,7,4,-1};
        int[] liste3 = {6,9,-1,-1,-1,-1,-1,8,7,-1,-1,-1,-1,-1,4,-1,9,-1,5,-1,3,-1,7,-1,-1,-1,1,2,8,5,9,6,-1,1,7,-1,9,1,-1,7,4,5,3,2,-1,-1,-1,-1,-1,-1,8,6,5,-1,8,-1,9,4,-1,1,-1,-1,-1,-1,3,-1,-1,-1,-1,-1,-1,5,-1,-1,-1,3,9,-1,-1,1,-1};
        int[] liste4 = {1,-1,-1,3,8,2,4,9,-1,3,-1,-1,-1,-1,-1,-1,1,-1,2,8,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,7,-1,-1,9,6,-1,-1,6,3,2,-1,-1,1,-1,-1,-1,-1,-1,-1,5,-1,3,-1,-1,-1,7,2,-1,-1,4,-1,-1,-1,8,3,-1,-1,-1,-1,-1,-1,-1,5,-1,9,1,6,-1,8,2,-1};
        Grid g = new Grid(liste3);

        g.printDisplay();

        /*
        elements.Row[] rows = g.getRows();
        System.out.println("les lignes:");
        for(int i=0;i<rows.length;i++) {
            rows[i].PrintRow();
        }
        elements.Column[] columns = g.getColumns();
        System.out.println("les colones:");
        for(int i=0;i<columns.length;i++) {
            columns[i].PrintColumn();
        }

        Square[] squares = g.getSquares();
        System.out.println("les squares:");
        for(int i=0;i<9;i++) {
            squares[i].PrintSquare();
            System.out.println();
        }

        System.out.println(squares[0].hasNum(6));
        */
        Cell c = new Cell(2,27);
        Cell c2 = new Cell(2,21);


        c.getSquare(g.getList()).PrintSquare();
        System.out.println();
        c2.getSquare(g.getList()).PrintSquare();





    }
}
