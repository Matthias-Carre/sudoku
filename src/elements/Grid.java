package elements;

public class Grid {
    int[] list;
    Cell[] cells;


    public Grid() {
        Cell[] cells = new Cell[81];
        for (int i = 0; i < 81; i++) {
            Cell c = new Cell(-1,i);
            cells[i]=c;
        }
        this.cells = cells;
    }

    public Grid(int[] list){
        Cell[] cells = new Cell[81];
        for (int i = 0; i < 81; i++) {
            Cell c = new Cell(list[i],i);
            cells[i]=c;
        }
        this.cells = cells;
    }

    public Cell[] getCells() {
        return this.cells;
    }
    public int[] getList() {
        return this.list;
    }
    public void printDisplay(){
        Cell[] list = this.cells;
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

                if (list[i * 9 + j].getValue() == -1) {
                    System.out.print("   ");
                } else {
                    //juste pour voir la progression les chiffre ajouter auron un ! derriere
                    if(list[i * 9 + j].isAddbyrule()){
                        System.out.print(" "+list[i * 9 + j].getValue()+"!");
                    }else{
                        System.out.print(" "+list[i * 9 + j].getValue()+" ");
                    }

                }
            }
            System.out.println("┃");
        }
        System.out.println("┗━━━┷━━━┷━━━┻━━━┷━━━┷━━━┻━━━┷━━━┷━━━┛");
    }
}
