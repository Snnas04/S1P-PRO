package Condicionals;

public class Fluxe {
    public static void main(String[] args) {
        int valor = 7;
        
        //if (valor > 5) {
        //    System.out.println("Greathen than five");
        //    if (valor < 8) {
        //        System.out.println("Correct");
        //    }
        //    else{
        //        System.out.println("Too big");
        //    }
        //}
        //else {
        //    System.out.println("Too small");
        //}


        //El doble && significa que s'ha de complir la primera i segona condició es un *and*
        // es a dir les dues condicions han de ser true perque continui, i si la primera es falsa ja no mira la segona
        
        //if ((valor > 5) && (valor < 8)) {
        //    System.out.println("Correct");
        //}
        //else {
        //    if (valor <= 5) {
        //        System.out.println("Too small");
        //    }
        //    if (valor >= 8) {
        //        System.out.println("Too big");
        //    }
        //}

        //A partir de l'exit acaba el programa, no seguira llegint les seguents lineas

        //if ((valor > 5) && (valor < 8)) {
        //    System.out.println("Correcte");
        //    System.exit(valor);
        //}
        //if (valor < 5) {
        //    System.out.println("Too big");
        //}
        //else {
        //    System.out.println("too big");
        //}

        // el || es un or

        if ((valor <= 5) || (valor >= 8)) {
            System.out.println("value out of bounds");
        }
        else {
            System.out.println("correct");
        }
    }
}
