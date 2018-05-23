package geometry;
/**
 * This class represents a triangle which uses the interface geometry 
 * for the geometrical objects.
 * @author R3V€4LeD
 */
public class Triangle implements Geometry {
    /**
     * The triangle's side a.
     */
    private double a;
    /**
     * The triangle's side b.
     */
    private double b;
    /**
     * The triangle's side c.
     */
    private double c;
    /**
     * Creates a triangle with three sides.
     * @param a the triangle's side a.
     * @param b the triangle's side b.
     * @param c the triangle's side c.
     */
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public void scale(int factor) {
        this.a = this.a * factor;
        this.b = this.b * factor;
        this.c = this.c * factor;
    }
    @Override
    public double getCircumference() {
        return a + b + c;
    }
}
