package RedBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import RedBox.BSTree.BinaryTree;
import RedBox.Movies.Movie;
import RedBox.Scanner.ScannerFactory;

// Cameron Testerman cxt200003 2021550951
public class Main 
{
    static BinaryTree<Movie> movies = new BinaryTree<Movie>();
    public static void main( String[] args ) throws FileNotFoundException
    {
        File inventory = new File("inventory.dat");
        ScannerFactory.setScannerFileInstance(inventory);
        String line = "";
        String title = "";
        String available = "";
        String rented = "";
        int avail = 0;
        int rent = 0;
        BinaryTree<Movie> BST = new BinaryTree<>();
        
        if(inventory.exists())
        {
            while(ScannerFactory.getScannerInstance().hasNext())
            {
                line = ScannerFactory.getScannerInstance().nextLine();
                
                line = line.substring(1);
                title = line.substring(0, line.indexOf('\"'));
                line = line.substring(line.indexOf('\"') + 1);
                line = line.substring(line.indexOf(',') + 1);
                
                available = line.substring(0, line.indexOf(','));
                available = available.trim();
                avail = Integer.parseInt(available);
                line = line.substring(line.indexOf(',') + 1);
                
                rented = line;
                rented = rented.trim();
                rent = Integer.parseInt(rented);
                Movie M = new Movie(title, avail, rent);
                BST.insert(M);
            }
            ScannerFactory.getScannerInstance().close();
        }
        else
        {
            System.out.println("The inventory.dat file doesn't exist.");
        }

        File transaction = new File("transaction.log");
        ScannerFactory.setScannerFileInstance(transaction);
        PrintWriter error = new PrintWriter(new File("error.log"));
        
        if(transaction.exists())
        {
            while(ScannerFactory.getScannerInstance().hasNext())
            {
                line = ScannerFactory.getScannerInstance().nextLine();
                
                if(line.substring(0, 3).equalsIgnoreCase("add"))
                {
                    checkAddRemove(line, "add", error, BST);
                }
                else if(line.substring(0, 6).equalsIgnoreCase("remove"))
                {
                    checkAddRemove(line, "remove", error, BST);
                }
                else if(line.substring(0, 4).equalsIgnoreCase("rent"))
                {
                    checkRentReturn(line, "rent", error, BST);
                }
                else if(line.substring(0, 6).equalsIgnoreCase("return"))
                {
                    checkRentReturn(line, "return", error, BST);
                }
                else
                {
                    error.println(line);
                    continue;
                }
            }
            ScannerFactory.getScannerInstance().close();
            error.close();

            
        }
        else
        {
            System.out.println("The transaction.log file doesn't exist.");
        }
        
        PrintWriter kiosk = new PrintWriter(new File("redbox_kiosk.txt")); 
        kiosk.printf("%-25s%-11s%-8s", "Title", "Available", "Rented");
        kiosk.println();
        BST.printTree(kiosk);
            
        kiosk.close();
    }
    
    public static boolean checkAddRemove(String line, String s, PrintWriter pw, BinaryTree<Movie> BST)
    {
        boolean valid = false;
        String newLine = "";
        String title = "";
        String numAddRemove = "";
        int num = 0;
        
        if(s.equalsIgnoreCase("add"))
        {
            newLine = line.substring(4);
        }
        else if(s.equalsIgnoreCase("remove"))
        {
            newLine = line.substring(7);
        }
        
        if(newLine.equals(""))
        {
        	pw.println(line);
            return false;
        }
        else if(newLine.charAt(0) == '\"')
        {
            newLine = newLine.substring(1);
            if(newLine.equals("")) 
            {
            	pw.println(line);
            	return false;
            }
            if(newLine.indexOf('\"') == -1)   
            {
            	pw.println(line);
            	return false;
            }
            
            title = newLine.substring(0, newLine.indexOf('\"'));
            valid = true;
            
            if(newLine.indexOf(',') == -1)
            {
            	pw.println(line);
            	return false;
            }
            
            newLine = newLine.substring(newLine.indexOf('\"') +1);
            newLine = newLine.substring(newLine.indexOf(',') + 1);
            
            if(newLine.equals(""))
            {
            	pw.println(line);
            	return false;
            }
        
            numAddRemove = newLine.trim();
            try
            {
                num = Integer.parseInt(numAddRemove);
            }
            catch(NumberFormatException E)
            {
            	pw.println(line);
            	return false;
            }
        }
        
        if(valid == false)
        {
        	pw.println(line);
        	return false;
        }
        
        Movie M = new Movie(title, num);
        
        if(s.equals("add"))
        {
            Movie search = BST.search(M);
            if(search == null)
            {
                BST.insert(M);
            }
            else
            {
                search.add(num);
            }
            
        }
        else
        {
            Movie search = BST.search(M);
            if(search == null)
            {
            	pw.println(line);
            	return false;
            }
            else
            {
                search.remove(num);
                if(search.available <= 0 && search.rented <= 0)
                {
                    BST.delete(M);
                }
            }
        }
        
        return true;
    }
    
    public static boolean checkRentReturn(String line, String s, PrintWriter pw, BinaryTree<Movie> BST)
    {
        boolean valid = false;
        String newLine = "";
        String title = "";
        
        if(s.equalsIgnoreCase("rent"))
        {
            newLine = line.substring(5);
        }
        else if(s.equalsIgnoreCase("return"))
        {
            newLine = line.substring(7);
        }
        
        if(newLine.equals(""))
        {
            pw.println(line);
            return false;
        }
        else if(newLine.charAt(0) == '\"')
        {
            newLine = newLine.substring(1);
            if(newLine.equals(""))
            {
            	pw.println(line);
            	return false;
            }
            if(newLine.indexOf('\"') == -1)
            {
            	pw.println(line);
            	return false;
            }
            
            title = newLine.substring(0, newLine.indexOf('\"'));
            newLine = newLine.substring(newLine.indexOf('\"') + 1);
            valid = true;
        }
        
        if(valid == false)
        {
        	pw.println(line);
        	return false;
        }
        
        if(!(newLine.equals("")))
        {
        	pw.println(line);
        	return false;
        }
        
        Movie M = new Movie(title);

        if(s.equals("rent"))
        {
            Movie search = BST.search(M);
            if(search == null)
            {
            	pw.println(line);
            }
            else
            {
                search.rent();
            }
        }
        else
        {
            Movie search = BST.search(M);
            if(search == null)
            {
            	pw.println(line);
            }
            else
            {
                search.returned();
            }
        }
     
        return true;
    }
}
