package lt.viko.eif.vskuder.model;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The test class for the Category class.
 */
public class CategoryTest {
    /**
     * The Category object used for testing.
     */

    @BeforeClass
    public static void beforeClass(){
        //output a string representation of the Category object
        System.out.println("CategoryTest before class");

    }
    /**
     * The Category object used for testing.
     */


    @Test
    public void testToString() {
        //output a string representation of the Category object to string
        System.out.println("toString");
    }
    /**
     * The Category object used for testing.
     */

    @AfterClass
    public static void afterClass(){
        //output a string representation of the Category object
        System.out.println("CategoryTest after class");

    }
}