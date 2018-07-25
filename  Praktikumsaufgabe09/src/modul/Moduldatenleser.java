package modul;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import static modul.Zustand.*;
/**
 * <p>Diese Klasse dient dazu, Beschreibungen von studierbaren Modulen aus
 * einer Datenquelle zu lesen, daraus Module zu erzeugen
 * und diese einem Modulverarbeiter zur weiteren Bearbeitung zu
 * übergeben. Diese Klasse funktioniert zunächst nur für Module.</p>
 * 
 * <p>Die Daten müssen folgendes Format besitzen:
 * Modul;<i>Kürzel</i>;<i>Bezeichnung</i>;<i>Studiengänge</i></p>
 * 
 * <ul>
 * <li>Modul ist ein fester Text und gibt an, dass es sich bei dem Fach
 * um ein Modul handelt.</li>
 * <li>Modulkürzel ist ein fester Text und gibt den Namen des Moduls
 * in abgekürzter Form wieder.
 * </li>
 * <li>
 * Beschreibung liefert einen festen Text der den Namen des Moduls in
 * voll ausgeschriebener Weise darstellt.</li>
 * <li>
 * Studiengänge sind alle die Studiengänge, in denen das Modul angeboten wird.
 * </li>
 * </ul>
 * @author Droxl
 */
public class Moduldatenleser {
    /**
     * Trennzeichen zwischen Daten zu einem Modul.
     */
    private static final char TRENNER = ';';
    /**
     * Zeichen, mit dem eine Textzelle, die das Trennzeichen enthält,
     * umgeben sein muss.
     */
    private static final char TEXTKLAMMER = '"';
    /**
     * Zeichen für Zeilenende.
     */
    private static final char ZEILENENDE = '\n';
    /**
     * Meldung für ModuldatenformatException: Moduldaten enden unerwartet.
     */
    private static final String MSG_UNERWARTETES_ENDE =
            "Unerwartetes Ende der Eingabe.";
    /**
     * Meldung für ModuldatenformatException: Nummerische
     * Angabe hat ungültiges Format.
     */
    private static final String MSG_UNGUELTIGES_ZAHLENFORMAT =
            "Ungültiges Zahlenformat.";
    /**
     * Meldung für ModuldatenformatException:
     * Eine Datenzelle hat ungültiges Format.
     */
    private static final String MSG_UNGUELTIGE_ZELLE =
            "Ungültiges Format einer Zelle.";
    /**
     * Meldung für ModuldatenformatException:
     * Das Modul ist ungültig.
     */
    private static final String MSG_UNGUELTIGER_MODULTYP =
            "Ungültiges Modulformat.";
    /**
     * Anfang einer Datenzeile für ein Modul.
     */
    private static final String MODUL = "Modul";
    /**
     * Für den zeilenweisen Zugriff auf die Moduldaten.
     */
    private final BufferedReader moduldaten;
    /**
     * Für die Ausgabe von Fehlern.
     */
    private final PrintWriter fehlerprotokoll;
    /*
     * Der Leser liest zeilenweise aus der Datenquelle. Das Verarbeiten
     * der eingelesenen Daten erfolgt zeichenweise.
     */
    
