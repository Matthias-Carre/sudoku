import java.util.List;

public class Grid {
    int[] grid;

    public Grid(int[] liste) {
        this.grid = liste;
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
