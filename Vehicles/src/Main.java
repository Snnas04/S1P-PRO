public class Main {
    public static void main(String[] args) {
        Nascar ford55 = new Nascar("Ford", "mustang", 2022);
        GT3 porche91 = new GT3("Porche", "992 GT3 R", 2019);
        SuperBike BMW24 = new SuperBike("BMW", "M1000RR", 2023);

        
        ford55.getMarca();
        ford55.getModel();

        ford55.accelerar(250);
        ford55.frenar(20);
        ford55.girarVolant(-25);

        ford55.girarVolant(25);
        ford55.accelerar(225);
        ford55.frenar(5);
        ford55.girarVolant(-20);

        ford55.girarVolant(20);
        ford55.accelerar(295);
        ford55.frenar(90);
        ford55.girarVolant(30);

        ford55.girarVolant(-30);
        ford55.accelerar(220);
        ford55.frenar(10);
        ford55.girarVolant(-15);


        System.out.println("\n");
        porche91.getMarca();
        porche91.getModel();

        porche91.accelerar(250);
        porche91.frenar(20);
        porche91.girarVolant(-25);

        porche91.girarVolant(25);
        porche91.accelerar(225);
        porche91.frenar(5);
        porche91.girarVolant(-20);

        porche91.girarVolant(20);
        porche91.accelerar(255);
        porche91.frenar(90);
        porche91.girarVolant(30);

        porche91.girarVolant(-30);
        porche91.accelerar(220);
        porche91.frenar(10);
        porche91.girarVolant(-15);


        System.out.println("\n");
        BMW24.getMarca();
        BMW24.getModel();

        BMW24.accelerar(310);
        BMW24.frenar(40);
        BMW24.girarVolant(-50);

        BMW24.girarVolant(50);
        BMW24.accelerar(225);
        BMW24.frenar(15);
        BMW24.girarVolant(-40);

        BMW24.girarVolant(40);
        BMW24.accelerar(330);
        BMW24.frenar(100);
        BMW24.girarVolant(-35);

        BMW24.girarVolant(35);
        BMW24.accelerar(220);
        BMW24.frenar(10);
        BMW24.girarVolant(-15);
    }
}
