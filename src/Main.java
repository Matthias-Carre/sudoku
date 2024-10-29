import Parser.parser;
import elements.Cell;
import elements.Grid;
import elements.GridAdapter;
import rules.DR1;
import rules.DR2;
import rules.DR3;
import rules.DeductionRule;
import rules.Subject;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    //Singleton
    private static Main instance;

    private Main() {}

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public static void main(String[] args) {
        Main mainInstance = Main.getInstance();
        mainInstance.execute();
    }

    public void execute() {
        Subject subject = new Subject();
        DeductionRule dr = selectionDR(subject);
        int[] list = setectionGrid().getList();

        run(list, dr);
    }

    public static int testWin(Grid g) { // renvoie soit la valeur de la 1er valeur à -1 ou alors -1 si tout est full
        for (int i = 0; i < 81; i++) {
            Cell cell = g.getCells()[i];
            if (cell.getValue() == -1) {
                return i;
            }
        }
        return -1;
    }

    public DeductionRule selectionDR(Subject subject) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (!(Objects.equals(s, "1") || Objects.equals(s, "2") || Objects.equals(s, "3"))) {
            System.out.print("Quel regle appliquer? (entre 1 et 3) : ");
            s = sc.nextLine();
        }
        int val = Integer.parseInt(s);
        DeductionRule dr;
        if (val == 1) {
            dr = new DR1();
        } else if (val == 2) {
            dr = new DR2(subject);
        } else {
            dr = new DR3(subject);
        }
        return dr;
    }

    public Grid setectionGrid() {
        Scanner sc = new Scanner(System.in);
        String path = "";
        boolean goodformat = false;
        Grid grid = null;

        while (!goodformat) {
            goodformat = true;
            System.out.print("Chemin vers la grille à résoudre : ");
            path = sc.nextLine();

            try {
                List<Integer> valuesList = parser.parse(path);
                // Utilisation du design pattern gridAdapter
                assert valuesList != null;
                grid = GridAdapter.convert(valuesList);
            } catch (Exception e) {
                System.out.println("Fichier non trouvé");
                goodformat = false;
            }
        }
        return grid;
    }


    public static void run(int[] liste, DeductionRule rule) {
        Grid g = new Grid(liste);
        Caretaker caretaker = new Caretaker(); // Création du caretaker pour gérer les mementos

        for (int i = 0; i < liste.length; i++) {
            if (liste[i] > 0) {
                g.getCells()[i].setValue(liste[i]);
            }

            // On save l'état de la grille avant l'application de la règle
            caretaker.saveState(new Memento(g.getCells()));
            rule.applyRule(g.getCells()[i], g);
        }

        g.printDisplay();
        int val = testWin(g);
        Scanner sc = new Scanner(System.in);

        if (val != -1) {
            System.out.println("Donner une valeur pour la ligne: " + (val / 9 + 1) + " et colone: " + (val % 9 + 1));
            int i = Integer.parseInt(sc.nextLine());

            //On restaure l'état si l'utilisateur souhaite annuler la dernière action
            System.out.print("Voulez-vous annuler la dernière action ? (o/n) : ");
            String undoChoice = sc.nextLine();
            if (undoChoice.equalsIgnoreCase("o")) {
                Memento previousState = caretaker.restoreState();
                if (previousState != null) {
                    g.setCells(previousState.getState());
                }
            } else {
                liste[val] = i;
            }

            run(liste, rule);
        }
    }
}
