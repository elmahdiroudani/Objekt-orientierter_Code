package geometry;
/**
 * This class represents a circle which uses the interface geometry 
 * for the geometrical objects.
 * @author R3V€4LeD
 */
public class Circle implements Geometry {
    /**
     * The circle's radius.
     */
    private double radius;
    /**
     * Creates a circle with a radius.
     * @param radius the circle's radius.
     */
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double getCircumference() {
        return (2 * Math.PI) * radius;
    }
    @Override
    public void scale(int factor) {
        this.radius = this.radius * factor;
    }
}
