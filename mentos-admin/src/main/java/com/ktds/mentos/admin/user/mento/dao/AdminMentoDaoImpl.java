package com.ktds.mentos.admin.user.mento.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.mentos.user.mento.dao.MentoDaoImpl;

public class AdminMentoDaoImpl extends MentoDaoImpl implements AdminMentoDao {

	String oracleUrl = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

	@Override
	public int deleteOneMento(String mentoId) {
		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");
			
			StringBuffer query = new StringBuffer();
			query.append(" DELETE	FROM	MENTO ");
			query.append(" WHERE	MNT_ID = ? ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, mentoId);
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}
	}

	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
		}
	}
}
