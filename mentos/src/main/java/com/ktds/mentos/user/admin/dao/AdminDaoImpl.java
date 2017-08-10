package com.ktds.mentos.user.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.mentos.user.admin.vo.AdminVO;

public class AdminDaoImpl implements AdminDao {

	@Override
	public AdminVO selectOneAdmin(AdminVO adminVO) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		String oracleUrl = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();
			query.append(" SELECT	ADMIN_ID ");
			query.append(" 			, ADMIN_PWD ");
			query.append(" 			, AUTH_ID ");
			query.append(" FROM		MTS_ADMIN ");
			query.append(" WHERE	ADMIN_ID = ? ");
			query.append(" AND		ADMIN_PWD = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, adminVO.getAdminId());
			stmt.setString(2, adminVO.getAdminPassword());

			rs = stmt.executeQuery();

			AdminVO admin = null;
			if (rs.next()) {
				admin = new AdminVO();
				admin.setAdminId(rs.getString("ADMIN_ID"));
				admin.setAdminPassword(rs.getString("ADMIN_PWD"));
				admin.setAuthId(rs.getString("AUTH_ID"));
			}

			return admin;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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

	@Override
	public int loginAdmin(AdminVO adminVO) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;

		String oracleUrl = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" SELECT	ADMIN_ID       	  ");
			query.append(" 			, ADMIN_PWD        ");
			query.append(" 			, AUTH_ID         ");
			query.append(" FROM		MTS_ADMIN            ");
			query.append(" WHERE	ADMIN_ID = ?   	  ");
			query.append(" AND		ADMIN_PWD = ?   	  ");
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, adminVO.getAdminId());
			stmt.setString(2, adminVO.getAdminPassword());

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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

}
