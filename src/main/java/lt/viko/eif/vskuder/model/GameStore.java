package lt.viko.eif.vskuder.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The GameStore class represents a game store, with a name, location, and list of games.
 * This class is annotated with JAXB and JPA annotations for XML and database serialization.
 */
@XmlRootElement(name = "GameStore", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id", "name", "location", "games"})
@Entity
@Table(name = "gamestore")
public class GameStore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    /**
     * The name of the game store.
     */
    @XmlElement
    private String name;

    /**
     * The location of the game store.
     */
    @XmlElement
    private String location;

    /**
     * The list of games available at the game store.
     */
    @XmlElementWrapper(name = "Games")
    @XmlElement(name = "Game")
    @OneToMany(targetEntity = Game.class, cascade = CascadeType.ALL)
    private List<Game> games;

    /**
     * Default constructor required by JPA.
     */
    GameStore() {
    }

    /**
     * Constructor that creates a new GameStore object with the given parameters.
     * @param name The name of the game store.
     * @param location The location of the game store.
     * @param games The list of games available at the game store.
     */
    public GameStore(String name, String location, List<Game> games) {
        this.name = name;
        this.location = location;
        this.games = games;
    }

    /**
     * Returns the name of the game store.
     * @return The name of the game store.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the game store.
     * @param name The new name of the game store.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the location of the game store.
     * @return The location of the game store.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the game store.
     * @param location The new location of the game store.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns the list of games available at the game store.
     * @return The list of games available at the game store.
     */
    public List<Game> getGames() {
        return games;
    }

    /**
     * Sets the list of games available at the game store.
     * @param games The new list of games available at the game store.
     */
    public void setGames(List<Game> games) {
        this.games = games;
    }

    /**
     * Returns a string representation of the GameStore object.
     * @return A string representation of the GameStore object.
     */
    @Override
    public String toString(){
        String data = String.format
                ("GameStore:\n\tGameStore name: %s\n\tGameStore location: %s\n"
                        ,name,location);
        data += "\tGames:\n";
        for (Game game : games) {
            data += game.toString();
        }
        data += "\tGames\n";
        data += "GameStore\n";
        return data;
    }
}
