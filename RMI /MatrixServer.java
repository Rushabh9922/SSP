import java.rmi.*;
import java.rmi.registry.*;
public class MatrixServer
{
    public static void main(String args[])
    {
        try
        {
            // Create an object of the interface
            // implementation class
		System.out.println("Matrix Server is Started...");
            Matrix obj = new MatrixMethods();
 
            // rmiregistry within the server JVM with
            // port number 1900
            LocateRegistry.createRegistry(1900);
 
            
            Naming.rebind("rmi://localhost:1900"+
                          "/matrix",obj);
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
}
