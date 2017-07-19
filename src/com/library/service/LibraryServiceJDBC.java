package com.library.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibraryServiceJDBC {

	Connection conn;

	public LibraryServiceJDBC() {
		try {
			Class.forName("org.sqlite.JDBC");
			String dbURL = "jdbc:sqlite:C:\\Vani\\db\\sqlite\\library.db";
			conn = DriverManager.getConnection(dbURL);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public ResultSet getResult(String queryString) {
		ResultSet rs = null;
		try {
			if (conn != null) {
				Statement stmt = conn.createStatement();
				System.out.println(" the quesry:::>" + queryString);
				rs = stmt.executeQuery(queryString);
				while (rs.next()) {
					System.out.println("The Employee Id : " + rs.getInt(1));
					System.out.println("The Name : " + rs.getString(2));
					System.out.println("The Salary: " + rs.getInt(3));
				}
				conn.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return rs;
	}

	public void insertData(String queryString) {

		try {
			if (conn != null) {
				Statement stmt = conn.createStatement();
				System.out.println(" the quesry:::>" + queryString);
				stmt.executeUpdate(queryString);
				conn.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	/*
	 * public static void main(String args[]){ LibraryServiceJDBC
	 * libraryServiceJdbc = new LibraryServiceJDBC(); String name = "neha";
	 * //String queryString =
	 * "SELECT * FROM EMPLOYEE where emp_Name ="+"'"+name+"';"; String
	 * queryString = "SELECT * FROM EMPLOYEE WHERE emp_Name LIKE '%ne%'";
	 * libraryServiceJdbc.getResult(queryString); }
	 */
}
