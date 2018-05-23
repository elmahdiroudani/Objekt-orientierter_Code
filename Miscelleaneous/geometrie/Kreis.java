package geometrie;
/**
 * Diese Klasse stellt einen Kreis dar, welcher die Schnittstelle Geo 
 * für alle geometrischen Objekte nutzt.
 * @author R3V€4LeD
 */
public class Kreis implements Geo {
    /**
     * Radius des Kreises.
     */
    private double radius;
    /**
     * Erzeugt einen Kreis mit einem Radius.
     * @param radius Der Radius des Kreises.
     */
    public Kreis(double radius) {
        this.radius = radius;
    }
    @Override
    public double gibUmfang() {
        return (2 * Math.PI) * radius;
    }
    @Override
    public void skaliere(int faktor) {
        this.radius = this.radius * faktor;
    }
}
