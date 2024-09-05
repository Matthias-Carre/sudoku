public class Row extends Elements{


    public Row(int[] l) {
        super(l);
    }

    public void PrintRow(){
        for(int i=0;i<9;i++){
            System.out.print(this.list[i]+" ");
        }
        System.out.println("");
    }
}
