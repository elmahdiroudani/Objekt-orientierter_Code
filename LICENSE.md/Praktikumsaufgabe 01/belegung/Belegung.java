package belegung;
import java.util.LinkedList;
/**
 * Diese Klasse generiert alle möglichen Permutationsbelegungen 
 * der Buchstaben a bis j.
 * In einer Belegung ist jedem Buchstaben genau eine Zahl zugeordnet, 
 * keine Zahl ist zwei Buchstaben zugeordnet. 
 * (Damit ist eine Belegung eine 
 * bijektive Abbildung {a, b, . . . , j} → {0, 1, . . . , 9}.)
 * 
 * Betrachten wir eine Belegung der Buchstaben a bis j als 
 * 10-stellige Zahl (mit dem Wert von a als erster und dem Wert von j als 
 * letzter Ziffer) und ordnen wir alle Belegungen entsprechend ihrem 
 * Zahlenwert an, so ergibt sich die:
 * 1. Belegung      0 1 2 3 4 5 6 7 8 9,
 * letzte Belegung  9 8 7 6 5 4 3 2 1 0.
 * @author R3V€4LeD
 */
public class Belegung {
    /**
     * Array für die Verwaltung der Permutationsbelegungen.
     */
    private int[] werte;
    /**
     * Alle Permutationen die vom übergebenen Array Werte erstellt werden.
     */
    private LinkedList<int[]> permutationen;
    /**
     * "Iterator" für die Permutationen.
     */
    private int index;
    /**
     * Erzeugt ein Objekt für Permutationsbelegungen.
     * @param groesse Die Größe mit der das Array erzeugt wird.
     */
    public Belegung(int groesse) {
        //Iteriert über die Permutationen, während sie erzeugt werden.
        index = 0;
        //Speichert alle Permutationen
        this.permutationen = new LinkedList();
        //Legt ein neues Array für die vom Benutzer fest definierte Größe an.
        werte = new int[groesse];
        for (int i = 0; i < werte.length; i++) {
            this.werte[i] = i;
        }
        //Erster Wert in der Liste, (der von dem "frisch" erstellten Objekt).
        permutationen.add(werte);
        //Neue Referenz auf neues Array.
        werte = permutationen.get(index);
    }
    /**
     * Erzeugt eine textuelle Darstellung einer Belegung.
     * @return Gibt eine textuelle Darstellung einer Belegung zurück.
     */
    public String gibAlsText() {
        //Textuelle Ausgabe.
        String ausgabe = "";
        //Erster Index = a.
        char buchstabe = 'a';
        /*Diese Schleife iteriert über das Belegungsobjekt (Array)
        und weist dabei von links nach rechts jedem Wert einen Buchstaben zu.
        Die Buchstaben geben dabei die Position der Werte innerhlab des Arrays
        an, a steht für Position 0[...], j für Position 9.*/
        for (int i = 0; i < werte.length; i++) {
            ausgabe = ausgabe + " " + buchstabe + "=" + werte[i];
            /*Erhöht den Buchstaben jeweils um eins, um auf das Format
            a=0, b=1, c=2, d=3, e=4, f=5, g=6, h=7, i=8, j=9 zugelangen.*/
            buchstabe++;
        }
        //Die textuelle Ausgabe.
        return ausgabe;
    }
    /**
     * Repräsentiert ein Objekt vor Aufruf dieser Methode die n-te Belegung, 
     * so soll es nach Aufruf die n + 1-te repräsentieren.
     * 
     * @return Falls das Objekt vor Aufruf der Methode die letzte Belegung 
     * repräsentiert, liefert der Aufruf false und der Objektzustand bleibt 
     * unverändert. Sonst liefert er true.
     */
    public boolean naechsteBelegung() {
        /*Die Fakultät zu der die Permutation entsteht.
        n Eingegebene Zahl dessen Fakultät berechnet wird.*/
        int n = werte.length;
        /*Die Fakultät der eingegebenen Zahl.*/
        int fakultaet = n;
        while(n > 1) {
            n = n - 1;
            fakultaet = fakultaet * n;
        }
        /*Anzahl der Möglichkeiten, ermittelt aus der Größe 
        der übergebenen Werte.*/
        int moeglichkeiten = fakultaet;
        //Gibt es noch eine nächste Belegung?
        boolean naechsteBelegung = index < moeglichkeiten - 1;
        /*Berechnet die nächste Permutation der Arraywerte. 
        Nur wenn es eine nächste Belegung gibt, wird sie ermittelt!*/
        if (naechsteBelegung) {
            /*Der Index beginnt von der letzten Stelle des Arrays.*/
            int i = werte.length - 1;
            /*Zahl finden, die nicht zur absteigenden Folge gehört.*/
            while (i > 0 && werte[i - 1] >= werte[i]) {
                i--;
            }
            if (i == 0) {
                //Kleine Hilfsvariable.
                int zwischenSpeicher0;
                /*Dreht die Folge des Arrays um.
                Array dessen Werte gespiegelt werden. 
                Ab 0 bis (werte.length - 1) wird gespiegelt.*/
                for (int j = 0; j <= ((werte.length - 1) - 0) / 2; j++) {
                    zwischenSpeicher0 = werte[0 + j];
                    werte[0 + j] = werte[(werte.length - 1) - j];
                    werte[(werte.length - 1) - j ] = zwischenSpeicher0;
                }
            } else {
                /*Findet das erste Element das nicht zur 
                absteigenden Folge gehört.*/
                int j = i;
                /*Findet den zweiten Kandidaten zum Tauschen.*/
                while (j < werte.length && werte[j] > werte[i - 1]) {
                    j++;
                }
                /*Vertauscht die Werte (werte[i-1], werte[j-1]).*/
                int kopierHilfe = werte[i - 1];
                werte[i - 1] = werte[j - 1];
                werte[j - 1] = kopierHilfe;
                //Kleine Hilfsvariable.
                int zwischenSpeicher1;
                /*Dreht die Folge des Arrays um.
                Array dessen Werte gespiegelt werden. 
                Ab i bis (werte.length - 1) wird gespiegelt.*/
                for (int k = 0; k <= ((werte.length - 1) - i) / 2; k++) {
                    zwischenSpeicher1 = werte[i + k];
                    werte[i + k] = werte[(werte.length - 1) - k];
                    werte[(werte.length - 1) - k ] = zwischenSpeicher1;
                }
            }
            index = index + 1;
        }
        return naechsteBelegung;
    }
}
