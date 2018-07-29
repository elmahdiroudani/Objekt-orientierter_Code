package personal;
/**
 * In dieser Klasse geht es um Vorgesetzte und Mitarbeiter in einem Unternehmen.
 * @author Droxl
 */
public class Vorgesetzter extends Mitarbeiter {
    /**
     * Ein Flag, speziell für das Bestelllimit.
     * Da Vorgesetzte mehr Freiheiten hinsichtlich Bestellungen genießen
     * als "normale" Mitarbeiter. Wurde allerdings nichts anderes festgelegt
     * haben sie ebenfalls ein Limit wie die Mitarbeiter.
     */
    private int bestellLimit;
    /**
     * Erzeugt einen Vorgesetzten...
     * @param name ...mit einem Namen...
     * ...der für höhere Beträge bestellen darf, als z.B. ein
     * "normaler" Mitarbeiter.
     */
    public Vorgesetzter(String name) {
        super(name);
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
     * da Vorgesetzte höhere Bestelllimits als 20 Euro haben können.
     * @return Gibt das Bestelllimit zurück.
     */
    @Override
    protected int gibBestellLimit() {
        int limit = bestellLimit;
        /*
        Fall, dass das Limit nicht höher ist, dann darf der Vorgesetzte
        nur für so viel Euro bestellen, wie ein Mitarbeiter.
        */
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
    /**
     * Überschreibt die geerbte Methode gibNamen() der Klasse Mitarbeiter,
     * zugunsten des Namens eines Vorgesetzten.
     * @return Gibt den Namen des Vorgesetzten zurück.
     */
    @Override
    protected String gibNamen() {
        return super.gibNamen();
    }
}