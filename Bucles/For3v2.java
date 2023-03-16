package Bucles;

//vercio millorada de For3
public class For3v2 {
    public static void main(String[] args) {
        //for (int i = 1; i < 100; i++) {
        //    if (i % 2 == 0) {
        //        System.out.println(i);
        //    }

        //    if (i % 3 == 0) {
        //        System.out.println(i);
        //    }
        //}

        for (int i = 1; i < 100; i++) {
           if ((i % 2 == 0) || (i % 3 == 0)) {
               System.out.println(i);
           }
        }
    }
}
