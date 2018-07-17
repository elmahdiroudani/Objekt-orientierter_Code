package ausdruck;
import java.text.ParseException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Eine auf JUnit 4.12 basierende Testklasse
 * für Tests mit dem Parser. Es wird davon ausgegangen,
 * dass die angewandten Ausdrücke gültig sind.
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
    public void testParse1() throws ParseException {
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
        assertEquals(sollAusdruck, parser.parse(term));
//        try {
//            assertEquals(sollAusdruck, parser.parse(term));
//        } catch (ParseException exc) {
//            exc.getMessage();
//        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse2() throws ParseException {
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
        assertEquals(sollAusdruck, parser.parse(term));
//        try {
//            assertEquals(sollAusdruck, parser.parse(term));
//        } catch (ParseException exc) {
//            exc.getMessage();
//        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse3() throws ParseException {
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
        assertEquals(sollAusdruck, parser.parse(term));
//        try {
//            assertEquals(sollAusdruck, parser.parse(term));
//        } catch (ParseException exc) {
//            exc.getMessage();
//        }
    }
    /*
    Testet die Methode {@link Parser#parse(java.lang.String)}.
    */
    @Test
    public void testParse4() throws ParseException {
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
        assertEquals(sollAusdruck, parser.parse(term));
//        try {
//            assertEquals(sollAusdruck, parser.parse(term));
//        } catch (ParseException exc) {
//            exc.getMessage();
//        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse5() throws ParseException {
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
        assertEquals(sollAusdruck, parser.parse(term));
//        try {
//            assertEquals(sollAusdruck, parser.parse(term));
//        } catch (ParseException exc) {
//            exc.getMessage();
//        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse6() throws ParseException {
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
        assertEquals(sollAusdruck, parser.parse(term));
//        try {
//            assertEquals(sollAusdruck, parser.parse(term));
//        } catch (ParseException exc) {
//            exc.getMessage();
//        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse7() throws ParseException {
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
        assertEquals(sollAusdruck, parser.parse(term));
//        try {
//            assertEquals(sollAusdruck, parser.parse(term));
//        } catch (ParseException exc) {
//            exc.getMessage();
//        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse8() throws ParseException {
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
        assertEquals(sollAusdruck, parser.parse(term));
//        try {
//            assertEquals(sollAusdruck, parser.parse(term));
//        } catch (ParseException exc) {
//            exc.getMessage();
//        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse9() throws ParseException {
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
        assertEquals(sollAusdruck, parser.parse(term));
//        try {
//            assertEquals(sollAusdruck, parser.parse(term));
//        } catch (ParseException exc) {
//            exc.getMessage();
//        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse10() throws ParseException {
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
        assertEquals(sollAusdruck, parser.parse(term));
//        try {
//            assertEquals(sollAusdruck, parser.parse(term));
//        } catch (ParseException exc) {
//            exc.getMessage();
//        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse11() throws ParseException {
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
        Belegung i=3 auswerten.
        */
        sollAusdruck = new Operatorausdruck(
                new Operatorausdruck(i, '+', new Konstante(18)),
                '/', new Konstante(2));
        //Sollergebnis: 10
        assertEquals(sollAusdruck, parser.parse(term));
//        try {
//            assertEquals(sollAusdruck, parser.parse(term));
//        } catch (ParseException exc) {
//            exc.getMessage();
//        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse12() throws ParseException {
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
        assertEquals(sollAusdruck, parser.parse(term));
//        try {
//            assertEquals(sollAusdruck, parser.parse(term));
//        } catch (ParseException exc) {
//            exc.getMessage();
//        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse13() throws ParseException {
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
        assertEquals(sollAusdruck, parser.parse(term));
//        try {
//            assertEquals(sollAusdruck, parser.parse(term));
//        } catch (ParseException exc) {
//            exc.getMessage();
//        }
    }
    /**
     * Testet die Methode {@link Parser#parse(java.lang.String)}.
     */
    @Test
    public void testParse14() throws ParseException {
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
        assertEquals(sollAusdruck, parser.parse(term));
//        try {
//            assertEquals(sollAusdruck, parser.parse(term));
//        } catch (ParseException exc) {
//            exc.getMessage();
//        }
    }
}