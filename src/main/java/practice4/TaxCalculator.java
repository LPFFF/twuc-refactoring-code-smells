package practice4;

public class TaxCalculator {
    public double calculateTax(double salary) {
        return salary * (0.08 + 0.02 + 0.004 + 3.45) - 87.37 * 0.08 / 99;
    }
}
