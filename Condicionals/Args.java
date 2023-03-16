package Condicionals;

public class Args {
    public static void main(String[] args) {
        // args = argumentos
        // args guarda tot el q escribem despues del programa, fins a un espai
        // sempre hem de posar algo, sino dona error, com hi ha dos hem de posar dos arguments, seperats per un espai
        
        //System.out.println(args[0]);
        //System.out.println(args[1]);

        // args-length es per tenir un control de la cantitat d''arguments
        // te compte la cantitat de arguments
        if (args.length != 2) {
            System.out.println("Wrong number of arguments (" + args.length + ")");
            System.exit(-1);
        }
        
        //hem de posar *Integer.parseInt() peruque args son strings i convertirlo amb es valor que represente.3 nomes poden ser numeros
        int valor0 = Integer.parseInt(args[0]);
        int valor1 = Integer.parseInt(args[1]);

        System.out.println(valor0 + " i " + valor1);
    }
}
