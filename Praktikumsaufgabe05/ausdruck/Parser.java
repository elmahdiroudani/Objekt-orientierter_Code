package ausdruck;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * Der Parser „parst“ gültige Ausdrücke zu gültigen Ergebnissen.
 * @author Droxl
 */
public class Parser {
    /**
     * Konstante für das Rechenzeichen '+'.
     */
    private static final char PLUS = '+';
    /**
     * Konstante für das Rechenzeichen '-'.
     */
    private static final char MINUS = '-';
    /**
     * Konstante für das Rechenzeichen '*'.
     */
    private static final char MAL = '*';
    /**
     * Konstante für das Rechenzeichen '/'.
     */
    private static final char GETEILT = '/';
    /**
     * Regulärer Ausdruck für eine Konstante.
     */
    private static final String KONSTANTE = "[0-9]*";
    /**
     * Regulärer Ausdruck für eine Variable.
     */
    private static final String VARIABLE = "[a-zA-Z]*[a-zA-Z0-9]*";
    /**
     * Konstante für '('.
     */
    private static final char OEFFNENDE_KLAMMER = '(';
    /**
     * Konstante für ')'.
     */
    private static final char SCHLIESSENDE_KLAMMER = ')';
    /**
     * Trennzeichen für das Zerlegen des Terms.
     */
    private static final String TRENNZEICHEN = "+-*/ ()";
    /**
     * Hier werden alle Tokens gespeichert, die für die Auswertung
     * relevant sind.
     */
    private LinkedList<String> tokenliste;
    /**
     * Die Anzahl der Tokens die eingelesen wurden.
     */
    private int tokenAnzahl;
    /**
     * Erzeugt den Parser.
     */
    public Parser() {
    }
    /**
     * Parst den ürbergebenen Term.
     * @param term Term der ausgewertet werden soll.
     * @return ausgewerteter Ausdruck
     */
    public Ausdruck parse(String term) {
        /*
        Die Liste MUSS zu Anfang leer sein! Deshalb wird sie
        erst hier initialsiert und nicht im Konstruktor selbst.
        */
        this.tokenliste = new LinkedList<>();
        /*
        Tokenizer verwenden, um unnötige Weißraumzeichen zu entfernen.
        Trennzeichen werden aber mitübergeben.
        */
        StringTokenizer tokenizer = new StringTokenizer(term, TRENNZEICHEN,
                true);
        /*
        Solange der Tokenizer noch Tokens hat, das nächste Element
        in die Liste aufnehmen, solange es kein Weißraumzeichen ist.
        */
        while (tokenizer.hasMoreTokens()) {
            String element = tokenizer.nextToken();
            /*
            Kein Weißraumzeichen in die Liste aufnehmen.
            */
            if (!" ".equals(element)) {
                this.tokenliste.add(element);
            }
        }
        //Anzahl der Tokens geht aus der Größe der Tokenliste hervor.
        this.tokenAnzahl = this.tokenliste.size();
        /*
        Der Ausdruck setzt sich aus dem zusammen,
        was bei parseAusdruck() entsteht.
        */
        Ausdruck geparsterAusdruck = parseAusdruck();
        /*
        Sofern der rechte Ausdruck keinen Summanden oder Summandenausdruck
        enthält, endet die Rekursion hier.
        Andernfalls wird mit parseSummand() weitergemacht, siehe oben.
        */
        return geparsterAusdruck;
    }
    /**
     * Abschnitt des Parsers, der einen Ausdruck "parst"/"parsed".
     * @return gibt einen Operatorausdruck zurück.
     */
    private Ausdruck parseAusdruck() {
        //Linker Ausdruck für mathematische Operation.
        Ausdruck linkerAusdruck;
        //Operator für mathematische Operation.
        char operator;
        //Rechter Ausdruck für mathematische Operation.
        Ausdruck rechterAusdruck;
        //Da von links aus ausgewertet wird.
        linkerAusdruck = parseSummand();
        /*
        Solange es noch Tokens in der Liste gibt
        und das Operatorzeichen ein '+' oder '-' ist,
        wird das Operatorzeichen ermittelt und aus der Liste entfernt.
        Danach wird mit dem rechten Ausdruck weitergemacht.
        */
        while (!this.tokenliste.isEmpty()
                && (this.tokenliste.getFirst().charAt(0) == PLUS
                || this.tokenliste.getFirst().charAt(0) == MINUS)) {
            
            operator = this.tokenliste.removeFirst().charAt(0);
            rechterAusdruck = parseSummand();
            /*
            Der linke Ausdruck bekommt den gesamten neuen Operatorausdruck,
            bestehend aus dem linken Argument, dem Operationszeichen und dem
            rechten Argument.
            */
            linkerAusdruck = new Operatorausdruck(linkerAusdruck, operator,
                    rechterAusdruck);
        }
        /*
        Sofern der rechte Ausdruck keinen Summanden oder Summandenausdruck
        enthält, endet die Rekursion hier.
        Andernfalls wird mit parseSummand() weitergemacht siehe oben.
        */
        return linkerAusdruck;
    }
    /**
     * Abschnitt des Parsers, der einen Summanden "parst"/"parsed".
     * @return gibt einen Operatorausdruck zurück.
     */
    private Ausdruck parseSummand() {
        //Linker Ausdruck für mathematische Operation.
        Ausdruck linkerAusdruck;
        //Operator für mathematische Operation.
        char operator;
        //Rechter Ausdruck für mathematische Operation.
        Ausdruck rechterAusdruck;
        //Da von links aus ausgewertet wird.
        linkerAusdruck = parseFaktor();
        /*
        Solange es noch Tokens in der Liste gibt
        und das Operatorzeichen ein '*' oder '/' ist,
        wird das Operatorzeichen ermittelt und aus der Liste entfernt.
        */
        while (!this.tokenliste.isEmpty() && (
                this.tokenliste.getFirst().charAt(0) == MAL
                || this.tokenliste.getFirst().charAt(0) == GETEILT)) {
            operator = this.tokenliste.removeFirst().charAt(0);
            //Danach wird mit dem rechten Ausdruck weitergemacht.
            rechterAusdruck = parseFaktor();
            /*
            Der linke Ausdruck bekommt den gesamten neuen Operatorausdruck,
            bestehnd aus dem linken Argument, dem Operationszeichen und dem
            rechten Argument.
            */
            linkerAusdruck = new Operatorausdruck(linkerAusdruck, operator,
                    rechterAusdruck);
        }
        /*
        Sofern der rechte Ausdruck keinen Summanden oder Summandenausdruck
        enthält, endet die Rekursion hier.
        Andernfalls wird mit parseFaktor() weitergemacht siehe oben.
        */
        return linkerAusdruck;
    }
    /**
     * Abschnitt des Parsers, der einen Faktor parst/"parsed".
     * @return gibt einen einzelnen Ausdruck zurück.
     */
    private Ausdruck parseFaktor() {
        //Das was die Methode zurückgibt, wenn keine Ausnahme ausgelöst wird.
        Ausdruck rueckgabeFaktor = null;
        /*
        Ausgehend vom Normalfall, dass die Liste nicht leer ist
        wird auf das aktulle Token zugegriffen.
        */
        if (!this.tokenliste.isEmpty()) {
            String aktuellesToken = this.tokenliste.removeFirst();
            /*
            Danach wird ermittelt, ob es eine Konstante...
            */
            if (aktuellesToken.matches(KONSTANTE)) {
                rueckgabeFaktor = new Konstante(
                        Integer.parseInt(aktuellesToken)
                );
                //...eine Variable...
            } else if (aktuellesToken.matches(VARIABLE)) {
                rueckgabeFaktor = new Variable(aktuellesToken);
                //...oder ein Ausdruck ist.
            } else if (aktuellesToken.charAt(0) == OEFFNENDE_KLAMMER) {
                rueckgabeFaktor = parseAusdruck();
                this.tokenliste.remove(0);
            }
        }
        //Läuft alles korrekt geht die Rekursion hier zuende.
        return rueckgabeFaktor;
    }
}