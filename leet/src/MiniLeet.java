public class MiniLeet {
    private static String code = "o0ò0ó0i1í1ì1ï1z2e3è3é3a4à4á4s5g6t7b8r9";

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Posa un missatge");
            System.exit(-1);
        }

        String text = args[0].toLowerCase();

        for (int i = 0; i < code.length(); i += 2)
            text = text.replaceAll(code.substring(i, i + 1), code.substring(i + 1, i + 2));

        System.out.print(text);
    }
}
