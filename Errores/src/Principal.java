public class Principal {
    
    public static void main(String[] args) {
        int numero;

        try {
            numero = Integer.parseInt(args[0]);
            new Errores(numero);
        }
        catch (Exception e) {
            System.err.println("You must give an integer number");
        }
        // catch (IndexOutOfBoundsException e) {
        //     System.err.println("You must give a number");
        // }
        // catch (NumberFormatException e) {
        //     System.err.println("You must give an integer number");
        // }
    }
}
