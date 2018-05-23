package geometrie;
/**
 * Teste Geo für alle geometrischen Objekte, die diese Schnittstelle nutzen.
 * @author R3V€4LeD
 */
public class GeoTest {
    /**
     * Hauptmethode, die Klassen auf korrekte Funktionalität überprüft.
     * @param args wird hier nicht benötigt.
     */
    public static void main(String[] args) {
        Geo g = new Kreis(2.0);
        g = new Rechteck(2.0, 1.0);
        // Figur in alle Richtungen um Faktor 3 vergrößern
        g.skaliere(3);
        // erwartete Ausgabe: Umfang = 18.0
        System.out.println("Umfang = " + g.gibUmfang());}
}
