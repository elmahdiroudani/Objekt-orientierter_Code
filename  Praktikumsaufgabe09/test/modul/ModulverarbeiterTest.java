package modul;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Testet die Funktionalität die ein Modulverarbeiter erbringen muss.
 * Hierzu dient die Attrappe.
 * @author Droxl
 */
public class ModulverarbeiterTest {
    /**
     * Attrappe zu Testzwecken.
     */
    private MockModulverarbeiter mockModulverarbeiter;
    /**
     * Modul für Tests mit dem Modulverarbeiter.
     */
    private Modul modul;
    /**
     * Testsdaten vorbereiten.
     */
    @Before
    public void setUp() {
        mockModulverarbeiter = new MockModulverarbeiter();
    }
    @Test
    public void testVerarbeiteModule1() {
        String kuerzel = "EPR";
        String bezeichnung = "Einführung in die Programmierung";
        modul = new Modul(kuerzel, bezeichnung);
        mockModulverarbeiter.verarbeiteModule(modul);
    }
    @Test
    public void testVerarbeiteModule2() {
        String kuerzel = "OPR";
        String bezeichnung = "Objekt-orientierte Programmierung";
        modul = new Modul(kuerzel, bezeichnung);
        mockModulverarbeiter.verarbeiteModule(modul);
    }
    @Test
    public void testGibModule() {
        String kuerzel1 = "EPR";
        String bezeichnung1 = "Einführung in die Programmierung";
        Modul modul1;
        modul1 = new Modul(kuerzel1, bezeichnung1);
        String kuerzel2 = "OPR";
        String bezeichnung2 = "Objekt-orientierte Programmierung";
        Modul modul2;
        modul2 = new Modul(kuerzel2, bezeichnung2);
        
        mockModulverarbeiter.verarbeiteModule(modul1);
        mockModulverarbeiter.verarbeiteModule(modul2);
        
        ArrayList<Modul> alleModule = new ArrayList();
        
        alleModule.add(modul1);
        alleModule.add(modul2);
        assertEquals(alleModule, mockModulverarbeiter.gibModule());
    }
}