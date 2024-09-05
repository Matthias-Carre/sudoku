public class Square extends Elements{
    public Square(int[] l) {
        super(l);
    }

    public void PrintSquare(){
        for (int i = 0; i < 9; i++){
            if(i%3==0){
                System.out.println();
            }
            System.out.print(this.list[i]+" ");
        }
    }
}
