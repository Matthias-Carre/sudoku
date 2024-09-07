package elements;

public class Square extends Elements{
    public Square(Cell[] cells) {
        super(cells);
    }

    public void PrintSquare(){
        for (int i = 0; i < 9; i++){
            if(i%3==0){
                System.out.println();
            }
            System.out.print(this.cells[i].getValue()+" ");
        }
    }

}
