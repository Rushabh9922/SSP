import java.rmi.*;
import java.rmi.server.*;
public class MatrixMethods extends UnicastRemoteObject
                         implements Matrix
	{
	   MatrixMethods() throws RemoteException
		{
	  		super();
		}
	public int[][] matAdd(int a[][], int b[][])
	{
                int r = a.length;
		int c = a[0].length;

		int res[][] = new int[r][c];

		for(int i=0; i<r;i++)
		{
			
			for(int j=0; j<c; j++)
				res[i][j] = a[i][j] + b[i][j];
		}
		
		return res;


	}

public int[][] matSub(int a[][], int b[][])
	{
                int r = a.length;
		int c = a[0].length;

		int res[][] = new int[r][c];

		for(int i=0; i<r;i++)
		{
			
			for(int j=0; j<c; j++)
				res[i][j] = a[i][j] - b[i][j];
		}
		
		return res;


	}

	}
