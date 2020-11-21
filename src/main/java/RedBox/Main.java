package RedBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import RedBox.BSTree.BinaryTree;
import RedBox.Movies.Movie;

public class Main 
{
    static BinaryTree<Movie> movies = new BinaryTree<Movie>();
    public static void main( String[] args ) throws FileNotFoundException
    {
            
        ArrayList<String> errors = new ArrayList<>();

        readInventory(movies);
        readTransactions(movies, errors);

    }
    
    private static void readInventory(BinaryTree<Movie> movies) throws FileNotFoundException {
        File inventory = new File("inventory.dat");
        Scanner s = new Scanner(inventory);
        String line;
        String[] splits;
        while (s.hasNextLine()) {
            line = s.nextLine();
            splits = line.split(",");
            movies.insert(new Movie(splits[0], Integer.parseInt(splits[1]), Integer.parseInt(splits[2])));
        }
    }

    private static void readTransactions(BinaryTree<Movie> movies, ArrayList<String> errors)
            throws FileNotFoundException {
        File transactionFile = new File("transaction.log");
        Scanner s = new Scanner(transactionFile);
        String line;
        String[] splits;
        

        while (s.hasNextLine()) {
            line = s.nextLine();
            splits = line.split(" ");

            if (splits[0].equals("add")) {
                splits = splits[1].split(",");
                AddTitle(splits[0], Integer.parseInt(splits[1]));
            } else if (splits[0].equals("remove")) {
                splits = splits[1].split(",");
                boolean removed = RemoveTitle(splits[0], Integer.parseInt(splits[1]));
                if (!removed) {
                    errors.add(line);
                }
            } else if (splits[0].equals("rent")) {
                boolean rented = RentTitle(splits[1]);
                if (!rented) {
                    errors.add(line);
                }
            } else if (splits[0].equals("return")) {
                boolean returned = ReturnTitle(splits[1]);
                if (!returned) {
                    errors.add(line);
                }
            } else {
                errors.add(line);
            }
        }

    }
    
    public static void AddTitle(String title, int numToAdd) {

        Movie temp = movies.search(new Movie(title, numToAdd, 0));

        if (temp != null) {
            temp.setAvailable(temp.getAvailable() + numToAdd);
        }
        movies.insert(new Movie(title, numToAdd, 0));
    }

    public static boolean RemoveTitle(String name, int remove)
    {
        boolean returnValue = false;
        Movie temp = movies.search(new Movie(name, remove, 0));

        if (temp == null) {
            return false;
        }
        temp.setAvailable(temp.getAvailable() - remove);
        if (temp.getAvailable() == 0 && temp.getRented() == 0) {
            movies.delete(temp);
            returnValue = true;
        }
        return returnValue;
    }
    
    public static boolean RentTitle(String name)
    {
        Movie temp = movies.search(new Movie(name, 0, 0));

        if (temp == null) {
            return false;
        }
        temp.setAvailable(temp.getAvailable() - 1);
        temp.setRented(temp.getRented() + 1);
        return true;
    }
    
    public static boolean ReturnTitle(String name)
    {
        Movie temp = movies.search(new Movie(name, 0, 0));

        if(temp == null)
        {
            return false;
        }
        temp.setAvailable(temp.getAvailable() + 1);
        temp.setRented(temp.getRented() - 1);
        return true;
    }
}
