## Com iniciar el programa
Per poder iniciar el programa s'ha d'executar l'arxiu [Main](./src/Main.java). Aquest arxiu aplica un tema a tot el programa i inicia l'execució d'aquest.

## LogIn
La classe [LogIn](./src/LogIn.java) és molt senzill, conte un botó de SignUp, per crear un compte, un botó de login, el qual funciona si pressionam la tecla entera o si clicam damunt com qualsevol botó, i un de "reset" que buida els camps a omplir.

Les credencials per defecte són:
- Usuari: admin
- Contrasenya: admin

El camp per emplenar compta amb un boto a la dreta que permete mostrar i amagar la contrasenya.

## SignUp
El [SignUp](./src/SignUp.java) compte mols més camps, ja que serveix per crear comptes, tots els camps són obligatoris, excepte "birthdate". Si seleccionam el país "Espanya" s'afegeixen dos camps, i si despres d'haver seleccionat "Espany" seleccionam un altre pais els dos camps que haviem seleccionat desapareixen.

Els camps que compte la classe SignUp es validen mitjançant una altra classe anomenada Validar.La classe SignUp compte amb dos botons, un de login, aquest una vegada el clicam et retorna a l'apartat de LogIn. I un segon botó, Crear Compte. 

Aquest crea el compte i accedeix a la finestra principal. Aquest darrer botó es pot emprar clicant a damunt o pressionant la tecla enter.

A més els camps contrasenya i repetir contrasenya compten amb un boto que mostra i amaga la contrasenya de forma simultanea en els dos camps.

## Window
La [finestra principal](./src/Window.java) compte amb una barra de menú, la qual té dos apartats, la primera no té cap funció, en canvi, la segona cada una de les opcions et redirigeix a una pàgina web relacionada amb el tema. 

A més compte amb 4 panels, 3 amb una fotografia i el 4 amb un minijoc.La finestra principal del programa també compta amb un botó de logout que demana confirmació i et redirigeix a la finestra principal.

## Validar
La classe [Validar](./src/Validar.java) compte un mètode boolean per cada camp amb una expressió regular, que comprova que les dades introduïdes siguin correctes.

## Minijoc
A la finestra principal del programa hi ha un [minijoc](./src/GuessGamePanel.java), aquest genera un número aleatori entre 0 i 100, el jugador ha d'introduir un número al TestField, i es retornarà un string dient si el número és més gran o més petit del que hem inserit, una vegada s'hagi trobat el número es mostrarà un recompte amb quants d'intents s'han necessitat per trobar el número.

## Llibreries
Totes les lliberies que s'han emprat es troben situades dins la caprpeta lib.

## Imatges
Totes les imatges que s'han emprat es troben situades dins la carpeta img.

Les imatges amb extenció jpg s'han emprat com a fons de pantalla, i les imatges amb extenció png d'icones.

## Maneig de dades
Quan crea el compta a l'aparatat [SignUp](./src/SignUp.java) emagatzema les dades de l'usuari, el nom d'usuari i la contrasenya, ja que no necessitam emprar cap altre tipus de dada. Les dades dels usuaris es troben emagetzemades a un arxiu [credentials.txt](./credenciales.txt).

El [LogIn](./src/LogIn.java) accedeix a l'arxiu [credentials.txt](./credenciales.txt) per compobar que l'usuari existeix i la contrasenya es valida.
