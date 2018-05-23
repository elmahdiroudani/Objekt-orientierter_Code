package rationalezahl;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Klasse zum Testen der "RationaleZahl"-Objekte.
 * @author R3V€4LeD
 */
public class RationaleZahlTest {
    /**
     * Die erste Rationale Zahl.
     */
    private RationaleZahl r1;
    /**
     * Die zweite Rationale Zahl.
     */
    private RationaleZahl r2;
    /**
     * Die dritte Rationale Zahl.
     */
    private RationaleZahl r3;
    /**
     * Die vierte Rationale Zahl.
     */
    private RationaleZahl r4;
    /**
     * Die fünfte Rationale Zahl.
     */
    private RationaleZahl r5;
    /**
     * Die sechste Rationale Zahl.
     */
    private RationaleZahl r6;
    /**
     * Die siebte Rationale Zahl.
     */
    private RationaleZahl r7;
    /**
     * Die achte Rationale Zahl.
     */
    private RationaleZahl r8;
    /**
     * Die neunte Rationale Zahl.
     */
    private RationaleZahl r9;
    /**
     * Die zehnte Rationale Zahl.
     */
    private RationaleZahl r10;
    /**
     * Das gewünschte Ergebnis.
     */
    private String sollErgebnis;
    /**
     * Test der textuellen Ausgabe der ersten Rationalen Zahl.
     */
    @Test
    public void testGibAlsTextRationaleZahl1() {
        //Legt eine neue Rationale Zahl an.
        r1 = new RationaleZahl(2L, 8L);
        sollErgebnis = "1/4";
        assertEquals(sollErgebnis, r1.gibAlsText());
    }
    /**
     * Test der textuellen Ausgabe der zweiten Rationalen Zahl.
     */
    @Test
    public void testGibAlsTextRationaleZahl2() {
        //Legt eine neue Rationale Zahl an.
        r2 = new RationaleZahl(5L, 6L);
        sollErgebnis = "5/6";
        assertEquals(sollErgebnis, r2.gibAlsText());
    }
    /**
     * Test der textuellen Ausgabe durch Addition der ersten 
     * mit der zweiten Rationalen Zahl.
     */
    @Test
    public void testGibAdditionVonR1UndR2() {
        //Legt eine neue Rationale Zahl an.
        r1 = new RationaleZahl(2L, 8L);
        //Legt eine neue Rationale Zahl an.
        r2 = new RationaleZahl(5L, 6L);
        sollErgebnis = "13/12";
        assertEquals(sollErgebnis, r1.addiere(r2).gibAlsText());
    }
    /**
     * Test der textuellen Ausgabe durch Addition der zweiten 
     * mit der ersten Rationalen Zahl.
     */
    @Test
    public void testGibAdditionVonR2UndR1() {
        //Legt eine neue Rationale Zahl an.
        r1 = new RationaleZahl(2L, 8L);
        //Legt eine neue Rationale Zahl an.
        r2 = new RationaleZahl(5L, 6L);
        sollErgebnis = "13/12";
        assertEquals(sollErgebnis, r2.addiere(r1).gibAlsText());
    }
    /**
     * Test der textuellen Ausgabe durch Addition der dritten 
     * mit der vierten Rationalen Zahl.
     */
    @Test
    public void testGibAdditionVonR3UndR4() {
        //Legt eine neue Rationale Zahl an.
        r3 = new RationaleZahl(17L, 4L);
        //Legt eine neue Rationale Zahl an.
        r4 = new RationaleZahl(7L, 4L);
        sollErgebnis = "6";
        assertEquals(sollErgebnis, r3.addiere(r4).gibAlsText());
    }
    /**
     * Test der textuellen Ausgabe durch Addition der fünften 
     * mit der sechsten Rationalen Zahl.
     */
    @Test
    public void testGibAdditionVonR5UndR6() {
        //Legt eine neue Rationale Zahl an.
        r5 = new RationaleZahl(100002L, 4L);
        //Legt eine neue Rationale Zahl an.
        r6 = new RationaleZahl(5L, 1L);
        sollErgebnis = "50011/2";
        assertEquals(sollErgebnis, r5.addiere(r6).gibAlsText());
    }
    /**
     * Test der textuellen Ausgabe durch Addition der siebten 
     * mit der achten Rationalen Zahl.
     */
    @Test
    public void testGibAdditionVonR7UndR8() {
        //Legt eine neue Rationale Zahl an.
        r7 = new RationaleZahl(11L, 2108303L);
        //Legt eine neue Rationale Zahl an.
        r8 = new RationaleZahl(31L, 2117009L);
        sollErgebnis = "189502901/4524816707267";
        assertEquals(sollErgebnis, r7.addiere(r8).gibAlsText());
    }
    /**
     * Test der textuellen Ausgabe durch Addition der neunten 
     * mit der zehnten Rationalen Zahl.
     */
    @Test
    public void testGibAdditionVonR9UndR10() {
        //Legt eine neue Rationale Zahl an.
        r9 = new RationaleZahl(3L, 3037000510L);
        //Legt eine neue Rationale Zahl an.
        r10 = new RationaleZahl(7L, 3037000500L);
        sollErgebnis = "3037000507/922337206737025500";
        assertEquals(sollErgebnis, r9.addiere(r10).gibAlsText());
    }
}
