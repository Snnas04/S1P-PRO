## Classe Main

La classe principal és el punt d'entrada al programa. Crea una matriu d'objectes Car i inicia el menú principal.


## Classe Car

La classe Car representa un objecte car amb diferents característiques específiques (marca, model, color, preu inicial, any, nombre de quilòmetres, nombre de CV, nombre de portes i estat).

Aquesta classe també conté un mètode de càlcul de preus basat en algunes característiques (quilòmetres, estat i anys) del cotxe. El preu final es calcula aplicant reduccions en funció d'aquests factors.


## Classe Info

La classe Info proporciona mètodes per mostrar informació sobre cotxes, comparar dos cotxes i mostrar tots els que hi ha cotxes.
El metodo ShowInfo crea un arxiu "Info-[car].txt" dins la carpeta "Information".
El metodo ShowComparation crea un arxiu "Comparacio-[car]_[car].txt" dins la carpeta "Comparation".


## Classe Menu

La classe menu representa un menú amb opcions per gestionar un sistema de venda de cotxes de segona mà.
El menú es mostra a la consola i l'usuari pot seleccionar una opció introduint un número.
Les opcions disponibles són:
    - Informació del cotxe: mostra informació sobre un cotxe específic.
    - Comparació: permet a l'usuari comparar dos cotxes.
    - Veure cotxes: mostra una llista de tots els cotxes disponibles.
    - Sortir: surt del programa.
