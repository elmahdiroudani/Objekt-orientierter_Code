package carsharing;
/**
 * Repräsentiert eine Fahrzeugbuchung als Klasse für die CarSharing-Anwendung.
 * @author Droxl
 */
public class FahrzeugBuchungzeitraum {
    /**
     * Der Zeitpunkt, ab dem das Fahrzeug gebucht werden kann.
     */
    private String buchungsBeginn;
    /**
     * Der Zeitpunkt, bis zu dem das Fahrzeug gebucht werden kann.
     */
    private String buchungsEnde;
    /**
     * Erstellt eine neue Fahrzeugbuchung.
     * @param buchungsBeginn Ab dem Zeitpunkt kann gebucht werden.
     * @param buchungsEnde Bis zu dem Zeitpunkt kann gebucht werden.
     */
    public FahrzeugBuchungzeitraum(String buchungsBeginn, String buchungsEnde) {
        this.buchungsBeginn = buchungsBeginn;
        this.buchungsEnde = buchungsEnde;
    }
    /**
     * Überprüft mögliche Überschneidungen zweier Termine.
     * @param buchung Übergebene Fahrzeug-Buchung.
     * @return Liefert wahr oder falsch in Abhängigkeit davon,
     * ob sich zwei Buchungen überschneiden.
     */
    public boolean buchungHatUeberschneidung(FahrzeugBuchungzeitraum buchung) {
        /*
        Der übergebene Buchungzeitraum eines Fahrzeuges darf sich nicht 
        exakt mit einer aktuellen Fahrzeugbuchung überlappen.
        */
        return (this.buchungsBeginn.equals(buchung.buchungsBeginn) 
                && this.buchungsEnde.equals(buchung.buchungsEnde))
                /*
                Das Ende eines übergebenen Buchungzeitraums eines 
                Fahrzeuges, darf nicht innerhalb der aktuellen Fahrzeugbuchung 
                liegen.
                */
                || (this.buchungsBeginn.compareTo(buchung.buchungsEnde) < 0 
                && this.buchungsEnde.compareTo(buchung.buchungsEnde) > 0)
                /*
                Der Anfang eines übergebenen Buchungzeitraums eines 
                Fahrzeuges, darf nicht innerhalb der aktuellen Fahrzeugbuchung 
                beginnen.
                */
                || (this.buchungsBeginn.compareTo(buchung.buchungsBeginn) < 0 
                && this.buchungsEnde.compareTo(buchung.buchungsBeginn) > 0)
                /*
                Die aktuelle Fahrzeugbuchung darf nicht in der 
                übergebenen Fahrzeugbuchung beginnen.
                */
                || (buchung.buchungsBeginn.compareTo(this.buchungsBeginn) < 0 
                && buchung.buchungsEnde.compareTo(this.buchungsBeginn) > 0)
                /*
                Die aktuelle Fahrzeugbuchung darf nicht in der 
                übergebenen Fahrzeugbuchung enden.
                */
                || (this.buchungsEnde.compareTo(buchung.buchungsEnde) < 0 
                && this.buchungsEnde.compareTo(buchung.buchungsBeginn) > 0);
    }
    /**
     * Generiert den Hash-Code des Obejektes.
     * Optional, da in diesem Fall auch Buchungen einzigartig sein können.
     * @return Gibt den generierten Hash-Code eines Objektes
     * vom Typ Buchung zurück.
     */
    @Override
    public int hashCode() {
        return buchungsBeginn.hashCode() + buchungsEnde.hashCode();
    }
    /**
     * Vergleicht das aufrufende Objekt mit dem übergebenen auf Gleichheit.
     * Optional, da auch Buchungen einzigartig sein können.
     * @param obj Ein übergebenes Objekt.
     * @return Ist gleich oder nicht.
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof FahrzeugBuchungzeitraum 
                && this.buchungsBeginn.equals(
                        ((FahrzeugBuchungzeitraum) obj).buchungsBeginn) 
                && this.buchungsEnde.equals(
                        ((FahrzeugBuchungzeitraum) obj).buchungsEnde);
    }
}