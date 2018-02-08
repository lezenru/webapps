package com.cos.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class DBManager {
	//DB연결 실제로 하는 곳
	public static Connection getConnection() throws NamingException, SQLException {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("close 오류");
		}
	}
	
	public static void close(Connection conn, PreparedStatement ps) {
		try {
			conn.close();
			ps.close();
		} catch (Exception e) {
			System.out.println("close 오류");
		}
	}
}
