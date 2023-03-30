public class Client extends Presona implements AccionsPersona, AccionsClient{
    /* atributs de la classe client */
    protected boolean targeta = false;

    public Client(String nom, boolean targeta) {
        super(nom);
        this.targeta = targeta;
    }

    /* metodes de la interfici AccionsPersona */
    public void Entrar() {
        System.out.println(nom + " entra a la tenda");
    }

    public void Sortir() {
        System.out.println(nom + " surt de la tenda");
    }

    public void Camina() {
        System.out.println(nom + " camina");
    }

    public void Mirar() {
        System.out.println(nom + " mira els productes de la tenda");
    }
    
    public void Comprar() {
        System.out.println(nom + " compra els productes");
    }

    public void Vendre() {
        System.out.println(nom + " ven els productes al client");
    }

    /* metodes de la interfici AccionsClient */
    public void Registar() {
        targeta = true;
        System.out.println(nom + " s'ha registrat");
    }

    public void Demanar() {
        System.out.println(nom + " demana infroamció sobre un producate");
    }

    public void Agafar() {
        System.out.println(nom + " agafa el producte");
    }
}
