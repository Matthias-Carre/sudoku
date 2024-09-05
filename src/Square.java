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
    public boolean hasNum(int num){
        for (int i = 0; i < 9; i++){
            if(list[i] == num){
                return true;
            }
        }
        return false;
    }
}
