public class NumeroComplexe {
    public double real;
    public double imaginari;

    public NumeroComplexe(double real, double imaginari) {
        this.real = real;
        this.imaginari = imaginari;
    }

    public static NumeroComplexe Suma(NumeroComplexe num1, NumeroComplexe num2) {
        double real = num1.real + num2.real;
        double imaginari = num1.imaginari + num2.imaginari;

        return new NumeroComplexe(real, imaginari);
    }

    public static NumeroComplexe Resta(NumeroComplexe num1, NumeroComplexe num2) {
        double real = num1.real - num2.real;
        double imaginari = num1.imaginari - num2.imaginari;

        return new NumeroComplexe(real, imaginari);
    }

    public static NumeroComplexe Multipicar(NumeroComplexe num1, NumeroComplexe num2) {
        double real = num1.real * num2.real - num1.imaginari * num2.imaginari;
        double imaginari = num1.real * num2.imaginari + num1.imaginari * num2.real;

        return new NumeroComplexe(real, imaginari);
    }

    public static NumeroComplexe Division(NumeroComplexe num1, NumeroComplexe num2) {
        double real = (num1.real * num2.real + num1.imaginari * num2.imaginari) / (num2.real * num2.real + num2.imaginari * num2.imaginari);
        double imaginari = (num2.real * num1.imaginari - num1.real * num2.imaginari) / (num2.real * num2.real + num2.imaginari * num2.imaginari);
    
        return new NumeroComplexe(real, imaginari);
    }

    public String toString() {
        return real + " + " + imaginari + "i";
    }
}
