/**
 * Der Code veranschaulicht den "Merge-Sort"-Algorithmus.
 * @author R3V€4LeD
 */
public class MergeSort {
    /**
     * MergeSort(folge, pointer, laenge) sortiert die Folge a(pointer),...,
     * a(pointer + laenge − 1).
     * @param folge Die Folge mit der gemischt wird.
     * @param zeiger Zeiger auf der linken Folge.
     * @param laenge Die gesamte Länge.
     */
    public static void mergeSort(int[] folge, int zeiger, int laenge) {
        if (laenge > 1) {
            int halbeLaenge = laenge / 2;
            mergeSort(folge, zeiger, halbeLaenge);
            mergeSort(folge, zeiger + halbeLaenge, laenge - halbeLaenge);
            merge(folge, zeiger, laenge, halbeLaenge);
        }
    }
    /**
     * Mischen durch
     * merge(a, pointer, laenge , halbeLaenge) mischt die sortierten Folgen 
     * a(pointer),...,a(pointer + halbeLaenge − 1)
     * und a(pointer + halbeLaenge,...,a(pointer + laenge − 1).
     * @param eingangsarray Das Eingabe-Array was übergeben wird.
     * @param pointer Der Zeiger, der auf Elemente der Folge zeigt.
     * @param laenge Die Länge der Folge.
     * @param halbeLaenge Die halbe Länge.
     */
    public static void merge(int[] eingangsarray, int pointer, int laenge,
            int halbeLaenge) {
        /*Die verschmelzte Folge, erstellt für diesen Durchgang.*/
        int[] mergeArray = new int[laenge];
        /*Index für die erste Folge oder Zeiger auf der linken Folge.*/
        int pointer1 = pointer;
        /*Index für die zweite Folge oder Zeiger auf der rechten Folge.*/
        int pointer2 = pointer + halbeLaenge;
        /*Sukzessive jeweils kleinstes Element aus beiden
        Folgen in Mischfolge übernehmen.*/
        for (int i = 0; i < laenge; i = i + 1) {
            if ((pointer1 < pointer + halbeLaenge) 
                    && (pointer2 >= pointer + laenge 
                    || eingangsarray[pointer1] <= eingangsarray[pointer2])) {
                //i ist der Zeiger zum Einfügen in das Mergearray
                mergeArray[i] = eingangsarray[pointer1];
                pointer1 = pointer1 + 1;
            } else {
                mergeArray[i] = eingangsarray[pointer2];
                pointer2 = pointer2 + 1;
            }
        }
        /*Mischfolge in ursprüngliche Folge kopieren.*/
        for (int i = 0; i < mergeArray.length; i++) {
            eingangsarray[pointer + i] = mergeArray[i];
        }
    }
}