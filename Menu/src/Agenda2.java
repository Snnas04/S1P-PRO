import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Agenda2 {
    String apellidos = "./recursos/apellidos.txt";
    String hombres = "./recursos/hombres.txt";
    String mujeres = "./recursos/mujeres.txt";

    List<String> listApellidos;
    List<String> listHombres;
    List<String> listMujeres;

    PrintWriter pw;
    Random rnd;

    public Agenda2() {
        listApellidos = llegir(apellidos);
        listHombres = llegir(hombres);
        listMujeres = llegir(mujeres);

        rnd = new Random(666);
        crear();
    }

    private List<String> llegir(String arxiu) {
        List<String> llista = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(arxiu))) {
            while (scan.hasNextLine()) llista.add(scan.nextLine());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return llista;
    }

    private void crear() {
        try {
            pw = new PrintWriter(new File("./result/agenda2.txt"));
            contingut();
            pw.close();
        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    private void contingut() {
        for (int i = 0; i < 10; i++)
            crearPersona();
    }

    private void crearPersona() {
        StringBuilder persona = new StringBuilder();

        persona.append(listApellidos.get(rnd.nextInt(listApellidos.size())));
        if (rnd.nextInt(5) != 2)
            persona.append(" ").append(listApellidos.get(rnd.nextInt(listApellidos.size())));

        persona.append(", ");

        if (rnd.nextBoolean()) {
            persona.append(listMujeres.get(rnd.nextInt(listMujeres.size())));
            if (rnd.nextInt(5) == 2)
                persona.append(" ").append(listMujeres.get(rnd.nextInt(listMujeres.size())));
        }
        else {
            persona.append(listHombres.get(rnd.nextInt(listHombres.size())));
            if (rnd.nextInt(5) == 2)
                persona.append(" ").append(listHombres.get(rnd.nextInt(listHombres.size())));
        }

        pw.println(persona.toString());

        pw.format("(6%02d %03d %03d)\n\n", rnd.nextInt(100), rnd.nextInt(1000), rnd.nextInt(1000));
    }

    public static void main(String[] args) {
        new Agenda2();
    }
}
