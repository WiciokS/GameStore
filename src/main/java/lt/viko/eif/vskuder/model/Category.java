
package lt.viko.eif.vskuder.model;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
/**

 The Category class represents a category that a game can belong to.
 It contains the id and name of the category.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"categoryId", "categoryName"})
@Entity
@Table(name = "Category")
public class Category {
    /**
    * The unique identifier of the category.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryId")
    @XmlElement(name = "id")
    private int categoryId;

    /**
     * The name of the category.
     */
    @XmlElement(name = "name")
    private String categoryName;

    /**
     * Constructs an empty Category object.
     */
    public Category() {
    }
    /**
     * Constructs a Category object with specified name.
     *
     * @param name the name of the category
     */

    public Category(String name) {
        this.categoryName = name;
    }

    /**
     * Constructs a Category object with specified id and name.
     *
     * @param id the unique identifier of the category
     * @param name the name of the category
     */
    public Category(int id, String name) {
        this.categoryId = id;
        this.categoryName = name;
    }

    /**
     * Returns the id of the category.
     *
     * @return the id of the category
     */
    public int getId() {
        return categoryId;
    }

    /**
     * Sets the id of the category.
     *
     * @param id the unique identifier of the category
     */
    public void setId(int id) {
        this.categoryId = id;
    }

    /**
     * Returns the name of the category.
     *
     * @return the name of the category
     */
    public String getName() {
        return categoryName;
    }

    /**
     * Sets the name of the category.
     *
     * @param name the name of the category
     */
    public void setName(String name) {
        this.categoryName = name;
    }

    /**
     * Returns a string representation of the Category object.
     *
     * @return a string representation of the Category object
     */
    @Override
    public String toString(){
        return String.format
                ("\t\t\t\tCategory:\n\t\t\t\t\tCategory id: %d\n\t\t\t\t\tCategory name: %s\n"
                        ,categoryId,categoryName);
    }
}
