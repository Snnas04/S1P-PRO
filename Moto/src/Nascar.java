public class Nascar {
    private String marca;
    private String model;
    private int any;

    public Nascar(String marca, String model, int any) {
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
}
