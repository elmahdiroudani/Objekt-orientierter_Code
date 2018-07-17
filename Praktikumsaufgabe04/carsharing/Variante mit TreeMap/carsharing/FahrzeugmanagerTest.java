package carsharing;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Klasse die Funktionen einer CarSharing-Anwendung überprüft
 * und zwar mithilfe von JUnit 4.12.
 * @author Droxl
 */
public class FahrzeugmanagerTest {
    /**
     * Das gewünschte Ergebnis.
     */
    private ArrayList<String> sollErgebnis;
    /**
     * Erzeugt einen Fahrzeugmanager, der die Fahrzeuge verwaltet.
     */
    private Fahrzeugmanager manager;
    /**
     * Testdaten aufbauen.
     */
    @Before
    public void setUp() {
        //Sollergebnis zur Überprüfung.
        sollErgebnis = new ArrayList();
        //Legt einen neuen Fahrzeugmanager an.
        manager = new Fahrzeugmanager();
        //Bereitet das Testobjekt für Tests vor.
        manager.fuegeFahrzeugHinzu("Rathaus 1", "Rathaus");
        manager.fuegeFahrzeugHinzu("Bahnhof 1", "Bahnhof");
        manager.fuegeFahrzeugHinzu("Bahnhof 2", "Bahnhof");
        manager.fuegeFahrzeugHinzu("Bahnhof 3", "Bahnhof");
        /*
        Fügt dem Fahrzeugmanager eine neue Buchung für dieses Fahrzeug
        zu diesem Zeitpunkt hinzu.
        */
        manager.bucheFahrzeug("Bahnhof 1", "2005/04/14 20:00",
                "2005/04/15 08:00");
        /*
        Fügt dem Fahrzeugmanager eine neue Buchung für dieses Fahrzeug
        zu diesem Zeitpunkt hinzu.
        */
        manager.bucheFahrzeug("Bahnhof 1", "2005/04/15 18:00",
                "2005/04/16 00:00");
        /*
        Fügt dem Fahrzeugmanager eine neue
        zu diesem Zeitpunkt hinzu.
        */
        manager.bucheFahrzeug("Bahnhof 2", "2005/04/14 11:00",
                "2005/04/15 12:00");
        /*
        Fügt dem Fahrzeugmanager eine neue
        zu diesem Zeitpunkt hinzu.
        */
        manager.bucheFahrzeug("Bahnhof 3", "2005/04/15 10:00",
                "2005/04/15 19:00");
    }
    /**
     * Test der Methode gibFahrzeugnamen() der Klasse Fahrzeugmanager.
     * Ohne Stringargument für den Standort.
     */
    @Test
    public void testGibFahrzeugnamenOhneStringargument() {
        ArrayList<String> sollergebnis = new ArrayList();
        sollergebnis.add("Bahnhof 1");
        sollergebnis.add("Bahnhof 2");
        sollergebnis.add("Bahnhof 3");
        sollergebnis.add("Rathaus 1");
        assertEquals(sollergebnis, manager.gibFahrzeugnamen());
    }
    /**
     * Erster Test der Methode gibFahrzeugnamen() der Klasse Fahrzeugmanager.
     * Mit Stringargument für den Standort.
     */
    @Test
    public void testGibFahrzeugnamenMitStringargument1() {
        //Standort Bahnhof Liste mit Bahnhof 1, Bahnhof 2, Bahnhof 3
        sollErgebnis.add("Bahnhof 1");
        sollErgebnis.add("Bahnhof 2");
        sollErgebnis.add("Bahnhof 3");
        assertEquals(sollErgebnis, manager.gibFahrzeugnamen("Bahnhof"));
    }
    /**
     * Zweiter Test der Methode gibFahrzeugnamen() der Klasse Fahrzeugmanager.
     * Mit Stringargument für den Standort.
     */
    @Test
    public void testGibFahrzeugnamenMitStringargument2() {
        //Standort Bahnhof Liste mit Bahnhof 1, Bahnhof 2, Bahnhof 3
        sollErgebnis.add("Rathaus 1");
        assertEquals(sollErgebnis, manager.gibFahrzeugnamen("Rathaus"));
    }
    /**
     * Test der Methode gibVerfuegbareFahrzeuge() der Klasse Fahrzeugmanager.
     */
    @Test
    public void testGibVerfuegbareFahrzeuge1() {
        //Standort Bahnhof Liste mit Bahnhof 1, Bahnhof 2, Bahnhof 3
        /*
        Soll: leere Liste
        */
        assertEquals(sollErgebnis, manager.gibVerfuegbareFahrzeuge("Bahnhof",
                "2005/04/15 11:30", "2005/04/15 19:00"));
    }
    /**
     * Test der Methode gibVerfuegbareFahrzeuge() der Klasse Fahrzeugmanager.
     */
    @Test
    public void testGibVerfuegbareFahrzeuge2() {
        //Standort Bahnhof Liste mit Bahnhof 1, Bahnhof 2, Bahnhof 3
        sollErgebnis.add("Bahnhof 1");
        sollErgebnis.add("Bahnhof 2");
        /*
        Soll: Liste mit Bahnhof 1, Bahnhof 2
        */
        assertEquals(sollErgebnis, manager.gibVerfuegbareFahrzeuge("Bahnhof",
                "2005/04/15 12:00", "2005/04/15 18:00"));
    }
    /**
     * Test der Methode gibVerfuegbareFahrzeuge() der Klasse Fahrzeugmanager.
     */
    @Test
    public void testGibVerfuegbareFahrzeuge3() {
        //Standort Bahnhof Liste mit Bahnhof 1, Bahnhof 2, Bahnhof 3
        sollErgebnis.add("Bahnhof 2");
        sollErgebnis.add("Bahnhof 3");
        /*
        Soll: Liste mit Bahnhof 2, Bahnhof 3
        */
        assertEquals(sollErgebnis, manager.gibVerfuegbareFahrzeuge("Bahnhof",
                "2005/04/15 19:15", "2005/04/15 23:00"));
    }
    /**
     * Test der Methode bucheFahrzeug() der Klasse Fahrzeugmanager.
     */
    @Test
    public void testBucheFahrzeug1() {
        //Soll: true
        assertTrue(manager.bucheFahrzeug("Bahnhof 3",
                "2005/04/15 09:00", "2005/04/15 10:00"));
    }
    /**
     * Test der Methode bucheFahrzeug() der Klasse Fahrzeugmanager.
     */
    @Test
    public void testBucheFahrzeug2() {
        //Soll: false
        assertFalse(manager.bucheFahrzeug("Bahnhof 3",
                "2005/04/15 09:00", "2005/04/15 11:00"));
    }
    /**
     * Test der Methode bucheFahrzeug() der Klasse Fahrzeugmanager.
     */
    @Test
    public void testBucheFahrzeug3() {
        //Soll: false
        assertFalse(manager.bucheFahrzeug("Bahnhof 3",
                "2005/04/15 11:00", "2005/04/15 18:00"));
    }
    /**
     * Test der Methode bucheFahrzeug() der Klasse Fahrzeugmanager.
     */
    @Test
    public void testBucheFahrzeug4() {
        //Soll: false
        assertFalse(manager.bucheFahrzeug("Bahnhof 3",
                "2005/04/15 18:00", "2005/04/15 20:00"));
    }
    /**
     * Test der Methode bucheFahrzeug() der Klasse Fahrzeugmanager.
     */
    @Test
    public void testBucheFahrzeug5() {
        //Soll: true
        assertTrue(manager.bucheFahrzeug("Bahnhof 3",
                "2005/04/15 19:00", "2005/04/15 20:00"));
    }
    /**
     * Test der Methode bucheFahrzeug() der Klasse Fahrzeugmanager.
     */
    @Test
    public void testBucheFahrzeug6() {
        //Soll: false
        assertFalse(manager.bucheFahrzeug("Bahnhof 3",
                "2005/04/15 09:00", "2005/04/15 20:00"));
    }
}