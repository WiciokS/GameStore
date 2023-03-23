package lt.viko.eif.vskuder.model;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 * The test class for the Game class.
 */

public class GameTest {
    /**
     * The Game object used for testing.
     * tests toString method
     */

    @Test
    public void testToString() {
        //create category
        Category category = new Category(1,"Category");
        Category category2 = new Category(2,"Category2");
        //create category list and add categories
        List<Category> categories = new ArrayList<>();
        categories.add(category);
        categories.add(category2);
        //create developer
        Developer developer = new Developer(1, "Developer", "Lithuania");
        //create game
        Game game = new Game(1,"Game", 10, developer, categories);
        //test toString
        assertEquals("Game{id='1', title='Game', price=10, developer=Developer{name='Developer', location='Vilnius', country='Lithuania'}, categories=[Category{id='1', name='Category'}, Category{id='2', name='Category2'}]}",
                game.toString());

    }
}