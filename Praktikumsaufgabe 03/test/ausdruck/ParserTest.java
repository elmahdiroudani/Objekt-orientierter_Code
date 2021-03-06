package ausdruck;
import java.text.ParseException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
/**
 * Eine auf JUnit 4.12 basierende Testklasse
 * für Tests mit dem Parser. Es wird davon ausgegangen,
 * dass die angewandten Ausdrücke gültig sind.
 * Ist dies nicht der Fall, wird eine entsprechende Ausnahme geworfen.
 * @author Droxl
 */
public class ParserTest {
    /**
     * Der Parser, welcher getestet wird.
     */
    private Parser parser;
    /**
     * Hier befindet sich das, was ausgewertet werden soll.
     */
    private String term = "";
    /**
     * Notwendig für die Wertzuweisung an eine Variable.
     */
    private Variablenbelegung belegung;
    /**
     * Testdaten aufbauen.
     */
    @Before
    public void setUp() {
        //Neuer Parser für's „Parsen“.
        parser = new Parser();
        //Variablen für die Tests.
        Variable a = new Variable("a");
        Variable z = new Variable("z");
        //Neue Variablenbelegung für die Werte...
        belegung = new Variablenbelegung();
        //a = 3
        belegung.belege("a", 3);
        //h = 1
        belegung.belege("h", 1);
        //p = 4
        belegung.belege("p", 4);
        //z = 6
        belegung.belege("z", 6);
        //x = 4
        belegung.belege("x", 4);
        //i = 3
        belegung.belege("i", 3);
        //k=4
        belegung.belege("k", 4);
        //j=9
        belegung.belege("j", 9);
        //xy=5
        belegung.belege("xy", 5);
        /*
        Initialisierung des Strings, je nach Test werden ihm
        neue Werte übergeben.
        */
        term = new String();
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse1() {
        term = "( 1 + a * 5 )";
        /*
        Der jeweilige Soll-Ausdruck für die Tests.
        */
        Ausdruck sollAusdruck;
        //Neue Variable für den Test.
        Variable a = new Variable("a");
        /*
        Test 1
        Getestet wird das „Parsen“ des Strings "( 1 + a * 5 )".
        */
        sollAusdruck = new Operatorausdruck(
                new Konstante(1), '+', new Operatorausdruck(a, '*',
                        new Konstante(5)
                )
        );
        try {
            assertEquals(sollAusdruck, parser.parse(term));
        } catch (ParseException exc) {
            exc.getMessage();
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse2() {
        term = "0";
        /*
        Der jeweilige Soll-Ausdruck für die Tests.
        */
        Ausdruck sollAusdruck;
        /*
        Test 2
        Getestet wird das Parsen des Strings "0".
        */
        sollAusdruck = new Konstante(0);
        try {
            assertEquals(sollAusdruck, parser.parse(term));
        } catch (ParseException exc) {
            exc.getMessage();
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse3() {
        term = "((1 + z) - a) / 2";
        /*
        Der jeweilige Soll-Ausdruck für die Tests.
        */
        Ausdruck sollAusdruck;
        //Neue Variablen für den Test.
        Variable a = new Variable("a");
        Variable z = new Variable("z");
        /*
        Test 3
        Getestet wird das „Parsen“ des Strings "((1 + z) - a) / 2".
        */
        sollAusdruck = new Operatorausdruck(new Operatorausdruck(
                new Operatorausdruck(new Konstante(1), '+', z),
                '-', a), '/', new Konstante(2));
        try {
            assertEquals(sollAusdruck, parser.parse(term));
        } catch (ParseException exc) {
            exc.getMessage();
        }
    }
    /*
    Testet die Methode {@link Parser#parse(java.lang.String)}.
    */
    @Test
    public void testParse4() {
        term = "5/0";
        /*
        Der jeweilige Soll-Ausdruck für die Tests.
        */
        Ausdruck sollAusdruck;
        /*
        Test 4
        Getestet wird das „Parsen“ des Strings "5/0".
        Hinweis: Das Parsen führt keine Berechnung durch, daher ist hier
        der String mit der Division durch 0 gültig!
        */
        sollAusdruck = new Operatorausdruck(new Konstante(5), '/',
                new Konstante(0));
        try {
            assertEquals(sollAusdruck, parser.parse(term));
        } catch (ParseException exc) {
            exc.getMessage();
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse5() {
        term = "a+b*c";
        /*
        Der jeweilige Soll-Ausdruck für die Tests.
        */
        Ausdruck sollAusdruck;
        //Neue Variablen für den Test.
        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");
        /*
        Test 5
        Getestet wird das „Parsen“ des Strings "a+b*c".
        */
        sollAusdruck = new Operatorausdruck(a, '+', new Operatorausdruck(
                b, '*', c)
        );
        try {
            assertEquals(sollAusdruck, parser.parse(term));
        } catch (ParseException exc) {
            exc.getMessage();
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse6() {
        term = "x / ((5-a))";
        /*
        Der jeweilige Soll-Ausdruck für die Tests.
        */
        Ausdruck sollAusdruck;
        //Neue Variablen für den Test.
        Variable x = new Variable("x");
        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");
        /*
        Test 6
        Getestet wird das „Parsen“ des Strings "x / ((5-a))".
        */
        sollAusdruck = new Operatorausdruck(x, '/',
                new Operatorausdruck(
                        new Konstante(5), '-', a)
        );
        try {
            assertEquals(sollAusdruck, parser.parse(term));
        } catch (ParseException exc) {
            exc.getMessage();
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse7() {
        term = "5-2";
        /*
        Der jeweilige Soll-Ausdruck für die Tests.
        */
        Ausdruck sollAusdruck = new Operatorausdruck(new Konstante(5), '-',
                new Konstante(2));
        /*
        Test 7
        Getestet wird das „Parsen“ des Strings "5-2".
        */
        try {
            assertEquals(sollAusdruck, parser.parse(term));
        } catch (ParseException exc) {
            exc.getMessage();
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse8() {
        term = "h * (h * p)";
        /*
        Der jeweilige Soll-Ausdruck für die Tests.
        */
        Ausdruck sollAusdruck;
        //Neue Variablen für den Test.
        Variable h = new Variable("h");
        Variable p = new Variable("p");
        /*
        Test 8
        Getestet wird das „Parsen“ des Strings "h * (h * p)".
        */
        sollAusdruck = new Operatorausdruck(h, '*', new Operatorausdruck(
                h, '*', p)
        );
        try {
            assertEquals(sollAusdruck, parser.parse(term));
        } catch (ParseException exc) {
            exc.getMessage();
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse9() {
        term = "10";
        /*
        Der jeweilige Soll-Ausdruck fuer die Tests.
        */
        Ausdruck sollAusdruck;
        /*
        Test 9
        Getestet wird das „Parsen“ des Strings "10".
        Belegung ohne Zuordnungen und Ausdruck "10" auswerten.
        */
        sollAusdruck = new Konstante(10);
        //Sollergebnis: 10
        try {
            assertEquals(sollAusdruck, parser.parse(term));
        } catch (ParseException exc) {
            exc.getMessage();
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse10() {
        term = "7 + i";
        /*
        Der jeweilige Soll-Ausdruck für die Tests.
        */
        Ausdruck sollAusdruck;
        //Neue Variablen für den Test.
        Variable i = new Variable("i");
        /*
        Test 10
        Getestet wird das „Parsen“ des Strings "7 + i".
        Belegung i=3 und Ausdruck "7 + i" auswerten.
        */
        sollAusdruck = new Operatorausdruck(new Konstante(7), '+', i);
        //Sollergebnis: 10
        try {
            assertEquals(sollAusdruck, parser.parse(term));
        } catch (ParseException exc) {
            exc.getMessage();
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse11() {
        term = "(i + 18)/2";
        /*
        Der jeweilige Soll-Ausdruck für die Tests.
        */
        Ausdruck sollAusdruck;
        //Neue Variablen für den Test.
        Variable i = new Variable("i");
        /*
        Test 11
        Getestet wird das „Parsen“ des Strings "(i + 18)/2".
        Belegung i=3 und Ausdruck "7 + i" auswerten.
        */
        sollAusdruck = new Operatorausdruck(
                new Operatorausdruck(i, '+', new Konstante(18)),
                '/', new Konstante(2));
        //Sollergebnis: 10
        try {
            assertEquals(sollAusdruck, parser.parse(term));
        } catch (ParseException exc) {
            exc.getMessage();
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse12() {
        term = "1 + 2 * (i + 2 * k - 1) / 2 + j";
        /*
        Test 12
        Getestet wird das „Parsen“ des
        Strings: "1 + 2 * (i + 2 * k - 1) / 2 + j"
        mit den Belegungen: i=3, k=4, j=9.
        */
        Ausdruck sollAusdruck;
        //Neue Variable i für den Test.
        Variable i = new Variable("i");
        //Neue Variable k für den Test.
        Variable k = new Variable("k");
        //Neue Variable j für den Test.
        Variable j = new Variable("j");
        //Aufbau des neuen Ausdrucks.
        sollAusdruck = new Operatorausdruck(
                new Operatorausdruck(
                        new Konstante(1), '+',
                        new Operatorausdruck(
                                new Operatorausdruck(
                                        new Konstante(2), '*',
                                        new Operatorausdruck(
                                                new Operatorausdruck(
                                                        i, '+',
                                                        new Operatorausdruck(
                                                                new Konstante(
                                                                        2),
                                                                '*', k)
                                                ), '-', new Konstante(1)
                                        )
                                ), '/', new Konstante(2)
                        )
                ), '+', j
        );
        //Sollergebnis: 20
        try {
            assertEquals(sollAusdruck, parser.parse(term));
        } catch (ParseException exc) {
            exc.getMessage();
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse13() {
        term = "a + (a - 1)";
        /*
        Test 13
        Getestet wird das „Parsen“ des
        Strings: "a + (a - 1)"
        mit der Belegung: a=3.
        */
        Ausdruck sollAusdruck;
        //Neue Variable i für den Test.
        Variable a = new Variable("a");
        //Aufbau des neuen Ausdrucks.
        sollAusdruck = new Operatorausdruck(a, '+',
                new Operatorausdruck(a, '-', new Konstante(1)
                )
        );
        //Sollergebnis: 5
        try {
            assertEquals(sollAusdruck, parser.parse(term));
        } catch (ParseException exc) {
            exc.getMessage();
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse14() {
        term = "(a + 1) * xy - 37";
        /**
         * Test 14
         * Getestet wird das „Parsen“ des
         * Strings: "(a + 1) * xy - 37"
         * mit der Belegung: a=3.
         */
        Ausdruck sollAusdruck;
        //Neue Variable i für den Test.
        Variable a = new Variable("a");
        Variable xy = new Variable("xy");
        Konstante testKonste1 = new Konstante(1);
        Konstante testKonste2 = new Konstante(37);
        //Aufbau des neuen Ausdrucks.
        sollAusdruck = new Operatorausdruck(
                new Operatorausdruck(
                        new Operatorausdruck(a, '+', testKonste1),
                        '*', xy), '-', testKonste2);
        //Sollergebnis: -17
        try {
            assertEquals(sollAusdruck, parser.parse(term));
        } catch (ParseException exc) {
            exc.getMessage();
        }
    }
    /**
     * Nun die Ausnahme-Fälle zur Fehlerbehandlung.
     */
    
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse15() {
        term = "1a";
        /*
        Test 15
        Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
        Strings: "1a"
        */
        try {
            System.out.println(parser.parse(term));
            parser.parse("1a");
            System.out.println("");
            fail("Es wurde keine Ausnahme geworfen.");
            System.out.println(parser.parse(term).toString());
        } catch (ParseException exc) {
            assertEquals("ungueltiges Token 1a", exc.getMessage());
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse16() {
        term = "3*(a+b";
        /*
        Test 16
        Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
        Strings: "3*(a+b"
        */
        try {
            System.out.println(parser.parse(term));
            fail("Es wurde keine Ausnahme geworfen.");
            System.out.println(parser.parse(term).toString());
        } catch (ParseException exc) {
            assertEquals("unerwartetes Ende", exc.getMessage());
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse17() {
        term = "3*(a+b@";
        /*
        Test 17
        Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
        Strings: "3*(a+b"
        */
        try {
            System.out.println(parser.parse(term));
            fail("Es wurde keine Ausnahme geworfen.");
            System.out.println(parser.parse(term).toString());
        } catch (ParseException exc) {
            assertEquals("ungueltiges Token b@", exc.getMessage());
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse18() {
        term = "3*(a+b+";
        /*
        Test 18
        Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
        Strings: "3*(a+b"
        */
        try {
            System.out.println(parser.parse(term));
            fail("Es wurde keine Ausnahme geworfen.");
            System.out.println(parser.parse(term).toString());
        } catch (ParseException exc) {
            assertEquals("ungueltiges Token +", exc.getMessage());
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse19() {
        term = "";
        /*
        Test 19
        Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
        Strings: ""
        */
        try {
            System.out.println(parser.parse(term));
            fail("Es wurde keine Ausnahme geworfen.");
            System.out.println(parser.parse(term).toString());
        } catch (ParseException exc) {
            assertEquals("unerwartetes Ende", exc.getMessage());
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse20() {
        term = ")";
        /*
        Test 17
        Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
        Strings: ""
        */
        try {
            System.out.println(parser.parse(term));
            fail("Es wurde keine Ausnahme geworfen.");
            System.out.println(parser.parse(term).toString());
        } catch (ParseException exc) {
            assertEquals("ungueltiges Token )", exc.getMessage());
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse21() {
        term = "a b";
        /*
        Test 21
        Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
        Strings: "a b"
        */
        try {
            System.out.println(parser.parse(term));
            fail("Es wurde keine Ausnahme geworfen.");
            System.out.println(parser.parse(term).toString());
        } catch (ParseException exc) {
            assertEquals("ungueltiges Token )", exc.getMessage());
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse22() {
        term = "x+*1";
        /*
        Test 22
        Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
        Strings: "x+*1"
        */
        try {
            System.out.println(parser.parse(term));
            fail("Es wurde keine Ausnahme geworfen.");
            System.out.println(parser.parse(term).toString());
        } catch (ParseException exc) {
            assertEquals("ungueltiges Token *", exc.getMessage());
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse23() {
        term = "(";
        /*
        Test 23
        Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
        Strings: "("
        */
        try {
            System.out.println(parser.parse(term));
            fail("Es wurde keine Ausnahme geworfen.");
            System.out.println(parser.parse(term).toString());
        } catch (ParseException exc) {
            assertEquals("unerwartetes Ende", exc.getMessage());
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse24() {
        term = "17+";
        /*
        Test 24
        Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
        Strings: "17+"
        */
        try {
            System.out.println(parser.parse(term));
            fail("Es wurde keine Ausnahme geworfen.");
            System.out.println(parser.parse(term).toString());
        } catch (ParseException exc) {
            assertEquals("unerwartetes Ende", exc.getMessage());
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse25() {
        term = "@ 3";
        /*
        Test 25
        Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
        Strings: "@ 3"
        */
        try {
            System.out.println(parser.parse(term));
            System.out.println(parser.parse(term).toString());
        } catch (ParseException exc) {
            assertEquals("ungueltiges Token @", exc.getMessage());
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse26() {
        term = "(17 + a";
        /*
        Test 26
        Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
        Strings: "x+*1"
        */
        try {
            System.out.println(parser.parse(term));
            fail("Es wurde keine Ausnahme geworfen.");
            System.out.println(parser.parse(term).toString());
        } catch (ParseException exc) {
            assertEquals("unerwartetes Ende", exc.getMessage());
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse27() {
        term = "(17 + a 7";
        /*
        Test 27
        Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
        Strings: "(17 + a 7"
        */
        try {
            System.out.println(parser.parse(term));
            fail("Es wurde keine Ausnahme geworfen.");
            System.out.println(parser.parse(term).toString());
        } catch (ParseException exc) {
            assertEquals("ungueltiges Token 7", exc.getMessage());
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse28() {
        term = "a 1";
        /*
        Test 28
        Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
        Strings: "a 1"
        */
        try {
            parser.parse(term);
        } catch (ParseException exc) {
            assertEquals("ungueltiges Token 1", exc.getMessage());
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse29() {
        term = "2 * (s - t) (";
        /*
        Test 29
        Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
        Strings: "2 * (s - t) ("
        */
        try {
            parser.parse(term);
        } catch (ParseException exc) {
            assertEquals("ungueltiges Token (", exc.getMessage());
        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse30() {
        term = "2 * (s - t) )";
        /**
         * Test 30
         * Getestet wird das werfen einer Exception im Falle von: „Parsen“ des
         * Strings: "2 * (s - t) )"
         */
        try {
            parser.parse(term);
        } catch (ParseException exc) {
            assertEquals("ungueltiges Token )", exc.getMessage());
        }
    }
}
