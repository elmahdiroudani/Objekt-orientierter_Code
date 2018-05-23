package geometry;
/**
 * Tests geometry for all geometrical objects which uses the interface.
 * @author R3V€4LeD
 */
public class GeometryTest {
    /**
     * The main-method which checks the proper use of the classes and methods.
     * @param args not used.
     */
    public static void main(String[] args) {
        Geometry geo = new Circle(2.0);
        geo = new Rectangle(2.0, 1.0);
        //change the figure's size by factor 3 in every direction
        geo.scale(3);
        //expected output: circumference = 18.0
        System.out.println("Circumference = " + geo.getCircumference());
    }
}
