package modul;
/**
 * Diese Ausnahme zeigt einen Fehler im Format der Moduldaten an.
 * @author Droxl
 */
public class ModuldatenformatException extends Exception {
    /**
     * Datenzeile, auf die sich die Ausnahme bezieht.
     */
    private String zeile;
    /**
     * Erzeugt ein neue Ausnahme dieser Klasse für die angegebenen Daten.
     * @param meldung Meldungstext zu dieser Ausnahme.
     * @param zeile Datenzeile, auf die sich diese Ausnahme bezieht.
     */
    public ModuldatenformatException(String meldung, String zeile) {
        super(meldung);
        this.zeile = zeile;
    }
    /**
     * Erzeugt ein neue Ausnahme dieser Klasse.
     * Diese Ausnahme bezieht sich auf keine Datenzeile.
     * @param meldung Meldungstext zu dieser Ausnahme.
     */
    public ModuldatenformatException(String meldung) {
        this(meldung, null);
    }
    /**
     * Liefert Datenzeile, auf die sich diese Ausnahme bezieht.
     * @return Datenzeile zu dieser Ausnahme.
     */
    public String gibZeile() {
        return zeile;
    }
    /**
     * Liefert eine textuelle Darstellung dieser Ausnahme.
     * @return Die textuelle Darstellung der Ausnahme.
     */
    @Override
    public String toString() {
        return "ModuldatenformatException: " + this.getMessage()
                + (zeile == null ? "" : " " + zeile);
    }
}