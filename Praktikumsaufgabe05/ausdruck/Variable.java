package ausdruck;
/**
 * Dies repräsentiert eine Variable als speziellen Ausdruck.
 * @author Droxl
 */
public class Variable extends Ausdruck {
    /**
     * Repräsentiert die Variable in textueller Form.
     */
    private final String name;
    /**
     * Erstellt eine neue Variable.
     * @param variablenName Die Variable bzw. ihre textuelle Repräsentation.
     */
    public Variable(final String variablenName) {
        this.name = variablenName;
    }
    /**
     * Liefert den Wert dieser Variable.
     * @param variablenbelegung Belegung der Variable.
     * @return Gibt den Wert dieser Variable zurück.
     */
    @Override
    public int gibWert(Variablenbelegung variablenbelegung) {
        return variablenbelegung.gibWert(name);
    }
    /**
     * Liefert eine textuelle Repräsentation für ein "Variable-Objekt"
     * zur leichteren Fehler-Überprüfung mit JUnit.
     * @return Gibt die textuelle Repräsentation zur leichteren
     * Fehler-Überprüfung in JUnit aus.
     */
    @Override
    public String toString() {
        return "Variable: " + this.name;
    };
    /**
     * Generiert den Hash-Code eines "Variable"-Objektes.
     * @return Liefert den generierten Hash-Code.
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }
    /**
     * Überprüft, ob das übergebene Objekt das gleiche ist, wie das aktuelle.
     * @param obj Das zu prüfende Objekt.
     * @return Wahr genau dann, wenn das übergebene Objekt das gleiche ist,
     * wie das aktuelle.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Variable
                && this.name.equals(((Variable) obj).name);
    }
}