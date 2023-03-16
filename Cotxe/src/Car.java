public class Car {
    // Atributs d'un cotxe
    private String brand;
    private String model;
    private String color;
    private double initialPrice;
    private int year;
    private int numKm;
    private int numCV;
    private int doors;
    private int state;

    // Constructor
    public Car(String brand, String model, String color, double initialPrice, int year, int numKm, int numCV, int doors, int state) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.initialPrice = initialPrice;
        this.year = year;
        this.numKm = numKm;
        this.numCV = numCV;
        this.doors = doors;
        this.state = state;
    }

    // Metodes
    // caracteristiques del cotxe
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public double getPrice() {
        return Double.parseDouble(String.format("%.2f", priceCalcul()));
    }
    
    public int getYear() {
        return year;
    }

    public double getNumKm() {
        return numKm;
    }

    public int getNumCV() {
        return numCV;
    }

    public int getDoors() {
        return doors;
    }

    public int getState() {
        return state;
    }

    
    // Calcular el pru del cotxe
    public double priceCalcul() {
        // preu a reduir per km
        double kmReduction = numKm / 10000.0 * 0.1;
        double kmPrice = initialPrice * (1 - kmReduction);

        // preu a reduir per l'state
        double stateReduction;
        if (state == 0)
            stateReduction = 0.2;
        else if (state == 1)
            stateReduction = 0.1;
        else if (state == 2)
            stateReduction = 0.05;
        else
            stateReduction = 0.0;
        
        double statePrice = initialPrice * (1 - stateReduction);

        // preu a reduir per l'antiguitat
        double yearReduction = year / 10.0 * 0.04;
        double yearPrice = initialPrice * (1 - yearReduction);

        // calcular el preu de venta
        double finalPrice =  initialPrice - (kmPrice + statePrice + yearPrice) * 0.1;

        // comprovar que el preu de venta no sigui menys del 80% del preu base
        if (finalPrice < initialPrice * 0.2)
            return initialPrice * 0.2;
        else
            return finalPrice;
    }
}
