package modul;
import java.util.Set;
import java.util.TreeSet;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
/**
 * Testet die Modulverwaltung hinsichtlich ihrer Methoden.
 * @author Droxl
 */
public class ModulverwaltungTest {
    /**
     * Modulverwaltung die getestet wird.
     */
    Modulverwaltung verwaltung;
    /**
     * Modul zum Testen der Modulverwaltung.
     */
    Modul testmodulEPR;
    /**
     * Modul zum Testen der Modulverwaltung.
     */
    Modul testmodulOPR;
    /**
     * Kürzel des Moduls.
     */
    String modulKuerzel;
    /**
     * Bezeichnung des Moduls.
     */
    String modulBezeichnung;
    //Testdaten aufbauen.
    @Before
    public void setUp() {
        //Neue Modulverwaltung zum Testen.
        verwaltung = new Modulverwaltung();
        //Testmodul-"Einführung in die Programmierung" mit IN_BA,MI_BA,WI_BA
        testmodulEPR = new Modul("EPR", "Einführung in die Programmierung");
        testmodulEPR.fuegeStudiengangHinzu(Studiengang.IN_BA);
        testmodulEPR.fuegeStudiengangHinzu(Studiengang.MI_BA);
        testmodulEPR.fuegeStudiengangHinzu(Studiengang.WI_BA);
        //Testmodul-"Objekt-orientierte Programmierung" mit IN_BA,MI_BA,WI_BA
        testmodulOPR = new Modul("OPR", "Objekt-orientierte Programmierung");
        testmodulOPR.fuegeStudiengangHinzu(Studiengang.IN_BA);
        testmodulOPR.fuegeStudiengangHinzu(Studiengang.MI_BA);
        testmodulOPR.fuegeStudiengangHinzu(Studiengang.WI_BA);
    }
    @Test
    public void testFuegeHinzu1() {
        try {
            verwaltung.fuegeHinzu(testmodulOPR);
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
            assertEquals("Das Modul ist bereits vorhanden.", exc.getMessage());
        }
    }
    @Test
    public void testFuegeHinzu2() {
        try {
            verwaltung.fuegeHinzu(testmodulEPR);
            verwaltung.fuegeHinzu(testmodulOPR);
            /*
            Zeigt, dass die gewünschte Ausgabe eintritt.
            */
            System.out.println(verwaltung.gibModule(true));
        } catch (IllegalArgumentException exc) {
            /*
            Kommt es zu einer IllegalArgumentException und enthält
            die Ausnahme die Meldung: "Das Modul ist bereits vorhanden.",
            dann ist die Methode "fuegeHinzu" für diesen Testfall korrekt.
            */
            assertEquals("Das Modul ist bereits vorhanden.", exc.getMessage());
        }
    }
//    @Ignore
//    public void testGibModule() {
//        Modul modulepr = new Modul("OPR", "Objekt-orientierte Prgrammierung");
//        Modul modulopr = new Modul("OPR", "Objekt-orientierte Prgrammierung");
//        try {
//            verwaltung.fuegeHinzu(modulepr);
//            verwaltung.fuegeHinzu(modulopr);
//            /*
//            Bei korrektem Verhalten der "fuegeHinzu"-Methode darf diese
//            Stelle nicht erreicht werden. Falls doch, verhält sich
//            die "fuegeHinzu"-Methode fehlerhaft.
//            */
//            fail("Es wurde keine Ausnahme geworfen.");
//        } catch (IllegalArgumentException exc) {
//            /*
//            Kommt es zu einer IllegalArgumentException und enthält
//            die Ausnahme die Meldung: "Das Modul ist bereits vorhanden.",
//            dann ist die Methode "fuegeHinzu" für diesen Testfall korrekt.
//            */
//            assertEquals("Das Modul ist bereits vorhanden.", exc.getMessage());
//        }
//    }
    @Test
    public void testGibModule1() {
        Modul modulepr = new Modul("EPR", "Einführung in die Prgrammierung");
        Modul modulopr = new Modul("OPR", "Objekt-orientierte Prgrammierung");
        Modul modulisy = new Modul("ISY", "Intelligente Systeme");
        Modul modulvbi = new Modul("VBI",
                "Vertiefung betriebliche Informationssysteme");
        //BACHELOR
        modulepr.fuegeStudiengangHinzu(Studiengang.IN_BA);
        modulopr.fuegeStudiengangHinzu(Studiengang.IN_BA);
        //MASTER
        modulisy.fuegeStudiengangHinzu(Studiengang.IS_MA);
        modulvbi.fuegeStudiengangHinzu(Studiengang.WI_MA);
        
        Set<Modul> sollErgebnis = new TreeSet();
        sollErgebnis.add(modulepr);
        sollErgebnis.add(modulopr);
        try {
            verwaltung.fuegeHinzu(modulepr);
            verwaltung.fuegeHinzu(modulopr);
            verwaltung.fuegeHinzu(modulisy);
            verwaltung.fuegeHinzu(modulvbi);
            /*
            Vergleicht ob das Format von Sollergebnis und
            tatsächlichem Ergebnis identisch sind.
            */
            assertEquals(sollErgebnis, verwaltung.gibModule(true));
            
            //Textuelle Ausgabe zur Überprüfung.
            String bachelorNamen = "";
            //Übernimmt für die textuelle Ausgabe nur Bachelor-Module.
            for (Modul modul : verwaltung.gibModule(true)) {
                bachelorNamen = bachelorNamen + modul + ",";
            }
            //Textuelle Ausgabe für Bachelormodule.
            System.out.println(bachelorNamen);
        } catch (IllegalArgumentException exc) {
            /*
            Kommt es zu einer IllegalArgumentException und enthält
            die Ausnahme die Meldung: "Das Modul ist bereits vorhanden.",
            dann ist die Methode "fuegeHinzu" für diesen Testfall korrekt.
            */
            assertEquals("Das Modul ist bereits vorhanden.", exc.getMessage());
        }
    }
    @Test
    public void testGibModule2() {
        Modul modulepr = new Modul("EPR", "Einführung in die Prgrammierung");
        Modul modulopr = new Modul("OPR", "Objekt-orientierte Prgrammierung");
        Modul modulisy = new Modul("ISY", "Intelligente Systeme");
        Modul modulvbi = new Modul("VBI",
                "Vertiefung betriebliche Informationssysteme");
        //BACHELOR
        modulepr.fuegeStudiengangHinzu(Studiengang.IN_BA);
        modulopr.fuegeStudiengangHinzu(Studiengang.IN_BA);
        //MASTER
        modulisy.fuegeStudiengangHinzu(Studiengang.IS_MA);
        modulvbi.fuegeStudiengangHinzu(Studiengang.WI_MA);
        
        Set<Modul> sollErgebnis = new TreeSet();
        sollErgebnis.add(modulisy);
        sollErgebnis.add(modulvbi);
        try {
            verwaltung.fuegeHinzu(modulepr);
            verwaltung.fuegeHinzu(modulopr);
            verwaltung.fuegeHinzu(modulisy);
            verwaltung.fuegeHinzu(modulvbi);
            /*
            Vergleicht ob das Format von Sollergebnis und
            tatsächlichem Ergebnis identisch sind.
            */
            assertEquals(sollErgebnis, verwaltung.gibModule(false));
            //Textuelle Ausgabe zur Überprüfung.
            String masterNamen = "";
            //Übernimmt für die textuelle Ausgabe nur Master-Module.
            for (Modul modul : verwaltung.gibModule(false)) {
                masterNamen = masterNamen + modul + ",";
            }
            //Textuelle Ausgabe für Mastermodule.
            System.out.println(masterNamen);
        } catch (IllegalArgumentException exc) {
            /*
            Kommt es zu einer IllegalArgumentException und enthält
            die Ausnahme die Meldung: "Das Modul ist bereits vorhanden.",
            dann ist die Methode "fuegeHinzu" für diesen Testfall korrekt.
            */
            assertEquals("Das Modul ist bereits vorhanden.", exc.getMessage());
        }
    }
}