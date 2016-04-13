package com.lynda.javatraining.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static ConnectionManager instance = null;

	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "dbpassword";
	private static final String H_CONN_STRING = "jdbc:hsqldb:data/explorecalifornia";
	private static final String M_CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";

	
	private Connection conn = null;
	private   DBType dbType = DBType.MYSQL;
	private ConnectionManager()
	{}
	
	public void setDBType(DBType dbType)
	{
		this.dbType = dbType;
	}
	
	public static ConnectionManager getInstance()
	{
		if(instance == null)
		{
			
			instance = new ConnectionManager();
		}
		return instance;
		
	}
	
	private boolean openConnection()
	{
		try {
			switch (dbType) {
			case HSQLDB: conn = DriverManager.getConnection(H_CONN_STRING,USERNAME,PASSWORD);
			return true;
			case MYSQL: conn = DriverManager.getConnection(M_CONN_STRING,USERNAME,PASSWORD);
			return true;
				
			

			default:
				return false;
			}
			
		} catch (SQLException e) {
	           System.out.println(e);
	           return false;
		}
		
	}
	
	public  Connection getConnection()
	{
		if(conn == null)
		{
			
			if(openConnection())
			{
				System.out.println("Connected!!");
				return conn;
			}
		}
		else
		{
			return null;
		}
		return conn;
		
	}
	public void close()
	{
		System.out.println("Closing!");
		try {
			conn.close();
				conn =null;
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}

}