package modul;
/**
 * Der Moduldatenimportierer verarbeitet Moduldaten, indem er
 * Module der übergebenen Modulverwaltung hinzufügt.
 * Sein Verhalten wird durch die Schnittstelle Moduldatenverarbeiter festgelegt.
 * @author Droxl
 */
public class Moduldatenimportierer implements Moduldatenverarbeiter {
    /**
     * Modulverwaltung, in die Module importiert werden.
     */
    private Modulverwaltung verwaltung;
    /**
     * Erzeugt den Moduldatenimportierer, der mittels Modulverwaltung,
     * die verarbeiteten Module, einer Modulverwaltung hinzufügt.
     * @param verwaltung übergebene Modulverwaltung,
     *                   der dieser Moduldatenimportierer Module hinzufügt.
     */
    public Moduldatenimportierer(Modulverwaltung verwaltung) {
        this.verwaltung = verwaltung;
    }
    /**
     * Die Methode verarbeitet das übergebene Modul, indem sie es in die
     * Modulverwaltung importiert.
     * @param fach Modul das importiert wird.
     */
    @Override
    public void verarbeiteModule(Modul fach) {
        verwaltung.fuegeHinzu(fach);
    }
}