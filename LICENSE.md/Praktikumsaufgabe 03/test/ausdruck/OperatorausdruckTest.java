package ausdruck;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;
/**
 * Eine, auf JUnit 4.12 basierende, Testklasse 
 * für Tests der Klasse Operatorausdruck.
 * @author Droxl
 */
public class OperatorausdruckTest {
    /**
     * Die Belegung der Variablen.
     */
    private Variablenbelegung belegung;
    /**
     * Testdaten aufbauen.
     */
    @Before
    public void setUp() {
        //Neue Belegung der Variablen
        belegung = new Variablenbelegung();
        //Variable c (mit Wert 10)
        belegung.belege("c", 10);
        
        //Variable a1 (mit Wert 0) - 3
        belegung.belege("a1", 0);
        
        //Variable c4 (mit Wert 10) * 3
        belegung.belege("c4", 10);
        
        //Variable b3 (mit Wert 25) + / 5
        belegung.belege("b3", 25);
    }
    /**
     * Testet zum ersten Mal die Methode gibWert() der Klasse Operatorausdruck.
     */
    @Test
    public void test1GibWert() {
        int sollWert = 35;
        /**
         * Das Sollergebnis Nummer eins.
         * Variable c (mit Wert 10) + 25
         */
        Ausdruck sollAusdruck1 = new Operatorausdruck(new Variable("c"), '+', 
                new Konstante(25));
        Assert.assertEquals(sollWert, sollAusdruck1.gibWert(belegung));
        //Textuelle Darstellung für die Fehlerüberprüfung.
        String operation1 = new Operatorausdruck(new Variable("c"),
                '+', new Konstante(25)).gibText();
        System.out.println("Test1: " + operation1);
    }
    /**
     * Testet zum zweiten Mal die Methode gibWert() der Klasse Operatorausdruck.
     */
    @Test
    public void test2GibWert() {
        int sollWert = -3;
        /**
         * Das Sollergebnis Nummer zwei.
         * Variable a1 (mit Wert 0) - 3
         */
        Ausdruck sollAusdruck2 = new Operatorausdruck(new Variable("a1"), '-', 
                new Konstante(3));
        //Variable a1 (mit Wert 0) - 3
        Assert.assertEquals(sollWert, sollAusdruck2.gibWert(belegung));
        //Textuelle Darstellung für die Fehlerüberprüfung.
        String operation2 = new Operatorausdruck(new Variable("a1"),
                '-', new Konstante(3)).gibText();
        System.out.println("Test2: " + operation2);
    }
    /**
     * Testet zum dritten Mal die Methode gibWert() der Klasse Operatorausdruck.
     */
    @Test
    public void test3GibWert() {
        int sollWert = 30;
        /**
         * Das Sollergebnis Nummer zwei.
         * Variable c4 (mit Wert 10) * 3
         */
        Ausdruck sollAusdruck3 = new Operatorausdruck(new Variable("c4"), '*', 
                new Konstante(3));
        //Variable c4 (mit Wert 10) * 3
        Assert.assertEquals(sollWert, sollAusdruck3.gibWert(belegung));
        //Textuelle Darstellung für die Fehlerüberprüfung.
        String operation3 = new Operatorausdruck(new Variable("c4"),
                '*', new Konstante(3)).gibText();
        System.out.println("Test3: " + operation3);
    }
    /**
     * Testet zum vierten Mal die Methode gibWert() 
     * der Klasse Operatorausdruck.
     */
    @Test
    public void test4GibWert() {
        int sollWert = 5;
        /**
         * Das Sollergebnis Nummer zwei.
         * Variable b3 (mit Wert 25) + / 5
         */
        Ausdruck sollAusdruck4 = new Operatorausdruck(new Variable("b3"), '/', 
                new Konstante(5));
        //Variable c4 (mit Wert 10) * 3
        Assert.assertEquals(sollWert, sollAusdruck4.gibWert(belegung));
        //Textuelle Darstellung für die Fehlerüberprüfung.
        String operation4 = new Operatorausdruck(new Variable("b3"), '/', 
                new Konstante(5)).gibText();
        System.out.println("Test4: " + operation4);
    }
    /**
     * Testet zum ersten Mal die Methode equals() 
     * der Klasse Operatorausdruck.
     */
    @Test
    public void testEquals1() {
        Ausdruck sollAusdruck5 = new Operatorausdruck(new Konstante(1), '+', 
                new Konstante(2));
        Ausdruck sollAusdruck6 = new Operatorausdruck(new Konstante(1), '+', 
                new Konstante(2));
        Assert.assertTrue(sollAusdruck5.equals(sollAusdruck6));
        Assert.assertTrue(sollAusdruck6.equals(sollAusdruck5));
    }
    /**
     * Testet zum zweiten Mal die Methode equals() 
     * der Klasse Operatorausdruck.
     */
    @Test
    public void testEquals2() {
        Ausdruck sollAusdruck7 = new Operatorausdruck(new Variable("a1"), '+', 
                new Variable("c4"));
        Ausdruck sollAusdruck8 = new Operatorausdruck(new Variable("a1"), '+', 
                new Variable("c4"));
        Assert.assertTrue(sollAusdruck7.equals(sollAusdruck8));
        Assert.assertTrue(sollAusdruck8.equals(sollAusdruck7));
    }
}
