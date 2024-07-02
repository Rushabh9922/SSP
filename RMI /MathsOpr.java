//implements interface 
import java.rmi.*;
import java.rmi.server.*;
public class MathsOpr extends UnicastRemoteObject implements Maths
{
   //Default constructor to throw RemoteException
   //from its parent constructor
   
   MathsOpr() throws RemoteException
   {
      super();
     
   }   
   public int add(int a , int b) 
   {
      return(a+b);
      }
   public int sub(int a , int b) 
   {
      return(a-b);
       
   }
   public int mul(int a , int b) 
   {
      return(a*b);
       
   }
   public int Div(int a , int b) 
   {
      return(a/b);
       
   }

}
