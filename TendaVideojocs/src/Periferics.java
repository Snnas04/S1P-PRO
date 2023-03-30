public class Periferics extends Producte {
    /* atributs de la classe periferics */
    private String marca;
    private String color;
    private boolean inalambric;

    public Periferics(String nom, double preu) {
        super(nom, preu);
    }

    /* metodes de la classe periferics */
    public void getMarca() {
        System.out.println(marca);
    }

    public void getInalambric() {
        System.out.println(inalambric);
    }

    public void getColor() {
        System.out.println(color);
    }
}
