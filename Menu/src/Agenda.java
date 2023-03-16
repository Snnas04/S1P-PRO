import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Agenda {
    String apellidos = "apellidos.txt";
    String hombres = "hombres.txt";
    String mujeres = "mujeres.txt";

    List<String> listApellidos;
    List<String> listHombres;
    List<String> listMujeres;
    
    PrintWriter pw;
    Random rnd;

    public Agenda() {
        listApellidos = llegir(apellidos);
        listHombres = llegir(hombres);
        listMujeres = llegir(mujeres);

        // mostrar(listApellidos);
        // mostrar(listHombres);
        // mostrar(listMujeres);

        rnd = new Random(666);
        crear();
    }

    private List<String> llegir(String arxiu)
    {
        List<String> llista = new ArrayList<>();

        try (Scanner s = new Scanner(new File(arxiu)))
        {
            while (s.hasNextLine()) llista.add(s.nextLine());
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

        return llista;
    }

    private void mostrar(List<String> llista)
    {
        for (String s: llista)
            System.out.println(s);
    }
    
    private void crear() {
        try {
            pw = new PrintWriter(new File("agenda.xml"));
            pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            contingut();
            pw.close();
        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void contingut() {
        pw.println("<agenda>");
        for (int i = 0; i < 10; i++) contacte();
        pw.println("</agenda>");
    }
    
    private void contacte()
    {
        pw.println("<contacte>");
        crearPersona();
        // telefons();
        pw.println("</contacte>");
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

        pw.println("<nom>" + persona.toString() + "</nom>");

        pw.format("<telefon>6%02d %03d %03d</telefon>\n", rnd.nextInt(100), rnd.nextInt(1000), rnd.nextInt(1000));
    }

    public static void main(String[] args) {
        new Agenda();
    }
}
