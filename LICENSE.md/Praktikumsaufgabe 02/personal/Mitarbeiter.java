/**
 * In dieser und der anderen Klasse, geht es um Mitarbeiter und 
 * Vorgesetzte in einem Unternehmen. Dazu gibt es noch eine Testklasse 
 * mit der die Methoden der beiden Klassen auf 
 * korrekte Ausführung getestet werden können.
 */
package personal;
/**
 * In dieser Klasse geht es um Mitarbeiter in einem Unternehmen. 
 * Dazu gibt es noch eine Testklasse mit der die Methoden der beiden Klassen 
 * für Mitarbeiter und Vorgesetzte in einem Unternehmen, 
 * auf korrekte Ausführung getestet werden können.
 * @author R3V€4LeD
 */
public class Mitarbeiter {
    /**
     * Das allgemeine Bestelllimit beträgt bei Mitarbeitern 20 Euro.
     */
    protected static int allgemeinesLimit = 20;
    /**
     * Name des Mitarbeiters.
     */
    private String name;
    /**
     * Variable bei Zuweisung eines Vorgesetzten gegenueber einem Mitarbeiter.
     */
    private Vorgesetzter vorgesetzter;
    /**
     * Erzeugt einen Mitarbeiter.
     * @param name Der Name des Mitarbeiters.
     */
    public Mitarbeiter(String name) {
        this.name = name;
    }
    /**
     * Setzt ein allgemeines Bestelllimit aller Mitarbeiter, sowie der 
     * Vorgesetzten ohne explizites Limit, auf einen festen Wert.
     * @param limit Das Limit dessen Höhe bestimmt wird.
     */
    public static void setzeAllgemeinesLimit(int limit) {
        allgemeinesLimit = limit;
    }
    /**
     * Instanzmethode durch die einer Person ein Vorgesetzter zugeordnet wird.
     * Durch Aufruf dieser Methode mit Parameter "null" entzieht 
     * man einer Person den Vorgesetzten.
     * @param vorgesetzter Der Vorgesetzte der dem Mitarbeiter vorgesetzt wird.
     */
    public void setzeVorgesetzten(Vorgesetzter vorgesetzter) {
        this.vorgesetzter = vorgesetzter;
    }
    /**
     * Instanzmethode durch die jeder Mitarbeiter (damit natürlich auch 
     * jeder Vorgesetzte) angibt, ob er eine Beschaffung in der 
     * angegebenen Höhe durchführen darf.
     * @param betrag Liegt der Betrag noch im korrekten Rahmen?
     * @return Gibt den Wahrheitswert in Abhängigkeit dessen wieder.
     */
    public boolean darfBestellen(int betrag) {
        return allgemeinesLimit >= betrag;
    }
    /**
     * Instanzmethode durch die jeder Mitarbeiter einen Info-Text über sich 
     * zurückgibt.
     * Abhängig von der Person und der Tatsache, ob sie einen Vorgesetzten hat.
     * @return Gibt eine allgemeine Info über die entsprechende Person zurück.
     */
    public String gibInfo() {
        Mitarbeiter vorgesetztePerson = this.vorgesetzter;
        String vorgesetzterText = "";
        if (vorgesetzter != null) {
            vorgesetzterText = "Mein Vorgesetzter ist " 
                    + vorgesetztePerson.name + ". ";
        }
        return "Ich bin " + gibPersonalbezeichnung() + ", Name " + name + ". " 
                + vorgesetzterText + "Mein Bestelllimit ist " 
                + gibBestellLimit() + " EUR.";
    }
    /**
     * Instanzmethode durch die jeder Mitarbeiter seine vollständige 
     * Personalhierarchie liefert. Das Ergebnis der Methode wird mehrzeilig 
     * aufgebaut, jeweils eine Zeile pro Stufe der Personalhierarchie. 
     * 
     * Der Mitarbeiter selbst steht am Ende der Zeichenkette, sein oberster 
     * Vorgesetzter am Anfang (s. auch Testablauf). 
     * Das Ergebnis endet nicht mit einem Zeilenumbruch.
     * @return Gibt eine Info über die Hierarchie zurück.
     */
    public String gibHierarchie() {
        Mitarbeiter person = this;
        String hierarchie = "";
        while (person != null) {
            String personenBeschreibung = person.gibPersonalbezeichnung() 
                    + " " + person.name;
            hierarchie = personenBeschreibung 
                    + ((person != this)
                    ? "\n" + hierarchie
                    : "");
            person = person.vorgesetzter;
        }
        return hierarchie;
    }
    /**
     * Liefert das allgemeine Bestelllimit. 
     * Bei Mitarbeitern beträgt es 20 Euro.
     * @return Gibt das allgemeine Bestelllimit aus, welches 20 Euro beträgt.
     */
    protected int gibBestellLimit() {
        return allgemeinesLimit;
    }
    /**
     * Liefert die Personalbezeichnung des Mitarbeiters. 
     * Die Methode behandelt außerdem den Fall, dass der Mitarbeiter ein 
     * freier Mitarbeiter ist.
     * @return Gibt die Personalbezeichnung des Mitarbeiters aus.
     */
    protected String gibPersonalbezeichnung() {
        /*Textausgabe über den Mitarbeiter, hat er keinen Vorgesetzten,...*/
        return this.vorgesetzter == null
                /*...ist er ein "freier Mitarbeiter",...*/
                ? "freier Mitarbeiter"
                /*...sonst ein "normaler".*/
                : "Mitarbeiter";
    }
}
