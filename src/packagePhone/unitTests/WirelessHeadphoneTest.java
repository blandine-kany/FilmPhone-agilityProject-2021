package packagePhone.unitTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import packagePhone.Phone;
import packagePhone.WirelessHeadphone;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe-test WirelessHeadphoneTest.
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
public class WirelessHeadphoneTest {
    private WirelessHeadphone muskpods;
    private Phone muskphone;

    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).

    /**
     * Constructeur de la classe-test WirelessHeadphoneTest
     */
    public WirelessHeadphoneTest() {
    }

    /**
     * Met en place les engagements.
     * <p>
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @BeforeEach
    public void setUp() // throws java.lang.Exception
    {
        muskpods = new WirelessHeadphone();
        muskphone = new Phone();
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
    public void testGetBattery() {
        muskpods.setBattery(55);
        assertEquals(55, muskpods.getBattery());
    }

    @Test
    public void testGetWHeadphoneName() {
        muskpods.setWHeadphoneName("muskpods");
        assertEquals("muskpods", muskpods.getWHeadphoneName());
    }

    @Test
    public void testGetIsTurnedOn() {
        muskpods.setIsTurnedOn(true);
        assertEquals(true, muskpods.getIsturnedOn());
    }

    @Test
    public void testGetPhone() {
        muskpods.setPhone(muskphone);
        assertEquals(null, muskpods.getPhone());
    }

}
