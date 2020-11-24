// Cameron Testerman cxt200003 2021550951
package RedBox;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.Test;

import RedBox.BSTree.BinaryTree;
import RedBox.Movies.Movie;
import RedBox.Scanner.ScannerFactory;


/**
 * Unit test for simple App.
 */
public class MainTest 
{
    @Test
    public void addTitle() throws FileNotFoundException
    {
        //variables
        BinaryTree<Movie> movieBST = new BinaryTree<Movie>();
        File inventoryFile = new File("inventory.dat");
        ScannerFactory.setScannerFileInstance(inventoryFile);
        String transaction = "adD \"Kingdom Under Heaven\", 2";
        String line = "";
        String movieTitle = "";
        String available = "";
        String rented = "";
        int avail = 0;
        int rent = 0;
        PrintWriter error = new PrintWriter(new File("error.log"));

        //fill binary tree
        while(ScannerFactory.getScannerInstance().hasNext()) 
        {
                line = ScannerFactory.getScannerInstance().nextLine();
                
                line = line.substring(1);
                movieTitle = line.substring(0, line.indexOf('\"'));
                line = line.substring(line.indexOf('\"') + 1);
                line = line.substring(line.indexOf(',') + 1);
                
                available = line.substring(0, line.indexOf(','));
                available = available.trim();
                avail = Integer.parseInt(available);
                line = line.substring(line.indexOf(',') + 1);
                
                rented = line;
                rented = rented.trim();
                rent = Integer.parseInt(rented);
                Movie M = new Movie(movieTitle, avail, rent);
                movieBST.insert(M);
        }
        ScannerFactory.closeScannerInstance();
       
        if(Main.checkAddRemove(transaction, "add", error, movieBST))
        {
        	assertTrue(true);
        }
    }
    @Test
    public void removeTitle() throws FileNotFoundException
    {
        //variables
        BinaryTree<Movie> movieBST = new BinaryTree<Movie>();
        File inventoryFile = new File("inventory.dat");
        ScannerFactory.setScannerFileInstance(inventoryFile);
        String transaction = "RemOvE \"The Departed\", 2";
        String line = "";
        String movieTitle = "";
        String available = "";
        String rented = "";
        int avail = 0;
        int rent = 0;
        PrintWriter error = new PrintWriter(new File("error.log"));

        //fill binary tree
        while(ScannerFactory.getScannerInstance().hasNext())
        {
                line = ScannerFactory.getScannerInstance().nextLine();
                
                line = line.substring(1);
                movieTitle = line.substring(0, line.indexOf('\"'));
                line = line.substring(line.indexOf('\"') + 1);
                line = line.substring(line.indexOf(',') + 1);
                
                available = line.substring(0, line.indexOf(','));
                available = available.trim();
                avail = Integer.parseInt(available);
                line = line.substring(line.indexOf(',') + 1);
                
                rented = line;
                rented = rented.trim();
                rent = Integer.parseInt(rented);
                Movie M = new Movie(movieTitle, avail, rent);
                movieBST.insert(M);
        }
        ScannerFactory.closeScannerInstance();

        if(Main.checkAddRemove(transaction, "remove", error, movieBST)) 
        {
            assertTrue(true);
        }
    }
    @Test
    public void rentTitle() throws FileNotFoundException
    {
        //variables
        BinaryTree<Movie> movieBST = new BinaryTree<Movie>();
        File inventoryFile = new File("inventory.dat");
        ScannerFactory.setScannerFileInstance(inventoryFile);
        String transaction = "rent \"Inception\"";
        String line = "";
        String movieTitle = "";
        String available = "";
        String rented = "";
        int avail = 0;
        int rent = 0;
        PrintWriter error = new PrintWriter(new File("error.log"));

        //fill binary tree
        while(ScannerFactory.getScannerInstance().hasNext())
        {
                line = ScannerFactory.getScannerInstance().nextLine();
                
                line = line.substring(1);
                movieTitle = line.substring(0, line.indexOf('\"'));
                line = line.substring(line.indexOf('\"') + 1);
                line = line.substring(line.indexOf(',') + 1);
                
                available = line.substring(0, line.indexOf(','));
                available = available.trim();
                avail = Integer.parseInt(available);
                line = line.substring(line.indexOf(',') + 1);
                
                rented = line;
                rented = rented.trim();
                rent = Integer.parseInt(rented);
                Movie M = new Movie(movieTitle, avail, rent);
                movieBST.insert(M);
        }
        ScannerFactory.closeScannerInstance();

        if(Main.checkRentReturn(transaction, "rent", error, movieBST))
        {
        	assertTrue(true);
        }
    }
    @Test
    public void returnTitle() throws FileNotFoundException
    {
        //variables
        BinaryTree<Movie> movieBST = new BinaryTree<Movie>();
        File inventoryFile = new File("inventory.dat");
        ScannerFactory.setScannerFileInstance(inventoryFile);
        String transaction = "retUrn \"Kingdom Under Heaven\"";
        String line = "";
        String movieTitle = "";
        String available = "";
        String rented = "";
        int avail = 0;
        int rent = 0;
        PrintWriter error = new PrintWriter(new File("error.log"));

        //fill binary tree
        while(ScannerFactory.getScannerInstance().hasNext())
        {
                line = ScannerFactory.getScannerInstance().nextLine();
                
                line = line.substring(1);
                movieTitle = line.substring(0, line.indexOf('\"'));
                line = line.substring(line.indexOf('\"') + 1);
                line = line.substring(line.indexOf(',') + 1);
                
                available = line.substring(0, line.indexOf(','));
                available = available.trim();
                avail = Integer.parseInt(available);
                line = line.substring(line.indexOf(',') + 1);
                
                rented = line;
                rented = rented.trim();
                rent = Integer.parseInt(rented);
                Movie M = new Movie(movieTitle, avail, rent);
                movieBST.insert(M);
        }
        ScannerFactory.closeScannerInstance();

        if(Main.checkRentReturn(transaction, "return", error, movieBST)) 
        {
        	assertTrue(true);
        }
    }
}
