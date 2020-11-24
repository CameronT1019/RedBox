// Cameron Testerman cxt200003 2021550951
package RedBox.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ScannerFactory
 */
public abstract class ScannerFactory
{

  private static Scanner _scannerObject;

  public static void setScannerKeyboardInstance()
  {
      _scannerObject = new Scanner(System.in);
  }

  public static void setScannerFileInstance(File newFile) throws FileNotFoundException
  {
      _scannerObject = new Scanner(newFile); 
  }

  public static Scanner getScannerInstance()
  {
      return _scannerObject;
  }
  
  public static void closeScannerInstance()
  {
      _scannerObject.close();
      _scannerObject = null; 
  } 
}