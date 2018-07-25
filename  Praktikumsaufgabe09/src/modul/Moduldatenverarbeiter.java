package modul;
/**
 * Diese Schnittstelle legt fest, was ein Moduldatenverarbeiter zu leisten hat.
 * @author Droxl
 */
public interface Moduldatenverarbeiter {
    /**
     * Verarbeitet die übergebenen Fächer.
     * @param modul Modul das verarbeitet wird.
     */
    void verarbeiteModule(Modul modul);
}