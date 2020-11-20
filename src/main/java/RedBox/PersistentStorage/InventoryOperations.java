package RedBox.PersistentStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import RedBox.BSTree.BinaryTree;
import RedBox.BSTree.Node;
import RedBox.Movies.Movie;

public class InventoryOperations {
   
    private static BinaryTree<Movie> item = new BinaryTree<Movie>();
    Node<Movie> temp;

    public static BinaryTree<Movie> readInventory() throws FileNotFoundException {
        File inventory = new File("/Users/cameron/Desktop/Project 4/RedBox/inventory.dat");
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

    public static void readTransactions(BinaryTree<Movie> passedTree, ArrayList<String> errors) throws FileNotFoundException {
        File transactionFile = new File("transaction.log");
        Scanner s = new Scanner(transactionFile);
        String line;
        String[] splits;
        

    }
    
    public static boolean AddTitle(String title, int numToAdd) {
        boolean updated = false;

        Movie add = new Movie(title, numToAdd, 0);

        if (item.search(add) == null) {
            item.insert(add);
            updated = true;
        } else {
            Movie now = new Movie(title, item.search(add).getElement().getAvailable() + numToAdd,
                    item.search(add).getElement().getRented());
            item.search(add).setElement(now);

            updated = true;
        }
        return updated;
    }
    
    public static boolean RemoveTitle(String name, int remove)
    {
        boolean removed = false;
        Movie given = new Movie(name, remove, 0);

        if (item.search(given) != null) {
            if (item.search(given).getElement().getAvailable() - remove >= 0
                    && item.search(given).getElement().getRented() >= 0) {
                Movie now = new Movie(name, item.search(given).getElement().getAvailable() - remove,
                        item.search(given).getElement().getRented());
                item.search(given).setElement(now);
            } else if (item.search(given).getElement().getAvailable() <= 0
                    && item.search(given).getElement().getRented() == 0) {
                item.delete(given);
            }
            removed = true;
        }
        return removed;
    }
    
    public static boolean RentTitle(String name)
    {
        boolean rented = false;
        Movie given = new Movie(name, 0, 0);

        if (item.search(given) != null) {
            Movie now = new Movie(name, item.search(given).getElement().getAvailable() - 1,
                    item.search(given).getElement().getAvailable() + 1);

            item.search(given).setElement(now);
            rented = true;
        }
        return rented;
    }
    
    public static String ReturnTitle(String name)
    {
        String returned = "";
        Movie given = new Movie(name, 0, 0);

        if(item.search(given) != null)
        {
            Movie now = new Movie(name, item.search(given).getElement().getAvailable() + 1,
                    item.search(given).getElement().getAvailable() - 1);

            item.search(given).setElement(now);
        }
        return returned;
    }

}
