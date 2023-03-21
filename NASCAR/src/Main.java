public class Main {
    public static void main(String[] args) {
        Cotxe cotxe23 = new Cotxe("Toyota", "TRD Camry", 2022);

        cotxe23.getMarca();
        cotxe23.getModel();

        cotxe23.accelerar(95, 150);
        cotxe23.frenar(245, 20);
        cotxe23.girarVolant(25, -50);

        cotxe23.girarVolant(-25, 50);
        cotxe23.accelerar(225, 10);
        cotxe23.frenar(235, 5);
        cotxe23.girarVolant(25, -40);

        cotxe23.girarVolant(-15, 40);
        cotxe23.accelerar(240, 55);
        cotxe23.frenar(295, 90);
        cotxe23.girarVolant(25, -55);

        cotxe23.girarVolant(-30, 55);
        cotxe23.accelerar(205, 15);
        cotxe23.frenar(220, 10);
        cotxe23.girarVolant(25, -35);
    }
}
