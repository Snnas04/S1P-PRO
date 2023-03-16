public class Main {
    public static void main(String[] args) {
        double a, b, c;
        double x, y;

        try{
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
            c = Double.parseDouble(args[2]);
            
            x = (-b + Math.sqrt(b * b - 4 * a * c) / (2 * a));
            y = (-b - Math.sqrt(b * b - 4 * a * c) / (2 * a));
    
            System.out.println("X = " + x);
            System.out.println("Y = " + y);
        }
        // per posar or, ||, hem de posar |
        catch (IndexOutOfBoundsException | NumberFormatException e){
            System.err.println("Something went worong!");
        }
        catch (Exception e) {
            System.err.println("");
        }
    }
}
