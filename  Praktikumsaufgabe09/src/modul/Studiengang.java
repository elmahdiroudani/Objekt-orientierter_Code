package modul;
/**
 * Aufzählungstyp Studiengang, dessen Werte alle Studiengänge
 * des Fachbereichs repräsentieren.
 * @author Droxl
 * Dieser Aufzählungstyp enthält die Studiengänge des Fachbereichs
 * um festzustellen, ob es sich bei einem bestimmten Modul
 * um ein Bachelor-Studiengangs- oder Master-Studiengangs-Modul handelt.
 */
public enum Studiengang {
    /**
     * Bachelor-Studiengang Informatik.
     */
    IN_BA(true),
    /**
     * Bachelor-Studiengang Medieninformatik.
     */
    MI_BA(true),
    /**
     * Bachelor-Studiengang Wirtschaftsinformatik.
     */
    WI_BA(true),
    /**
     * Master-Studiengang Informatik.
     */
    IN_MA(false),
    /**
     * Master-Studiengang Medieninformatik.
     */
    MI_MA(false),
    /**
     * Master-Studiengang Wirtschaftsinformatik.
     */
    WI_MA(false),
    /**
     * Master-Studiengang Internet-Sicherheit.
     */
    IS_MA(false);
    /**
     * Bidirektionaler Indikator für wahr und falsch.
     * Stellt fest ob es sich um einen Bachelorstudiengang <code>true</code>
     * oder um einen Masterstudiengang <code>false</code> handelt.
     */
    private final boolean istBachelorstudiengang;
    /**
     * Erzeugt einen Studiengang des Fachbereichs.
     * @param istBachelorstudiengang Gibt an,
     * ob dieser Studiengang ein Bachelor-Studiengang ist.
     */
    private Studiengang(boolean istBachelorstudiengang) {
        this.istBachelorstudiengang = istBachelorstudiengang;
    }
    /**
     * Gibt an, ob dieser Studiengang ein Bachelor-Studiengang ist.
     * @return <code>true</code> genau dann, wenn er ein
     * Bachelor-Studiengang ist.
     */
    public boolean istBachelorstudiengang() {
        return istBachelorstudiengang;
    }
}