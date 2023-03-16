import java.util.Arrays;

public class Euler_Ramon {
	static final int BASE = 10;
	static final int LOGBASE = 1;
	static final int DIGITS = 100;
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
		int i, c, d = 1, q, z = 0;

		init();
	    while (z < MIDA) {
        	c = 0;
        	for (i = z; i < MIDA; i++) {
            	q = terme[i] + c * BASE;
            	terme[i] = q / d;
            	c = q % d;
        	}
            
        	c = 0;
            for (i = MIDA - 1; (i >= z) || (c != 0); i--) {
            	euler[i] += terme[i] + c;
            	if (euler[i] >= BASE) {
                	euler[i] -= BASE;
                	c = 1;
            	}
            	else
                	c = 0;
        	}

        	System.out.println(z);
        	while ((z < MIDA) && (terme[z] == 0))
                z++;
        	d++;
    	}
    	for (i = 0; i < MIDA; i++)
            System.out.print(euler[i]);
    	System.out.println();
	}
}
