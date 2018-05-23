package belegung;
/**
 * Testklasse des Beleungsobjekts und Hauptmethode, die die Instanzmethoden
 * auf korrekte Funktionalität hinsichtlich Ausführung überprüft.
 * @author R3V€4LeD
 */
public class BelegungTest {
    /**
     * Führt die Testmethoden aus und stellt die Testergebnisse auf
     * dem Bildschirm dar.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        /*
        1 Objekt der Klasse Belegung erzeugen.
        */
        Belegung testObjekt1 = new Belegung(10);
        /*
        2 Dieses Objekt textuell darstellen (gibAlsText textuell aufrufen 
        und Rueckgabewert ausgeben).
        Sollergebnis: a=0, b=1, c=2, d=3, e=4, f=5, g=6, h=7, i=8, j=9
        */
        System.out.println(testObjekt1.gibAlsText());
        /*
        3 naechste Belegung berechnen (naechsteBelegung aufrufen 
        und Rückgabewert ausgeben)
        true
        */
        testObjekt1.naechsteBelegung();
        /*
        4 Objekt textuell darstellen
        a=0, b=1, c=2, d=3, e=4, f=5, g=6, h=7, i=9, j=8
        */
        System.out.println(testObjekt1.gibAlsText());
        /*
        5 362878 mal nächste Belegung berechnen
        testObjekt1.naechsteBelegung();
        */
        System.out.println(testObjekt1.naechsteBelegung());
        /*
        6 Objekt textuell darstellen
        a=0, b=9, c=8, d=7, e=6, f=5, g=4, h=3, i=2, j=1
        */
        System.out.println(testObjekt1.gibAlsText());
        /*
        7 nächste Belegung berechnen true
        */
        testObjekt1.naechsteBelegung();
        /*
        8 Objekt textuell darstellen 
        a=1, b=0, c=2, d=3, e=4, f=5, g=6, h=7, i=8, j=9
        */
        System.out.println(testObjekt1.gibAlsText());
        /*
        9 3265918 mal nächste Belegung berechnen
        */
        System.out.println(testObjekt1.naechsteBelegung());
        /*
        10 Objekt textuell darstellen
        a=9, b=8, c=7, d=6, e=5, f=4, g=3, h=2, i=0, j=1
        */
        System.out.println(testObjekt1.gibAlsText());
        /*
        11 nächste Belegung berechnen true
        */
        System.out.println(testObjekt1.naechsteBelegung());
        /*
        12 Objekt textuell darstellen a=9, b=8, c=7, d=6, e=5, f=4, g=3, 
        h=2, i=1, j=0
        */
        System.out.println(testObjekt1.gibAlsText());
        /*
        13 nächste Belegung berechnen false
        */
        System.out.println(testObjekt1.naechsteBelegung());
        /*
        14 Objekt textuell darstellen a=9, b=8, c=7, d=6, e=5, f=4, g=3, 
        h=2, i=1, j=0
        */
        System.out.println(testObjekt1.gibAlsText());
    }
}
