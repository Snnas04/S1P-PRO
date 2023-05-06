## Com iniciar el programa
Per poder iniciar el programa me d'executar l'arxiu [Main](./src/Main.java).  Aquest arxiu alica un tema a tot el programa i inicia l'execució d'aquest.

## LogIn
La classe [LogIn](./src/LogIn.java) es molt senzill, conte un boto de SignUp, per crear un compte, un boto de login, el qual funciona si pressionam la tecla enter o si clicam demaunt com cualsevol boto, i un de reset que buida els camps a rellenar.

## SignUp
El [SignUp](./src/SignUp.java) conte mols més camps, ja que serveix per crear comptes, tots els camps son obligatoris, execpte birthdate. Si seleccionam el pais "Espanya" s'afageixen dos camps.

Els camps que compte la classe SignUp es validen mitjanasant una altra classe anomenda Validar.

La classe SignUp compte amb dos botons, un de login, aquest una vegada el clicam et retorna a l'apartat de LogIn. I un segon boto, Crear Compte. Aquest crea el compte i accedeix a la finestra principal. Aquest darrer boto es pot empra clicant a damunt o pressionant la tecla enter.

## Window
La [finestra](./src/Window.java) compte amb una barra de menu, la qual te dos apartats, la primera no te cap funció, en canvi la segona cada una de les opcions et redirigeix a una pagina web realcionada amb el tema. A més compte amb 4 panels, 3 amb una fotografia i el 4 amb un minijoc.

La finestr principal del programa tambe compta amb un boto de logout que demana confirmació i et redirigeix a la finesrtra principal.

## Validar
La classe [Validar](./src/Validar.java) compte un metode boolean per cada camp amb una expressio regualr, que comprova que les dades introduides siguin correctes.

## Minijoc
A la fonsetra principal del programa hi ha un [minijoc](./src/GuessGamePanel.java), aquest genera un numero aleatori entre 0 i 100, el jugador ha d'introduir un numero al TestField, i es tetornara un string diguent si el numero es més gran o més petit d'el que hem incerit, una vegada s'hagui trobat el numro es mostrara un recompte amb quants d'intents s'han necessitat per trobar el numero.
