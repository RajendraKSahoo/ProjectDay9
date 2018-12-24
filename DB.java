package com.ibm.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Assert;

public class DB {

	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
		/*//connection string - jdbc(odbc0:server://host:port/db_name, username, password
		Connection c = DriverManager.getConnection("jdbc:mysql://foodsonfinger.com:3306/foodsonfinger_atozgroceries", "foodsonfinger_atoz", "welcome@123");
		
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("Select * from as_tabs");
		
		while(rs.next())
		{
			System.out.print(rs.getInt("tab_id"));
			System.out.println("\t"+rs.getString("name"));
		}*/
		//System.out.println("The is for DB connection then continue...");
		//dbvalidation_tab ();
	}
	
	public void dbvalidation_tab () throws SQLException, FileNotFoundException, IOException
	{
		Connection c = DriverManager.getConnection("jdbc:mysql://foodsonfinger.com:3306/foodsonfinger_atozgroceries", "foodsonfinger_atoz", "welcome@123");
		
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("Select * from as_tabs");
		
		Properties p = new Properties();
		p.load(new FileInputStream("./TestData/magentodata.properties"));
		
		while(rs.next())
		{
			//System.out.println(rs.getInt("tab_id"));
			//System.out.println(rs.getString("name"));
			
			if (p.getProperty("tabname").equalsIgnoreCase(rs.getString("name")))
			{
				System.out.println("The record is inserted!");
				Assert.assertTrue(true);
			}
			
		}
		
	}
}
