package RedBox.PersistentStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import RedBox.BSTree.BinaryTree;
import RedBox.Movies.Movie;

public class InventoryOperations {
   
    private static BinaryTree<Movie> item = new BinaryTree<Movie>();
    
    public static BinaryTree<Movie> readInventory() throws FileNotFoundException {
        File inventory = new File("inventory.dat");
        Scanner s = new Scanner(inventory);
        String line;
        String[] split;
        while (s.hasNextLine()) {
            line = s.nextLine();
            split = line.split(",");
            item.insert(new Movie(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2])));
        }
        return item;
    }
}
