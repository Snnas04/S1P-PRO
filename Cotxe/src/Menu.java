import java.io.FileNotFoundException;
import java.util.Scanner;

    /**
     * A class that represents a menu with options for managing a second-hand car sales system.
     * The menu is displayed on the console, and the user can select an option by entering a number.
     * The available options are:
     *     Information Car - Displays information about a specific car.
     *     Comparation - Allows the user to compare two cars.
     *     See cars - Displays a list of all the available cars.
     *     Exit - Exits the program.
     */

public class Menu {
    private String header;
    private String[] options;
    private Car[] cars;

    /**
     * Creates a new Menu instance with the given header, options, and cars.
     *
     * @param header the header to be displayed at the top of the menu
     * @param options the options to be displayed in the menu
     * @param cars the array of cars to be used in the menu
     */
    public Menu(String header, String[] options, Car[] cars) {
        this.header = header;
        this.options = options;
        this.cars = cars;
    }
    
    /**
     * Displays the menu on the console.
     */
    public void Show() {
        int line = 30;

        System.out.println("-".repeat(line));
        System.out.format("| %-26s |\n", header);
        System.out.println("-".repeat(line));

        int count = 0;
        for (String option : options)
            // System.out.println("| " + ++count + ". " + option + " |");
            System.out.format("| %-1s. %23s |\n", ++count, option);
        
        System.out.println("-".repeat(line));
        System.out.format("| %-26s |\n", "0. Exit");
        System.out.println("-".repeat(line));
    }

    /**
     * Prompts the user to enter an option number and returns the selected option.
     *
     * @return the selected option number
     */
    public int getOption() {
        Scanner get = new Scanner(System.in);
        
        Show();

        return  get.nextInt();
    }

    /**
     * Displays the main menu and handles user input until the user selects the "Exit" option.
     *
     * @param cars the array of cars to be used in the menu
     * @throws FileNotFoundException if an error occurs while reading a file
     */
    public static void mainMenu(Car[] cars) throws FileNotFoundException {
        Menu menu = new Menu("Second-Hand Car Sales", new String[]{"Information Car", "Comparation", "See cars"}, cars);

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    infoMenu(menu.cars);
                    return;
                case 2:
                    comparationMenu(menu.cars);
                    return;
                case 3:
                    Info.showCars(menu.cars);
                default:
                    menu.doNothing();
            }
        }
    }

    /**
     * Displays the "Information Car" sub-menu and handles user input until the user selects the "Exit" option.
     *
     * @param cars the array of cars to be used in the menu
     * @throws FileNotFoundException if an error occurs while reading a file
     */
    private static void infoMenu(Car[] cars) throws FileNotFoundException {
        Menu menu = new Menu("Get Information Menu", getCarOptions(cars), cars);
    
        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
        
            if(answer > 0 && answer <= cars.length) {
                Car car = cars[answer - 1];
                Info.Information(car);
                Menu.mainMenu(cars);
            }
            else {
                menu.doNothing();
            }
        }
    }
    
    /**
     *
     * Displays the comparation menu for cars and receives user input to select two cars to compare.
     *
     * @param cars an array of Car objects to choose from.
     *
     * @throws FileNotFoundException if an error occurs while accessing a file.
     */
    private static void comparationMenu(Car[] cars) throws FileNotFoundException {
        System.out.println("-".repeat(30));
        System.out.format("| %-26s |\n", "Select first car");

        Menu menu = new Menu("Comparation Menu", getCarOptions(cars), cars);
    
        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
        
            if(answer > 0 && answer <= cars.length) {
                Car car1 = cars[answer - 1];

                System.out.println("-".repeat(30));
                System.out.format("| %-26s |\n", "Select second car");
        
                Menu subMenu = new Menu("Comparation Menu", getCarOptions(cars), cars);

                int answer2 = subMenu.getOption();

                if(answer2 > 0 && answer2 <= cars.length) {
                    Car car2 = cars[answer2 - 1];
                    Info.Comparation(car1, car2);
                    Menu.mainMenu(cars);
                }
            }
            else {
                menu.doNothing();
            }
        }
    }
    
    /**
     *
     * Returns an array of strings containing the brand and model of each car in the cars array.
     * @param cars an array of Car objects.
     * @return an array of strings with the brand and model of each car.
     */
    private static String[] getCarOptions(Car[] cars) {
        String[] options = new String[cars.length];
        for(int i = 0; i < cars.length; i++) {
            options[i] = cars[i].getBrand() + " " + cars[i].getModel();
        }
        return options;
    }
    
    /**
     *
     *A method that does nothing. Used for menu navigation purposes.
     */
    public void doNothing() {}
}
