package carsharing;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
     * Enthält die Fahrzeuge, die unter ihrer Bezeichnung gespeichert werden.
     */
    private Map<String, Fahrzeug> fahrzeuge;
    /**
     * Erzeugt einen Fahrzeugmanager, der die Fahrzeuge verwaltet.
     */
    public Fahrzeugmanager() {
        fahrzeuge = new HashMap<>();
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
    public List<String> gibFahrzeugnamen() {
        return fahrzeuge
                .keySet().stream().sorted().collect(Collectors.toList());
    }
    /**
     * Liefert (alphabetisch sortiert) die Namen aller Fahrzeuge
     * des angegebenen Standortes.
     * @param standort Der Standort, von dem die Fahrzeuge verwaltet werden.
     * @return Gibt die Namen aller Fahrzeuge dieses Standortes
     * alphabetisch aufsteigend sortiert zurück.
     */
    public List<String> gibFahrzeugnamen(String standort) {
        return fahrzeuge
                .values().stream()
                .filter(f -> f.gibStandort().equals(standort))
                .map(f -> f.gibFahrzeugname())
                .sorted()
                .collect(Collectors.toList());
    }
    /**
     * Hilft dabei das Fahrzeug mit dem angegebenen Namen für
     * einen bestimmten Zeitraum zu buchen.
     * Die Angabe der Zeitpunkte der Buchung, erfolgt
     * im Format: JJJJ/MM/TT HH:MM, z.B. 2005/04/22 09:35
     * für den 22. April 2005, 9:35 Uhr.
     * 
     * @param fahrzeugname Der Name des Fahrzeugs.
     * @param buchungsBeginn Der Zeitpunkt, ab dem das Fahrzeug
     * gebucht werden kann.
     * @param buchungsEnde Der Zeitpunkt, bis zu dem das Fahrzeug
     * gebucht werden kann.
     * 
     * @return Die Methode liefert genau dann true zurück,
     * wenn das angegebene Fahrzeug für den gewünschten Zeitraum
     * gebucht werden kann, das heißt, sich der gewünschte Buchungszeitraum
     * mit keiner anderen Buchung dieses Fahrzeugs überschneidet.
     */
    public boolean bucheFahrzeug(
            String fahrzeugname,
            String buchungsBeginn,
            String buchungsEnde) {
        //Setzt eine Buchung für dieses Fahrzeug, wenn mölgich.
        return fahrzeuge.get(fahrzeugname).setzeBuchung(
                buchungsBeginn, buchungsEnde);
    }
    /**
     * Liefert, alphabetisch sortiert, die Namen aller Fahrzeuge des
     * angegebenen Standortes, die in einem bestimmten
     * Zeitraum verfügbar sind.
     * 
     * Ein Fahrzeug ist in einem Zeitraum verfügbar, wenn es für diesen
     * Zeitraum gebucht werden kann.
     * @param standort Standort, an dem sich die Fahrzeuge befinden.
     * @param buchungsBeginn Ab dem Zeitpunkt kann gebucht werden.
     * @param buchungsEnde Bis zu dem Zeitpunkt kann gebucht werden.
     * @return Gibt alphabetisch sortiert, die Namen aller Fahrzeuge
     * des angegebenen Standorts zurück, wenn sie verfügbar sind.
     */
    public List<String> gibVerfuegbareFahrzeuge(
            String standort,
            String buchungsBeginn,
            String buchungsEnde) {
        
        return gibFahrzeugnamen(standort).stream()
                .filter(f -> fahrzeuge.get(f)
                        .istBuchbar(buchungsBeginn, buchungsEnde))
                .sorted().collect(Collectors.toList());
    }
}