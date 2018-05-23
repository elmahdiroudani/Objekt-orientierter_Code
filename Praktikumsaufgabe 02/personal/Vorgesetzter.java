/**
 * In dieser und der anderen Klasse, geht es um Vorgesetzte und 
 * Mitarbeiter in einem Unternehmen. Dazu gibt es noch eine Testklasse 
 * mit der die Methoden der beiden Klassen auf 
 * korrekte Ausführung getestet werden können.
 */
package personal;
/**
 * In dieser Klasse geht es um Vorgesetzte in einem Unternehmen. 
 * Dazu gibt es noch eine Testklasse mit der die Methoden der beiden Klassen 
 * für Mitarbeiter und Vorgesetzte in einem Unternehmen, 
 * auf korrekte Ausführung getestet werden können.
 * @author R3V€4LeD
 */
public class Vorgesetzter extends Mitarbeiter {
    /**
     * Ein(e) Flag, speziell für das Bestelllimit bei Vorgesetzten. 
     * Da Vorgesetzte mehr Freiheiten hinsichtlich Bestellungen genießen 
     * als "normale" Mitarbeiter. Wurde allerdings nichts anderes festgelegt 
     * haben sie ebenfalls ein Limit von 20 Euro.
     */
    private int bestellLimit;
    /**
     * Erzeugt einen Vorgesetzten...
     * @param name mit einem Namen, der für höhere Beträge bestellen darf, 
     * als z.B. ein "normaler" Mitarbeiter.
     */
    public Vorgesetzter(String name) {
        //Erbt das Attribut der Klasse: Mitarbeiter.
        super(name);
        //Bei Vorgesetzten muss hier das/die Flag aktiviert sein.
        bestellLimit = -1;
    }
    /**
     * Hierdurch wird einem Vorgesetzten ein Limit zugeordnet.
     * @param limit Das Limit bis zu dem der Vorgesetzte bestellen darf.
     */
    public void setzeBestelllimit(int limit) {
        this.bestellLimit = limit;
    }
    /**
     * Überschreibt die geerbte Methode gibBestelllimit(), 
     * da Vorgesetzte höhere Bestelllimits als 20 Euro haben können 
     * (siehe auch Methode gibBestelllimit() in Klasse Mitarbeiter).
     * @return Gibt das Bestelllimit zurück.
     */
    @Override
    protected int gibBestellLimit() {
        int limit = bestellLimit;
        /*Fall, dass das Limit nicht höher ist, dann darf der Vorgesetzte 
        nur für bis zu 20 Euro bestellen.*/
        if (limit < 0) {
            limit = super.gibBestellLimit();
        }
        return limit;
    }
    /**
     * Überschreibt die geerbte Methode darfBestellen(), 
     * da Vorgesetzte höhere Bestelllimits als 20 Euro haben.
     * @param betrag Der Bestellbetrag.
     * @return Gibt den Wahrheitswert in Abhängigkeit davon, 
     * ob die Person bestellen darf, zurück.
     */
    @Override
    public boolean darfBestellen(int betrag) {
        return ((bestellLimit >= betrag) 
                || (super.darfBestellen(betrag) && bestellLimit < 0));
    }
    /**
     * Überschreibt die geerbte Methode gibPersonalbezeichnung(), 
     * da Vorgesetzte spezielle Mitarbeiter sind.
     * @return Gibt eine Personalbezeichnung aus, in Abhängigkeit davon, 
     * in welcher Position sich die betreffende Person befindet.
     */
    @Override
    protected String gibPersonalbezeichnung() {
        return "Vorgesetzter";
    }
}
