public class Fibarray_Ramon
{
    int places = 1 << 10;
    int termes;

    long[] a = new long[places];
    long[] b = new long[places];

    long base = 1_000_000_000_000_000_000L;

    int baseLog = 18;

    public Fibarray_Ramon(int termes)
    {
        this.termes = termes;

        a[0] = 0L;
        b[0] = 1L;

        for (int i = 2; i <= termes; i++)
        {
            long carry = 0L;

            for (int j = 0; j < places; j++)
            {
                long c = a[j] + b[j] + carry;

                carry = 0L;
                if (c >= base)
                {
                    c -= base;
                    carry = 1L;
                }
                a[j] = b[j];
                b[j] = c;
            }
        }
        int k = places - 1;
        while (b[k--] == 0L);
        System.out.print(b[k + 1]);
        for (int j = k; j >= 0; j--)
            System.out.format("%0" + baseLog + "d", b[j]);
        System.out.println();
    }

    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        new Fibarray_Ramon(500);
        System.out.println(System.currentTimeMillis() - start);
    }
}
