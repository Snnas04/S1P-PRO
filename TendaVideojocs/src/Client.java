public class Client extends Presona implements AccionsPersona, AccionsClient{
    /* atributs de la classe client */
    protected boolean targeta = false;

    /* metodes de la interfici AccionsPersona */
    public void Entrar() {
        System.out.println("El client entra a la tenda");
    }

    public void Sortir() {
        System.out.println("El client surt de la tenda");
    }

    public void Camina() {
        System.out.println("El client camina");
    }

    public void Mirar() {
        System.out.println("El client mira els productes de la tenda");
    }
    
    public void Comprar() {
        System.out.println("El client compra els productes");
    }

    public void Vendre() {
        System.out.println("El client ven els productes al client");
    }

    /* metodes de la interfici AccionsClient */
    public void Registar() {
        targeta = true;
        System.out.println("El client s'ha registrat");
    }

    public void Demanar() {
        System.out.println("El client demana infroamció sobre un producate");
    }
}
