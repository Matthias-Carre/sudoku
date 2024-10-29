package elements;

public class Grid {
    int[] list;
    Cell[] cells;

    public Grid() {
        this.list = new int[81];
        this.cells = new Cell[81]; // Référence correctement à this.cells
        for (int i = 0; i < 81; i++) {
            this.cells[i] = new Cell(-1, i);
        }
    }

    public Grid(int[] list) {
        if (list.length != 81) {
            throw new IllegalArgumentException("La liste doit contenir exactement 81 entiers.");
        }

        this.list = list; // Associe directement le tableau donné à l'argument
        this.cells = new Cell[81];
        for (int i = 0; i < 81; i++) {
            this.cells[i] = new Cell(list[i], i);
        }
    }

    public Cell[] getCells() {
        return this.cells;
    }

    public int[] getList() {
        return this.list;
    }

    public void setCells(Cell[] cells) {
        this.cells = cells;
    }

    public void printDisplay() {
        Cell[] list = this.cells;
        System.out.println("┏━━━┯━━━┯━━━┳━━━┯━━━┯━━━┳━━━┯━━━┯━━━┓");

        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6) {
                System.out.println("┣━━━┿━━━┿━━━╋━━━┿━━━┿━━━╋━━━┿━━━┿━━━┫");
            }
            System.out.print("┃");

            for (int j = 0; j < 9; j++) {
                if (j == 3 || j == 6) {
                    System.out.print("┃");
                } else if (j > 0) {
                    System.out.print("│");
                }

                if (list[i * 9 + j].getValue() == -1) {
                    System.out.print("   ");
                } else {
                    // "!" c'est pour les chiffres ajoutés par les règles
                    if (list[i * 9 + j].isAddbyrule()) {
                        System.out.print(" " + list[i * 9 + j].getValue() + "!");
                    } else {
                        System.out.print(" " + list[i * 9 + j].getValue() + " ");
                    }
                }
            }
            System.out.println("┃");
        }
        System.out.println("┗━━━┷━━━┷━━━┻━━━┷━━━┷━━━┻━━━┷━━━┷━━━┛");
    }
}
