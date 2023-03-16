import java.io.FileNotFoundException;

/**
 * The Main class is the entry point for the program. It creates an array of Car objects and starts the main menu.
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Car[] cars = new Car[] {
            new Car("Nissan", "skyline GTR R-32", "Blau", 40000, 1993, 86000, 640, 3, 3),
            new Car("BMW", "M4 competition", "Blanc", 150000, 2021, 20000, 510, 3, 2),
            new Car("Porche", "911 GT3 RS", "Gris", 220000, 2019, 37000, 620, 3, 3),
            new Car("Mazda", "RX7", "Vermell", 32000, 1998, 126000, 240, 3, 2),
            new Car("Toyota", "yaris GR", "Blanc", 35000, 2021, 12000, 261, 3, 2),
            new Car("Citroen", "C3", "Gris", 12000, 2006, 142085, 70, 5, 0),
            new Car("Renault", "Clio", "Groc", 18000, 2017, 76000, 90, 5, 1),
            new Car("Rayo", "McQueen", "Vermell", 120000000, 2006, 120000, 760, 0, 3)
        };

        Menu.mainMenu(cars);
    }
}
