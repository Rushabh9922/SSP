import java.rmi.*;
import java.rmi.registry.*;
public class MathServer
{
   public static void main(String args[]) 
    {
      try
     
   {   
      System.out.println("server Started.....");
 	//create an objectof the interface implementation class   
	Maths obj = new MathsOpr();
      //rmiregidtry within the server JVM with port number 1900
	LocateRegistry.createRegistry(1900);
     Naming.rebind("rmi://localhost:1900"+"/jnec",obj);
  }
    catch(Exception ae)
    {
        System.out.println(ae);
         
    }
      
       
   }


} 
