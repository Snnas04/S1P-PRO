public abstract class Producte {
    /* Atributs del producte */
    private String nom;
    private double preu;
    private String descripcio;
    private String categoria;

    public Producte(String nom, double preu) {
        this.nom = nom;
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public double getPreu() {
        return preu;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getCategoria() {
        return categoria;
    }
}
