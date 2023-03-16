import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Info {
    public static void Information(Car carX) throws FileNotFoundException {
        ShowInfo(carX);
    }

    public static void Comparation(Car carX, Car carY) throws FileNotFoundException {
        ShowComparation(carX, carY);
    }

    private static void ShowInfo(Car carX) throws FileNotFoundException {
        String carInfo = carX.getBrand();

        try (PrintWriter pw = new PrintWriter("Info-" + carInfo + ".txt")) {
            int lineLength = 45;
            char c = '-';

            String repeatedChar = String.format("%0" + lineLength + "d", 0).replace("0", String.valueOf(c));
            pw.println(repeatedChar);

            // Print the headers
            pw.format("|%-22s|%20s|\n", "Marca", carX.getBrand());
            pw.format("|%-22s|%20s|\n", "Model", carX.getModel());
            pw.format("|%-22s|%20s|\n", "Color", carX.getColor());
            pw.format("|%-22s|%20s|\n", "Preu de compra", carX.getInitialPrice());
            pw.format("|%-22s|%20s|\n", "Preu de venta", carX.getPrice());
            pw.format("|%-22s|%20s|\n", "Any", carX.getYear());
            pw.format("|%-22s|%20s|\n", "Numero de kilometres", carX.getNumKm());
            pw.format("|%-22s|%20s|\n", "Numero de Cavalls", carX.getNumCV());
            pw.format("|%-22s|%20s|\n", "Numero de Portes", carX.getDoors());
            pw.format("|%-22s|%20s|\n", "Estat", carX.getState());

            pw.println(repeatedChar);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ShowComparation(Car carX, Car carY) throws FileNotFoundException {
        String option1 = carX.getBrand();
        String option2 = carY.getBrand();

        try (PrintWriter pw = new PrintWriter("Comparacio-" + option1 + "_" + option2 + ".txt")) {
            int lineLength = 66;
            char c = '-';

            String repeatedChar = String.format("%0" + lineLength + "d", 0).replace("0", String.valueOf(c));
            pw.println(repeatedChar);

            // Print the headers
            pw.format("|%-22s|%20s|%20s|\n", "Marca", carX.getBrand(), carY.getBrand());
            pw.format("|%-22s|%20s|%20s|\n", "Model", carX.getModel(), carY.getModel());
            pw.format("|%-22s|%20s|%20s|\n", "Color", carX.getColor(), carY.getColor());
            pw.format("|%-22s|%20s|%20s|\n", "Preu de compra", carX.getInitialPrice(), carY.getInitialPrice());
            pw.format("|%-22s|%20s|%20s|\n", "Preu de venta", carX.getPrice(), carY.getPrice());
            pw.format("|%-22s|%20s|%20s|\n", "Any", carX.getYear(), carY.getYear());
            pw.format("|%-22s|%20s|%20s|\n", "Numero de kilometres", carX.getNumKm(), carY.getNumKm());
            pw.format("|%-22s|%20s|%20s|\n", "Numero de Cavalls", carX.getNumCV(), carY.getNumCV());
            pw.format("|%-22s|%20s|%20s|\n", "Numero de Portes", carX.getDoors(), carY.getDoors());
            pw.format("|%-22s|%20s|%20s|\n", "Estat", carX.getState(), carY.getState());

            pw.println(repeatedChar);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
