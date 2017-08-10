package com.ktds.mentos.admin.review.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.mentos.review.dao.ReviewDaoImpl;
import com.ktds.mentos.review.vo.ReviewSearchVO;
import com.ktds.mentos.review.vo.ReviewVO;

public class AdminReviewDaoImpl extends ReviewDaoImpl implements AdminReviewDao {

	private String oracleUrl = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

	@Override
	public List<ReviewVO> selectAllReviewsForAdmin(ReviewSearchVO reviewSearchVO) {

		loadDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT  * ");
			query.append(" FROM    ( ");
			query.append("             SELECT  ROWNUM AS RNUM ");
			query.append("                     , A.* ");
			query.append("             FROM    ( ");
			query.append("						SELECT		REW_ID	");
			query.append("									,REW_TL	");
			query.append("									,REW_CNTET	");
			query.append("									,RTNG	");
			query.append("									,MNT_NM	");
			query.append("									,TO_CHAR(SYSDATE, 'YYYY-MM-DD') WR_DT ");
			query.append("									,MNTE_ID");
			query.append("									,MNT_ID");
			query.append("						FROM		REVIEW	");
			query.append("						ORDER		BY	REW_ID ASC, RTNG	ASC	");
			query.append("                     ) A ");
			query.append("             WHERE     ROWNUM <= ? ");
			query.append("         ) ");
			query.append(" WHERE   RNUM >= ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setInt(1, reviewSearchVO.getPager().getEndArticleNumber());
			stmt.setInt(2, reviewSearchVO.getPager().getStartArticleNumber());

			rs = stmt.executeQuery();

			ReviewVO reviewVO = null;
			List<ReviewVO> reviewList = new ArrayList<ReviewVO>();
			while (rs.next()) {
				reviewVO = new ReviewVO();
				reviewVO.setReviewId(rs.getString("REW_ID"));
				reviewVO.setReviewTitle(rs.getString("REW_TL"));
				reviewVO.setReviewContent(rs.getString("REW_CNTET"));
				reviewVO.setReviewRating(rs.getString("RTNG"));
				reviewVO.setMentoName(rs.getString("MNT_NM"));
				reviewVO.setMenteeId(rs.getString("MNTE_ID"));
				reviewVO.setMentoId(rs.getString("MNT_ID"));
				reviewVO.setReviewWriteDate(rs.getString("WR_DT"));
				reviewList.add(reviewVO);
			}

			return reviewList;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}

	}

	@Override
	public int insertNewReviewForAdmin(ReviewVO reviewVO) {
		loadDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.201.17:1521:XE", "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();
			query.append("	INSERT INTO	REVIEW	");
			query.append("						(	");
			query.append("							REW_ID ");
			query.append("							,REW_TL ");
			query.append("							,REW_CNTET	");
			query.append("							,RTNG	");
			query.append("							,WRT_DT	");
			query.append("							,MNTE_ID");
			query.append("						)	");
			query.append("	VALUES				(	");
			query.append("							?	");
			query.append("							,?	");
			query.append("							,?	");
			query.append("							,-1	");
			query.append("							,TO_DATE(SYSDATE, 'YYYY-MM-DD') WR_DT ");
			query.append("							,?	");
			query.append("						)	");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, reviewVO.getReviewId());
			stmt.setString(2, reviewVO.getReviewTitle());
			stmt.setString(3, reviewVO.getReviewContent());
			stmt.setString(4, "admin");

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}
	}
	
	@Override
	public String generateNoticeId() {
		loadDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();
			query.append(" SELECT  'NO-' || ");
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

	private void loadDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	private void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}



}
