public class HistoriaClient {
    /* empleats */
    Empleat angel = new Empleat("Angel");

    /* clients */
    Client carlos = new Client("Carlos");

    /* videojocs */
    

    /* accessoris */


    /* periferics */



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
