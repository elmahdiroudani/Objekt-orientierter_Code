package rationalezahl;
/**
 * Klasse deren Objekte rationale Zahlen repräsentieren und die 
 * die nachfolgenden Methoden enthält.
 * @author R3V€4LeD
 */
public class RationaleZahl {
    /**
     * Zähler einer Rationalen Zahl.
     */
    private long zaehler;
    /**
     * Nenner einer Rationalen Zahl.
     */
    private long nenner;
    /**
     * Erzeugt eine rationale Zahl als ganze Zahl.
     * @param zaehler Variable für den Zähler einer Zahl.
     * Der Nenner wird automatisch auf 1 gesetzt.
     * Verwendung bei ganzen Zahlen.
     */
    public RationaleZahl(long zaehler) {
        this.zaehler = zaehler;
        this.nenner = 1L;
    }
    /**
     * Erzeugt eine rationale Zahl für einen Bruch.
     * @param zaehler Variable für den Zähler einer Zahl.
     * @param nenner Variable fuer den Nenner einer Zahl.
     * Verwendung bei echten Brüchen.
     */
    public RationaleZahl(long zaehler, long nenner) {
        /*Verhindert, dass ein Nenner = 0 entstehen kann.*/
        if (nenner == 0) {
            throw new IllegalArgumentException();
            //alternativer Ansatz: throw new ArithmeticException();
        }
        this.zaehler = zaehler;
        this.nenner = nenner;
    }
    /**
     * Addiert zwei rationale Zahlen miteinander...
     * @param rz Parameter zur Übergabe der zweiten rationalen Zahl, 
     * die mit der ersten addiert wird.
     * @return ...und gibt das Ergebnis aus.
     */
    public RationaleZahl addiere(RationaleZahl rz) {
        /*Neues "RationaleZahl"-Objekt als Resultat der Addition des ersten 
        Objekts mit dem zweiten "RationaleZahl"-Objekt als Parameter.*/
        return new RationaleZahl(
                /*Das kleinste gemeinsame Vielfache lässt sich durch die 
                Formel: Erste Zahl mal zweite Zahl geteilt durch den größten 
                gemeinsamen Teiler der ersten und zweiten Zahl, 
                kurz: kgV = (erste Zahl * zweite Zahl) / ggT(
                erste Zahl, zweite Zahl), bilden.*/
                rz.nenner / ggT(this.nenner, rz.nenner) * this.zaehler 
                        + this.nenner / ggT(this.nenner, 
                                rz.nenner) * rz.zaehler, 
                this.nenner / ggT(this.nenner, rz.nenner) * rz.nenner);
    }
    /**
     * Liefert den größten gemeinsamen Teiler zweier positiver, ganzer Zahlen.
     * @param n erste Zahl
     * @param m zweite Zahl
     * @return Größter gemeinsamer Teiler beider Zahlen.
     */
    public long ggT(long n, long m) {
        /*Endrekursive Realisierung nach Euklid.*/
        return (m == 0)
                ? n
                : ggT(m, n % m);
    }
    /**
     * Die Methode gibt eine textuelle Darstellung dieser rationalen Zahl aus, 
     * (wobei die Zahl in ihrer maximal gekürzten Form dargestellt wird).
     * @return Gibt eine textuelle Darstellung dieser rationalen Zahl zurück. 
     * 
     * Ist die Zahl ein echter Bruch wird sie im Format "Zähler/Nenner" 
     * wiedergegeben, ist sie ganzzahlig wird sie im Format 
     * "Zahl" wiedergegeben.
     */
    public String gibAlsText() {
        /*Hier wird jeweils der größte gemeinsame Teiler des letzten 
        "RationaleZahl"-Objekts berechnet...*/
        long ggT = ggT(this.zaehler, this.nenner);
        //...und jeweils der letzte Zaehler durch ihn dividiert...
        this.zaehler = this.zaehler / ggT;
        /*...sowie der letzte Nenner durch ihn dividiert, 
        um ein maximal gekürztes "RationaleZahl"-Objekt zu erzeugen.*/
        this.nenner = this.nenner / ggT;
        return (RationaleZahl.this.nenner == 1)
                /*Wenn es sich um eine Ganze Zahl ohne Nenner handelt, 
                also der Nenner = 1 ist, wird nur der Zähler dargestellt.*/
                ? "" + RationaleZahl.this.zaehler
                /*Handelt es sich um einen echten Bruch, 
                werden Zähler und Nenner dargestellt.*/
                : "" + RationaleZahl.this.zaehler
                + "/" + RationaleZahl.this.nenner;
    }
    /**
     * Überprüft, ob das übergebene Objekt das gleiche ist, wie das aktuelle.
     * @param obj Das zu überprüfende Objekt.
     * @return Gibt wahr aus, genau dann, wenn das übergebene Objekt 
     * das gleiche ist, wie das aktuelle.
     */
    @Override
    public boolean equals(Object obj) {
        boolean gleichheitLiegtVor = false;
        
        if (obj instanceof RationaleZahl) {
            RationaleZahl rz = (RationaleZahl) obj;
            gleichheitLiegtVor = (this.zaehler * rz.nenner 
                    + this.nenner * rz.zaehler)
                    == (this.nenner * rz.zaehler
                    + this.zaehler * rz.nenner);
        }
        return gleichheitLiegtVor;
    }
    @Override
    public int hashCode() {
        return (int) (zaehler + nenner);
    }
}
