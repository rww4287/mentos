package com.ktds.mentos.admin.authorization.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.mentos.admin.authorization.vo.AuthVO;

public class AdminAuthDaoImpl implements AdminAuthDao {

	private String oracleUrl = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

	@Override
	public String generateNewAuthId() {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();
			query.append(" SELECT  'AT-' || ");
			query.append("			TO_CHAR(SYSDATE, 'YYYYMMDDHH24') ||	");
			query.append("			'-' || ");
			query.append("			 LPAD(AUTH_ID_SEQ.NEXTVAL, 6, '0') SEQ ");
			query.append(" FROM		DUAL ");

			stmt = conn.prepareStatement(query.toString());
			rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getString("SEQ");
			}

			return null;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}
	}

	@Override
	public int insertNewAuth(AuthVO authVO) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" INSERT	INTO	AUTH ( ");
			query.append(" 							AUTH_ID ");
			query.append(" 							, AUTH_NM ");
			query.append(" 						  ) ");
			query.append(" VALUES				  ( ");
			query.append(" 							? ");
			query.append(" 							, ? ");
			query.append(" 						  ) ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, authVO.getAuthId());
			stmt.setString(2, authVO.getAuthName());

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}
	}

	@Override
	public List<AuthVO> getAllAuthList(AuthVO authVO) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();
			query.append(" SELECT	AUTH_ID ");
			query.append(" 			, AUTH_NM ");
			query.append(" FROM		AUTH ");

			stmt = conn.prepareStatement(query.toString());
			rs = stmt.executeQuery();

			List<AuthVO> authList = new ArrayList<AuthVO>();
			while (rs.next()) {
				authVO.setAuthId(rs.getString("AUTH_ID"));
				authVO.setAuthName(rs.getString("AUTH_NM"));
				authList.add(authVO);
			}
			return authList;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
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
