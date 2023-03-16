import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    String operacions[];

    public Menu(String ... operacions) {
        this.operacions = operacions;
    }

    public void printMenu() {
        int count = 0;
        for (String option : operacions)
            System.out.println(++count + ". " + option);
        
            System.out.println("0. Exit");
    }

    public NumeroComplexe getNumbers() {
        System.out.println("Introdueix el numero real:");
        double real = scanner.nextDouble();

        System.out.println("Introdueix el numero imaginaria:");
        double imaginari = scanner.nextDouble();
        System.out.println("");

        return new NumeroComplexe(real, imaginari);
    }

    public int getOperation() {
        getNumbers();
        printMenu();

        System.out.println("Introdueix quina operacio vols fer:");
        int opcio = scanner.nextInt();

        return opcio;
    }
}
