package lt.viko.eif.vskuder.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.List;


/**

 The Game class represents a game object with its properties such as id, title, price, developer, and categories.

 This class is mapped to a database table named "Game" using JPA annotations.

 It also has JAXB annotations for XML binding.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"gameId", "gameTitle", "gamePrice", "developer", "categories"})
@Entity
@Table(name = "game")
public class Game {

    /**

     The id of the game.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gameId")
    @XmlElement(name = "id")
    private int gameId;
    /**

     The title of the game.
     */
    @XmlElement(name = "title")
    private String gameTitle;
    /**

     The price of the game.
     */
    @XmlElement(name = "price")
    private float gamePrice;
    /**

     The developer of the game.
     */
    @XmlElement(name = "Developer")
    @ManyToOne(targetEntity = Developer.class, cascade = CascadeType.ALL)
    private Developer developer;
    /**

     The categories of the game.
     */
    @XmlElementWrapper(name = "Categories")
    @XmlElement(name = "Category")
    @OneToMany(targetEntity = Category.class, cascade = CascadeType.ALL)
    private List<Category> categories;
    /**

     Constructs a new game object with default values for all properties.
     */
    public Game() {
    }

    /**

     Constructs a new game object with the specified values for all properties.
     @param title The title of the game.
     @param price The price of the game.
     @param developer The developer of the game.
     @param categories The categories of the game.
     */

    public Game(String title, float price, Developer developer, List<Category> categories) {
        this.gameTitle = title;
        this.gamePrice = price;
        this.developer = developer;
        this.categories = categories;
    }
    /**

     Constructs a new game object with the specified values for all properties.
     @param id The id of the game.
     @param title The title of the game.
     @param price The price of the game.
     @param developer The developer of the game.
     @param categories The categories of the game.
     */
    public Game(int id, String title, float price, Developer developer, List<Category> categories) {
        this.gameId = id;
        this.gameTitle = title;
        this.gamePrice = price;
        this.developer = developer;
        this.categories = categories;
    }
    /**

     Returns the id of the game.
     @return The id of the game.
     */
    public int getId() {
        return gameId;
    }
    /**

     Sets the id of the game.
     @param id The id of the game.
     */
    public void setId(int id) {
        this.gameId = id;
    }
    /**

     Returns the title of the game.
     @return The title of the game.
     */
    public String getTitle() {
        return gameTitle;
    }
    /**

     Sets the title of the game.
     @param title The title of the game.
     */
    public void setTitle(String title) {
        this.gameTitle = title;
    }
    /**

     Returns the price of the game.
     @return The price of the game.
     */
    public float getPrice() {
        return gamePrice;
    }
    /**

     Sets the price of the game.
     @param price The price of the game.
     */
    public void setPrice(float price) {
        this.gamePrice = price;
    }
    /**

     Returns the developer of the game.
     @return The developer of the game.
     */
    public Developer getDeveloper() {
        return developer;
    }
    /**

     Sets the developer of the game.
     @param developer The developer of the game.
     */
    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
    /**

     Returns the categories of the game.
     @return The categories of the game.
     */
    public List<Category> getCategories() {
        return categories;
    }
    /**

     Sets the categories of the game.
     @param categories The categories of the game.
     */

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    /**

     Returns a string representation of the game object.
     @return A string representation of the game object.
     */

    @Override
    public String toString(){
        String data = String.format("\t\tGame:\n\t\t\tGame id: %d\n\t\t\tGame title: %s\n\t\t\tGame price: %f\n",gameId,gameTitle,gamePrice);
        data += "\t";
        data += developer.toString();
        data += "\t\t\tCategories:\n";
        for (Category category : categories) {
            data += category.toString();
        }
        data += "\t\t\tCategories:\n";
        data += "\t\tGame:\n";
        return data;
    }
}
