import java.rmi.*;
public interface Matrix extends Remote
{
 public int[][] matAdd(int a[][], int b[][]) throws RemoteException;
public int[][] matSub(int a[][], int b[][]) throws RemoteException;
}
