public class Selector {
    public Selector() {
        Menu menu = new Menu("Quina historia vols viure?", new String[]{"Empleat", "Client"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    new HistoriaEmpleat();
                    return;
                case 2:
                    new HistoriaClient();
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

}
