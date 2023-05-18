public class Main {
    public static void main(String[] args) {
        int height = 900;
        int width = 750;
        int level = 6;

        new Frame("Cantor Dust", height, width, level, new CantorDust());
//        new Frame("Sierpinski", height, width, level, new Sierpinski());
//        new Frame("Menger", height, width, level, new MengerCarpet());
    }
}
