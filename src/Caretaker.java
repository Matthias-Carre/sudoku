import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    private final List<Memento> mementoList = new ArrayList<>();

    public void saveState(Memento memento) {
        mementoList.add(memento);
    }

    public Memento restoreState() {
        if (!mementoList.isEmpty()) {
            return mementoList.remove(mementoList.size() - 1);
        }
        return null;
    }
}

