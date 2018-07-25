package modul;
/**
 * Ein Objekt dieser Klasse repräsentiert ein Modul.
 * @author Droxl
 */
public class Modul implements Comparable<Modul> {
    /**
     * Das Kürzel des Moduls.
     */
    private final String kuerzel;
    /**
     * Die Bezeichnung des Moduls.
     */
    private final String bezeichnung;
    /**
     * Hier werden nur die Studiengänge gespeichert.
     */
    private java.util.HashSet<Studiengang> studiengaenge;
    /**
     * Meldung für den Ausnahmefall, der hoffentlich nicht eintreten muss.
     */
    private final String meldung =
            "Ein Modul kann nicht gleichzeitig zu Bachelor- und "
            + "Masterstudiengang gehören.";
    /**
     * Erzeugt ein Objekt dieser Klasse für die angegebenen Daten.
     * @param kuerzel Kürzel des Moduls z.B. EPR.
     * @param bezeichnung Bezeichnung des Moduls
     * z.B. "Einführung in die Programmierung.
     */
    public Modul(String kuerzel, String bezeichnung) {
        this.kuerzel = kuerzel;
        this.bezeichnung = bezeichnung;
        /*
        Zeigt zu wie vielen Studiengängen das Modul gehört.
        */
        studiengaenge = new java.util.HashSet<>();
    }
    /**
     * Durch Anwendung der Methode wird einem Modul mitgeteilt,
     * dass es in dem entsprechenden Studiengang angeboten wird.
     * Ein Modul kann in mehreren Studiengängen angeboten werden,
     * allerdings immer nur nach Bachelor oder Master kategorisiert.
     * 
     * NIEMALS IN BACHELOR UND MASTER!
     * 
     * @param studiengang Dieser Studiengang wird dem Modul hinzugefügt,
     * wenn er noch nicht enthalten ist.
     * @throws IllegalArgumentException Es wird eine Ausnahme mit der Meldung:
     * "Ein Modul kann nicht gleichzeitig zu Bachelor- und Masterstudiengang
     * gehören." geworfen, wenn einem Modul sowohl ein Bachelor-,
     * und ein Masterstudiengang übergeben wird.
     */
    public void fuegeStudiengangHinzu(Studiengang studiengang) 
            throws IllegalArgumentException {
        /*
        Handelt es sich bei dem hinzuzufügenden Studiengang um den
        Bachelor in Informatik, Bachelor in Medieninformatik,
        Bachelor in Wirtschaftsinformatik
        und ist dieses Modul bereits einem Master-Studiengang zugeordnet...
        */
        if ((Studiengang.IN_BA == studiengang
                || Studiengang.MI_BA == studiengang
                || Studiengang.WI_BA == studiengang)
                && (studiengaenge.contains(Studiengang.IN_MA)
                || studiengaenge.contains(Studiengang.MI_MA)
                || studiengaenge.contains(Studiengang.WI_MA)
                || studiengaenge.contains(Studiengang.IS_MA))) {
            //...wird eine "Illegales Argument"-Ausnahme ausgelöst.
            throw new IllegalArgumentException(meldung);
            /*
            Handelt es sich bei dem hinzuzufügenden Studiengang um den
            Master-Informatik, Master-Medieninformatik,
            Master-Wirtschaftsinformatik oder den Master in Internet-Sicherheit
            und ist dieses Modul bereits einem
            Bachelor-Studiengang zugeordnet...
            */
        } else if ((Studiengang.IN_MA == studiengang
                || Studiengang.MI_MA == studiengang
                || Studiengang.WI_MA == studiengang
                || Studiengang.IS_MA == studiengang)
                && (studiengaenge.contains(Studiengang.IN_BA)
                || studiengaenge.contains(Studiengang.WI_BA)
                || studiengaenge.contains(Studiengang.MI_BA))) {
            //...wird ebenfalls eine "Illegales Argument"-Ausnahme ausgelöst.
            throw new IllegalArgumentException(meldung);
            /*
            Wurde das Modul noch keinem Studiengang zugeordnet...
            */
        } else {
            //...wird der Studiengang dem Modul zugeordnet.
            studiengaenge.add(studiengang);
        }
    }
    /**
     * Liefert standardmäßige textuelle Darstellung dieses Moduls.
     * @return textuelle Darstellung dieses Moduls.
     */
    @Override
    public String toString() {
        return kuerzel + ";" + bezeichnung;
    }
    /**
     * Liefert das Kürzel des Moduls.
     * @return Liefert das Modulkürzel.
     */
    public String gibKuerzel() {
        return kuerzel;
    }
    /**
     * Liefert die Bezeichnung des Moduls.
     * @return Liefert die Modulbezeichnung.
     */
    public String gibBezeichnung() {
        return bezeichnung;
    }
    /**
     * Textuelle Repräsentation des Moduls mit oder ohne Studiengänge
     * (siehe dazu auch überschriebene Methode toString() in dieser Klasse).
     * @return Textuelle Repräsentation dieses Moduls.
     */
    public String gibText() {
        //Textuelle Repräsentation der Studiengänge dieses Moduls.
        String dieStudiengaenge = "";
        /*
        Läuft einmal über alle enthaltenen Studiengänge
        und sorgt für eine textuelle Repräsentation eben dieser.
        */
        for (Studiengang studiengang : studiengaenge) {
            dieStudiengaenge = dieStudiengaenge + studiengang + ",";
        }
        /*
        Textuelle Repräsentation des Moduls mit oder ohne
        zugehörige Studiengänge.
        */
        String rueckgabe = !this.studiengaenge.isEmpty()
                ? toString() + ";" + dieStudiengaenge
                : toString();
        //Textuelle Ausgabe ohne "," am Ende.
        String gekuerzteRueckgabe
                = rueckgabe.substring(0, rueckgabe.length() - 1);
        
        return !this.studiengaenge.isEmpty()
                ? gekuerzteRueckgabe
                : toString();
    }
    /**
     * Aussage darüber, ob es sich um ein Bachelormodul handelt oder nicht.
     * @return Liefert <code>true</code>, wenn es sich um ein Bachelormodul
     * handelt, sonst <code>false</code>.
     */
    public boolean istBachelor() {
        /*
        Indikator dafür, ob es sich um ein Bachelor- oder Mastermodul handelt.
        Enthält die Menge nur Bachelormodule handelt es sich um ein
        Bachelormodul, andernfalls nicht!
        Liefert die Aussage, anhand derer sich auf ein Bachelor-
        oder Mastermodul schließen lässt.
        */
        return !studiengaenge.isEmpty()
                ? studiengaenge.iterator().next().istBachelorstudiengang()
                : false;
    }
    /**
     * Vergleicht dieses Modul mit dem übergebenen Objekt.
     * @param obj Objekt das mit diesem Modul auf Gleichheit
     * verglichen werden soll.
     * @return Gibt true zurück, falls es sich bei beiden Modulen
     * um das gleiche handelt.
     */
    @Override
    public boolean equals(Object obj) {
        /*
        Springt nur auf wahr, wenn das übergebene Objekt ein Modul ist
        und zu diesem Modul aufrufenden gleich ist.
        */
        boolean sindGleich = false;
        if (obj instanceof Modul) {
            sindGleich = this.kuerzel.equalsIgnoreCase(((Modul) obj).kuerzel)
                    && this.bezeichnung.equalsIgnoreCase(
                            ((Modul) obj).bezeichnung
                    );
        }
        return sindGleich;
    }
    /**
     * Hash-Code dieses Moduls.
     * @return Der für dieses Modul definierte Hashcode.
     */
    @Override
    public int hashCode() {
        int hash = this.kuerzel.hashCode() * 7
                + this.bezeichnung.hashCode() * 7;
        return hash;
    }
    /**
     * Vergleicht dieses Modul mit dem übergebenen Objekt.
     * @param modul Modul das mit diesem Modul auf Gleichheit
     * verglichen werden soll.
     * @return Gibt true zurück, falls es sich bei beiden Modulen
     * um das gleiche handelt.
     */
    public boolean equals(Modul modul) {
        /*
        Springt nur auf wahr, wenn das übergebene Modul zu diesem Modul
        gleich ist.
        */
        boolean sindGleich = false;
        sindGleich = this.kuerzel.equalsIgnoreCase(modul.kuerzel)
                && this.bezeichnung.equalsIgnoreCase(modul.bezeichnung);
        return sindGleich;
    }
    /**
     * Vergleicht dieses Modul mit dem übergebenen Modul,
     * um ein Kriterium zur alphabetischen Sortierung zu bieten.
     * @param modul Das übergebene Modul, welches mit dem aufrufenden Modul
     * dieser Methode hinsichtlich alphabetischer Sortierung verglichen wird.
     * @return Liegt die zurückgegebene Zahl bei 0
     */
    @Override
    public int compareTo(Modul modul) {
        int vergleichswert = this.kuerzel.compareTo(modul.kuerzel);
        if (vergleichswert == 0) {
            vergleichswert = this.bezeichnung.compareTo(modul.bezeichnung);
        }
        return vergleichswert;
    }
}