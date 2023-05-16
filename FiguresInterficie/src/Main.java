public class Main {
    public static void main(String[] args) {
        new Frame("Cantor Dust", 5, new CantorDust());
        new Frame("Sierpinski", 6, new Sierpinski());
        new Frame("Menger", 4, new MengerCarpet());
    }
}
