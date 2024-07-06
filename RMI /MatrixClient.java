import java.rmi.*;

import java.rmi.*;
public class MatrixClient
{
    public static void main(String args[])
    {
        int a[][]={{1,2,3},{4,5,6},{7,8,9}};
	int b[][]={{1,2,3},{4,5,6},{7,8,9}};
	int c[][]= new int[3][3];
        try
        {
            // lookup method to find reference of remote object
            Matrix m1 =
                (Matrix)Naming.lookup("rmi://localhost:1900"+
                                      "/matrix");
            c = m1.matAdd(a,b);
            System.out.println("Addition of matrix  ");
		int row = c.length;
		int col = c[0].length;
		
		for(int i=0; i<row;i++)
		{
			System.out.println(" ");
			for(int j=0; j<col; j++)
				System.out.print("  "+ c[i][j]);
		}

		
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
}
