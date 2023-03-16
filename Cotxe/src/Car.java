/**
* The Car class represents a car object with specific characteristics such as brand, model, color, initial price, year, number of kilometers, number of CV, number of doors, and state.
* This class also contains a price calculation method based on the car's characteristics, such as the number of kilometers, state, and years.
* The final price is calculated by applying reductions based on these factors.
*/

public class Car {
    /**
     * Car characteristics
     */
    private String brand;
    private String model;
    private String color;
    private double initialPrice;
    private int year;
    private int numKm;
    private int numCV;
    private int doors;
    private int state; // 0 = bad, 1 = average, 2 = good, 3 = perfect

    /**
    * Constructs a Car object with the specified brand, model, color, initial price, year, number of kilometers, number of CV, number of doors, and state.
    *
    * @param brand the car's brand.
    * @param model the car's model.
    * @param color the car's color.
    * @param initialPrice the car's initial price.
    * @param year the car's year.
    * @param numKm the car's number of kilometers.
    * @param numCV the car's number of CV.
    * @param doors the car's number of doors.
    * @param state the car's state.
    */
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

    /**
    * Returns the characteristics of the car.
    * @return the characteristics of the car.
    */
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

    
    /**
    * Calculates the price of a car based on its initial price, kilometers driven, state, and age.
    *
    * @return the calculated price of the car.
    */
    public double priceCalcul() {
        // reduce price for the kilometers number
        double kmReduction = numKm / 10000.0 * 0.1;
        double kmPrice = initialPrice * (1 - kmReduction);

        // reduce price for the state
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

        // reduce the state for the years
        double yearReduction = year / 10.0 * 0.04;
        double yearPrice = initialPrice * (1 - yearReduction);

        // calcul the price
        double finalPrice =  initialPrice - (kmPrice + statePrice + yearPrice) * 0.1;

        // verify that the price is not less than 80% of the base price
        if (finalPrice < initialPrice * 0.2)
            return initialPrice * 0.2;
        else
            return finalPrice;
    }
}
