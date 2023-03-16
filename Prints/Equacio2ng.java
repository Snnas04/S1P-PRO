package Prints;

public class Equacio2ng {
    public static void main(String[] args) {
        // fer equacio de segon grau
        double a, b, c, x, y;

        a = 1;
        b = 1;
        c = 1;

        x = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        y = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);

        System.out.println(x);
        System.out.println(y);
    }
}
// NaN: Not a Number