package packagePhone.unitTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import packagePhone.MobileApp;
import packagePhone.Phone;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Classe-test MobileAppTest.
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
public class MobileAppTest {
    /*
     * private Phone phone1; private MobileApp mobileAp1; private MobileApp
     * mobileAp2;
     */

    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).

    /**
     * Constructeur de la classe-test MobileAppTest
     */
    public MobileAppTest() {
    }

    /**
     * Met en place les engagements.
     * <p>
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @BeforeEach
    public void setUp() // throws java.lang.Exception
    {
        /*
         * phone1 = new Phone(); mobileAp1 = new MobileApp(); mobileAp2 = new
         * MobileApp();
         */
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
        MobileApp mobileAp1 = new MobileApp();
        mobileAp1.setAppName("whatsapp");
        mobileAp1.setAppSize(26.0);
        assertEquals("App : whatsapp Size : 26.0 Mo", mobileAp1.toString());
    }

    @Test
    public void testGetAppSize() {
        MobileApp mobileAp1 = new MobileApp();
        mobileAp1.setAppSize(26.0);
        assertEquals(26.0, mobileAp1.getAppSize(), 0.1);
    }

    @Test
    public void testGetPhone() {
        MobileApp mobileAp1 = new MobileApp();
        Phone phone1 = new Phone();
        mobileAp1.setPhone(phone1);
        assertEquals("Phone : default name Battery : 100% Memory size : 126.0 Mo "
                + "[App : call Size : 26.0 Mo, App : messages Size : 20.0 Mo]", mobileAp1.getPhone());
    }
}