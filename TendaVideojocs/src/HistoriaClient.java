public class HistoriaClient {
    /* Tendes */
    Tenda GAME = new Tenda("GAME", "10:00 - 15:00 / 16:00 - 22:00");
    Tenda FNAC = new Tenda("FANC", "09:30 - 14:30 / 16:30 - 13:00");

    /* empleat */
    Empleat angel = new Empleat("Angel");

    /* client */
    Client carlos = new Client("Carlos", false);

    /* videojocs */
    Videojocs[] videojoc = new Videojocs[] {
        new Videojocs("GTA V", 50.45),
        new Videojocs("Rainbow Six Siege", 24.95),
        new Videojocs("The Last of Us II", 62.00),
        new Videojocs("Far Cry 6", 69.95),
        new Videojocs("God of War Ragnarok", 64.90)
    };

    /* accessoris */
    Accessoris[] accessori = new Accessoris[] {
        new Accessoris("Peluche 1", 14.95),
        new Accessoris("Coixi", 9.95),
        new Accessoris("Figura 1", 34.95),
        new Accessoris("Figura 2", 40.50),
        new Accessoris("Figura 3", 28.90)
    };


    /* periferics */
    Periferics[] periferic = new Periferics[] {
        new Periferics("Monitor", 209.95),
        new Periferics("Teclat", 74.95),
        new Periferics("Ratoli", 28.50),
        new Periferics("Estoreta", 19.95),
        new Periferics("Cadira", 279.95)
    };


    public HistoriaClient() {
        triarTenda();
    }

    /* Podem triar entre dues tendes */
    private void triarTenda() {
        System.out.println("\n------------------------------");

        System.out.println("Ara ets un client, tens ganes de comprar algun producte relacionat amb els videojocs");
        System.out.println("Cerques per internet i trobes que hi ha dues tendes de videojocs que et poden interesar");
        System.out.format("\n%-6s %5s\n", FNAC.getNom(), FNAC.getHorari());
        System.out.format("\n%-6s %5s\n", GAME.getNom(), GAME.getHorari());
        
        Menu menu = new Menu("A quina tenda vols anar?", new String[]{"GAME", "FNAC", "Quedar a casa"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    intro();
                    accedirSeccio();
                    return;
                case 2:
                    intro();
                    accedirSeccio();
                    return;
                case 3:
                    System.out.println("El client no surt de caseva i se queda jugant");
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    /* introduccio del client */
    private void intro() {
        System.out.println("Ets un nou client per a la tenda");
        carlos.Entrar();
    }

    /* podem triar a quina seccio de la tenda volem accedir
     * tenim tres opcion
     */
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

    /* mostar els vidojocs que te la tenda */
    private void mirarVideojocs() {
        System.out.println("------------------------------");
        System.out.println("VIDEOJOCS");
        System.out.println("------------------------------");
        for (int producNum = 0; producNum < videojoc.length; producNum++) {
            System.out.format("\n%-20s - %5s\n", videojoc[producNum].getNom(), videojoc[producNum].getPreu());
            System.out.println("------------------------------");
        }
    }

    /* mostar els accessoris que te la tenda */
    private void mirarAcessoris() {
        System.out.println("------------------------------");
        System.out.println("ACCESSORIS");
        System.out.println("------------------------------");
        for (int producNum = 0; producNum < accessori.length; producNum++) {
            System.out.format("\n%-20s - %5s\n", accessori[producNum].getNom(), accessori[producNum].getPreu());
            System.out.println("------------------------------");
        }
    }

    /* mostar els periferics que te la tenda */
    private void mirarPeriferics() {
        System.out.println("------------------------------");
        System.out.println("PERIFERICS");
        System.out.println("------------------------------");
        for (int producNum = 0; producNum < periferic.length; producNum++) {
            System.out.format("\n%-20s - %5s\n", periferic[producNum].getNom(), periferic[producNum].getPreu());
            System.out.println("------------------------------");
        }
    }

    /* quan estem a una secció podem fer 5 accions */
    private void accioProducte() {
        Menu menu = new Menu("Que fas?", new String[]{"Agafar un prducte", "Anar a un altra secció", "Agafa un producte i anar a una altra secció", "Demanar ajuda", "Sortir de la tenda"});

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
                    carlos.Demanar();
                    angel.Camina();
                    angel.Ajudar();
                    accioProducte();
                    return;
                case 5:
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
