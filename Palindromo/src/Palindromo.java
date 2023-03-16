import java.text.Normalizer;

public class Palindromo {
    String missatge;

    public Palindromo(String missatge) {
        this.missatge = missatge;
    }

    public void Resposta() {
        if (Comprovar())
            System.out.print("Es polindromo");
        else
            System.out.print("No es polindromo");
    }

    private void Depurar() {
        String work = Normalizer.normalize(missatge, Normalizer.Form.NFD);
        work = work.toLowerCase();
        work = work.replaceAll("[^a-z]", "").replaceAll(" ", "");
        missatge = work;
    }

    private boolean Comprovar() {
        char[] fraseArray = missatge.toCharArray();
        int i = 0;
        int j = fraseArray.length -1;
        
        while (i < (fraseArray.length / 2) + 1) {
            if (fraseArray[i++] != fraseArray[j--])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Palindromo p = new Palindromo("hoh");
        p.Depurar();
        p.Resposta();
    }
}
