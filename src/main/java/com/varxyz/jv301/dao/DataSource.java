package com.varxyz.jv301.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSource {
	private String jdbcDriver;
	private String jdbcURL;
	private String jdbcUserName;
	private String jdbcPassword;
	
	public DataSource(String driver, String url, String userName, String password) 
									throws ClassNotFoundException, SQLException {
		super();
		this.jdbcDriver = driver;
		this.jdbcURL = url;
		this.jdbcUserName = userName;
		this.jdbcPassword = password;
		
		loadDriver();
		System.out.println("[Jdbc Driver loaded for jv301.DataSource]");
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(con == null) {
			throw new RuntimeException("ConnNotAvailException");
		}
		return con;
	}
	
	
	/**
	 * 
	 * @param rs
	 * @param pstmt
	 * @param con
	 * @throws SQLException
	 */
	public void close(ResultSet rs, PreparedStatement pstmt, Connection con) 
														throws SQLException {
		if(rs != null && !rs.isClosed()) {
			rs.close();
		}
		if(pstmt != null && !pstmt.isClosed()) {
			pstmt.close();
		}
		if(con != null && !con.isClosed()) {
			con.close();
		}
	}
	
	/**
	 * 
	 * @param pstmt
	 * @param con
	 * @throws SQLException
	 */
	public void close(PreparedStatement pstmt, Connection con) throws SQLException {
		close(null, pstmt, con);
	}
	
	
	
	
	
	//---------------------------
	//		private method
	//---------------------------
	
	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void loadDriver() throws ClassNotFoundException, SQLException {
		Class.forName(jdbcDriver);
	}
	

	public String getJdbcDriver() {
		return jdbcDriver;
	}


	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}


	public String getJdbcURL() {
		return jdbcURL;
	}


	public void setJdbcURL(String jdbcURL) {
		this.jdbcURL = jdbcURL;
	}


	public String getJdbcUserName() {
		return jdbcUserName;
	}


	public void setJdbcUserName(String jdbcUserName) {
		this.jdbcUserName = jdbcUserName;
	}


	public String getJdbcPassword() {
		return jdbcPassword;
	}


	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}
}
