package Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class parser {

    public static List<Integer> parse(String filePath) throws IOException {
        List<Integer> values = new ArrayList<>(81);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int row = 0;

        while ((line = reader.readLine()) != null && row < 9) {
            String[] lineValues = line.split(",");

            if (lineValues.length != 9) {
                throw new IllegalArgumentException("Chaque ligne doit contenir 9 valeurs.");
            }

            for (int col = 0; col < 9; col++) {
                int value = Integer.parseInt(lineValues[col].trim());
                values.add((value == 0) ? -1 : value);
            }
            row++;
        }

        reader.close();

        if (row != 9) {
            throw new IllegalArgumentException("Le fichier doit contenir exactement 9 lignes.");
        }

        return values;
    }

    public static void main(String[] args) {
        try {
            List<Integer> values = parse("C:\\Users\\potichachalcoolik\\IdeaProjects\\sudoku\\src\\sudoku.txt");
            System.out.println(values);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
