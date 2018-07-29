package personal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * In dieser Klasse geht es um Mitarbeiter und Vorgesetzte in einem Unternehmen.
 * @author Droxl
 */
public class Mitarbeiter {
    /**
     * Das allgemeine Bestelllimit beträgt bei Mitarbeitern 20 Euro.
     */
    protected static int allgemeinesLimit = 20;
    /**
     * Name des Mitarbeiters.
     */
    private final String name;
    /**
     * Variable bei Zuweisung eines Vorgesetzten gegenueber einem Mitarbeiter.
     */
    private Vorgesetzter vorgesetzter;
    /**
     * Erzeugt einen Mitarbeiter.
     *
     * @param name Der Name des Mitarbeiters.
     */
    public Mitarbeiter(String name) {
        this.name = name;
    }
    /**
     * Setzt ein allgemeines Bestelllimit aller Mitarbeiter sowie der
     * Vorgesetzten ohne explizites Limit fest.
     *
     * @param limit Das Limit.
     */
    public static void setzeAllgemeinesLimit(int limit) {
        allgemeinesLimit = limit;
    }
    /**
     * Setzt den angegebenen Vorgesetzten für diesen Mitarbeiter. Durch Aufruf
     * dieser Methode mit Parameter "null" entzieht man einer Person den
     * Vorgesetzten.
     *
     * @param vorgesetzter Der Vorgesetzte der dem Mitarbeiter vorgesetzt wird.
     */
    public void setzeVorgesetzten(Vorgesetzter vorgesetzter) {
        this.vorgesetzter = vorgesetzter;
    }
    /**
     * Gibt den Vorgesetzten für diesen Mitarbeiter.
     *
     * @return Null wenn dieser Mitarbeiter keinen Vorgesetzten hat, sonst den
     * Vorgesetzten dieses Mitarbeiters.
     */
    public Vorgesetzter gibVorgesetzten() {
        return this.vorgesetzter;
    }
    /**
     * Hierdurch gibt jeder Mitarbeiter (damit natürlich auch jeder
     * Vorgesetzte) an, ob er eine Beschaffung in der angegebenen Höhe
     * durchführen darf.
     * 
     * @param betrag Liegt der Betrag noch im korrekten Rahmen?
     * @return Gibt den Wahrheitswert in Abhängigkeit dessen wieder.
     */
    public boolean darfBestellen(int betrag) {
        return allgemeinesLimit >= betrag;
    }
    /**
     * Instanzmethode durch die jeder Mitarbeiter einen Info-Text über sich
     * zurückgibt. Abhängig von der Person und der Tatsache, ob sie einen
     * Vorgesetzten hat.
     *
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
     * Hierdurch liefert jeder Mitarbeiter seine vollständige
     * Personalhierarchie. Das Ergebnis der Methode wird mehrzeilig
     * aufgebaut, jeweils eine Zeile pro Stufe der Personalhierarchie.
     *
     * Der Mitarbeiter selbst steht am Ende der Zeichenkette, sein oberster
     * Vorgesetzter am Anfang (s. auch Testablauf).
     * Das Ergebnis endet nicht mit einem Zeilenumbruch.
     *
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
     * Bei Mitarbeitern hat es es einen zuvor festgelegten Wert.
     *
     * @return Gibt das allgemeine Bestelllimit aus.
     */
    protected int gibBestellLimit() {
        return allgemeinesLimit;
    }
    /**
     * Liefert die Personalbezeichnung des Mitarbeiters. Die Methode behandelt
     * außerdem den Fall, dass der Mitarbeiter ein freier Mitarbeiter ist.
     *
     * @return Gibt die Personalbezeichnung des Mitarbeiters aus.
     */
    protected String gibPersonalbezeichnung() {
        /*
        Textausgabe über den Mitarbeiter, hat er keinen Vorgesetzten,
        ist er ein "freier Mitarbeiter", sonst ein "normaler".
         */
        return this.vorgesetzter == null
                ? "freier Mitarbeiter"
                : "Mitarbeiter";
    }
    /**
     * Liefert den Namen dieses Mitarbeiters.
     *
     * @return Der Name des Mitarbeiters.
     */
    protected String gibNamen() {
        return this.name;
    }
    /**
     * Liefert die Information über Vorgesetzte und ihre direkten Untergebenen,
     * die ausgehend von den übergebenen Mitarbeitern ermittelt werden kann.
     *
     * @param mitarbeiter Mitarbeiter, von denen ausgehend die
     * Hierarchieinformation ermittelt wird.
     *
     * @return Die Schlüssel der Zuordnung sind alle direkten und indirekten
     * Vorgesetzten der übergebenen Mitarbeiter. Jedem Vorgesetzten sind als
     * Wert die direkten Untergebenen zugeordnet.
     */
    public static HashMap<Vorgesetzter, Set<Mitarbeiter>>
            gibPersonalstruktur(Collection<Mitarbeiter> mitarbeiter) {

        HashMap<Vorgesetzter, Set<Mitarbeiter>> personalstruktur
                = new HashMap<>();

        mitarbeiter.stream()
                .filter(m -> m instanceof Vorgesetzter)
                .map(v -> (Vorgesetzter) v)
                .forEach(v -> personalstruktur.put(v,
                        mitarbeiter.stream()
                            .filter(m ->  v.equals(m.gibVorgesetzten()))
                            .collect(Collectors.toSet())));
        //Altmodisch
//        for (Mitarbeiter m : mitarbeiter) {
//            Vorgesetzter v = m.vorgesetzter;
//            while (v != null) {
//                if (!personalstruktur.containsKey(v)) {
//                    personalstruktur.put(v, new HashSet<>());
//                }
//                personalstruktur.get(v).add(m);
//                m = v;
//                v = m.vorgesetzter;
//            }
//        }
        return personalstruktur;
    }
}