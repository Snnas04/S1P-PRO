public class Accessoris extends Producte {
    /* Atribut d'accessoris */
    private String marca;
    private String tamany;

    public Accessoris(String nom) {
        super(nom);
    }

    /* Metodes de la calsse Accessori */
    public void getMarca() {
        System.out.println(marca);
    }

    public void getTamanny() {
        System.out.println(tamany);
    }
}
