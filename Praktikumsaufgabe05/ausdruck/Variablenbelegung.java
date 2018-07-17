package ausdruck;
import java.util.HashMap;
/**
 * Dies repräsentiert eine Variablenbelegung, die einer
 * ausgewählten Variable den Wert zuweist.
 * @author Droxl
 */
public class Variablenbelegung {
    /**
     * Die Belegungen in dieser Variablenbelegung.
     */
    private final HashMap<String, Integer> variablenbelegungen;
    /**
     * Erstellt eine neue Variablenbelegung.
     */
    public Variablenbelegung() {
        this.variablenbelegungen = new HashMap();
    }
    /**
     * Belegt eine Variable mit einem Wert.
     * @param variable Veriable, die zu belegen ist.
     * @param wert Wert, mit dem die Variable zu belegen ist.
     */
    public void belege(String variable, int wert) {
        variablenbelegungen.put(variable, wert);
    }
    /**
     * Liefert den Wert für die Variable.
     * @param variable Variable, für die der Wert ausgegeben werden soll.
     * @return Gibt den Wert für die Variable wieder.
     */
    public int gibWert(String variable) {
        return (variablenbelegungen.containsKey(variable))
                ? variablenbelegungen.get(variable)
                : 0;
    }
}