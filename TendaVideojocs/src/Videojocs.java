public class Videojocs extends Producte {
    /* atributs de la classe videojocs */
    private String plataforma;
    private int PEGI;
    private String empresa;
    private String genere;

    public Videojocs(String nom) {
        this.nom = nom;
    }

    /* metodes de la classe videojoc */
    public void getPlataforma() {
        System.out.println(plataforma);
    }

    public void getPEGI() {
        System.out.println(PEGI);
    }

    public void getEmpresa() {
        System.out.println(empresa);
    }

    public void getGenere() {
        System.out.println(genere);
    }
}
