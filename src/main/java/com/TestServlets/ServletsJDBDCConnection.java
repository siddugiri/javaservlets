package com.TestServlets;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ServletsJDBDCConnection 
{
	public static void insert(TestServlets TS) throws SQLException
	{
	        Connection connection = null;
	        PreparedStatement statement = null;
	      
	        String DataBaseURL = "jdbc:mysql:// 192.168.0.151/CODEBEGIN_TEST";
	        String UserName = "root";
	        String Password = "root";
	        String insertQuery = "insert into RServletData"+ "(FirstName,LastName,Email,Phone)"+"values (?,?,?,?)";
	        
	        try 
	        {
	            connection = DriverManager.getConnection(DataBaseURL,UserName,Password);
	            statement = connection.prepareStatement(insertQuery);
	            statement.setString(1,TS.getFirstName());
	            statement.setString(2,TS.getLastName());
	            statement.setString(3,TS.getEmail());
	            statement.setString(4,TS.getPhone());
	            statement.execute();
	        }
	
	        catch(Exception ae)
	        {
	           ae.printStackTrace();
	        }
        finally {
		connection.close();
		statement.close();
	}
	}
}
