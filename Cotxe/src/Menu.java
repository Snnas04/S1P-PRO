import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    String header;
    String[] options;
    Car[] cars;

    public Menu(String header, String[] options, Car[] cars) {
        this.header = header;
        this.options = options;
        this.cars = cars;
    }
    

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

    public int getOption() {
        Scanner get = new Scanner(System.in);
        
        Show();

        return  get.nextInt();
    }

    public static void mainMenu(Car[] cars) throws FileNotFoundException {
        Menu menu = new Menu("Second-Hand Car Sales", new String[]{"Information Car", "Comparation"}, cars);

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
                default:
                    menu.doNothing();
            }
        }
    }

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
                // menu.doNothing();
                Menu.mainMenu(cars);
            }
        }
    }
    
    private static void comparationMenu(Car[] cars) throws FileNotFoundException {
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
                // menu.doNothing();
                Menu.mainMenu(cars);
            }
        }
    }
    
    private static String[] getCarOptions(Car[] cars) {
        String[] options = new String[cars.length];
        for(int i = 0; i < cars.length; i++) {
            options[i] = cars[i].getBrand() + " " + cars[i].getModel();
        }
        return options;
    }
    
    public void doNothing() {}
}
