package com.lynda.javatraining.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager

{
	private static ConnectionManager instance = null;
	private static String USERNAME = "dbuser";
	private static String PASSWORD = "dbpassword";
	private static String H_CONN_STRING = "jdbc:hsqldb:data/explorecalifornia";
	private static String M_CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";
	
	private Connection conn = null;
	private ConnectionManager()
	{};
	public static ConnectionManager getInstance()
	{
		if(instance == null)
		{
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	private DBType dbType = DBType.MYSQL;
	public void setDBType(DBType dbType)
	{
		this.dbType = dbType;
	}
	
	private boolean OpenConnection()
	{
		try {
			switch (dbType) {
			case HSQLDB:conn = DriverManager.getConnection(H_CONN_STRING,USERNAME,PASSWORD);
				
			return true;
			case MYSQL: conn = DriverManager.getConnection(M_CONN_STRING,USERNAME,PASSWORD);
			return true;

			default:
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public Connection getConnection()
	{
		if(conn == null)
		{
			if(OpenConnection())
			{
				return conn;
			}
		}
		else
		{
			return null;
		}
		return conn;
		
	}
	public void  close() throws SQLException
	{
		try {
			if(conn!=null)conn.close();
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
	
//	private static ConnectionManager instance  =null;
//	private static final String USERNAME = "dbuser";
//	private static final String PASSWORD = "dbpassword";
//	private static final String H_CONN_STRING ="jdbc:hsqldb:data/explorecalifornia";
//	private static final String M_CONN_STRING="jdbc:mysql://localhost/explorecalifornia";
//	
//	
//	private Connection conn = null;
//	private DBType dbType = DBType.MYSQL;
//	private ConnectionManager(){};
//	
//	public static ConnectionManager getInstance()
//	{
//		if(instance == null)
//		{
//			instance  = new ConnectionManager();
//		}
//		return  instance;
//		
//		
//	}
//	
//	public void setDBType (DBType dbType)
//	{
//		this.dbType = dbType;
//		
//	}
//	
//	private boolean openConnection()
//	{
//		System.out.println("Connection is opened!");
//		try {
//			switch (dbType) {
//			case HSQLDB: conn = DriverManager.getConnection(H_CONN_STRING,USERNAME,PASSWORD);
//			return true;
//				
//			case MYSQL: conn = DriverManager.getConnection(M_CONN_STRING,USERNAME,PASSWORD);
//			return true;
//
//			default:
//				 return false;
//			}
//		} catch (SQLException e) {
//		System.out.println(e);
//		return false;
//		}
//	
//		
//		
//	}
//	public  Connection getConnection()
//	{
//		if(conn == null)
//		{
//			if(openConnection())
//					{
//				      return conn;
//				
//					}
//				
//		}
//		else
//		{
//			
//			return null;
//		}
//		return conn;
//		
//		
//	}
//	
//	public void close()
//	{
//		System.out.println("Connection is closed!");
//		try {
//			conn.close();
//			conn=null;
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}


}