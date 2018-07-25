package modul;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * Testet das Verhalten des Objekts Modul.
 * @author Droxl
 */
public class ModulTest {
    /**
     * Modul das getestet wird.
     */
    private Modul modul;
    /**
     * Kürzel des Moduls das getestet wird.
     */
    private String kuerzel;
    /**
     * Bezeichnung des Moduls das getestet wird.
     */
    private String bezeichnung;
    /**
     * Die Fehlerfall-Ausnahme im Notfall.
     */
    private final String meldung =
            "Ein Modul kann nicht gleichzeitig zu Bachelor- "
            + "und Masterstudiengang gehören.";
    /**
     * Meldung für den Ausnahmefall, dass das Modul keinem Studiengang angehört.
     */
    private final String MSG_KEIN_STUDIENGANG =
            "Das Modul wurde noch keinem Studiengang hinzugefügt.";
    //Testdaten aufbauen.
    @Before
    public void setUp() {
        //Neue Modulverwaltung zum Testen.
        modul = new Modul(kuerzel, bezeichnung);
    }
    @Test
    public void testFuegeHinzu1() {
        kuerzel = "EPR";
        bezeichnung = "Einführung in die Programmierung";
        try {
            modul.fuegeStudiengangHinzu(Studiengang.IN_BA);
            modul.fuegeStudiengangHinzu(Studiengang.MI_BA);
            modul.fuegeStudiengangHinzu(Studiengang.WI_BA);
            /*
            Bei korrektem Verhalten der "fuegeHinzu"-Methode darf diese
            Stelle nicht erreicht werden. Falls doch, verhält sich
            die "fuegeHinzu"-Methode fehlerhaft.
            */
            //fail("Es wurde keine Ausnahme geworfen.");
        } catch (IllegalArgumentException exc) {
            /*
            Kommt es zu einer IllegalArgumentException und enthält
            die Ausnahme die Meldung: "Das Modul ist bereits vorhanden.",
            dann ist die Methode "fuegeHinzu" für diesen Testfall korrekt.
            */
            assertEquals(meldung, exc.getMessage());
        }
    }
    @Test
    public void testFuegeHinzu2() {
        kuerzel = "OPR";
        bezeichnung = "Objekt-orientierteE Programmierung";
        try {
            modul.fuegeStudiengangHinzu(Studiengang.IN_BA);
            modul.fuegeStudiengangHinzu(Studiengang.MI_BA);
            modul.fuegeStudiengangHinzu(Studiengang.WI_BA);
            /*
            Bei korrektem Verhalten der "fuegeHinzu"-Methode darf diese
            Stelle nicht erreicht werden. Falls doch, verhält sich
            die "fuegeHinzu"-Methode fehlerhaft.
            */
            //fail("Es wurde keine Ausnahme geworfen.");
        } catch (IllegalArgumentException exc) {
            /*
            Kommt es zu einer IllegalArgumentException und enthält
            die Ausnahme die Meldung: "Das Modul ist bereits vorhanden.",
            dann ist die Methode "fuegeHinzu" für diesen Testfall korrekt.
            */
            assertEquals(meldung, exc.getMessage());
        }
    }
    @Test
    public void testFuegeHinzu3() {
        Modul modulepr = new Modul("EPR", "Einführung in die Programmierung");
        Modul modulopr = new Modul("OPR", "Objekt-orientierteE Programmierung");
        try {
            modulepr.fuegeStudiengangHinzu(Studiengang.IN_BA);
            modul.fuegeStudiengangHinzu(Studiengang.MI_BA);
            modul.fuegeStudiengangHinzu(Studiengang.WI_BA);
            modul.fuegeStudiengangHinzu(Studiengang.IS_MA);
            /*
            Bei korrektem Verhalten der "fuegeHinzu"-Methode darf diese
            Stelle nicht erreicht werden. Falls doch, verhält sich
            die "fuegeHinzu"-Methode fehlerhaft.
            */
            //fail("Es wurde keine Ausnahme geworfen.");
        } catch (IllegalArgumentException exc) {
            /*
            Kommt es zu einer IllegalArgumentException und enthält
            die Ausnahme die Meldung: "Das Modul ist bereits vorhanden.",
            dann ist die Methode "fuegeHinzu" für diesen Testfall korrekt.
            */
            assertEquals(meldung, exc.getMessage());
        }
    }
    @Test
    public void testModulEPRGibText1() {
        Modul modulepr = new Modul("EPR", "Einführung in die Programmierung");
        try {
            modulepr.gibText();
        //fail("Es wurde keine Ausnahme geworfen.");
        } catch (IllegalArgumentException exc) {
            assertEquals("Das Modul wurde noch keinem Studiengang hinzugefügt.",
                    MSG_KEIN_STUDIENGANG, exc.getMessage());
        }
    }
    @Test
    public void testModulEPRGibText2() {
        Modul modulepr = new Modul("EPR", "Einführung in die Programmierung");
        modulepr.fuegeStudiengangHinzu(Studiengang.IN_BA);
        modulepr.fuegeStudiengangHinzu(Studiengang.MI_BA);
        modulepr.fuegeStudiengangHinzu(Studiengang.WI_BA);
        
        assertEquals("EPR;Einführung in die Programmierung;WI_BA,IN_BA,MI_BA", 
                modulepr.gibText());
        System.out.println(modulepr.gibText());
    }
    @Test
    public void testModulOPRGibText1() {
        Modul modulopr = new Modul("OPR", "Objekt-orientierte Programmierung");
        modulopr.fuegeStudiengangHinzu(Studiengang.IN_BA);
        
        assertEquals("OPR;Objekt-orientierte Programmierung;IN_BA",
                modulopr.gibText());
        //Textuelle Ausgabe zur Augenkontrolle
        System.out.println(modulopr.gibText());
    }
    @Test
    public void testModulOPRGibText2() {
        Modul modulopr = new Modul("OPR", "Objekt-orientierte Programmierung");
        modulopr.fuegeStudiengangHinzu(Studiengang.IN_BA);
        modulopr.fuegeStudiengangHinzu(Studiengang.MI_BA);
        modulopr.fuegeStudiengangHinzu(Studiengang.WI_BA);
        assertEquals("OPR;Objekt-orientierte Programmierung;WI_BA,IN_BA,MI_BA",
                modulopr.gibText());
        System.out.println(modulopr.gibText());
    }
}