import java.rmi.*;
import java.rmi.registry.*;
public class DatabaseServer
{
    public static void main(String args[])
    {
        try
        {
		System.out.println("Server Started.....");
         // Create an object of the interface implementation class
            Database obj = new DatabaseTask();
          // rmiregistry within the server JVM with port number 1900
            LocateRegistry.createRegistry(1900);
             // Binds the remote object by the name dbService
            Naming.rebind("rmi://localhost:1900"+"/dbService",obj);
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
}
