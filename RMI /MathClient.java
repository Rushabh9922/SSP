import java.rmi.*;
import java.rmi.*;
public class MathClient
{
   public static void main(String args[]) 
    {
      int a=10,b=20,ans;
      try
   {   
      
     Maths m1 = (Maths)Naming.lookup("rmi://localhost:1900"+"/jnec");
           ans= m1.add(a,b);
          System.out.println("Addition is"+ans);
     Maths m2 = (Maths)Naming.lookup("rmi://localhost:1900"+"/jnec");
           res= m2.sub(a,b);
          System.out.println("sub is"+res);
     Maths m3 = (Maths)Naming.lookup("rmi://localhost:1900"+"/jnec");
           ans1= m1.mul(a,b);
          System.out.println("mul is"+ans1);
     Maths m4 = (Maths)Naming.lookup("rmi://localhost:1900"+"/jnec");
           ans4= m4.Div(a,b);
          System.out.println("Div is"+ans4);

}
   catch(Exception e)	

    {
        System.out.println(e);
         
    }
      
       
   }


}
