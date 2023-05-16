public class Main {
    public static void main(String[] args) {
        new Frame("sierpinski", 6, new Sierpinski());
        new Frame("Menger", 4, new MengerCarpet());
    }
}
