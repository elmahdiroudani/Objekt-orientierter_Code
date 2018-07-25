package modul;
/**
 * Dieser Aufzählungstyp enthält die Zustände des endlichen Automaten zur
 * Erkennung einer Textzelle.
 */
public enum Zustand {
    START(false),
    OHNE_ANFUEHRUNGSSTRICHE(false),
    MIT_ANFUEHRUNGSSTRICHEN(false),
    ANFUEHRUNGSSTRICH(false),
    ENDE(true),
    UNDEFINIERT(false);
    /**
     * Erzeugt einen Zustand des endlichen Automaten.
     * @param istEndzustand Gibt an, ob dieser Zustand ein Endzustand ist.
     */
    private Zustand(boolean istEndzustand) {
        this.istEndzustand = istEndzustand;
    }
    private final boolean istEndzustand;
    /**
     * Gibt an, ob dieser Zustand ein Endzustand ist.
     * @return <code>true</code> genau dann, wenn es ein Endzustand ist.
     */
    public boolean istEndzustand() {
        return istEndzustand;
    }
}