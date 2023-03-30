public class Tenda {
    /* atributs de la classe tenda */
    private String ubicacio;
    private String nom;
    private String horari;
    private String productes;
    private String clients;
    private String empleat;
    private String proveidor;

    public Tenda(String nom, String horari) {
        this.nom = nom;
        this.horari = horari;
    }

    /* metodes de la calsse tenda */
    public String getUbicacio() {
        return ubicacio;
    }

    public String getNom() {
        return nom;
    }

    public String getHorari() {
        return horari;
    }

    public String getProductes() {
        return productes;
    }

    public String getClients() {
        return clients;
    }

    public String getEmpleat() {
        return empleat;
    }

    public String getProveidor() {
        return proveidor;
    }
}
