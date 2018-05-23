package geometrie;
/**
 * Diese Klasse stellt ein Rechteck dar, welches die Schnittstelle Geo 
 * für alle geometrischen Objekte nutzt.
 * @author R3V€4LeD
 */
public class Rechteck implements Geo {
    /**
     * Die Länge des Rechtecks.
     */
    private double laenge;
    /**
     * Die Breite des Rechtecks.
     */
    private double breite;
    /**
     * Erzeugt ein Rechteck mit einer Länge und einer Breite.
     * @param laenge Die Länge des Rechtecks.
     * @param breite Die Breite des Rechtecks.
     */
    public Rechteck(double laenge, double breite) {
        this.laenge = laenge;
        this.breite = breite;
    }
    @Override
    public void skaliere(int faktor) {
        this.laenge = this.laenge * faktor;
        this.breite = this.breite * faktor;
    }
    @Override
    public double gibUmfang() {
        return 2 * this.laenge + 2 * this.breite;
    }
}
