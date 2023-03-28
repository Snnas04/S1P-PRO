public class HistoriaClient {
    /* empleats */
    Empleat angel = new Empleat("Angel");

    /* clients */
    Client carlos = new Client("Carlos");

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
        intro();
        compra1();
    }

    private void intro() {
        System.out.println("Ets un nou client per a la tenda");
        carlos.Entrar();
    }

    private void compra1() {
        System.out.println("HAs entrat a la tenda");

        Menu menu = new Menu("A quina seccion vas?", new String[]{"Videojocs", "Accessoris", "Periferics"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    carlos.Camina();
                    carlos.Mirar();
                    mirarVideojocs();
                    return;
                case 2:
                    carlos.Camina();
                    carlos.Mirar();
                    mirarAcessoris();
                    return;
                case 3:
                    carlos.Camina();
                    carlos.Mirar();
                    mirarPeriferics();
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    private void mirarVideojocs() {
        
    }

    private void mirarAcessoris() {

    }

    private void mirarPeriferics() {

    }


}
