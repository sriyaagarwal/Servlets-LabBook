package com.cg.iter.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getCon() throws SQLException{
		Connection con=null; 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Sriyaagarwal09");
				return con;
		}
	}

