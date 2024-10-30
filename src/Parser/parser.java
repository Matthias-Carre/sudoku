package Parser;

import elements.Grid;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class parser {

    public static List<Integer> parse(String filePath) {
        List<Integer> values = new ArrayList<>(81);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int row = 0;

            while ((line = reader.readLine()) != null && row < 9) {
                String[] lineValues = line.split(",");

                if (lineValues.length != 9) {
                    throw new IllegalArgumentException("Erreur de format : chaque ligne doit contenir exactement 9 valeurs.");
                }

                for (int col = 0; col < 9; col++) {
                    int value = Integer.parseInt(lineValues[col].trim());
                    values.add((value == 0) ? -1 : value);
                }
                row++;
            }

            if (row != 9) {
                throw new IllegalArgumentException("Erreur de format : le fichier doit contenir exactement 9 lignes.");
            }
        } catch (IOException e) {
            System.out.println("Erreur : le fichier spécifié est introuvable. Veuillez vérifier le chemin.");
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return values;
    }

    public static void main(String[] args) {
        List<Integer> values = parse("src\\sudoku.txt");
        if (values != null) {
            System.out.println(values);
        }
    }
}