package test;

import java.sql.*;
public class DBConnection 
{
	private static Connection con= null;
	private DBConnection() {}
	static
	{
		
	 try
	 {
		 Class.forName("oracle.jdbc.driver.OracleDriver"); 
		 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","system","Qazmlp01");
	 }
	 
	 catch(Exception e)
	 
		 {e.printStackTrace();}
	}
	 public static Connection getCon()
	 {
		 return con;
	 }
	 
	
}
