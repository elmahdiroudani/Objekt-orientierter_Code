package ausdruck;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * Eine, auf JUnit 4.12 basierende, Testklasse für Tests
 * der Klasse Konstante.
 * @author Droxl
 */
public class KonstanteTest {
    /**
     * Die Belegung der Konstanten.
     */
    private Variablenbelegung belegung;
    /**
     * Testet die Methode gibWert() der Klasse Konstante zum ersten Mal.
     */
    @Test
    public void test1GibWert() {
        assertEquals(2, new Konstante(2).gibWert(belegung));
        System.out.println(new Konstante(2).toString());
    }
    /**
     * Testet die Methode gibWert() der Klasse Konstante zum zweiten Mal.
     */
    @Test
    public void test2GibWert() {
        assertEquals(28, new Konstante(28).gibWert(belegung));
        System.out.println(new Konstante(28).toString());
    }
    /**
     * Testet die Methode gibWert() der Klasse Konstante zum dritten Mal.
     */
    @Test
    public void test3GibWert() {
        assertEquals(82, new Konstante(82).gibWert(belegung));
        System.out.println(new Konstante(82).toString());
    }
    /**
     * Testet die Methode gibWert() der Klasse Konstante zum vierten Mal.
     */
    @Test
    public void test4GibWert() {
        assertEquals(8, new Konstante(8).gibWert(belegung));
        System.out.println(new Konstante(8).toString());
    }
    /**
     * Testet die Methode gibWert() der Klasse Konstante zum fünften Mal.
     */
    @Test
    public void test5GibWert() {
        assertEquals(5, new Konstante(5).gibWert(belegung));
        System.out.println(new Konstante(5).toString());
    }
    /**
     * Testet die Methode gibWert() der Klasse Konstante zum sechsten Mal.
     */
    @Test
    public void test6GibWert() {
        assertEquals(6, new Konstante(6).gibWert(belegung));
        System.out.println(new Konstante(6).toString());
    }
    /**
     * Testet die Methode gibWert() der Klasse Konstante zum siebten Mal.
     */
    @Test
    public void test7GibWert() {
        assertEquals(56, new Konstante(56).gibWert(belegung));
        System.out.println(new Konstante(56).toString());
    }
    /**
     * Testet die Methode gibWert() der Klasse Konstante zum achten Mal.
     */
    @Test
    public void test8GibWert() {
        assertEquals(65, new Konstante(65).gibWert(belegung));
        System.out.println(new Konstante(65).toString());
    }
}