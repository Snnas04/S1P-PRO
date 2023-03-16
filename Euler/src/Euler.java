import java.util.Arrays;

public class Euler {
    static final int BASE = 100;
	static final int LOGBASE = 2;
	static final int DIGITS = 1000;
	static final int MIDA = 1 + DIGITS / LOGBASE;

	static int[] euler = new int[MIDA];
	static int[] terme = new int[MIDA];

	static void init() {
		Arrays.fill(euler, 0);
		euler[0] = 1;
		Arrays.fill(terme, 0);
		terme[0] = 1;
	}

	public static void main(String[] args) {
		int i, quocient, carry; 
        int denominador = 1;
        int zero = 0;

		init();
        
	    while (zero < MIDA) {
        	carry = 0;
        	for (i = zero; i < MIDA; i++) {
            	quocient = terme[i] + carry * BASE;
            	terme[i] = quocient / denominador;
            	carry = quocient % denominador;
        	}

        	carry = 0;
            for (i = MIDA - 1; (i >= zero) || (carry != 0); i--) {
            	euler[i] += terme[i] + carry;
            	if (euler[i] >= BASE) {
                	euler[i] -= BASE;
                	carry = 1;
            	}
            	else
                	carry = 0;
        	}

        	System.out.println(zero);
        	while ((zero < MIDA) && (terme[zero] == 0))
                zero++;
        	denominador++;
    	}
    	for (i = 0; i < MIDA; i++)
            System.out.format("%0" + LOGBASE + "d", euler[i]);
    	System.out.println();
	}
}
