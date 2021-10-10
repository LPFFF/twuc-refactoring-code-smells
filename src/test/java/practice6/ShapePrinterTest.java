package practice6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapePrinterTest {
    @Test
    void should_return_correct_rectangle_info() {
        ShapePrinter shapePrinter = new ShapePrinter(new Rectangle(10, 20));

        String result = shapePrinter.printRectangleInfo();

        assertEquals("Area: 200, Perimeter: 60", result);
    }
}