package modul;
import java.util.LinkedList;
import java.util.List;
/**
 * Ein Objekt dieser Klasse ist ein Modulverarbeiter, der die durch
 * verarbeiteModule() übergebenen Module protokolliert. Die Reihenfolge
 * der Module im Protokoll entspricht der Reihenfolge, in der die Module
 * durch Aufruf der Methode verarbeiteModule übergeben werden.
 * 
 * Diese Klasse wird zum Testen der Klasse Moduldatenleser benötigt.
 * @author Droxl
 */
public class MockModulverarbeiter implements Moduldatenverarbeiter {
    /**
     * Protokolliert alle verarbeiteten Module.
     */
    private final LinkedList<Modul> protokollierteModule;
    /**
     * Erzeugt ein Objekt dieser Klasse mit anfangs leerem Protokoll.
     */
    public MockModulverarbeiter() {
        protokollierteModule = new LinkedList();
    }
    @Override
    public void verarbeiteModule(Modul modul) {
        protokollierteModule.add(modul);
    }
    /**
     * Liefert die protokollierten Module.
     * @return Die protokollierten Module.
     */
    public List<Modul> gibModule() {
        return protokollierteModule;
    }
}