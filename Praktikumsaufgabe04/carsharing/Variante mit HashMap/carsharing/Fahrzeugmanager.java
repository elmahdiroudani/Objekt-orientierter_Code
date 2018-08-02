package carsharing;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.HashMap;
/**
 * Klasse die Funktionen einer CarSharing-Anwendung realisiert.
 * CarSharing-Unternehmen unterhalten Standorte, an denen Fahrzeuge
 * stationiert sind. Jedes Fahrzeug besitzt einen Namen und einen
 * festen Standort.
 * Der Fahrzeugmanager dient der Verwaltung aller übergebenen Fahrzeuge.
 * @author Droxl
 */
public class Fahrzeugmanager {
    /**
     * Enthält die Fahrzeugbuchungen.
     */
    private ArrayList<FahrzeugBuchungzeitraum> buchungen;
    /**
     * Enthält die Fahrzeuge, die unter ihrer Bezeichnung gespeichert werden.
     */
    private HashMap<String, Fahrzeug> fahrzeuge;
    /**
     * Erzeugt einen Fahrzeugmanager, der die Fahrzeuge verwaltet.
     */
    public Fahrzeugmanager() {
        fahrzeuge = new HashMap<>();
        buchungen = new ArrayList();
    }
    /**
     * Fügt dem Fahrzeugmanager ein Fahrzeug mit einem
     * bestimmten Namen und Standort hinzu.
     * Falls der Fahrzeugmanager bereits ein Fahrzeug mit diesem Namen
     * verwaltet, wird kein Fahrzeug hinzugefügt.
     * @param fahrzeugname Der Name des Fahrzeugs.
     * @param standort Der Standort des Fahrzeugs, an dem es sich befindet.
     */
    public void fuegeFahrzeugHinzu(String fahrzeugname, String standort) {
        if (!fahrzeuge.containsKey(fahrzeugname)) {
            fahrzeuge.put(fahrzeugname, new Fahrzeug(fahrzeugname, standort));
        }
    }
    /**
     * Liefert die Namen aller Fahrzeuge alphabetisch aufsteigend sortiert.
     * @return Gibt die Namen aller Fahrzeuge alphabetisch sortiert zurück.
     */
    public ArrayList<String> gibFahrzeugnamen() {
        //Diese Liste enthält die Fahrzeugnamen.
        ArrayList<String> fahrzeugNamen = new ArrayList<>();
        //Iterator der über die Liste wandert.
        Iterator<String> fahrzeugIterator = fahrzeuge.keySet().iterator();
        //Solange der Iterator noch über Elemente iterieren kann,...
        while (fahrzeugIterator.hasNext()) {
            /*
            ...wird das nächste Element, der Liste
            der Fahrzeugnamen, hinzugefügt.
            */
            fahrzeugNamen.add(fahrzeugIterator.next());
        }
        //Sortiert die Fahrzeugnamen alphabetisch aufsteigend.
        Collections.sort(fahrzeugNamen);
        //Liefert die Namen der Fahrzeuge aus der Liste.
        return fahrzeugNamen;
    }
    /**
     * Liefert (alphabetisch sortiert) die Namen aller Fahrzeuge
     * des angegebenen Standortes.
     * @param standort Der Standort, von dem die Fahrzeuge verwaltet werden.
     * @return Gibt die Namen aller Fahrzeuge dieses Standortes
     * alphabetisch aufsteigend sortiert zurück.
     */
    public ArrayList<String> gibFahrzeugnamen(String standort) {
        //Diese Liste enthält die Fahrzeugnamen.
        ArrayList<String> fahrzeugnamen = new ArrayList<>();
        //Iterator der über die Liste wandert.
        Iterator<String> fahrzeugIterator = fahrzeuge.keySet().iterator();
        //Solange der Iterator noch über Elemente iterieren kann,...
        while (fahrzeugIterator.hasNext()) {
            //...verweist er immer auf das aktuelle Fahrzeug.
            Fahrzeug aktuellesFahrzeug = fahrzeuge.get(fahrzeugIterator.next());
            /*
            Wenn der Standort des aktuellen Fahrzeuges gleich
            dem übergebenen Standort ist,...
            */
            if (aktuellesFahrzeug.gibStandort().equalsIgnoreCase(standort)) {
                //...wird es zur Liste der Fahrzeugnamen hinzugefügt.
                fahrzeugnamen.add(aktuellesFahrzeug.gibFahrzeugname());
            }
        }
        //Sortiert die Fahrzeugnamen alphabetisch aufsteigend.
        Collections.sort(fahrzeugnamen);
        //Liefert die Namen der Fahrzeuge aus der Liste.
        return fahrzeugnamen;
    }
    /**
     * Hilft dabei das Fahrzeug mit dem angegebenen Namen für
     * einen bestimmten Zeitraum zu buchen.
     * Die Angabe der Zeitpunkte der Buchung, erfolgt
     * im Format: JJJJ/MM/TT HH:MM, z.B. 2005/04/22 09:35
     * für den 22. April 2005, 9:35 Uhr.
     * @param fahrzeugname Der Name des Fahrzeugs.
     * @param buchungsBeginn Der Zeitpunkt, ab dem das Fahrzeug
     * gebucht werden kann.
     * @param buchungsEnde Der Zeitpunkt, bis zu dem das Fahrzeug
     * gebucht werden kann.
     * @return Die Methode liefert genau dann true zurück,
     * wenn das angegebene Fahrzeug für den gewünschten Zeitraum
     * gebucht werden kann, das heißt, sich der gewünschte Buchungszeitraum
     * mit keiner anderen Buchung dieses Fahrzeugs überschneidet.
     */
    public boolean bucheFahrzeug(String fahrzeugname, String buchungsBeginn,
            String buchungsEnde) {
        //Setzt eine Buchung für dieses Fahrzeug, wenn mölgich.
        return fahrzeuge.get(fahrzeugname).setzeBuchung(
                buchungsBeginn, buchungsEnde);
    }
    /**
     * Liefert, alphabetisch sortiert, die Namen aller Fahrzeuge des
     * angegebenen Standortes, die in einem bestimmten
     * Zeitraum verfügbar sind.
     * Ein Fahrzeug ist in einem Zeitraum verfügbar, wenn es für diesen
     * Zeitraum gebucht werden kann.
     * @param standort Standort, an dem sich die Fahrzeuge befinden.
     * @param buchungsBeginn Ab dem Zeitpunkt kann gebucht werden.
     * @param buchungsEnde Bis zu dem Zeitpunkt kann gebucht werden.
     * @return Gibt alphabetisch sortiert, die Namen aller Fahrzeuge
     * des angegebenen Standorts zurück, wenn sie verfügbar sind.
     */
    public ArrayList<String> gibVerfuegbareFahrzeuge(String standort,
            String buchungsBeginn, String buchungsEnde) {
        //Liste mit allen Fahrzeugen des übergebenen Standortes.
        ArrayList<String> standortFahrzeuge = gibFahrzeugnamen(standort);
        /*
        Liste mit allen Fahrzeugen, die im übergebenen Zeitraum
        gebucht werden können.
        */
        ArrayList<String> verfuegbareFahrzeuge = new ArrayList();
        /*
        Der Fahrzeug-Iterator iteriert über die Liste der
        verfügbaren Fahrzeuge...
        */
        Iterator<String> fahrzeugIterator = standortFahrzeuge.iterator();
        //...dabei läuft er über alle Fahrzeuge der Liste.
        while (fahrzeugIterator.hasNext()) {
            //Das Fahrzeug auf das aktuell via Iterator zugegriffen wird.
            Fahrzeug aktuellesFahrzeug = fahrzeuge.get(fahrzeugIterator.next());
            /*
            Wenn das aktuelle Fahrzeug im übergebenen
            Zeitraum nicht buchbar ist, wird es aus der Liste der
            verfügbaren Fahrzeuge entfernt.
            */
            if (aktuellesFahrzeug.istBuchbar(buchungsBeginn, buchungsEnde)) {
                verfuegbareFahrzeuge.add(aktuellesFahrzeug.gibFahrzeugname());
            }
        }
        //Gibt nur verfügbare Fahrzeuge aus.
        return verfuegbareFahrzeuge;
    }
}
