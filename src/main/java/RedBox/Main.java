package RedBox;

import java.io.FileNotFoundException;

import RedBox.BSTree.BinaryTree;
import RedBox.Movies.Movie;
import RedBox.PersistentStorage.InventoryOperations;

public class Main 
{
    
    public static BinaryTree<Movie> tree = new BinaryTree<Movie>();
    public static void main( String[] args ) throws FileNotFoundException
    {
        
        tree = InventoryOperations.readInventory();
        
    }
}
