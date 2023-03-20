public class Cotxe extends Nascar {
    private int velocitatSortida = 95;
    private int velocitatAcc;
    private int velocitatFre;
    private int angelVolant;
    private int angleVolantInici = -25;

    public Cotxe(String marca, String model, int any) {
        super(marca, model, any);
        accelerar(velocitatSortida, velocitatAcc);
        frenar(velocitatAcc, velocitatFre);
        girarVolant(angleVolantInici, angelVolant);
    }

    public void accelerar(int velocitatSortida, int velocitatAcc) {
        int velocitatRecta = velocitatSortida + velocitatAcc;
        System.out.println("accalera: " + velocitatRecta);
    }

    public void frenar(int velocitatAcc, int velocitatFre) {
        int velocitatCurva = velocitatAcc - velocitatFre;
        System.out.println("frena: " + velocitatCurva);
    }

    public void girarVolant(int angleVolantInici, int angelVolant) {
        int angle = angelVolant + angleVolantInici;
        System.out.println("angle: " + angle);
    }
}
