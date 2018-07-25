package modul;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * Testklasse für Methoden der Klasse Moduldatenleser.
 * @author Droxl
 */
public class ModuldatenleserTest {
    //Zeilenumbruch.
    private static final String UMBRUCH = System.getProperty("line.separator");
    @Test
    public void testLiesDaten() throws IOException {
        StringReader moduldaten;
        StringWriter fehlerprotokoll;
        
        ArrayList<Modul> sollergebnis;
        
        moduldaten = new StringReader(
                "Modul;TGI;Technische Grundlagen der Informatik" + UMBRUCH
                        + "Modul;DSG;Design-Grundlagen" + UMBRUCH
                        + "Modul;TEN-MI;Technisches Englisch für "
                                + "Medieninformatiker"
        );
        fehlerprotokoll = new StringWriter();
        try {
            MockModulverarbeiter verarbeiter = new MockModulverarbeiter();
            
            new Moduldatenleser(moduldaten,
                    fehlerprotokoll).liesDaten(verarbeiter);
            
            sollergebnis = new ArrayList<>();
            sollergebnis.add(new Modul("TGI",
                    "Technische Grundlagen der Informatik"));
            sollergebnis.add(new Modul("DSG",
                    "Design-Grundlagen"));
            sollergebnis.add(new Modul("TEN-MI",
                    "Technisches Englisch für Medieninformatiker"));
            
            assertEquals(sollergebnis, verarbeiter.gibModule());
        } finally {
            moduldaten.close();
            fehlerprotokoll.close();
        }
    }
}