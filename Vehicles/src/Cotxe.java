public abstract class Cotxe implements Vehicle {
    private int velocitat;
    private int angelVolant;
    private int quantitat;

    private String marca;
    private String model;
    private int any;

    public Cotxe(String marca, String model, int any) {
        this.marca = marca;
        this.model = model;
        this.any = any;
    }

    public void getMarca() {
        System.out.println(marca);
    }

    public void getModel() {
        System.out.println(model);
    }

    public void getAny() {
        System.out.println(any);
    }


    public void accelerar(int quantitat) {
        this.velocitat += quantitat;
        System.out.println(velocitat);
    }

    public void frenar(int quantitat) {
        this.velocitat -= quantitat;
        System.out.println(velocitat);
    }

    public void girarVolant(int angelVolant) {
        System.out.println(angelVolant);
    }
}
