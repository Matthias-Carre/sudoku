import Parser.parser;
import elements.Cell;
import elements.Grid;
import rules.DR1;
import rules.DR2;
import rules.DR3;
import rules.DeductionRule;

import java.io.FileNotFoundException;
import java.util.List;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //List<Integer> valuesList = parser.parse("grilles/grille2.txt");

        DeductionRule dr=selectionDR();
        int[] list=setectionGrid();

        run(list,dr);


    }

    public static int testWin(Grid g){//renvoie soit la valeur de la 1er valeur a -1 ou alors -1 si tout est full
        for(int i=0;i<81;i++){
            Cell cell = g.getCells()[i];
            if(cell.getValue()==-1){
                return i;
            }
        }
        return -1;
    }
    public static DeductionRule selectionDR(){
        Scanner sc = new Scanner(System.in);
        String s = "";
        while ( !(Objects.equals(s, "1") || Objects.equals(s, "2") || Objects.equals(s, "3")) ) {
            System.out.print("Quel regle appliquer? (entre 1 et 3) : ");
            s = sc.nextLine();
        }
        int val = Integer.parseInt(s);
        DeductionRule dr;
        if(val==1){
            dr = new DR1();
        } else if (val==2) {
            dr = new DR2();
        }else{
            dr = new DR3();
        }
        return dr;
    }
    public static int[] setectionGrid(){
        Scanner sc = new Scanner(System.in);
        String path = "";
        boolean goodformat = false;
        int[] list=null;

        while (!goodformat) {
            goodformat = true;
            System.out.print("Chemin vers la grille a resoudre: ");
            path=sc.nextLine();

            try{
                List<Integer> valuesList = parser.parse(path);

                list = valuesList.stream().mapToInt(Integer::intValue).toArray();
            } catch (Exception e) {
                System.out.println("ficher non trouve");
                goodformat = false;
            }
        }
        return list;
    }

    public static void run(int[] liste, DeductionRule rule) {
        Grid g = new Grid(liste);
        for (int i = 0; i < liste.length; i++) {
            if(liste[i]>0){
                g.getCells()[i].setValue(liste[i]);
            }

            rule.applyRule(g.getCells()[i], g);
        }

        g.printDisplay();
        int val = testWin(g);
        Scanner sc = new Scanner(System.in);
        if (!(val==-1)){
            System.out.println("donner une valeur pour la ligne: "+val/9 +1+" et colone: "+(val%9 +1));
            //verifier la valeur demander
            int i = Integer.parseInt(sc.nextLine());
            liste[val]=i;

            run(liste,rule);
        }

    }

}
