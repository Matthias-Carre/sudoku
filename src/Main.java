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
    // Singleton
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

    public static int testWin(Grid g) { // renvoie soit la valeur de la 1re valeur à -1 ou alors -1 si tout est full
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
        int val = -1;
        while (val < 1 || val > 3) {
            System.out.print("Quelle règle appliquer? (entre 1 et 3) : ");

            // Vérifie que l'entrée est un entier
            while (!sc.hasNextInt()) {
                System.out.println("Entrée invalide. Veuillez entrer un entier entre 1 et 3.");
                sc.next(); // Ignore l'entrée pas valide
            }

            val = sc.nextInt();
        }

        // Crée l'objet DeductionRule en fonction de la valeur saisie
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
                // Utilisation du design pattern GridAdapter
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
            System.out.println("Donner une valeur pour la ligne: " + (val / 9 + 1) + " et colonne: " + (val % 9 + 1));

            int i = -1;
            while (i < 1 || i > 9) { // Validation de l'entrée
                System.out.print("Entrez un entier entre 1 et 9 : ");
                while (!sc.hasNextInt()) { // Vérifier que l'entrée est un entier
                    System.out.println("Entrée invalide. Veuillez entrer un entier.");
                    sc.next(); // Ignorer l'entrée non valide
                }
                i = sc.nextInt();
            }

            g.getCells()[val].setValue(i);

            // On save l'état après avoir mis à jour la cellule avec la nouvelle valeur
            caretaker.saveState(new Memento(g.getCells()));

            // Appliquer la règle de déduction après la mise à jour
            rule.applyRule(g.getCells()[val], g);
            g.printDisplay();

            // On propose l'annulation après affichage de l'état mis à jour
            System.out.print("Voulez-vous annuler la dernière action ? (o/n) : ");
            String undoChoice = sc.next();
            if (undoChoice.equalsIgnoreCase("o")) {
                Memento previousState = caretaker.restoreState();
                if (previousState != null) {
                    g.setCells(previousState.getState());
                    System.out.println("Action annulée.");
                    g.printDisplay();
                }
            }

            run(liste, rule);
        }
    }
}
