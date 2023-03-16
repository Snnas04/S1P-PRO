public class Fecha {

    int[] dies = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Fecha(String arguments) {
        if (!arguments.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
            System.out.println("");
        }
        else {
            String any = arguments.substring(6);
            int mes = Integer.parseInt(arguments.substring(3, 5));
            int dia = Integer.parseInt(arguments.substring(0, 2));

            if (any.matches("([02468][048]|[13579][26])00|[0-9]{2}(0[48]|[2468][048]|[13579][26])"))
                dies[1] = 29;
            else
                dies[1] = 28;

            if ((mes >= 1 && mes <=12) && (dia >= 1 && dia <= dies[mes - 1]))
                System.out.println("Data correcta ");
            else
                System.out.println("Data incorrecte ");
        }
    }
}
