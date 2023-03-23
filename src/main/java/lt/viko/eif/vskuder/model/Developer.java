
package lt.viko.eif.vskuder.model;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
/**

 The Developer class represents a video game developer.
 It contains the developer's id, name, and country.
 The class is annotated with JAXB annotations to support XML serialization and deserialization.
 The class is also annotated with JPA annotations to support persistence.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"developerId", "developerName", "developerCountry"})
@Entity
@Table(name = "Developer")
public class Developer {
    /**
    * The id of the developer.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "developerId")
    @XmlElement(name = "id")
    private int developerId;

    /**
     * The name of the developer.
     */
    @XmlElement(name = "name")
    private String developerName;

    /**
     * The country of the developer.
     */
    @XmlElement(name = "country")
    private String developerCountry;

    /**
     * Default constructor for the Developer class.
     */
    public Developer() {
    }

    /**
     * Constructor for the Developer class with parameters.
     *
     * @param name The name of the developer.
     * @param country The country of the developer.
     */

    public Developer(String name, String country) {
        this.developerName = name;
        this.developerCountry = country;
    }

    /**
     * Constructor for the Developer class with parameters.
     *
     * @param id The id of the developer.
     * @param name The name of the developer.
     * @param country The country of the developer.
     */
    public Developer(int id, String name, String country) {
        this.developerId = id;
        this.developerName = name;
        this.developerCountry = country;
    }

    /**
     * Returns the id of the developer.
     *
     * @return The id of the developer.
     */
    public int getId() {
        return developerId;
    }

    /**
     * Sets the id of the developer.
     *
     * @param id The id of the developer.
     */
    public void setId(int id) {
        this.developerId = id;
    }

    /**
     * Returns the name of the developer.
     *
     * @return The name of the developer.
     */
    public String getName() {
        return developerName;
    }

    /**
     * Sets the name of the developer.
     *
     * @param name The name of the developer.
     */
    public void setName(String name) {
        this.developerName = name;
    }

    /**
     * Returns the country of the developer.
     *
     * @return The country of the developer.
     */
    public String getCountry() {
        return developerCountry;
    }

    /**
     * Sets the country of the developer.
     *
     * @param country The country of the developer.
     */
    public void setCountry(String country) {
        this.developerCountry = country;
    }

    /**
     * Returns a String representation of the Developer object.
     *
     * @return A String representation of the Developer object.
     */
    @Override
    public String toString(){
        return String.format("\t\tDeveloper:\n\t\t\t\tDeveloper id: %d\n\t\t\t\tDeveloper name: %s\n\t\t\t\tDeveloper country: %s\n",
                developerId,developerName,developerCountry);
    }
}