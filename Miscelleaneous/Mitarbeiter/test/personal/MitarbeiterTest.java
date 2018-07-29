package personal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Diese Klasse dient dazu den Test für die Methode gibPersonalstruktur()
 * der Klasse Mitarbeiter durchzuführen.
 * @author Droxl
 */
public class MitarbeiterTest {
    /**
     * Test der Methode gibPersonalstruktur().
     */
    @Test
    public void testGibPersonalstruktur() {
        ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<>();
        
        Vorgesetzter obersterVorgesetzter = new Vorgesetzter(
                "Oberster Vorgesetzter");
        Vorgesetzter vorgesetzter = new Vorgesetzter("Vorgesetzter");
        vorgesetzter.setzeVorgesetzten(obersterVorgesetzter);
        
        Mitarbeiter mitarbeiter1 = new Mitarbeiter("Mitarbeiter1");
        Mitarbeiter mitarbeiter2 = new Mitarbeiter("Mitarbeiter2");
        
        mitarbeiter1.setzeVorgesetzten(vorgesetzter);
        mitarbeiter2.setzeVorgesetzten(vorgesetzter);
        
        mitarbeiter.add(mitarbeiter1);
        mitarbeiter.add(mitarbeiter2);
        mitarbeiter.add(obersterVorgesetzter);
        mitarbeiter.add(vorgesetzter);
        
        HashMap<Vorgesetzter, HashSet<Mitarbeiter>> sollergebnis
                = new HashMap<>();
        
        HashSet<Mitarbeiter> ms = new HashSet<>();
        ms.add(mitarbeiter1);
        ms.add(mitarbeiter2);
        sollergebnis.put(vorgesetzter, ms);
        
        ms = new HashSet<>();
        ms.add(vorgesetzter);
        sollergebnis.put(obersterVorgesetzter, ms);
        
        assertEquals(
                sollergebnis,
                Mitarbeiter.gibPersonalstruktur(mitarbeiter)
        );
    }
}