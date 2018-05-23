package geometry;
/**
 * Interface geometry for all geometrical objects which uses the interface.
 * @author R3V€4LeD
 */
public interface Geometry {
    /**
     * This helps to scale objects.
     * @param factor scales the objects by the given factor.
     */
    public void scale(int factor);
    /**
     * The method returns a geometrical object's circumference.
     * @return the geometrical object's circumference.
     */
    public double getCircumference();
}
