import javax.lang.model.util.ElementScanner14;

public class Historia {
    /* empleats */
    Empleat joan = new Empleat();

    /* clients */
    Client pep = new Client();


    public Historia() {
        intro();
        acctio1();
    }

    public void intro() {
        System.out.println("Ara meteix ets l'empleat d'una tenda de videojocs");
        System.out.println("Estas a la porta de la tenda 10 min antes de començar el teu horari");
        /* cridar al menu */
    }

    /* primera desicio */
    public void acctio1() {
        Menu menu = new Menu("Que fas?", new String[]{"Entrar", "No entrar"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    joan.Entrar();
                    acctio2();
                    return;
                case 2:
                    joan.Sortir();
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    /* si l'empeat ha entrat */
    public void acctio2() {
        System.out.println("\n");
        joan.Camina();
        System.out.println("Vas al mostrador");

        Menu menu = new Menu("Que fas?", new String[]{"Mirar es movil", "Colocar els productes", "Comprar productes"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    joan.Esperar();
                    entraClient();
                    return;
                case 2:
                    joan.ColocarProductes();
                    entraClient();
                    return;
                case 3:
                    joan.ComprarProductes();
                    entraClient();
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    /* entra un client */
    public void entraClient() {
        pep.Entrar();
        pep.Camina();
        pep.Mirar();
        pep.Demanar();

        Menu menu = new Menu("Que fas?", new String[]{"Ajudar", "Ignorar"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    joan.Camina();
                    joan.Ajudar();
                    joan.Camina();
                    System.out.println("Tornas al mostrador");
                    clientComprar();
                    return;
                case 2:
                    pep.Sortir();
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    /* el client va al mostrador per comprar productes */
    public void clientComprar() {
        pep.Camina();
        System.out.println("El client va la mostrador");
        System.out.println("Atens al client. Vol comprar un videojoc");

        Menu menu = new Menu("Que fas?", new String[]{"Demana si es vol registrar", "No demanar res"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    if (pep.targeta = false) {
                        System.out.println("Empeat demana si es vol registrar");
                        System.out.println("El client diu que si");
                        pep.Registar();
                    }
                    else {
                        System.out.println("El client diu que ja esta registrat");
                    }

                    pep.Comprar();
                    pep.Sortir();
                    return;
                case 2:
                    pep.Comprar();
                    pep.Sortir();
                    return;
                default:
                    menu.doNothing();
            }
        }
    }


}
