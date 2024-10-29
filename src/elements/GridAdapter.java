package elements;

import java.util.List;

public class GridAdapter {
    public static Grid convert(List<Integer> values) {
        if (values.size() != 81) {
            throw new IllegalArgumentException("La liste doit contenir exactement 81 entiers.");
        }
        int[] intArray = values.stream().mapToInt(Integer::intValue).toArray();
        return new Grid(intArray);
    }
}

