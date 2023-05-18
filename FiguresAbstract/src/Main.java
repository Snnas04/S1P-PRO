public class Main {
    public static void main(String[] args) {
        int width = 900;
        int height = 750;
        int level = 6;

        new Frame("Cantor Dust", width, height, level, new CantorDust());
        new Frame("Sierpinski", width, height, level, new Sierpinski());
        new Frame("Menger", width, height, level, new MengerCarpet());
    }
}
