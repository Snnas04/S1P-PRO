public abstract class Cotxe extends Vehicle {
    private int velocitat;
    private int angelVolant;

    public Cotxe(String marca, String model, int any) {
        super(marca, model, any);
    }

    public void accelerar(int velocitat) {
        System.out.println(velocitat);
    }

    public void frenar(int velocitat) {
        System.out.println(velocitat);
    }

    public void girarVolant(int angelVolant) {
        System.out.println(angelVolant);
    }
}
