package ausdruck;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * Eine, auf JUnit 4.12 basierende, Testklasse 
 * für Tests der Klasse Variable.
 * @author Droxl
 */
public class VariableTest {
    /**
     * Die Belegung der Variablen.
     */
    private Variablenbelegung belegung;
    /**
     * Testdaten aufbauen.
     */
    @Before
    public void setUp() {
        belegung = new Variablenbelegung();
        belegung.belege("a1", 0);
        belegung.belege("a2", 1);
        belegung.belege("a3", 2);
        belegung.belege("a4", 3);
        belegung.belege("a5", 4);
        belegung.belege("a6", 5);
        belegung.belege("a7", 6);
        belegung.belege("a8", 7);
    }
    /**
     * Testet Methode gibWert() der Klasse Variable.
     */
    @Test
    public void testGibWert() {
        assertEquals(0, new Variable("a1").gibWert(belegung));
        assertEquals(1, new Variable("a2").gibWert(belegung));
        assertEquals(2, new Variable("a3").gibWert(belegung));
        assertEquals(3, new Variable("a4").gibWert(belegung));
        assertEquals(4, new Variable("a5").gibWert(belegung));
        assertEquals(5, new Variable("a6").gibWert(belegung));
        assertEquals(6, new Variable("a7").gibWert(belegung));
        assertEquals(7, new Variable("a8").gibWert(belegung));
    }
}
