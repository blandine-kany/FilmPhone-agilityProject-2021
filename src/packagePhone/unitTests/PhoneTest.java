package packagePhone.unitTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import packagePhone.MobileApp;
import packagePhone.Phone;
import packagePhone.WirelessHeadphone;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Classe-test PhoneTest.
 *
 * @author raphabiz
 * @version 03/11/21
 * <p>
 * Les classes-test sont documentées ici :
 * http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 * et sont basées sur le document Š 2002 Robert A. Ballance intitulé
 * "JUnit: Unit Testing Framework".
 * <p>
 * Les objets Test (et TestSuite) sont associés aux classes à tester
 * par la simple relation yyyTest (e.g. qu'un Test de la classe
 * Name.java se nommera NameTest.java); les deux se retrouvent dans le
 * męme paquetage. Les "engagements" (anglais : "fixture") forment un
 * ensemble de conditions qui sont vraies pour chaque méthode Test à
 * exécuter. Il peut y avoir plus d'une méthode Test dans une classe
 * Test; leur ensemble forme un objet TestSuite. BlueJ découvrira
 * automatiquement (par introspection) les méthodes Test de votre
 * classe Test et générera la TestSuite conséquente. Chaque appel
 * d'une méthode Test sera précédé d'un appel de setUp(), qui
 * réalise les engagements, et suivi d'un appel à tearDown(), qui les
 * détruit.
 */
public class PhoneTest {
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).
    protected double fValeur1;
    protected double fValeur2;
    private Phone muskphone;
    private MobileApp mobileAp1;
    private MobileApp mobileAp2;
    private WirelessHeadphone muskpods;

    /**
     * Constructeur de la classe-test PhoneTest
     */
    public PhoneTest() {
    }

    /**
     * Met en place les engagements.
     * <p>
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @BeforeEach
    public void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements
        muskphone = new Phone();
        mobileAp1 = new MobileApp();
        mobileAp2 = new MobileApp();
        muskpods = new WirelessHeadphone();
    }

    /**
     * Supprime les engagements
     * <p>
     * Méthode appelée après chaque appel de méthode de test.
     */
    @AfterEach
    public void tearDown() // throws java.lang.Exception
    {
        // Libérez ici les ressources engagées par setUp()
    }

    @Test
    public void testToString() {
        Phone phone2 = new Phone();
        phone2.setName("My phone");
        phone2.setMemorySize(50.0);
        assertEquals(
                "Phone : My phone Battery : 100% Memory size : 50.0 Mo [App : call Size : 26.0 Mo, App : messages Size : 20.0 Mo]",
                phone2.toString());
    }

    @Test
    public void testSetBattery() {
        Phone phone1 = new Phone();
        phone1.setBattery(98);
        assertEquals(98, phone1.getBattery());
    }

    @Test
    public void testGetMemorySize() {
        Phone phone1 = new Phone();
        phone1.setMemorySize(50.0);
        assertEquals(50.0, phone1.getMemorySize(), 0.1);
    }

    @Test
    public void testFixture() {
        mobileAp1.setAppName("waze");
        mobileAp1.setAppSize(10.0);
        muskphone.install(mobileAp1);
        mobileAp2.setAppName("waze");
        mobileAp2.setAppSize(11.0);
        muskphone.install(mobileAp2);
        assertEquals("Phone : default name Battery : "
                + "100% Memory size : 126.0 Mo [App : call Size : 26.0 Mo, App : messages Size : "
                + "20.0 Mo, App : waze Size : 10.0 Mo]", muskphone.toString());
    }

    @Test
    public void testIsConnected() {
        muskphone.setPassword("pass1dutout");
        assertEquals(true, muskphone.getIsConnected());

    }

    @Test
    public void testGetPasword() {
        muskphone.setPassword("pass1dutout");
        assertEquals("pass1dutout", muskphone.getPassword());

    }

    @Test
    public void testGetIsTurnedOn() {
        muskphone.setIsTurnedOn(false);
        assertEquals(false, muskphone.getIsTurnedOn());
    }

    @Test
    public void testIsCharging() {
        muskphone.setBattery(100);
        assertEquals("Battery is full", muskphone.isCharging());
    }

    @Test
    public void testIsCharging2() {
        muskphone.setBattery(99);
        assertEquals("Phone battery : 100", muskphone.isCharging());
    }

    @Test
    public void testIsDischarging() {
        muskphone.setIsTurnedOn(true);
        muskphone.setBattery(55);
        assertEquals("Phone battery : 54", muskphone.isDischarging());
    }

    @Test
    public void testIsDischarging2() {
        muskphone.setIsTurnedOn(true);
        muskphone.setBattery(0);
        assertEquals("Battery is empty", muskphone.isDischarging());
        assertEquals(false, muskphone.getIsTurnedOn());
    }

    @Test
    public void testChangePassword() {
        muskphone.changePassword("pass1dutout", "newpass");
        assertEquals("newpass", muskphone.getPassword());
    }

    @Test
    public void testCheckStorage() {
        mobileAp1.setAppSize(190.0);
        assertEquals(false, muskphone.checkStorage(mobileAp1));
    }

    @Test
    public void testGetSim() {
        muskphone.setSim(true);
        assertEquals(true, muskphone.getSim());
    }

    @Test
    public void testDisconnect() {
        muskphone.connect(muskpods);
        muskphone.disconnect(muskpods);
        assertEquals("Wireless Headphone disconnected", muskphone.getSuccessMessage());
    }

    @Test
    public void testGetBluetoothOn() {
        muskphone.setBluetoothOn(true);
        ;
        assertEquals(true, muskphone.getBluetoothOn());
    }

    @Test
    public void testGetWheadphone() {
        muskphone.setWheadphone(muskpods);
        assertEquals(muskpods, muskphone.getWheadphone());
    }

}