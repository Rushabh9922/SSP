import java.rmi.*;
public interface Maths extends Remote
{
   //declaring the method prototype 
   public int add(int n1 , int n2) throws RemoteException;
   public int sub(int n1 , int n2) throws RemoteException;
   public int mul(int n1 , int n2) throws RemoteException;
   public int Div(int n1 , int n2) throws RemoteException;
}

