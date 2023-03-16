public class ProLeet {
    public static void main(String[] args) throws Exception {
        // aqui faig un array amb una lletra i el numero que vull que representi 
        // he inclos vocals amb accents i amb dieresis i la ç i la ñ
        String[][] codificador = {
            {"A", "4"}, {"À", "4"}, {"Á", "4"},
            {"B", "8"},
            {"C", "("}, {"Ç", "("},
            {"D", "[)"},
            {"E", "3"}, {"È", "3"}, {"É", "3"},
            {"F", "|="},
            {"G", "6"},
            {"H", "/-/"},
            {"I", "1"}, {"Í", "1"}, {"Ï", "1"},
            {"J", "_]"},
            {"K", "|<"},
            {"L", "|_"},
            {"M", "^^"},
            {"N", "^"}, {"Ñ", "^"},
            {"O", "0"}, {"Ò", "0"}, {"Ó", "0"},
            {"P", "|>"},
            {"Q", "0_"},
            {"R", "9"},
            {"S", "5"},
            {"T", "7"}, 
            {"U", "(_)"}, {"Ú", "(_)"}, {"Ü", "(_)"},
            {"V", "'/"},
            {"W", "'//"},
            {"X", "><"},
            {"Y", "`/"},
            {"Z", "2"},
        };

        // amb el segunt if comprob que m'haguin posat alagun argument
        if (args.length != 1) {
            System.out.println("Escriu un missatge entre comilles");
            System.exit(-1);
        }

        // indtroduesc el contingut de l'argument dins la variable text
        // amb el .toUpperCase pos tot el missatge amb majuscules, ja que el meu array nomes comptempla majuscules
        String text = args[0].toUpperCase();


        for (String[] lletra : codificador) {
            text = text.replaceAll(lletra[0], lletra[1]);
        }

        // imprimim el missatge amb leet
        System.out.print(text);
    }
}
