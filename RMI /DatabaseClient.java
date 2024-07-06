import java.rmi.*;
public class DatabaseClient
{
    public static void main(String args[])
    {
        String u1="student",pwd="12345";
	String response;
        try
        {
            // lookup method to find reference of remote object
        Database db =(Database)Naming.lookup("rmi://localhost:1900"+ "/dbService");
            response = db.userLogin(u1,pwd);
            System.out.println("Server Response :  "+response);
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
}
