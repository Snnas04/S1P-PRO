public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu("Suma", "Resta", "Multiplicació", "Divivició");

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOperation();

            switch (answer) {
                case 1 -> System.out.println("Suma");
                case 2 -> System.out.println("Resta");
                case 3 -> System.out.println("Multiplicació");
                case 4 -> System.out.println("Divivició");
            }
        }
    }
}
