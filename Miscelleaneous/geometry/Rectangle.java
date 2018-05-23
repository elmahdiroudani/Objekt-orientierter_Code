package geometry;
/**
 * This class represents a rectangle which uses the interface geometry 
 * for the geometrical objects.
 * @author R3V€4LeD
 */
public class Rectangle implements Geometry {
    /**
     * The rectangle's length.
     */
    private double length;
    /**
     * The rectangle's width.
     */
    private double width;
    /**
     * Creates a rectangle with a length and a width.
     * @param length the rectangle's length
     * @param width the rectangle's width
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public void scale(int factor) {
        this.length = this.length * factor;
        this.width = this.width * factor;
    }
    @Override
    public double getCircumference() {
        return 2 * this.length + 2 * this.width;
    }
}
