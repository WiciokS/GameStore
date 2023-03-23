package lt.viko.eif.vskuder.model;

import org.junit.*;

import static org.junit.Assert.*;
/**
 * The test class for the Developer class.
 */

public class DeveloperTest {
/**
     * The Developer object used for testing.
     */
    @Test
    public void testToString() {
        //output a string representation of the Developer object to string
        System.out.println("toString");
        //and also test the toString method
        Developer developer = new Developer();
        developer.setName("Test");
        developer.setCountry("Test");
        developer.setId(1);
        assertEquals("Developer{id=1, name='Test', country='Test'}", developer.toString());
        //and output it
        System.out.println(developer.toString());
    }
}