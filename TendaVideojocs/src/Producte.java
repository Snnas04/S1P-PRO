public abstract class Producte {
    /* Atributs del producte */
    private String nom;
    private double preu;
    private String descripcio;
    private String categoria;

    public Producte(String nom) {
        this.nom = nom;
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
