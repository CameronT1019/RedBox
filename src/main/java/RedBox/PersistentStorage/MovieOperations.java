package RedBox.PersistentStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import RedBox.BSTree.BinaryTree;
import RedBox.Movies.Movie;

public class MovieOperations {
    
    
    /* public static boolean RemoveTitle(String name, int remove)
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
    } */
    
    /* public static boolean RentTitle(String name)
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
    } */
    
    /* public static String ReturnTitle(String name)
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
    } */

}
