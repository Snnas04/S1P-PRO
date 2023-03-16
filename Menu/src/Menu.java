import java.util.Scanner;

public class Menu {
    String header;
    String[] options;

    // indicam que com a minim hen d'inidcar la capsalera, i posar x opcions de forma no obligatoria, 
    // amb els tres punts eindocam desde ningun fins els que siguin
    public Menu(String header, String ... options) {
        this.options = options;
        this.header = header;
    }

    public void Show() {
        System.out.println("-".repeat(8));
        System.out.println(header);
        System.out.println("-".repeat(8));

        int count = 0;
        for (String option : options)
            System.out.println(++count + ". " + option);
        
        System.out.println("-".repeat(8));
        System.out.println("0. Exit");
        System.out.println("-".repeat(8));
    }

    public int getOption() {
        Scanner get = new Scanner(System.in);
        
        Show();

        return  get.nextInt();
    }

    public static void main(String[] args) {
        Menu menu = new Menu("main", "first", "second", "third", "fourth");

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();

            switch (answer) {
                case 1 -> System.out.println("first");
                case 2 -> System.out.println("second");
                case 3 -> System.out.println("third");
                case 4 -> System.out.println("fourth");
                default -> menu.doNothing();
            }
        }
    }

    private void doNothing() {}
}
