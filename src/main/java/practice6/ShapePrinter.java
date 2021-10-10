package practice6;

public class ShapePrinter {
    public final Rectangle rectangle;

    public ShapePrinter(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public String printRectangleInfo() {
        int area = rectangle.getHeight() * rectangle.getWidth();
        int perimeter = (rectangle.getHeight() + rectangle.getWidth()) * 2;

        return String.format("Area: %s, Perimeter: %s", area, perimeter);
    }
}
