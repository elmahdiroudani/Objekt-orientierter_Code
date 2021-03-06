package carsharing;
import java.util.ArrayList;
import java.util.List;
/**
 * Repräsentiert ein Fahrzeug als Klasse für die CarSharing-Anwendung.
 * CarSharing-Unternehmen unterhalten Standorte, an denen Fahrzeuge
 * stationiert sind. Jedes Fahrzeug besitzt einen Namen und einen
 * festen Standort.
 * @author Droxl
 */
public class Fahrzeug {
    /**
     * Der Name des Fahrzeuges.
     */
    private final String fahrzeugname;
    /**
     * Der Standort des Fahrzeuges.
     */
    private String standort;
    /**
     * Die Buchungen.
     */
    private List<FahrzeugBuchungzeitraum> buchungen;
    /**
     * Erzeugt ein Fahrzeug mit einem Namen und einem Standort.
     * @param fahrzeugname Der Name des Fahrzeugs.
     * @param standort Der Standort des Fahrzeugs.
     */
    public Fahrzeug(String fahrzeugname, String standort) {
        this.fahrzeugname = fahrzeugname;
        this.standort = standort;
        this.buchungen = new ArrayList<>();
    }
    /**
     * Liefert den Fahrzeugnamen.
     * @return Gibt den Fahrzeugnamen zurück.
     */
    public String gibFahrzeugname() {
        return this.fahrzeugname;
    }
    /**
     * Liefert den Standort, an dem sich das Fahrzeug befindet.
     * @return Gibt den Standort zurück.
     */
    public String gibStandort() {
        return this.standort;
    }
    /**
     * Setzt eine Fahrzeugbuchung, wenn möglich.
     * @param buchungsBeginn Der Zeitpunkt, ab dem das Fahrzeug
     * gebucht werden kann.
     * @param buchungsEnde Der Zeitpunkt, bis zu dem das Fahrzeug
     * gebucht werden kann.
     * @return Ist buchbar oder nicht.
     */
    public boolean setzeBuchung(String buchungsBeginn, String buchungsEnde) {
        /*
        Ist eine Buchung im angegebenen Zeitraum möglich, wird sie gesetzt.
        Danach wird ausgegeben, ob sie mölgich war.
        War sie nicht möglich, wurde sie auch nicht gesetzt.
        */
        boolean istBuchbar = istBuchbar(buchungsBeginn, buchungsEnde);
        if (istBuchbar) {
            buchungen.add(new FahrzeugBuchungzeitraum(buchungsBeginn, 
                    buchungsEnde));
        }
        return istBuchbar;
    }
    /**
     * Überprüft, ob ein Fahrzeug buchbar ist, oder nicht.
     * @param buchungsBeginn Der Zeitpunkt, ab dem das Fahrzeug
     * gebucht werden kann.
     * @param buchungsEnde Der Zeitpunkt, bis zu dem das Fahrzeug
     * gebucht werden kann.
     * @return Ist buchbar oder nicht.
     */
    public boolean istBuchbar(String buchungsBeginn, String buchungsEnde) {
        //Hilfsvariable die den übergebenen Buchungszeitraum repräsentiert.
        FahrzeugBuchungzeitraum buchung = 
                new FahrzeugBuchungzeitraum(buchungsBeginn, buchungsEnde);
        return buchungen.stream()
                .noneMatch(b -> buchung.buchungHatUeberschneidung(b));
    }
    /**
     * Überprüft, ob das Fahrzeug, im Sinne von equals(), gleich ist.
     * @param obj Ein übergebenes Objekt mit dem das aufrufende verglichen wird.
     * @return Ist gleich oder nicht.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Fahrzeug 
                && this.fahrzeugname.equals(
                        ((Fahrzeug) obj).fahrzeugname)
                && this.standort.equals(
                        ((Fahrzeug) obj).standort);
    }
    /**
     * Generiert den Hash-Code des Obejektes.
     * @return Gibt den generierten Hash-Code eines Objektes
     * vom Typ Fahrzeug zurück.
     */
    @Override
    public int hashCode() {
        return fahrzeugname.hashCode() + standort.hashCode();
    }
}