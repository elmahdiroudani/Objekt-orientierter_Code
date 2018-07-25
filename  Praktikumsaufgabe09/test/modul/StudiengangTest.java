package modul;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
/**
 * Testet das Verhalten des Objekts Modul.
 * @author Droxl
 */
public class StudiengangTest {
    /**
     * Bachelor-Studiengang Informatik
     */
    private Studiengang studiengangBachelorInformatik;
    /**
     * Bachelor-Studiengang Medieninformatik
     */
    private Studiengang studiengangBachelorMedieninformatik;
    /**
     * Bachelor-Studiengang Wirtschaftsinformatik
     */
    private Studiengang studiengangBachelorWirtschaftsinformatik;
    /**
     * Master-Studiengang Informatik
     */
    private Studiengang studiengangMasterInformatik;
    /**
     * Master-Studiengang Medieninformatik
     */
    private Studiengang studiengangMasterMedieninformatik;
    /**
     * Master-Studiengang Wirtschaftsinformatik
     */
    private Studiengang studiengangMasterWirtschaftsinformatik;
    /**
     * Master-Studiengang Internet-Sicherheit
     */
    private Studiengang studiengangMasterInternetSicherheit;
    /**
     * Testdaten aufbauen.
     */
    @Before
    public void setUp() {
        //Daten für Tests initialisieren...
        studiengangBachelorInformatik = Studiengang.IN_BA;
        studiengangBachelorMedieninformatik = Studiengang.MI_BA;
        studiengangBachelorWirtschaftsinformatik = Studiengang.WI_BA;
        studiengangMasterInformatik = Studiengang.IN_MA;
        studiengangMasterMedieninformatik = Studiengang.MI_MA;
        studiengangMasterWirtschaftsinformatik = Studiengang.WI_MA;
        studiengangMasterInternetSicherheit = Studiengang.IS_MA;
    }
    /**
     * Teste Methode istBachelorstudiengang() der Klasse Studiengang.
     */
    @Test
    public void testIstBachelorstudiengang1() {
        assertTrue(studiengangBachelorInformatik.istBachelorstudiengang());
    }
    /**
     * Teste Methode istBachelorstudiengang() der Klasse Studiengang.
     */
    @Test
    public void testIstBachelorstudiengang2() {
        assertTrue(studiengangBachelorMedieninformatik
                .istBachelorstudiengang()
        );
    }
    /**
     * Teste Methode istBachelorstudiengang() der Klasse Studiengang.
     */
    @Test
    public void testIstBachelorstudiengang3() {
        assertTrue(
                studiengangBachelorWirtschaftsinformatik
                        .istBachelorstudiengang()
        );
    }
    /**
     * Teste Methode istBachelorstudiengang() der Klasse Studiengang.
     */
    @Test
    public void testIstMasterstudiengang1() {
        assertFalse(studiengangMasterInformatik.istBachelorstudiengang());
    }
    /**
     * Teste Methode istBachelorstudiengang() der Klasse Studiengang.
     */
    @Test
    public void testIstMasterstudiengang2() {
        assertFalse(studiengangMasterMedieninformatik.istBachelorstudiengang());
    }
    /**
     * Teste Methode istBachelorstudiengang() der Klasse Studiengang.
     */
    @Test
    public void testIstMasterstudiengang3() {
        assertFalse(
                studiengangMasterWirtschaftsinformatik
                .istBachelorstudiengang()
        );
    }
    /**
     * Teste Methode istBachelorstudiengang() der Klasse Studiengang.
     */
    @Test
    public void testIstMasterstudiengang4() {
        assertFalse(
                studiengangMasterInternetSicherheit.istBachelorstudiengang()
        );
    }
    /**
     * Teste Methode name() der Klasse Studiengang.
     */
    @Test
    public void testGibNamen1() {
        assertEquals("IN_BA", studiengangBachelorInformatik.name());
    }
    /**
     * Teste Methode name() der Klasse Studiengang.
     */
    @Test
    public void testGibNamen2() {
        assertEquals("MI_BA", studiengangBachelorMedieninformatik.name());
    }
    /**
     * Teste Methode name() der Klasse Studiengang.
     */
    @Test
    public void testGibNamen3() {
        assertEquals("WI_BA", studiengangBachelorWirtschaftsinformatik.name());
    }
    /**
     * Teste Methode name() der Klasse Studiengang.
     */
    @Test
    public void testGibNamen4() {
        assertEquals("IN_MA", studiengangMasterInformatik.name());
    }
    /**
     * Teste Methode name() der Klasse Studiengang.
     */
    @Test
    public void testGibNamen5() {
        assertEquals("MI_MA", studiengangMasterMedieninformatik.name());
    }
    /**
     * Teste Methode name() der Klasse Studiengang.
     */
    @Test
    public void testGibNamen6() {
        assertEquals("WI_MA", studiengangMasterWirtschaftsinformatik.name());
    }
    /**
     * Teste Methode name() der Klasse Studiengang.
     */
    @Test
    public void testGibNamen7() {
        assertEquals("IS_MA", studiengangMasterInternetSicherheit.name());
    }
}