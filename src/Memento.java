import elements.Cell;

public class Memento {
    private final Cell[] state;

    public Memento(Cell[] state) {
        this.state = new Cell[state.length];
        for (int i = 0; i < state.length; i++) {
            this.state[i] = new Cell(state[i].getValue(), state[i].getPos());
            this.state[i].setAddbyrule(state[i].isAddbyrule());
            this.state[i].getPossibilitys().clear();
            this.state[i].getPossibilitys().addAll(state[i].getPossibilitys());
        }
    }

    public Cell[] getState() {
        return state;
    }
}

