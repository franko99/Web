package com.franko.rest.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/bookstore";
	static final String USER = "root";
	static final String PASS = "admin";
	private static Connection conn;

	private static Connection getConnection() {
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void create(String name, float wholeSalePrice, String brand) {
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO product(name, wholeSalePrice, brand, salePrice) VALUES(?,?,?,?)";
		float salePrice = wholeSalePrice * 2;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setFloat(2, wholeSalePrice);
			pstmt.setString(3, brand);
			pstmt.setFloat(4, salePrice);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void read() {
		Statement stmt = null;

		try {
			Class.forName(JDBC_DRIVER);
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT product_id, name FROM product";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("product_id");
				String name = rs.getString("name");

				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public static void variableRead(String inName) {
		PreparedStatement pStmt = null;

		try {
			Class.forName(JDBC_DRIVER);
			conn = getConnection();
			String sql = "SELECT product_id, name FROM product where name = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, inName);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("product_id");
				String outName = rs.getString("name");

				System.out.println("ID: " + id);
				System.out.println("Name: " + outName);
			}

			rs.close();
			pStmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pStmt != null) {
					pStmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public static void update(String inName) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE product SET name = ? WHERE name = ?";
		String outName = "Conditioner";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, outName);
			pstmt.setString(2, inName);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void delete(String name) {
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM product WHERE name = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}