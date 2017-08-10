package com.ktds.mentos.admin.user.mentee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.mentos.user.mentee.dao.MenteeDaoImpl;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public class AdminMenteeDaoImpl extends MenteeDaoImpl implements AdminMenteeDao {

	private String oracleUrl = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

	@Override
	public List<MenteeVO> getAllMentees() {

		loadOracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();
			query.append(" SELECT	MNTE_ID          ");
			query.append(" 			, MNTE_NM        ");
			query.append("			, MNTE_PWD       ");
			query.append(" 			, MNTE_ADDR      ");
			query.append(" 			, PHONE          ");
			query.append(" 			, EMAIL          ");
			query.append(" 			, GNDR           ");
			query.append(" 			, TO_CHAR(MNTE_BRTH, 'YYYY-MM-DD') M_MNTE_BRTH ");
			query.append(" 			, AUTH_ID        ");
			query.append(" 			, PNT            ");
			query.append(" 	FROM	MENTEE           ");

			stmt = conn.prepareStatement(query.toString());
			rs = stmt.executeQuery();

			MenteeVO menteeVO = null;
			List<MenteeVO> menteeList = new ArrayList<MenteeVO>();
			while (rs.next()) {
				menteeVO = new MenteeVO();

				menteeVO.setMenteeId(rs.getString("MNTE_ID"));
				menteeVO.setMenteeName(rs.getString("MNTE_NM"));
				menteeVO.setMenteePassword(rs.getString("MNTE_PWD"));
				menteeVO.setMenteeAddress(rs.getString("MNTE_ADDR"));
				menteeVO.setPhone(rs.getString("PHONE"));
				menteeVO.setEmail(rs.getString("EMAIL"));
				menteeVO.setGender(rs.getString("GNDR"));
				menteeVO.setMenteeBirthday(rs.getString("M_MNTE_BRTH"));
				menteeVO.getAuthVO().setAuthId(rs.getString("AUTH_ID"));
				menteeVO.setPoint(rs.getInt("PNT"));
				
				menteeList.add(menteeVO);
			}
			return menteeList;

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
