package modul;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
/**
 * Klasser zur Repräsentation der Moduldaten eines Fachbereichs.
 * @author Droxl
 */
public class Modulverwaltung {
    /**
     * Meldung der Ausnahme die im "worst-case" geworfen wird.
     */
    private final String meldung = "Das Modul ist bereits vorhanden.";
    /**
     * Speichert Module mit Namen und Moduldaten.
     */
    private TreeMap<String, Modul> module;
    /**
     * Erzeugt eine neue leere Modulverwaltung.
     */
    public Modulverwaltung() {
        module = new TreeMap();
    }
    /**
     * Hierdurch wird der Modulverwaltung ein Modul hinzugefügt.
     * @param modul Dieses Modul wird der Modulverwaltung hinzugefügt,
     * wenn es noch nicht enthalten ist.
     * @throws IllegalArgumentException Das Modul ist bereits vorhanden.
     */
    public void fuegeHinzu(Modul modul) throws IllegalArgumentException {
        /*
        Ist genau das übergebene Modul bereits in der
        Modulverwaltung enthalten,
        führt dies zu einer "Illegales Argument"-Ausnahme.
        Anderenfalls wird es der Modulverwaltung hinzugefügt.
        */
        if (module.containsKey(modul.gibKuerzel())) {
            throw new IllegalArgumentException(meldung);
        } else {
            module.put(modul.gibKuerzel(), modul);
        }
    }
    /**
     * Liefert entweder alle Bachelormodule (für Parameter true) oder
     * alle Mastermodule.
     * @param fuerBachelor Entscheidet ob alle Bachelor- oder alle Mastermodule
     * zurückgegeben werden.
     * @return Bei <code>true</code> werden alle Bachelormodule
     * und bei <code>false</code> alle Mastermodule ausgegeben.
     */
    public Set<Modul> gibModule(boolean fuerBachelor) {
        //Menge aller Bachelor-Module.
        Set<Modul> modulmengeBachelor = new TreeSet();
        module.values().stream().filter(
                (m) -> (m.istBachelor())
        ).forEach((m) -> {
            modulmengeBachelor.add(m);
        });
//        //Altmodisch
//        for (Modul m : module.values()) {
//            if (m.gibModulIstBachelor()) {
//                modulmengeBachelor.add(m);
//            }
//        }
        //Menge aller Master-Module.
        Set<Modul> modulmengeMaster = new TreeSet();
        module.values().stream().filter(
                (m) -> (!m.istBachelor())
        ).forEach((m) -> {
            modulmengeMaster.add(m);
        });
//        for (Modul m : module.values()) {
//            if (!m.gibModulIstBachelor()) {
//                modulmengeBachelor.add(m);
//            }
//        }
        /*
        Ausgabe in Abhängigkeit dessen, ob es sich bei dem übergebenen Parameter
        um Bachelor- oder Mastermodule handelt.
        */
        return fuerBachelor
                ? modulmengeBachelor
                : modulmengeMaster;
    }
}