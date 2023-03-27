import java.util.Scanner;

public class Menu {
    private String header;
    private String[] options;

    public Menu(String header, String[] options) {
        this.header = header;
        this.options = options;
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
    }

    public int getOption() {
        Scanner get = new Scanner(System.in);
        
        Show();

        return  get.nextInt();
    }
    
    public void doNothing() {}
}
