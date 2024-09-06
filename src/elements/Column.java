package elements;

public class Column extends Elements{



    public Column(int[] l) {
        super(l);
    }

    public void PrintColumn(){
        for(int i=0;i<9;i++){
            System.out.println(this.list[i]);
        }
    }
}
