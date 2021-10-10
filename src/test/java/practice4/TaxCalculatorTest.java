package practice4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {
    @Test
    void should_return_correct_tax_for_salary_100() {
        assertEquals(355.329397979798, new TaxCalculator().calculateTax(100));
    }

    @Test
    void should_return_correct_tax_for_salary_200() {
        assertEquals(710.729397979798, new TaxCalculator().calculateTax(200));
    }
}
