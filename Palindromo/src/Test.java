public class Test {
    public static void main(String[] args) {
        String missatge = "oso";
        String missatgeInvers = "";

        int missatgeLength = missatge.length();

        for (int i = (missatgeLength - 1); i >=0; --i)
            missatgeInvers = missatgeInvers + missatge.charAt(i);
        
        System.out.println(missatge);
        
        if (missatge.toLowerCase() == missatgeInvers.toLowerCase())
            System.out.println("Es polindromo");
        else
            System.out.println("No es polindromo");
    }
}
