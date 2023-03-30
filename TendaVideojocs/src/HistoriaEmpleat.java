public class HistoriaEmpleat {
    /* empleats */
    Empleat joan = new Empleat("Joan");
    Empleat xisca = new Empleat("Xisca");

    /* clients */
    Client pep = new Client("Pep", false);
    Client maria = new Client("Maria", false);
    Client xavier = new Client("Xavier", false);
    Client ruben = new Client("Ruben", false);
    Client andreu = new Client("Andreu", false);

    /* incisos */
    private int incisosJoan = 0;
    private int incisosXisca = 0;

    private boolean ferFeina;

    public HistoriaEmpleat() {
        /* historia del dia 1 */
        introDia1();
        dia1();
        if (ferFeina == true) {
            outro();
        }

        /* historia del dia 2 */
        introDia2();
        dia2();
        if (ferFeina == true) {
            outro();
        }
    }



    /* dia 1 com a empleat */
    /* Introduccio */
    public void introDia1() {
        System.out.println("Ara meteix ets l'empleat d'una tenda de videojocs");
        System.out.println("Estas a la porta de la tenda 10 min antes de començar el teu horari");
    }

    /* s'ah acabat el dia */
    private void outro() {
        System.out.println("\n------------------------------");       
        System.out.println("Ja has fet totes les hores que et tocaben aquest dia");

        Menu menu = new Menu("Que fas?", new String[]{"Anar a casa", "Revisar els productes de la tenda"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    joan.Camina();
                    joan.Sortir();
                    return;
                case 2:
                    System.out.println("L'empeat mira revisa que els productes de la tenda estiiguin ben colocats");
                    joan.Camina();
                    joan.Sortir();
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    /* dia 1 */
    public void dia1() {
        System.out.println("\n------------------------------");

        Menu menu = new Menu("Que fas?", new String[]{"Entrar", "No entrar"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    joan.Entrar();
                    esperarMostrador();
                    ferFeina = true;
                    return;
                case 2:
                    joan.Sortir();
                    incisosJoan += 5;
                    ferFeina = false;
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    /* l'empeat espera al mostrador */
    public void esperarMostrador() {
        System.out.println("\n------------------------------");

        joan.Camina();
        System.out.println("Vas al mostrador");

        Menu menu = new Menu("Que fas?", new String[]{"Mirar es movil", "Colocar els productes", "Comprar productes"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    joan.Esperar();
                    incisosJoan += 1;
                    entraClientComprarDia1();
                    return;
                case 2:
                    joan.ColocarProductes();
                    entraClientComprarDia1();
                    incisosJoan += -1;
                    return;
                case 3:
                    joan.ComprarProductes();
                    entraClientComprarDia1();
                    incisosJoan += -1;
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    /* entra un client */
    public void entraClientComprarDia1() {
        System.out.println("\n------------------------------");

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
                    
                    incisosJoan += -1;
                    
                    System.out.println("Tornas al mostrador");
                    clientComprar();
                    return;
                case 2:
                    pep.Sortir();
                    incisosJoan += 3;
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    /* el client va al mostrador per comprar productes */
    public void clientComprar() {
        System.out.println("\n------------------------------");

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
                    entraClientVendreDia1();
                    
                    incisosJoan += -1;
                    
                    return;
                case 2:
                    pep.Comprar();
                    pep.Sortir();
                    entraClientVendreDia1();
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    /* entren dos clients a vendre els seus productes */
    public void entraClientVendreDia1() {
        System.out.println("\n------------------------------");

        System.out.println("Entren dos clients amb una capsa amb productes per vendre");
        maria.Entrar();
        xavier.Entrar();
        System.out.println("Els dos clients caminen fins al mostrador i volen vendre la capsa de prooductes");

        joan.Mirar();
        System.out.println("Veus que hi ha 10 productes, en bon estat");

        Menu menu = new Menu("Que fas?", new String[]{"Consultar la base de dades i proporcionar un preu", "Deduir el preu del productes(tirant per lo alt)", "Deduir el preu dels productes(tirant per lo baix)"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    System.out.println("Empleat diu un preu coerent i raonamble");
                    xavier.Vendre();
                    joan.Vendre();
                    xavier.Sortir();
                    maria.Sortir();
                    
                    incisosJoan += -1;
                    
                    return;
                case 2:
                    xavier.Vendre();
                    joan.Comprar();
                    xavier.Sortir();
                    maria.Sortir();

                    incisosJoan += 2;
                    
                    return;
                case 3:
                    discutirDia1();
                default:
                    menu.doNothing();
            }
        }
    }

    private void discutirDia1() {
        System.out.println("\n------------------------------");

        System.out.println("El client no li agrada el preu i demana més pels productes");
        System.out.println("El client proposa un preu");

        Menu menu = new Menu("Que fas?", new String[]{"Acceptes", "Rebutjes"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    xavier.Vendre();
                    joan.Comprar();
                    xavier.Sortir();
                    maria.Sortir();
                    return;
                case 2:
                    xavier.Sortir();
                    maria.Sortir();
                    joan.Esperar();

                    incisosJoan += 3;
                    
                    return;
                default:
                    menu.doNothing();
            }
        }
    }


    /* dia 2 com a empleat */
    /* intro */
    public void introDia2() {
        System.out.println("\n------------------------------");

        System.out.println("Ets l'empleat de la tenda de videojocs");
        System.out.println("Estas a la porta de la tenda arribant puntual");
        System.out.println("Pero veus que esta obert, entres i t'espera el jefe");
    }

    /* dia 2 */
    public void dia2() {
        System.out.println("\n------------------------------");

        if (incisosJoan <= 0) {
            System.out.println("El jefe et dona l'enorabona i t'ascendeix");
            joan.Ascendir();
            segueixTraballant();
        }

        if (incisosJoan == 1) {
            System.out.println("El jefe et diu que has de millorar el teu comportament de cara al public");
            segueixTraballant();
        }

        if (incisosJoan == 2) {
            System.out.println("El jefe et diu que t'has d'implicar més amb la tenda i t'avisa de que si segueixes et despedira");
            segueixTraballant();
        }

        if (incisosJoan == 3) {
            System.out.println("El jefe esta enfadat perque tens un molt mal comportament de cara al public");
            joan.Descendir();
            segueixTraballant();
        }

        if (incisosJoan >= 5) {
            System.out.println("El jefe esta molt enfadat amb el teu comportament");
            joan.Despedir();
            joan.Camina();
            joan.Sortir();
            contratarNouTraballador();
        }
    }

    public void contratarNouTraballador() {
        System.out.println("\n------------------------------");

        System.out.println("El jefe contrata un nou traballador");
        System.out.println("Ara ets un nou traballador");
        System.out.println("Has arribat puntual");

        Menu menu = new Menu("Que fas?", new String[]{"Entrar", "Sortir"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    xisca.Entrar();
                    esperarMostradorDia2();
                    ferFeina = true;
                    return;
                case 2:
                    xisca.Sortir();
                    incisosJoan += 1;
                    ferFeina = false;
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    public void esperarMostradorDia2() {
        System.out.println("\n------------------------------");

        xisca.Camina();

        Menu menu = new Menu("Que fas?", new String[]{"Mirar es movil", "Colocar els productes", "Comprar productes"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    xisca.Esperar();
                    incisosXisca += 1;
                    entraClientVendreDia2();
                    return;
                case 2:
                    xisca.ColocarProductes();
                    entraClientVendreDia2();
                    incisosXisca += -1;
                    return;
                case 3:
                    xisca.ComprarProductes();
                    entraClientVendreDia2();
                    incisosXisca += -1;
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    public void entraClientVendreDia2() {
        System.out.println("\n------------------------------");

        andreu.Entrar();
        System.out.println("Entra un client amb una capsa per vendra 3 productes");

        xisca.Mirar();
        System.out.println("Veus que hi ha 3 productes, en estat mig");

        Menu menu = new Menu("Que fas?", new String[]{"Consultar la base de dades i proporcionar un preu", "Deduir el preu del productes(tirant per lo alt)", "Deduir el preu dels productes(tirant per lo baix)"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    System.out.println("Empleat diu un preu coerent i raonamble");
                    andreu.Vendre();
                    xisca.Vendre();
                    andreu.Sortir();
                    
                    incisosXisca += -1;
                    
                    return;
                case 2:
                    andreu.Vendre();
                    xisca.Comprar();
                    andreu.Sortir();

                    incisosXisca += 2;
                    
                    return;
                case 3:
                    discutirDia2();
                default:
                    menu.doNothing();
            }
        }
    }

    private void discutirDia2() {
        System.out.println("\n------------------------------");

        System.out.println("El client no li agrada el preu i demana més pels productes");
        System.out.println("El client proposa un preu");

        Menu menu = new Menu("Que fas?", new String[]{"Acceptes", "Rebutjes"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    andreu.Vendre();
                    xisca.Comprar();
                    andreu.Sortir();
                    return;
                case 2:
                    andreu.Sortir();
                    xisca.Esperar();

                    incisosXisca += 3;
                    
                    return;
                default:
                    menu.doNothing();
            }
        }
    }
    

    /* esta darrera el mostrador metres esperea a que entri algun client */
    public void segueixTraballant() {
        ferFeina = true;

        System.out.println("\n------------------------------");

        System.out.println("Segueixes amb la teva feina metre esperes a que entri algun client");

        Menu menu = new Menu("Que fas?", new String[]{"Mirar es movil", "Colocar els productes", "Comprar productes"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    joan.Esperar();
                    incisosJoan += 1;
                    entraClientComprarDia2();
                    return;
                case 2:
                    joan.ColocarProductes();
                    entraClientComprarDia2();
                    incisosJoan += -1;
                    return;
                case 3:
                    joan.ComprarProductes();
                    entraClientComprarDia2();
                    incisosJoan += -1;
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    public void entraClientComprarDia2() {
        System.out.println("\n------------------------------");

        System.out.println("Entra un clint a la tenda");
        ruben.Entrar();
        ruben.Camina();
        ruben.Mirar();

        Menu menu = new Menu("Que fas?", new String[]{"Mirar es movil", "Colocar els productes", "Caminar per la tenda"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    System.out.println("L'empleat mira el movil");
                    incisosJoan += 1;
                    clientComprarDia2();
                    return;
                case 2:
                    System.out.println("L'empleat coloca nous productes");
                    incisosJoan += -1;
                    clientComprarDia2();
                    return;
                case 3:
                    joan.Camina();
                    clientComprarDia2();
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    public void clientComprarDia2() {
        System.out.println("\n------------------------------");

        System.out.println("El client ha agafat dos productes i es dirigeix al mostrador");
        System.out.println("El client posa els porductes damunt el mostrador");

        Menu menu = new Menu("Que fas?", new String[]{"Demana si es vol registrar", "No demanar res"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    if (andreu.targeta = false) {
                        System.out.println("Empeat demana si es vol registrar");
                        System.out.println("El client diu que si");
                        andreu.Registar();
                    }
                    else {
                        System.out.println("El client diu que ja esta registrat");
                    }

                    andreu.Comprar();
                    andreu.Sortir();
                    
                    incisosJoan += -1;
                    
                    return;
                case 2:
                    andreu.Comprar();
                    andreu.Sortir();
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

}
