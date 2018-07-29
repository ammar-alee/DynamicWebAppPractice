/**
 * 
 */
package com.apex.advance.java.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.apex.advance.java.vo.ValueObj;

public class DbManager {
	private static Connection conn = ConnectionManager.getInstance().getConnection();

	public static void createTable() throws Exception {
		try {
			String sql = "CREATE TABLE IF NOT EXISTS register(id int(11) NOT NULL AUTO_INCREMENT, firstName varchar(25), middleName varchar(25), lastName varchar(25), gender varchar(6), address varchar(50), city varchar(25), state varchar(25), country varchar(25), phone varchar(25), bankName varchar(25), accountNumber varchar(25), ssn varchar(25), PRIMARY KEY(id))";
			PreparedStatement create = conn.prepareStatement(sql);
			create.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table Created Succussfully...");
		}
	}

	public static void insertRecord(ValueObj register) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		String sql = "INSERT INTO register (firstName,middleName,lastName,gender,address,city,state,country,phone,bankName,accountNumber,ssn) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, register.getFirstName());
		pstmt.setString(2, register.getMiddleName());
		pstmt.setString(3, register.getLastName());
		pstmt.setString(4, register.getGender());
		pstmt.setString(5, register.getAddress());
		pstmt.setString(6, register.getCity());
		pstmt.setString(7, register.getState());
		pstmt.setString(8, register.getCountry());
		pstmt.setString(9, register.getPhone());
		pstmt.setString(10, register.getBankName());
		pstmt.setString(11, register.getAccountNumber());
		pstmt.setString(12, register.getSsn());

		pstmt.executeUpdate();
	}

	public static void checkUser() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");

		String sql = "SELECT * FROM register";
		PreparedStatement checkUser = conn.prepareStatement(sql);
		ResultSet rs = checkUser.executeQuery();
		while (rs.next()) {
			System.out.print(" " + rs.getString(1));
			System.out.print(" " + rs.getString(2));
			System.out.print(" " + rs.getString(3));
			System.out.print(" " + rs.getString(4));
			System.out.print(" " + rs.getString(5));
			System.out.print(" " + rs.getString(6));
			System.out.print(" " + rs.getString(7));
			System.out.print(" " + rs.getString(8));
			System.out.print(" " + rs.getString(9));
			System.out.print(" " + rs.getString(10));
			System.out.print(" " + rs.getString(11));
			System.out.println(" " + rs.getString(12));

		}

		ConnectionManager.getInstance().close();

	}
}