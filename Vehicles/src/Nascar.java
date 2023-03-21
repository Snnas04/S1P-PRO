public class Nascar extends Cotxe {
    private int velocitat;
    private int angelVolant;

    public Nascar(String marca, String model, int any) {
        super(marca, model, any);
    }

    @Override
    public void accelerar(int velocitat) {
        System.out.println("accalera: " + velocitat);
    }

    @Override
    public void frenar(int velocitat) {
        System.out.println("frena: " + velocitat);
    }

    @Override
    public void girarVolant(int angelVolant) {
        System.out.println("angle: " + angelVolant);
    }
}
