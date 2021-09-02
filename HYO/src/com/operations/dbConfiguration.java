package com.operations;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hyo.AppConfiguration;

public class dbConfiguration {
	
	public static ResultSet excuteSelectStatement(String sql) {
		ResultSet data = null;
		Connection con = null;
		try {
			con = getJDBCConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			data = ps.executeQuery();
		    
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	    return data;
	}
	
	public static int excuteUpdateStatement(String sql) {
		int data = -1;
		Connection con = null;
		try {
			con = getJDBCConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			data = ps.executeUpdate();
		    con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	    return data;
	}
	
	public static int excuteDeleteStatement(String sql) {
		int data = -1;
		Connection con = null;
		try {
			con = getJDBCConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			data = ps.executeUpdate();
		    con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	    return data;
	}
	
	public static int excuteAddStatement(String sql) {
		int data = -1;
		Connection con = null;
		try {
			con = getJDBCConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			data = ps.executeUpdate();
		    con.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	    return data;
	}
	
	public static Connection getJDBCConnection() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection con = DriverManager.getConnection(AppConfiguration.dbUrl,AppConfiguration.dbUser,AppConfiguration.dbPassword); 
		return con;
	}

    
}

