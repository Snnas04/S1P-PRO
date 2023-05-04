import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validar {
    public static boolean validarUsername(String text) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]{3,12}$");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean validarName(String text) {
        Pattern pattern = Pattern.compile("^[a-zA-ZÁ-ú\\s]{2,25}$");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean validarSurname(String text) {
        Pattern pattern = Pattern.compile("^[a-zA-ZÁ-ú\\s]{2,25}$");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean validarEmail(String text) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{3,30}@[a-z]{3,30}\\.[a-z]{2,6}$");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean validarPhone(String text) {
        Pattern pattern = Pattern.compile("^(?:\\+34|0034|34)?[6789]\\d{8}$");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean validarZipcode(String text) {
        Pattern pattern = Pattern.compile("^(?:0[1-9]|[1-4]\\d|5[0-2])\\d{3}$");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean validarPass(String text) {
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[\\W_]).{8,}$");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}
