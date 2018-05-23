/**
 * Diese Klasse dient dazu verschiedene Tests mit den Klassen Mitarbeiter und 
 * Vorgeetzter durchzuführen.
 * @author R3V€4LeD
 */
package personal;
/**
 * Die Klasse selbst testet lediglich die Methoden der beiden Klassen auf 
 * Korrektheit in der Auführung.
 */
public class MitarbeiterTest {
    /**
     * Die Hauptmethode für die Tests.
     * @param args findet keine Verwendung.
     */
    public static void main(String[] args) {
        System.out.println(
                "1. Erzeugen Sie einen Mitarbeiter „Walter Winkelmann“.");
        Mitarbeiter walterWinkelmann = new Mitarbeiter("Walter Winkelmann");
        System.out.println("Ist: " + walterWinkelmann);
        System.out.println("-------------------------------------------------");
        System.out.println(
                "2. Erzeugen Sie eine Vorgesetzte „Waltraud Wichtig“.");
        Vorgesetzter waltraudWichtig = new Vorgesetzter("Waltraud Wichtig");
        System.out.println("Ist: " + waltraudWichtig);
        System.out.println("-------------------------------------------------");
        System.out.println(
                "3. Erzeugen Sie einen Vorgesetzten „Hermann Wichtiger“.");
        Vorgesetzter hermannWichtiger = new Vorgesetzter("Hermann Wichtiger");
        System.out.println("Ist: " + hermannWichtiger);
        System.out.println("-------------------------------------------------");
        System.out.println(
                "4. Machen Sie Frau Wichtig zur Vorgesetzten von "
                        + "Herrn Winkelmann.");
        walterWinkelmann.setzeVorgesetzten(waltraudWichtig);
        System.out.println("-------------------------------------------------");
        System.out.println(
                "5. Machen Sie Herrn Wichtiger zum Vorgesetzten von "
                        + "Frau Wichtig.");
        waltraudWichtig.setzeVorgesetzten(hermannWichtiger);
        System.out.println("-------------------------------------------------");
        System.out.println(
                "6. Geben Sie für Herrn Winkelmann aus, ob er Beschaffungen "
                        + "für EUR 15,- durchführen darf. Sollergebnis: true"
                        + '\n' + "Ist: " + walterWinkelmann.darfBestellen(15));
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println(
                "7. Geben Sie für Herrn Winkelmann aus, ob er Beschaffungen "
                        + "für EUR 20,- durchführen darf. Sollergebnis: true"
                        + '\n' + "Ist: " + walterWinkelmann.darfBestellen(20));
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println(
                "8. Geben Sie für Herrn Winkelmann aus, ob er Beschaffungen "
                        + "für EUR 21,- durchführen darf. Sollergebnis: false"
                        + '\n' + "Ist: " + walterWinkelmann.darfBestellen(21));
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println(
                "9. Geben Sie für Herrn Wichtiger aus, ob er Beschaffungen "
                        + "für EUR 15,- durchführen darf. Sollergebnis: true"
                        + '\n' + "Ist: " + hermannWichtiger.darfBestellen(15));
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println(
                "10. Geben Sie für Herrn Wichtiger aus, ob er Beschaffungen "
                        + "für EUR 25,- durchführen darf. Sollergebnis: false"
                        + '\n' + "Ist: " + hermannWichtiger.darfBestellen(25));
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("11. Setzen Sie das allgemeine Bestelllimit auf "
                + "EUR 30,-.");
        Mitarbeiter.setzeAllgemeinesLimit(30);
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("12. Erzeugen Sie einen Mitarbeiter „Willi Winzig“."
        );
        Mitarbeiter williWinzig = new Mitarbeiter("Willi Winzig");
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("13. Geben Sie für Herrn Winkelmann aus, "
                + "ob er Beschaffungen für EUR 21,- durchführen darf. "
                + "Sollergebnis: true"
                + '\n' + "Ist: " + walterWinkelmann.darfBestellen(21));
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("14. Geben Sie für Herrn Wichtiger aus, ob er "
                + "Beschaffungen für EUR 25,- durchführen darf. "
                + "Sollergebnis: true"
                + '\n' + "Ist: " + hermannWichtiger.darfBestellen(25));
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("15. Weisen Sie Frau Wichtig ein Bestelllimit "
                + "von EUR 10,- zu.");
        waltraudWichtig.setzeBestelllimit(10);
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("16. Geben Sie für Frau Wichtig aus, "
                + "ob sie Beschaffungen für EUR 10,- durchführen darf. "
                + "Sollergebnis: true"
                + '\n' + "Ist: " + waltraudWichtig.darfBestellen(10));
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("17. Geben Sie für Frau Wichtig aus, "
                + "ob sie Beschaffungen für EUR 11,- durchführen darf. "
                + "Sollergebnis: false"
                + '\n' + "Ist: " + waltraudWichtig.darfBestellen(11));
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("18. Weisen Sie Frau Wichtig ein Bestelllimit "
                + "von EUR 5000,- zu.");
        waltraudWichtig.setzeBestelllimit(5000);
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("19. Geben Sie für Frau Wichtig aus, "
                + "ob sie Beschaffungen für EUR 2000,- durchführen darf. "
                + "Sollergebnis: true"
                + '\n' + "Ist: " + waltraudWichtig.darfBestellen(2000));
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("20. Geben Sie für Frau Wichtig aus, "
                + "ob sie Beschaffungen für EUR 7000,- durchführen darf. "
                + "Sollergebnis: false"
                + '\n' + "Ist: " + waltraudWichtig.darfBestellen(7000));
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("21. Geben Sie den Info-Text für Frau Wichtig aus. "
                + "Sollergebnis: "
                + "Ich bin Vorgesetzter, Name Waltraud Wichtig. "
                + "Mein Vorgesetzter ist Hermann Wichtiger. "
                + "Mein Bestelllimit ist 5000 EUR."
                + '\n' + "Ist: " + waltraudWichtig.gibInfo());
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println(
                "22. Geben Sie die Hierarchie für Frau Wichtig aus. "
                        + "Sollergebnis: "
                        + "Vorgesetzter Hermann Wichtiger "
                        + "Vorgesetzter Waltraud Wichtig"
                        + '\n' + "Ist: " + waltraudWichtig.gibHierarchie());
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("23. Geben Sie den Info-Text für "
                + "Herrn Wichtiger aus. Sollergebnis: "
                + "Ich bin Vorgesetzter, Name Hermann Wichtiger. "
                + "Mein Bestelllimit ist 30 EUR."
                + '\n' + "Ist: " + hermannWichtiger.gibInfo());
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("24. Geben Sie die Hierarchie "
                + "für Herrn Wichtiger aus. "
                + "Sollergebnis: Vorgesetzter Hermann Wichtiger"
                + '\n' + "Ist: " + hermannWichtiger.gibHierarchie());
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("25. Geben Sie den Info-Text für "
                + "Herrn Winkelmann aus. "
                + "Sollergebnis: "
                + "Ich bin Mitarbeiter, Name Walter Winkelmann. "
                + "Mein Vorgesetzter ist Waltraud Wichtig. "
                + "Mein Bestelllimit ist 30 EUR."
                + '\n' + "Ist: " + walterWinkelmann.gibInfo());
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("26. Geben Sie die Hierarchie für "
                + "Herrn Winkelmann aus. "
                + "Sollergebnis: "
                + "Vorgesetzter Hermann Wichtiger "
                + "Vorgesetzter Waltraud Wichtig "
                + "Mitarbeiter Walter Winkelmann"
                + '\n' + "Ist: " + walterWinkelmann.gibHierarchie());
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("27. Entziehen Sie Frau Wichtig ihren Vorgesetzten."
        );
        waltraudWichtig.setzeVorgesetzten(null);
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("28. Geben Sie die Hierarchie für "
                + "Herrn Winkelmann aus. "
                + "Sollergebnis: "
                + "Vorgesetzter Waltraud Wichtig "
                + "Mitarbeiter Walter Winkelmann"
                + '\n' + "Ist: " + walterWinkelmann.gibHierarchie());
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("29. Geben Sie den Info-Text für Herrn Winzig aus. "
                + "Sollergebnis: "
                + "Ich bin freier Mitarbeiter, Name Willi Winzig. "
                + "Mein Bestelllimit ist 30 EUR."
                + '\n' + "Ist: " + williWinzig.gibInfo());
        System.out.println("-------------------------------------------------"
                + "-------------------------------------------------"
                + "-------------");
        System.out.println("30. Geben Sie die Hierarchie für Herrn Winzig aus. "
                + "Sollergebnis: freier Mitarbeiter Willi Winzig"
                + '\n' + "Ist: " + williWinzig.gibHierarchie());
    }
}
