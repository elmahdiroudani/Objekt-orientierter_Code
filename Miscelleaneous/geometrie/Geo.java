package geometrie;
/**
 * Schnittstelle Geo für alle geometrischen Objekte, 
 * die diese Schnittstelle nutzen.
 * @author R3V€4LeD
 */
public interface Geo {
    /**
     * Hiermit lassen sich Objekte skalieren.
     * @param faktor um diesen Faktor wird das Objekt skaliert.
     */
    public void skaliere(int faktor);
    /**
     * Der Umfang eines geometrischen Objektes 
     * wird durch diese Methode wiedergegeben.
     * @return Liefert den Umfangum eines geometrischen Objektes.
     */
    public double gibUmfang();
}
