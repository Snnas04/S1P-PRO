public class Historia {
    /* empleats */
    Empleat joan = new Empleat();

    /* clients */
    Client pep = new Client();
    Client maria = new Client();
    Client xavier = new Client();

    /* incisos */
    private int incisos = 0;

    public Historia() {
        /* historia del dia 1 */
        introDia1();
        dia1();
        outro();

        /* historia del dia 2 */
        introDia2();
        dia2();
        outro();
    }

    /* dia 1 com a empleat */
    /* Introduccio */
    public void introDia1() {
        System.out.println("Ara meteix ets l'empleat d'una tenda de videojocs");
        System.out.println("Estas a la porta de la tenda 10 min antes de començar el teu horari");
    }

    /* s'ah acabat el dia */
    private void outro() {
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
        Menu menu = new Menu("Que fas?", new String[]{"Entrar", "No entrar"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    joan.Entrar();
                    esperarMostrador();
                    return;
                case 2:
                    joan.Sortir();
                    incisos = 5;
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    /* l'empeat espera al mostrador */
    public void esperarMostrador() {
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
                    incisos = 1;
                    entraClientComprar();
                    return;
                case 2:
                    joan.ColocarProductes();
                    entraClientComprar();
                    incisos = -1;
                    return;
                case 3:
                    joan.ComprarProductes();
                    entraClientComprar();
                    incisos = -1;
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    /* entra un client */
    public void entraClientComprar() {
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
                    
                    incisos = -1;
                    
                    System.out.println("Tornas al mostrador");
                    clientComprar();
                    return;
                case 2:
                    pep.Sortir();
                    incisos = 3;
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
                    entraClientVendre();
                    
                    incisos = -1;
                    
                    return;
                case 2:
                    pep.Comprar();
                    pep.Sortir();
                    entraClientVendre();
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

    /* entren dos clients a vendre els seus productes */
    public void entraClientVendre() {
        System.out.println("\nEntren dos clients amb una capsa amb productes per vendre");
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
                    
                    incisos = -1;
                    
                    return;
                case 2:
                    xavier.Vendre();
                    joan.Comprar();
                    xavier.Sortir();
                    maria.Sortir();

                    incisos = 2;
                    
                    return;
                case 3:
                    discutir();
                default:
                    menu.doNothing();
            }
        }
    }

    private void discutir() {
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

                    incisos = 3;
                    
                    return;
                default:
                    menu.doNothing();
            }
        }
    }


    /* dia 2 com a empleat */
    /* intro */
    public void introDia2() {
        System.out.println("Ets l'empleat de la tenda de videojocs");
        System.out.println("Estas a la porta de la tenda arribant puntual");
        System.out.println("Pero veus que esta obert, entres i t'espera el jefe");
    }

    /* dia 2 */
    public void dia2() {
        if (incisos <= 0) {
            System.out.println("El jefe et dona l'enorabona i t'ascendeix");
            joan.Ascendir();
            segueixTraballant();
        }

        if (incisos == 1) {
            System.out.println("El jefe et diu que has de millorar el teu comportament de cara al public");
            segueixTraballant();
        }

        if (incisos == 2) {
            System.out.println("El jefe et diu que t'has d'implicar més amb la tenda i t'avisa de que si segueixes et despedira");
            segueixTraballant();
        }

        if (incisos == 3) {
            System.out.println("El jefe esta enfadat perque tens un molt mal comportament de cara al public");
            joan.Descendir();
            segueixTraballant();
        }

        if (incisos >= 4) {
            System.out.println("El jefe esta molt enfadat amb el teu comportament i amb el teu comportament");
            joan.Despedir();
            joan.Camina();
            joan.Sortir();
        }
    }

    /* esta darrera el mostrador metres esperea a que entri algun client */
    public void segueixTraballant() {
        System.out.println("Segueixes amb la teva feina metre esperes a que entri algun client");

        Menu menu = new Menu("Que fas?", new String[]{"Mirar es movil", "Colocar els productes", "Comprar productes"});

        int answer = -1;
        while(answer != 0) {
            answer = menu.getOption();
            
            switch (answer) {
                case 1:
                    joan.Esperar();
                    incisos = 1;
                    entraClientComprar();
                    return;
                case 2:
                    joan.ColocarProductes();
                    entraClientComprar();
                    incisos = -1;
                    return;
                case 3:
                    joan.ComprarProductes();
                    entraClientComprar();
                    incisos = -1;
                    return;
                default:
                    menu.doNothing();
            }
        }
    }

}