    /**
     * Zeile, die zuletzt eingelesen wurde.
     */
    private String aktuelleZeile;
    /**
     * Position des nächsten Zeichens, das verarbeitet werden muss.
     */
    private int aktuellePosition;
    /**
     * Erzeugt ein Objekt dieser Klasse für die angegebene Datenquelle.
     * @param moduldaten Reader, aus dem die Moduldaten gelesen
     *        werden.
     * @param fehlerprotokoll Writer, in den Fehlerausgaben geschrieben
     *        werden.
     * @throws IOException  wird geworfen, wenn es zu einem
     *         Ein-/Ausgabefehler kommt
     */
    public Moduldatenleser(Reader moduldaten, Writer fehlerprotokoll)
        throws IOException {

        this.moduldaten = new BufferedReader(moduldaten);
        this.fehlerprotokoll = new PrintWriter(fehlerprotokoll);
        //Erste Zeile laden.
        this.ladeNaechsteZeile();
    }
    /**
     * Lädt die nächste Zeile aus der Datenquelle und setzt die aktuelle
     * Position auf das erste Zeichen dieser Zeile.
     * @throws IOException  wird geworfen, wenn es zu einem
     *         Ein-/Ausgabefehler kommt
     */
    private void ladeNaechsteZeile() throws IOException {
        aktuelleZeile = moduldaten.readLine();
        aktuellePosition = 0;
    }
    /**
     * Liefert das nächste Zeichen aus der zuletzt gelesenen Zeile.
     * Auch das Ende einer Zeile wird als ein Zeichen geliefert.
     * Dadurch können Aufrufer dieser Methode erkennen, wann das Ende
     * einer Zeile erreicht ist.
     * @return nächstes Zeichen der zuletzt gelesenen Zeile. '\n' wird
     *         als Zeichen für das Zeilenende geliefert.
     * @throws IOException  wird geworfen, wenn es zu einem
     *         Ein-/Ausgabefehler kommt
     * @throws KatalogformatException wird geworfen, wenn kein weiteres
     *         Zeichen zur Verfügung steht
     */
    private char gibNaechstesZeichen()
        throws IOException, ModuldatenformatException {

        char naechstesZeichen;
        /*
        Das letzte Lesen aus der Datenquelle lieferte null, d.h.
        es gibt keine weiteren Zeichen.
        */
        if (aktuelleZeile == null) {
            throw new ModuldatenformatException(MSG_UNERWARTETES_ENDE);
        }

        if (aktuellePosition < aktuelleZeile.length()) {
            naechstesZeichen = aktuelleZeile.charAt(aktuellePosition);
            aktuellePosition++;
        } else {
            /*
            Alle Zeichen der zuletzt gelesenen Zeile sind schon
            verarbeitet. Es wird das Zeichen für das Zeilenende
            zurückgegeben.
            */
            naechstesZeichen = ZEILENENDE;
            /*
            Nächste Zeile laden, sodass beim nächsten Aufruf dieser Methode
            das Zeichen geliefert werden kann, das dem Zeilenumbruch folgt.
            */
            this.ladeNaechsteZeile();
        }
        return naechstesZeichen;
    }
    /**
     * Liefert die nächste Zelle. Eine Zelle endet mit einem Semikolon
     * oder einem Zeilenende. Siehe Zeilenformat in der Beschreibung
     * dieser Klasse.
     * @return nächste Datenzelle
     * @throws IOException  wird geworfen, wenn es zu einem
     *         Ein-/Ausgabefehler kommt
     * @throws KatalogformatException wird geworfen, wenn die Zelle wegen
     *         eines fehlerhaften Datenformats nicht geliefert werden kann
     */
    private String gibZelle() throws IOException, ModuldatenformatException {

        String zeile = aktuelleZeile;
        /*
        Diese Methode realisiert einen endlichen Automaten.
        Der Zustand OHNE_ANFUEHRUNGSSTRICHE gibt an, dass die Daten der Zelle
        nicht mit einem Anführungsstrich beginnen. Der Zustand
        MIT_ANFUEHRUNGSSTRICHEN gibt an, dass die Daten mit
        Anführungsstrichen beginnen. Sie müssen dann auch damit enden.
        */
        String zelle = "";
        Zustand zustand = START;

        while (!zustand.istEndzustand() && (zustand != UNDEFINIERT)) {

            char aechstesZeichen = this.gibNaechstesZeichen();

            Zustand folgezustand = UNDEFINIERT;

            switch (zustand) {
                case START:
                    switch (aechstesZeichen) {
                        case TRENNER:
                        case ZEILENENDE:
                            folgezustand = ENDE;
                            break;
                        case TEXTKLAMMER:
                            folgezustand = MIT_ANFUEHRUNGSSTRICHEN;
                            break;
                        default:
                            folgezustand = OHNE_ANFUEHRUNGSSTRICHE;
                            zelle = zelle + aechstesZeichen;
                            break;
                    }   break;
                case OHNE_ANFUEHRUNGSSTRICHE:
                    if (aechstesZeichen == TRENNER
                            || aechstesZeichen == ZEILENENDE) {
                        folgezustand = ENDE;
                    } else if (aechstesZeichen != TEXTKLAMMER) {
                        folgezustand = OHNE_ANFUEHRUNGSSTRICHE;
                        zelle = zelle + aechstesZeichen;
                    }   break;
                case MIT_ANFUEHRUNGSSTRICHEN:
                    if (aechstesZeichen == TEXTKLAMMER) {
                        folgezustand = ANFUEHRUNGSSTRICH;
                    } else {
                        folgezustand = MIT_ANFUEHRUNGSSTRICHEN;
                        zelle = zelle + aechstesZeichen;
                    }   break;
                case ANFUEHRUNGSSTRICH:
                    if (aechstesZeichen == TEXTKLAMMER) {
                        folgezustand = MIT_ANFUEHRUNGSSTRICHEN;
                        zelle = zelle + TEXTKLAMMER;
                    } else if (aechstesZeichen == TRENNER
                            || aechstesZeichen == ZEILENENDE) {
                        folgezustand = ENDE;
                    }   break;
            }
            zustand = folgezustand;
        }

        if (zustand == UNDEFINIERT) {
            throw new ModuldatenformatException(MSG_UNGUELTIGE_ZELLE, zeile);
        }
        return zelle;
    }
    /**
     * Gibt an, ob die Datenquelle noch Daten für ein weiteres Modul enthält.
     * @return <code>true</code> genau dann, wenn die Datenquelle
     *         noch weitere Daten enthält.
     */
    private boolean gibtEsWeiteresModul() {
        return (aktuelleZeile != null);
    }
    /**
     * Liefert nächstes Modul, das anhand der Daten aus der Datenquelle
     * erzeugt wird.
     * @return nächstes Modul
     * @throws IOException  wird geworfen, wenn es zu einem
     *         Ein-/Ausgabefehler kommt
     * @throws ModuldatenformatException wird geworfen, wenn das Datenformat
     *         fehlerhaft ist und deshalb kein Modul erzeugt werden kann.
     */
    private Modul gibModule() throws IOException, ModuldatenformatException {

        String zeile = aktuelleZeile;

        if (MODUL.equals(this.gibZelle())) {
            /*
            Bei korrektem Format ist die Reihenfolge der Zellen:
            Kürzel Bezeichnung (und eventuell der Studiengang).
            */
            String kuerzel = this.gibZelle();
            String bezeichnung = this.gibZelle();
            try {
                return new Modul(kuerzel, bezeichnung);
            } catch (NumberFormatException exc) {
                throw new ModuldatenformatException(
                        MSG_UNGUELTIGES_ZAHLENFORMAT, zeile);
            }
        } else {
            throw new ModuldatenformatException(
                    MSG_UNGUELTIGER_MODULTYP, zeile);
        }
    }
    /**
     * Liest aus der Datenquelle und übergibt die eingelesenen Module
     * dem übergebenen Moduldatenverarbeiter zur weiteren Verarbeitung.
     * @param verarbeiter verarbeitet die eingelesenen Moduldaten
     * @throws IOException  wird geworfen, wenn es zu einem
     *         Ein-/Ausgabefehler kommt
     */
    public void liesDaten(Moduldatenverarbeiter verarbeiter)
            throws IOException {

        while (this.gibtEsWeiteresModul()) {
            try {
                verarbeiter.verarbeiteModule(this.gibModule());
            } catch (ModuldatenformatException exc) {
                fehlerprotokoll.println(exc);
                /*
                Alles in der aktuellen Zeile überspringen und mit nächster
                Zeile fortfahren. Falls aktuellePosition == 0, so wurde
                nach dem Lesen des letzten Zeichens schon die nächste
                Zeile geladen.
                */
                if (this.aktuellePosition > 0) {
                    this.ladeNaechsteZeile();
                }
            }
        }
    }
    /**
     * Diese Methode zeigt beispielhaft die Anwendung der Klasse
     * Moduldatenleser.
     * @param args wird nicht verwendet
     * @throws IOException  wird geworfen, wenn es zu einem
     *         Ein-/Ausgabefehler kommt
     */
    public static void main(String[] args) throws IOException {
        /*
        Verzeichnis- und Dateinamen werden in dieser Klasse nicht
        als Konstanten definiert, da sie nicht zur Klasse Moduldatenleser
        gehören, sondern nur mit der beispielhaften Anwendung
        dieser Klasse zu tun haben.
        */
        
        /*
        Verzeichnis für Testdateien zur Ein- und Ausgabe.
        */
        File verzeichnis = new File("src/modul");

        File datendatei = new File(verzeichnis, "Moduldaten.txt");
        File protokolldatei = new File(verzeichnis, "Protokoll.txt");

        try (InputStreamReader moduldaten = new InputStreamReader(
                     new FileInputStream(datendatei), "UTF-8");
             OutputStreamWriter fehlerprotokoll = new OutputStreamWriter(
                     new FileOutputStream(protokolldatei), "UTF-8")) {
            
            Moduldatenleser leser =
                    new Moduldatenleser(moduldaten, fehlerprotokoll);
            /*
            λ-Ausdruck zum Zugriff auf den Moduldatenverarbeiter, der
            die Daten aufbereitet.
            */
            leser.liesDaten((Modul modul) -> {
                System.out.println(modul);
            });
//            leser.liesDaten(new Moduldatenverarbeiter() {
//                @Override
//                public void verarbeiteModule(Modul modul) {
//                    System.out.println(modul);
//                }
//            });
        }
    }
}