package ausdruck;
/**
 * Diese Klasse repräsentiert einen Ausdruck der z.B. durch eine
 * arithmetische Operation entsteht, "1 + 2" wäre z.B. ein Ausdruck.
 * @author Droxl
 */
public abstract class Ausdruck {
    /**
     * Liefert den Wert dieser Variable.
     * @param belegung Belegung der Variable.
     * @return Gibt den Wert dieser Variable aus.
     */
    public abstract int gibWert(Variablenbelegung belegung);
    /**
     * Liefert textuelle Darstellung dieses Ausdrucks.
     * @return textuelle Darstellung dieses Ausdrucks.
     */
    @Override
    public abstract String toString();
}