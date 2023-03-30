public class Empleat extends Presona implements AccionsPersona, AccionsEmpleat {
    /* atributs de l'empleat */
    private String horari;
    private double paga;
    private String carreg;

    public Empleat(String nom) {
        super(nom);
    }

    /* metodes de la classe empleat */
    public String getHorari() {
        return horari;
    }

    public double getPaga() {
        return paga;
    }

    public String getCarreg() {
        return carreg;
    }

    /* metodes de la interfici AccionsPersona */
    public void Entrar() {
        System.out.println( nom + " entra a la tenda");
    }

    public void Sortir() {
        System.out.println(nom + " surt de la tenda");
    }

    public void Camina() {
        System.out.println(nom + " camina");
    }

    public void Mirar() {
        System.out.println(nom + " mira els productes del client");
    }

    public void Comprar() {
        System.out.println(nom + " compra els productes del client");
    }

    public void Vendre() {
        System.out.println(nom + " ven els productes al client");
    }

    /* metodes de la interfici AccionsEmpleat */
    public void Ajudar() {
        System.out.println(nom + " ajuda al client");
    }

    public void Ascendir() {
        System.out.println("El carreg de " + nom + " ha augmentat");
    }

    public void Descendir() {
        System.out.println("El carreg de " + nom + " ha disminuit");
    }

    public void Despedir() {
        System.out.println(nom + " esta despedit");
    }

    public void Esperar() {
        System.out.println(nom + " esta esperant");
    }

    public void ColocarProductes() {
        System.out.println(nom + " coloca els nous productes del magatzem");
    }

    public void ComprarProductes() {
        System.out.println(nom + " compra productes al proveidor");
    }
}
