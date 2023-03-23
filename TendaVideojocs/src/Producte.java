public abstract class Producte {
    /* Atributs del producte */
    private String nom;
    private double preu;
    private String descripcio;
    private String categoria;

    /* metodes de la classe producte */
    public void getNom() {
        System.out.println(nom);
    }

    public void getPreu() {
        System.out.println(preu);
    }

    public void getDescripcio() {
        System.out.println(descripcio);
    }

    public void getCategoria() {
        System.out.println(categoria);
    }
}
