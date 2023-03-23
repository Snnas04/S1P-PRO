public abstract class Presona {
    /* atributs de la classe ambstracte presona */
    private String DNI;
    private String nom;
    private String llinatge;
    private String email;
    private String direccio;
    private String telefon;
    private String dataNaixament;

    /* metodoes de la classe persona */
    public void getDNI() {
        System.out.println(DNI);
    }

    public void getNom() {
        System.out.println(nom);
    }

    public void getLlinatge() {
        System.out.println(llinatge);
    }

    public void getEmail() {
        System.out.println(email);
    }

    public void getDireccio() {
        System.out.println(direccio);
    }

    public void getTelefon() {
        System.out.println(telefon);
    }

    public void gatDataNaixament() {
        System.out.println(dataNaixament);
    }
}
