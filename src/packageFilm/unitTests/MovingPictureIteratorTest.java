package packageFilm.unitTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import packageFilm.Film;
import packageFilm.MovingPicture;
import packageFilm.MovingPictureIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MovingPictureIteratorTest {
    private MovingPictureIterator movingPictureIterator;
    private List<MovingPicture> movingPictureList;
    private Film film1;
    private Film film2;

    public MovingPictureIteratorTest() { }

    @BeforeEach
    public void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements
        this.film1 = new Film("1st", "d1");
        this.film2 = new Film("2nd", "d2");
        this.movingPictureList = Arrays.asList(film1, film2);
        this.movingPictureIterator = new MovingPictureIterator(movingPictureList);

    }

    @AfterEach
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
        this.film1 = null;
        this.film2 = null;
        this.movingPictureList = null;
        this.movingPictureIterator = null;
    }

    @Test
    public void testHasNext(){
        assertTrue(this.movingPictureIterator.hasNext());
        assertFalse(new MovingPictureIterator((new ArrayList<>())).hasNext());
    }

    @Test
    public void testNext(){
        assertEquals(this.film1, this.movingPictureIterator.next());
    }

    @Test
    public void testReset(){
        while(this.movingPictureIterator.hasNext())
            this.movingPictureIterator.next();

        this.movingPictureIterator.reset();
        assertEquals(this.film1, this.movingPictureIterator.currentItem());
    }

    @Test
    public void testCurrentItem(){
        assertEquals(this.film1, this.movingPictureIterator.currentItem());
    }
}
