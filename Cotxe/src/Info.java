import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * The Info class provides methods for displaying information about cars, comparing two cars, and displaying an array of cars.
 */

public class Info {
    /**
     * Displays the information about a single car.
     *
     * @param carX the car to display the information of
     * @throws FileNotFoundException if the file to write the information to cannot be found
     */
    public static void Information(Car carX) throws FileNotFoundException {
        ShowInfo(carX);
    }

     /**
     * Compares the information of two cars.
     *
     * @param carX the first car to compare
     * @param carY the second car to compare
     * @throws FileNotFoundException if the file to write the comparison to cannot be found
     */
    public static void Comparation(Car carX, Car carY) throws FileNotFoundException {
        ShowComparation(carX, carY);
    }

    /**
     * Displays the information of an array of cars.
     *
     * @param cars the array of cars to display the information of
     */
    public static void showCars(Car[] cars) {
        getCars(cars);
    }

    /**
     * Displays the information about a single car.
     *
     * @param carX the car to display the information of
     * @throws FileNotFoundException if the file to write the information to cannot be found
     */
    private static void ShowInfo(Car carX) throws FileNotFoundException {
        String carInfo = carX.getBrand();

        try (PrintWriter pw = new PrintWriter("./Information/Info-" + carInfo + ".txt")) {
            int lineLength = 45;
            char c = '-';

            String repeatedChar = String.format("%0" + lineLength + "d", 0).replace("0", String.valueOf(c));
            pw.println(repeatedChar);

            // Print the headers
            pw.format("|%-22s|%20s|\n", "Brand", carX.getBrand());
            pw.format("|%-22s|%20s|\n", "Model", carX.getModel());
            pw.format("|%-22s|%20s|\n", "Color", carX.getColor());
            pw.format("|%-22s|%20s|\n", "Initial price", carX.getInitialPrice());
            pw.format("|%-22s|%20s|\n", "Final price", carX.getPrice());
            pw.format("|%-22s|%20s|\n", "Year", carX.getYear());
            pw.format("|%-22s|%20s|\n", "Kilometres number", carX.getNumKm());
            pw.format("|%-22s|%20s|\n", "Horsepower number", carX.getNumCV());
            pw.format("|%-22s|%20s|\n", "Doors numbers", carX.getDoors());
            pw.format("|%-22s|%20s|\n", "State", carX.getState());

            pw.println(repeatedChar);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Compares the information of two cars.
     *
     * @param carX the first car to compare
     * @param carY the second car to compare
     * @throws FileNotFoundException if the file to write the comparison to cannot be found
     */
    private static void ShowComparation(Car carX, Car carY) throws FileNotFoundException {
        String option1 = carX.getBrand();
        String option2 = carY.getBrand();

        try (PrintWriter pw = new PrintWriter("./Comparation/Comparacio-" + option1 + "_" + option2 + ".txt")) {
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

    /**
     * Displays the information of an array of cars.
     *
     * @param cars the array of cars to display the information of
     */
    private static void getCars(Car[] cars) {
        int lineLength = 45;
            char c = '-';

        for (int carNum = 0; carNum < cars.length; carNum++) {
            String repeatedChar = String.format("%0" + lineLength + "d", 0).replace("0", String.valueOf(c));
            System.out.println(repeatedChar);

            // Print the headers
            System.out.format("|%-22s|%20s|\n", "Brand", cars[carNum].getBrand());
            System.out.format("|%-22s|%20s|\n", "Model", cars[carNum].getModel());
            System.out.format("|%-22s|%20s|\n", "Color", cars[carNum].getColor());
            System.out.format("|%-22s|%20s|\n", "Initial price", cars[carNum].getInitialPrice());
            System.out.format("|%-22s|%20s|\n", "Final price", cars[carNum].getPrice());
            System.out.format("|%-22s|%20s|\n", "Year", cars[carNum].getYear());
            System.out.format("|%-22s|%20s|\n", "Kilometres number", cars[carNum].getNumKm());
            System.out.format("|%-22s|%20s|\n", "Horsepower number", cars[carNum].getNumCV());
            System.out.format("|%-22s|%20s|\n", "Doors numbers", cars[carNum].getDoors());
            System.out.format("|%-22s|%20s|\n", "State", cars[carNum].getState());

            System.out.println(repeatedChar);
        }
    }
}
