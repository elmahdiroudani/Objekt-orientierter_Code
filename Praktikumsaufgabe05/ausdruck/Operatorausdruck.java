package ausdruck;
/**
 * Dies repräsentiert einen speziellen Ausdruck, bestehend aus Operatorsymbol
 * und zwei Teilausdrücken, jeweils links und rechts des Operatorsymbols.
 * @author Droxl
 */
public class Operatorausdruck extends Ausdruck {
    /**
     * Das ausgewertete Ergebnis.
     */
    private int operatorAuswertung;
    /**
     * Der linke Teilausdruck der Operation.
     */
    private final Ausdruck linkesArgument;
    /**
     * Der rechte Teilausdruck der Operation.
     */
    private final Ausdruck rechtesArgument;
    /**
     * Der Operator zur arithmetischen Operation z.B. "+" für Addition.
     */
    private final char operatorsymbol;
    /**
     * Erstellt einen neuen Operatorausdruck.
     * @param linkesArgument Linke Seite des Ausdrucks.
     * @param operator Mitte des Ausdrucks, durch Operatorsymbol repräsentiert.
     * @param rechtesArgument Rechte Seite des Ausdrucks.
     */
    public Operatorausdruck(Ausdruck linkesArgument, char operator,
            Ausdruck rechtesArgument) {
        this.linkesArgument = linkesArgument;
        this.operatorsymbol = operator;
        this.rechtesArgument = rechtesArgument;
    }
    /**
     * Liefert den Wert ausgewerteter Variablen und Konstanten, wenn sie bei
     * Auswertung einen gültigen Ausdruck ergeben.
     * @param belegung Belegung der Argumente innerhalb des Operatorausdrucks.
     * @return Gibt den Wert dieses Ausdrucks zurück.
     */
    @Override
    public int gibWert(Variablenbelegung belegung) {
        /*
        Mehrfachverzweigung: Jenachdem welche Operation erwünscht bzw.
        gefordert ist, wird die jeweilige arithmetische Operation ausgewählt.
        */
        switch (operatorsymbol) {
            case '+':
                operatorAuswertung = linkesArgument.gibWert(belegung)
                        + rechtesArgument.gibWert(belegung);
                break;
            case '-':
                operatorAuswertung = linkesArgument.gibWert(belegung)
                        - rechtesArgument.gibWert(belegung);
                break;
            case '*':
                operatorAuswertung = linkesArgument.gibWert(belegung)
                        * rechtesArgument.gibWert(belegung);
                break;
            case '/':
                operatorAuswertung = linkesArgument.gibWert(belegung)
                        / rechtesArgument.gibWert(belegung);
                break;
        }
        //Danach wird das Ergebnis geliefert.
        return operatorAuswertung;
    }
    /**
     * Liefert eine textuelle Repräsentation für ein "Operatorausdruck"-Objekt
     * zur leichteren Fehlerüberprüfung mit JUnit.
     * @return Gibt die textuelle Repräsentation zur leichteren
     * Fehlerüberprüfung in JUnit aus.
     */
    @Override
    public String toString() {
        return "(" + linkesArgument.toString() + " " + operatorsymbol
                + " " + rechtesArgument.toString() + ")";
    }
    /**
     * Generiert den Hash-Code eines "Operatorausdruck"-Objektes.
     * @return Liefert den generierten Hash-Code.
     */
    @Override
    public int hashCode() {
        return linkesArgument.hashCode() + rechtesArgument.hashCode()
                + operatorsymbol;
    }
    /**
     * Überprüft, ob das übergebene Objekt das gleiche ist, wie das aktuelle.
     * @param obj Das zu prüfende Objekt.
     * @return Gibt wahr aus, genau dann, wenn das übergebene Objekt
     * das gleiche ist, wie das aktuelle.
     */
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Operatorausdruck)
                && this.operatorsymbol == (
                ((Operatorausdruck) obj).operatorsymbol)
                && this.linkesArgument.equals(
                        ((Operatorausdruck) obj).linkesArgument)
                && this.rechtesArgument.equals(
                        ((Operatorausdruck) obj).rechtesArgument);
    }
}