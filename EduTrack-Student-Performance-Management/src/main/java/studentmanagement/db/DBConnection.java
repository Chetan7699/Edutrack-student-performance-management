package studentmanagement.db;
import java.sql.*;
public class DBConnection 
{
   private static Connection conn=null;
   private DBConnection()
   {
	   
   }
   static
   {
	   try {
		   Class.forName(DBInfo.driver);
		conn=DriverManager.getConnection(DBInfo.url,DBInfo.uname,DBInfo.password);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	   
   }
   
   public static Connection getConn()
   {
	   return conn;
   }
}
