public class Empleat extends Presona implements AccionsPersona, AccionsEmpleat {
    /* atributs de l'empleat */
    private String horari;
    private double paga;
    private String carreg;

    /* metodes de la classe empleat */
    public void getHorari() {
        System.out.println(horari);
    }

    public void getPaga() {
        System.out.println(paga);
    }

    public void getCarreg() {
        System.out.println(carreg);
    }

    /* metodes de la interfici AccionsPersona */
    public void Entrar() {
        System.out.println("L'empleat entra a la tenda");
    }

    public void Sortir() {
        System.out.println("L'empleat surt de la tenda");
    }

    public void Camina() {
        System.out.println("L'empleat camina");
    }

    public void Mirar() {
        System.out.println("L'empleat mira els productes del client");
    }

    public void Comprar() {
        System.out.println("L'empeat compra els productes del client");
    }

    public void Vendre() {
        System.out.println("L'empleat ven els productes al client");
    }

    /* metodes de la interfici AccionsEmpleat */
    public void Ajudar() {
        System.out.println("L'empleat ajuda al client");
    }

    public void Ascendir() {
        System.out.println("El carreg de l'epleat ha augmentat");
    }

    public void Esperar() {
        System.out.println("Esperes a que entri un client");
    }

    public void ColocarProductes() {
        System.out.println("L'empeat coloca els nous productes del magatzem");
    }

    public void ComprarProductes() {
        System.out.println("L'empeat compra productes al proveidor");
    }
}
