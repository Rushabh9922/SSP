import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.rmi.*;
import java.rmi.server.*;
public class DatabaseTask extends UnicastRemoteObject
                         implements Database
	{
	   DatabaseTask() throws RemoteException
		{
	  		super();
		}

	public String userLogin(String usr,String pswd)
		{
			String s1=" ";	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
		    
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUD","root","jneccse");

	String sql1 ="Select username,password from users where username=? and password=?";				
		PreparedStatement stmt=con.prepareStatement(sql1);
		stmt.setString(1,usr);
		stmt.setString(2,pswd);

		ResultSet rs=stmt.executeQuery();
		
		if (rs.next()){
			s1= " You are valid user"; } 
		else
		{ s1=" Check your user name and password";}		
				
			
		}catch(Exception e){
				e.printStackTrace();
			}
		return s1;
		}
}
