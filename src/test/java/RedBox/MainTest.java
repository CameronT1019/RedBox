package RedBox;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import RedBox.Movies.Movie;
import RedBox.PersistentStorage.InventoryOperations;

/**
 * Unit test for simple App.
 */
public class MainTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void AddTitleTest()
    {
        Movie now = new Movie("Find", 12, 0);
        Boolean worked = InventoryOperations.AddTitle(now.getTitle(), now.getAvailable());

        if(worked)
        {
            assertTrue( true );
        }
        else{
            assertTrue( false );
        }
    }

    @Test
    public void RemoveTitleTest()
    {
        InventoryOperations.AddTitle("Find", 12);

        Boolean worked = InventoryOperations.RemoveTitle("Find", 10);

        if(worked)
        {
            assertTrue( true );
        }
        else{
            assertTrue( false );
        }
    }

    @Test
    public void RentTitleTest()
    {
        InventoryOperations.AddTitle("Find", 12);

        Boolean worked = InventoryOperations.RentTitle("Find");

        if(worked)
        {
            assertTrue( true );
        }
        else{
            assertTrue( false );
        }
    }

    @Test
    public void ReturnTitleTest()
    {
        InventoryOperations.AddTitle("name", 1);
        String now = InventoryOperations.ReturnTitle("name");

        if(now.equals("name"))
        {
            assertTrue( true );
        }
        else
        {
            assertTrue( false );
        }

    }
}
