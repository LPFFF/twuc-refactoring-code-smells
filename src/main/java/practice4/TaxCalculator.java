package practice4;

public class TaxCalculator {

    private static final double ZERO_POINT_ZERO_EIGHT = 0.08;
    private static final double ZERO_POINT_ZERO_TWO = 0.02;
    private static final double ZERO_POINT_ZERO_ZERO_TWO = 0.004;
    private static final double THREE_FOUR_FIVE = 3.45;
    private static final double EIGHT_SEVEN_POINT_THREE_SEVEN = 87.37;
    private static final int NINETY_NINE = 99;

    public double calculateTax(double salary) {
        return salary * (ZERO_POINT_ZERO_EIGHT + ZERO_POINT_ZERO_TWO + ZERO_POINT_ZERO_ZERO_TWO + THREE_FOUR_FIVE) - EIGHT_SEVEN_POINT_THREE_SEVEN * ZERO_POINT_ZERO_EIGHT / NINETY_NINE;
    }
}
