package packagePhone.unitTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import packagePhone.MobileApp;
import packagePhone.Phone;
import packagePhone.WirelessHeadphone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


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
    private Phone muskPhone;
    private MobileApp mobileAp1;
    private MobileApp mobileAp2;
    private WirelessHeadphone muskPods;

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
        muskPhone = new Phone();
        mobileAp1 = new MobileApp();
        mobileAp2 = new MobileApp();
        muskPods = new WirelessHeadphone();
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
        muskPhone.install(mobileAp1);
        mobileAp2.setAppName("waze");
        mobileAp2.setAppSize(11.0);
        muskPhone.install(mobileAp2);
        assertEquals("Phone : default name Battery : "
                + "100% Memory size : 126.0 Mo [App : call Size : 26.0 Mo, App : messages Size : "
                + "20.0 Mo, App : waze Size : 10.0 Mo]", muskPhone.toString());
    }

    @Test
    public void testIsConnected() {
        muskPhone.setPassword("pass1dutout");
        assertEquals(true, muskPhone.getIsConnected());

    }

    @Test
    public void testGetPasword() {
        muskPhone.setPassword("pass1dutout");
        assertEquals("pass1dutout", muskPhone.getPassword());

    }

    @Test
    public void testGetIsTurnedOn() {
        muskPhone.setIsTurnedOn(false);
        assertEquals(false, muskPhone.getIsTurnedOn());
    }

    @Test
    public void testIsCharging() {
        muskPhone.setBattery(100);
        assertEquals("Battery is full", muskPhone.isCharging());
    }

    @Test
    public void testIsCharging2() {
        muskPhone.setBattery(99);
        assertEquals("Phone battery : 100", muskPhone.isCharging());
    }

    @Test
    public void testIsDischarging() {
        muskPhone.setIsTurnedOn(true);
        muskPhone.setBattery(55);
        assertEquals("Phone battery : 54", muskPhone.isDischarging());
    }

    @Test
    public void testIsDischarging2() {
        muskPhone.setIsTurnedOn(true);
        muskPhone.setBattery(0);
        assertEquals("Battery is empty", muskPhone.isDischarging());
        assertEquals(false, muskPhone.getIsTurnedOn());
    }

    @Test
    public void testChangePassword() {
        muskPhone.changePassword("pass1dutout", "newpass");
        assertEquals("newpass", muskPhone.getPassword());

        this.muskPhone.changePassword("1234", "pass");
        assertEquals("Error : Wrong Password", this.muskPhone.getErrorMessage());
    }

    @Test
    public void testCheckStorage() {
        mobileAp1.setAppSize(190.0);
        assertEquals(false, muskPhone.checkStorage(mobileAp1));
    }

    @Test
    public void testGetSim() {
        muskPhone.setSim(true);
        assertEquals(true, muskPhone.getSim());
    }

    @Test
    public void testDisconnect() {
        muskPhone.connect(muskPods);
        muskPhone.disconnect(muskPods);
        assertEquals("Wireless Headphone disconnected", muskPhone.getSuccessMessage());
    }

    @Test
    public void testGetBluetoothOn() {
        muskPhone.setBluetoothOn(true);

        assertEquals(true, muskPhone.getBluetoothOn());

        this.muskPhone.setBluetoothOn(true);
        assertEquals("Error : bluetooth is already in this state", this.muskPhone.getErrorMessage());
    }

    @Test
    public void testGetWheadphone() {
        muskPhone.setWheadphone(muskPods);
        assertEquals(muskPods, muskPhone.getWheadphone());
    }

    @Test
    public void testConnect() {
        this.muskPods.setIsAvailable(true);
        this.muskPhone.setBluetoothAvailability(true);
        this.muskPhone.connect(this.muskPods);
        assertEquals("Wireless Headphone connected", this.muskPhone.getSuccessMessage());
    }

    @Test
    public void testGetMessage() {
        this.muskPhone.setMessage("Musk's phone");
        assertEquals("Musk's phone", this.muskPhone.getMessage());
    }

    @Test
    public void testSendMessage() {
        Phone jeffBesosPhone = new Phone();
        this.muskPhone.sendMessage("Btw, you suck :)", jeffBesosPhone);
        assertEquals("Btw, you suck :)", jeffBesosPhone.getMessage());
    }

    @Test
    public void testSetPassword() {
        this.muskPhone.setPassword("0000");
        assertFalse(this.muskPhone.getIsConnected());
    }


}