public class Operacion {
    //Numero reinas
    private final int numReina=20;
    private int[][] tablero= new int[numReina][numReina];;

    String letras[]= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    
    public void imprimirBis() {
        // Imprime cabecera
        System.out.print("   ");
            
        for (int i = 0; i < numReina; i++) {
            System.out.print(" " + letras[i] + "     ");
        }
            
        System.out.print("\n");
            
        // Imprime tablero - filas 0 a (numReina - 1)
        for (int i = 0; i < numReina; i++) {
                
            // Imprime índice de fila
            System.out.print((i + 1));
                
            // Imprime fila i - Columnas 0 a (numReina - 1)
            for (int j = 0; j < numReina; j++) {
                System.out.print("   " + tablero[i][j] + "   ");
            }
                
            System.out.print("\n\n");
        }       
    }

    public boolean posicionVerdadera(int fila, int columna) {
        
        //verificar que fila actual sea segura, verificando cada columna de esta
        for (int j = 0; j < columna; j++) 
            if (tablero[fila][j]==1) 
                return false; 

        //verifica diagonal superior del lado izquierdo sea segura
        for (int i=fila, j=columna; i>=0 && j>=0; i--, j--) 
            if (tablero[i][j]==1) 
                return false; 

        //verifica diagonal inferior del lado izquierdo sea segura
        for (int i=fila, j=columna; j>=0 && i<numReina; i++, j--) 
            if (tablero[i][j]==1) 
                return false; 

        //verifica que no hayan atacantes ni en sus lados, ni en sus diagonales
        return true; 
        
        
    }

    public boolean solucion(int columna) {
        //Caso base: si la solucion es la correcta
        if (columna >=numReina) {
            return true;
        }
        //Se considera la columna actual como una posible solución y se verifica
        for (int i = 0; i < numReina; i++) {
            //verifica si se puede colocar  en el tablero[i][columna]
            if (posicionVerdadera(i, columna)) {
                
                tablero[i][columna]=1;
                //se invoca la funcion recursiva para dar solucion  a ls demad reinas del tablero
                if (solucion(columna+1)) {
                    
                    return true;
                }
                
                tablero[i][columna]=0;
                
            }   
        }
        //si no hay solucion la renia puede se colocada en ninguna fila de esta columna
        return false;
    }

    public boolean inicializar() {
        
        if (solucion(0)==false) {
            System.out.println("No Hay solucion");
            return false;
        }
        imprimirBis();
        
        return true;
    }

    public static void main(String[] args) {
        Operacion reina = new Operacion();
        reina.inicializar();
    }
}
