package Primos;

//trobar els numeros primers del numero que indicam per terminal
public class ActivitatFor {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Nomes podem posar un argument");
            System.exit(-1);
        }

        int num_ter = Integer.parseInt(args[0]);

        for (int i = 2; i < num_ter; i += 1) {
            if ((num_ter % i == 0)) {
                System.out.println("No es primo");
                System.exit(0);;
            }
        }
        System.out.println("Es primo");
    }
}
