package admin.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import admin.beans.Admin;
import studentmanagement.db.DBConnection;
public class AdminLoginDAO 
{
	
	Admin admin=null;
	
	public Admin getAdmin(String userName,String password)
	{
		try
		{
			Connection conn=DBConnection.getConn();
			PreparedStatement ps=conn.prepareStatement("Select * from studentadmin where uname=? and password=?" );
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				admin=new Admin();
				admin.setUsername(rs.getString(1));
				admin.setPassword(rs.getString(2));
				admin.setFirstName(rs.getString(3));
				admin.setLastName(rs.getString(4));
				admin.setCity(rs.getString(5));
				admin.setMailId(rs.getString(6));
				admin.setMobileNo(rs.getLong(7));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return admin;
	}
	
	

}
