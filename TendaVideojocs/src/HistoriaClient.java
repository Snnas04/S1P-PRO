public class HistoriaClient {
    /* empleats */
    Empleat angel = new Empleat("Angel");

    /* clients */
    Client carlos = new Client("Carlos", false);

    /* videojocs */
    Videojocs[] videojoc = new Videojocs[] {
        new Videojocs("GTA V"),
        new Videojocs("Rainbow Six Siege"),
        new Videojocs("The Last of Us II"),
        new Videojocs("Far Cry 6"),
        new Videojocs("God of War Ragnarok")
    };

    /* accessoris */
    Accessoris[] accessori = new Accessoris[] {
        new Accessoris("Peluche 1"),
        new Accessoris("Coixi"),
        new Accessoris("Figura 1"),
        new Accessoris("Figura 2"),
        new Accessoris("Figura 3")
    };


    /* periferics */
    Periferics[] periferic = new Periferics[] {
        new Periferics("Monitor"),
        new Periferics("Teclat"),
        new Periferics("Ratoli"),
        new Periferics("Estoreta"),
        new Periferics("Cadira")
    };


    public HistoriaClient() {
        introDia1();
        accedirSeccio();
    }

    private void introDia1() {
        System.out.println("Ets un nou client per a la tenda");
        carlos.Entrar();
    }

    private void accedirSeccio() {
        System.out.println("Estas dins la tenda");

        Menu menu = new Menu("A quina seccion vas?", new String[]{"Videojocs", "Accessoris", "Periferics"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    carlos.Camina();
                    carlos.Mirar();
                    mirarVideojocs();
                    accioProducte();
                    return;
                case 2:
                    carlos.Camina();
                    carlos.Mirar();
                    mirarAcessoris();
                    accioProducte();
                    return;
                case 3:
                    carlos.Camina();
                    carlos.Mirar();
                    mirarPeriferics();
                    accioProducte();
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    private void mirarVideojocs() {
        System.out.println("------------------------------");
        System.out.println("VIDEOJOCS");
        System.out.println("------------------------------");
        for (int producNum = 0; producNum < videojoc.length; producNum++) {
            System.out.format("\n%-20s\n", videojoc[producNum].getNom());
            System.out.println("------------------------------");
        }
    }

    private void mirarAcessoris() {
        System.out.println("------------------------------");
        System.out.println("ACCESSORIS");
        System.out.println("------------------------------");
        for (int producNum = 0; producNum < accessori.length; producNum++) {
            System.out.format("\n%-20s\n", accessori[producNum].getNom());
            System.out.println("------------------------------");
        }
    }

    private void mirarPeriferics() {
        System.out.println("------------------------------");
        System.out.println("PERIFERICS");
        System.out.println("------------------------------");
        for (int producNum = 0; producNum < periferic.length; producNum++) {
            System.out.format("\n%-20s\n", periferic[producNum].getNom());
            System.out.println("------------------------------");
        }
    }

    private void accioProducte() {
        Menu menu = new Menu("Que fas?", new String[]{"Agafar un prducte", "Anar a un altra secció", "Agafa un producte i anar a una altra secció", "Sortir de la tenda"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    carlos.Agafar();
                    carlos.Camina();
                    anarMostrador();
                    return;
                case 2:
                    carlos.Camina();
                    carlos.Mirar();
                    accedirSeccio();
                    return;
                case 3:
                    carlos.Agafar();
                    carlos.Camina();
                    carlos.Mirar();
                    accedirSeccio();
                    return;
                case 4:
                    carlos.Camina();
                    carlos.Sortir();
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    private void anarMostrador() {
        System.out.println("El client esta al mostrador a punt de pagar");

        if (carlos.targeta == false) {
            Menu menu = new Menu("Que fas?", new String[]{"Pagar", "Demanar per Registrarte"});

            int answer = -1;
            while(answer != 0) {
                answer = menu.getOption();
                
                switch (answer) {
                    case 1:
                        carlos.Comprar();
                        angel.Vendre();
                        carlos.Sortir();
                        return;
                    case 2:
                        carlos.Registar();
                        carlos.Comprar();
                        angel.Vendre();
                        carlos.Sortir();
                        return;
                    default:
                        menu.doNothing();
                }
            }
        }
        else {
            System.out.println("------------------------------");
            carlos.Comprar();
            angel.Vendre();
        }        
        carlos.Sortir();
    }

}
