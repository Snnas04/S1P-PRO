import java.text.Normalizer;

public class Caracters {
    String vocabulari = "0123456789abcdefghijklmnopqrstuvwxyz";

    /* un contador per cada carecter */
    int[] contador = new int[vocabulari.length()];
    int otros = 0;

    String text;

    public Caracters(String text) {
        this.text = text;
        for (int i = 0; i < contador.length; i++)
            contador[i] = 0;
    }

    public static void main(String[] args) {
        Caracters c = new Caracters("Spirit is willing, but the flesh is weak");
        c.processar();
        c.mostrar();
    }

    private void mostrar() {
        for (int i = 0; i < contador.length; i++)
            if (contador[i] != 0)
                System.out.format("%c - %d\n", vocabulari.charAt(i), contador[i]);
        
        // System.out.println("altres: " + otros);
        System.out.format("altres: %d\n", otros);
    }

    private void processar() {
        String work = Normalizer.normalize(text, Normalizer.Form.NFD);
        work = work.replaceAll("[^\\p{ASCII}]", "").toLowerCase();

        for (int i = 0; i < work.length(); i++) {
            /* agafar cada caracter */
            char c = work.charAt(i);
            int j = vocabulari.indexOf(c);

            if (j != -1)
                contador[j]++;
            else
                otros++;
        }
    }
}
