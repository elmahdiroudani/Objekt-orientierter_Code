package ausdruck;
/**
 * Dies repräsentiert eine Konstante als speziellen Ausdruck.
 * @author Droxl
 */
public class Konstante extends Ausdruck {
    /**
     * Der Wert der Konstanten.
     */
    private final int wert;
    /**
     * Erstellt eine neue Konstante.
     * @param wert Wert der Konstanten.
     */
    public Konstante(int wert) {
        this.wert = wert;
    }
    /**
     * Liefert den Wert dieser Variable.
     * @param konstantenbelegung Belegung der Konstante.
     * @return Gibt den Wert dieser Variable zurück.
     */
    @Override
    public int gibWert(Variablenbelegung konstantenbelegung) {
        return wert;
    }
    /**
     * Liefert eine textuelle Repräsentation für ein "Konstante"-Objekt
     * zur leichteren Fehler-Überprüfung mit JUnit.
     * @return Gibt die textuelle Repräsentation zur leichteren
     * Fehlerüberprüfung in JUnit aus.
     */
    @Override
    public String toString() {
        return "(Konstante mit Wert: " + this.wert + ")";
    };
    /**
     * Überprüft, ob das übergebene Objekt das gleiche ist, wie das aktuelle.
     * @param obj Das zu überprüfende Objekt.
     * @return Gibt wahr aus, genau dann, wenn das übergebene Objekt
     * das gleiche ist, wie das aktuelle.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Konstante && this.wert == ((Konstante) obj).wert;
    }
    /**
     * Generiert den Hash-Code eines "Konstante"-Objektes.
     * @return Liefert den generierten Hash-Code.
     */
    @Override
    public int hashCode() {
        return wert;
    }
}