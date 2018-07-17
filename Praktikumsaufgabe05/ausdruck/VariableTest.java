package ausdruck;
import static org.junit.Assert.assertEquals;
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
     * Testet zum ersten Mal die Methode gibWert() der Klasse Variable.
     */
    @Test
    public void teste1GibWert() {
        Variable a1 = new Variable("a1");
        assertEquals(0, a1.gibWert(belegung));
        System.out.println(a1.toString() + " = " + a1.gibWert(belegung));
    }
    /**
     * Testet zum zweiten Mal die Methode gibWert() der Klasse Variable.
     */
    @Test
    public void teste2GibWert() {
        Variable a2 = new Variable("a2");
        assertEquals(1, a2.gibWert(belegung));
        System.out.println(a2.toString() + " = " + a2.gibWert(belegung));
    }
    /**
     * Testet zum dritten Mal die Methode gibWert() der Klasse Variable.
     */
    @Test
    public void teste3GibWert() {
        Variable a3 = new Variable("a3");
        assertEquals(2, a3.gibWert(belegung));
        System.out.println(a3.toString() + " = " + a3.gibWert(belegung));
    }
    /**
     * Testet zum vierten Mal die Methode gibWert() der Klasse Variable.
     */
    @Test
    public void teste4GibWert() {
        Variable a4 = new Variable("a4");
        assertEquals(3, a4.gibWert(belegung));
        System.out.println(a4.toString() + " = " + a4.gibWert(belegung));
    }
    /**
     * Testet zum fünften Mal die Methode gibWert() der Klasse Variable.
     */
    @Test
    public void teste5GibWert() {
        Variable a5 = new Variable("a5");
        assertEquals(4, a5.gibWert(belegung));
        System.out.println(a5.toString() + " = " + a5.gibWert(belegung));
    }
    /**
     * Testet zum sechsten Mal die Methode gibWert() der Klasse Variable.
     */
    @Test
    public void teste6GibWert() {
        Variable a6 = new Variable("a6");
        assertEquals(5, a6.gibWert(belegung));
        System.out.println(a6.toString() + " = " + a6.gibWert(belegung));
    }
    /**
     * Testet zum siebten Mal die Methode gibWert() der Klasse Variable.
     */
    @Test
    public void teste7GibWert() {
        Variable a7 = new Variable("a7");
        assertEquals(6, a7.gibWert(belegung));
        System.out.println(a7.toString() + " = " + a7.gibWert(belegung));
    }
    /**
     * Testet zum achten Mal die Methode gibWert() der Klasse Variable.
     */
    @Test
    public void teste8GibWert() {
        Variable a8 = new Variable("a8");
        assertEquals(7, a8.gibWert(belegung));
        System.out.println(a8.toString() + " = " + a8.gibWert(belegung));
    }
}