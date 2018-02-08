package com.conv.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtil {
	public static void close(PreparedStatement stmt) {
		close(stmt, null);
	}
	public static void close(PreparedStatement stmt, Connection con) {
		if(stmt!=null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
	if(con!=null) {
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	}
}
