package com.ktds.mentos.category.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.mentos.category.vo.CategoryVO;

public class CategoryDaoImpl implements CategoryDao {

	private String oracleUrl = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

	@Override
	public List<CategoryVO> getAllCategoryList() {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();
			query.append(" SELECT	CTGRY_ID ");
			query.append(" 			, CTGRY_NM ");
			query.append(" FROM		CTGRY ");

			stmt = conn.prepareStatement(query.toString());
			rs = stmt.executeQuery();

			List<CategoryVO> categoryList = new ArrayList<CategoryVO>();
			CategoryVO categoryVO = null;

			while (rs.next()) {
				categoryVO = new CategoryVO();
				categoryVO.setCategoryId(rs.getString("CTGRY_ID"));
				categoryVO.setCategoryName(rs.getString("CTGRY_NM"));
				categoryList.add(categoryVO);
			}
			return categoryList;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}
	}

	@Override
	public CategoryVO getOneCategory(String categoryId) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();
			query.append(" SELECT	CTGRY_ID ");
			query.append(" 			, CTGRY_NM ");
			query.append(" FROM		CTGRY ");
			query.append(" WHERE	CTGRY_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			rs = stmt.executeQuery();

			CategoryVO categoryVO = new CategoryVO();
			if (rs.next()) {
				categoryVO.setCategoryId(rs.getString("CTGRY_ID"));
				categoryVO.setCategoryName(rs.getString("CTGRY_NM"));
			}
			return categoryVO;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}
	}

	@Override
	public String generateNewCategoryId() {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();
			query.append(" SELECT  'CT-' || ");
			query.append("			TO_CHAR(SYSDATE, 'YYYYMMDDHH24') ||	");
			query.append("			'-' || ");
			query.append("			 LPAD(CTGRY_ID_SEQ.NEXTVAL, 6, '0') SEQ ");
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
	public int insertNewCategory(CategoryVO categoryVO) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" INSERT	INTO	CTGRY ( ");
			query.append(" 							CTGRY_ID ");
			query.append(" 							, CTGRY_NM ");
			query.append(" 						  ) ");
			query.append(" VALUES				  ( ");
			query.append(" 							? ");
			query.append(" 							, ? ");
			query.append(" 							, ? ");
			query.append(" 						  ) ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, categoryVO.getCategoryId());
			stmt.setString(2, categoryVO.getCategoryName());

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}
	}

	@Override
	public int modifyCategoryInfo(CategoryVO categoryVO) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" UPDATE	CTGRY ");
			query.append(" SET		CTGRY_NM = ? ");
			query.append(" WHERE	CTGRY_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, categoryVO.getCategoryName());
			stmt.setString(2, categoryVO.getCategoryId());

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}
	}

	@Override
	public int deleteCategory(String categoryId) {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" DELETE	FROM	CTGRY ");
			query.append(" WHERE	CTGRY_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, categoryId);

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
