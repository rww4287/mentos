package com.ktds.mentos.user.mentee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.mentos.user.mentee.vo.MenteeSearchVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class MenteeDaoImpl implements MenteeDao {

	@Override
	public int insertNewMentee(MenteeVO menteeVO) {

		loadDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		String url = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();
			query.append(" INSERT INTO		MENTEE 	(            ");
			query.append(" 							MNTE_ID      ");
			query.append(" 							, MNTE_NM    ");
			query.append(" 							, MNTE_PWD   ");
			query.append(" 							, MNTE_ADDR  ");
			query.append(" 							, PHONE      ");
			query.append(" 							, EMAIL      ");
			query.append(" 							, GNDR       ");
			query.append(" 							, MNTE_BRTH  ");
			query.append(" 							, AUTH_ID    ");
			query.append("							, PNT  	 ");
			query.append(" 						)                ");
			query.append(" VALUES				(            	 ");
			query.append(" 							?            ");
			query.append(" 							, ?          ");
			query.append(" 							, ?          ");
			query.append(" 							, ?          ");
			query.append(" 							, ?          ");
			query.append(" 							, ?          ");
			query.append(" 							, ?          ");
			query.append(" 							, TO_DATE(?, 'YYYY/MM/DD')          ");
			query.append(" 							, 'AT-2017032810-000008' ");
			query.append(" 							, 0	         ");
			query.append(" 						)                ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, menteeVO.getMenteeId());
			stmt.setString(2, menteeVO.getMenteeName());
			stmt.setString(3, menteeVO.getMenteePassword());
			stmt.setString(4, menteeVO.getMenteeAddress());
			stmt.setString(5, menteeVO.getPhone());
			stmt.setString(6, menteeVO.getEmail());
			stmt.setString(7, menteeVO.getGender());
			stmt.setString(8, menteeVO.getMenteeBirthday());

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}
	}

	@Override
	public int selectAllMenteesCount(MenteeSearchVO menteeSearchVO) {

		loadDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" SELECT	COUNT(1) CNT ");
			query.append(" FROM		MENTEE       ");

			stmt = conn.prepareStatement(query.toString());

			rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("CNT");
			}

			return 0;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}
	}

	@Override
	public List<MenteeVO> selectAllMentees(MenteeSearchVO menteeSearchVO) {

		loadDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" SELECT	*                                    ");
			query.append(" FROM	(                                        ");
			query.append(" 			SELECT	ROWNUM RNUM                  ");
			query.append(" 					, A.*                        ");
			query.append(" 			FROM	(                            ");
			query.append(" 						SELECT	MNTE_ID          ");
			query.append(" 								, MNTE_NM        ");
			query.append(" 								, MNTE_PWD       ");
			query.append(" 								, MNTE_ADDR      ");
			query.append(" 								, PHONE          ");
			query.append(" 								, EMAIL          ");
			query.append(" 								, GNDR           ");
			query.append(" 								, TO_CHAR(MNTE_BRTH, 'YYYY-MM-DD') M_MNTE_BRTH ");
			query.append(" 								, AUTH_ID        ");
			query.append(" 								, PNT          ");
			query.append(" 						FROM	MENTEE           ");
			query.append(" 						ORDER 	BY MNTE_ID DESC  ");
			query.append(" 					) A                          ");
			query.append(" 			WHERE	ROWNUM <= ?                  ");
			query.append(" 		)                                        ");
			query.append(" WHERE RNUM >= ?                               ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setInt(1, menteeSearchVO.getPager().getEndArticleNumber());
			stmt.setInt(2, menteeSearchVO.getPager().getStartArticleNumber());

			rs = stmt.executeQuery();

			List<MenteeVO> menteeList = new ArrayList<MenteeVO>();
			MenteeVO menteeVO = null;
			if (rs.next()) {
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

	@Override
	public MenteeVO selectOneMentee(String menteeId) {

		loadDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" SELECT	MNTE_ID       	  ");
			query.append(" 			, MNTE_NM         ");
			query.append(" 			, MNTE_PWD        ");
			query.append(" 			, MNTE_ADDR       ");
			query.append(" 			, PHONE           ");
			query.append(" 			, EMAIL           ");
			query.append(" 			, GNDR            ");
			query.append(" 			, TO_CHAR(MNTE_BRTH, 'YYYY-MM-DD') M_MNTE_BRTH ");
			query.append(" 			, AUTH_ID         ");
			query.append(" 			, PNT           ");
			query.append(" FROM		MENTEE            ");
			query.append(" WHERE	MNTE_ID = ?   	  ");
			stmt = conn.prepareStatement(query.toString());
			
			stmt.setString(1, menteeId);

			rs = stmt.executeQuery();

			MenteeVO menteeVO = null;
			if (rs.next()) {
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
			}
			return menteeVO;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt,null);
		}

	}

	@Override
	public int updateMentee(MenteeVO menteeVO) {

		loadDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		String url = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();
			query.append(" UPDATE MENTEE  ");
			query.append(" SET   ");
			query.append("       MNTE_PWD  =  ? ");
			query.append("       , MNTE_ADDR =  ? ");
			query.append("       , PHONE    = ? ");
			query.append("       , EMAIL    = ? ");
			query.append(" WHERE  MNTE_ID   = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, menteeVO.getMenteePassword());
			stmt.setString(2, menteeVO.getMenteeAddress());
			stmt.setString(3, menteeVO.getPhone());
			stmt.setString(4, menteeVO.getEmail());
			stmt.setString(5, menteeVO.getMenteeId());
			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}

	}
	@Override
	public int loginMentee(MenteeVO menteeVO) {
		
		loadDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		String url = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" SELECT	MNTE_ID       	  ");
			query.append(" 			, MNTE_NM         ");
			query.append(" 			, MNTE_PWD        ");
			query.append(" 			, MNTE_ADDR       ");
			query.append(" 			, PHONE           ");
			query.append(" 			, EMAIL           ");
			query.append(" 			, GNDR            ");
			query.append(" 			, TO_CHAR(MNTE_BRTH, 'YYYY-MM-DD') M_MNTE_BRTH ");
			query.append(" 			, AUTH_ID         ");
			query.append(" 			, PNT           ");
			query.append(" FROM		MENTEE            ");
			query.append(" WHERE	MNTE_ID = ?   	  ");
			query.append(" AND		MNTE_PWD = ?   	  ");
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, menteeVO.getMenteeId());
			stmt.setString(2, menteeVO.getMenteePassword());

	
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt,null);
		}
	}
	@Override
	public int deleteOneMentee(String menteeId) {

		loadDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		String url = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" DELETE               ");
			query.append(" FROM		MENTEE      ");
			query.append(" WHERE	MNTE_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, menteeId);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}
	}

	@Override
	public int updatePointUsedCharge(String menteeId, int point) {
		loadDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		String oracleUrl = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();
			query.append(" UPDATE	MENTEE ");
			query.append(" SET		PNT = PNT + ? ");
			query.append(" WHERE	MNTE_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setInt(1, point);
			stmt.setString(2, menteeId);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}
	}

	@Override
	public int updatePointUsedPayment(String menteeId, int cost) {
		loadDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		String oracleUrl = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

		try {
			conn = DriverManager.getConnection(oracleUrl, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();
			query.append(" UPDATE	MENTEE ");
			query.append(" SET		PNT = PNT + ? ");
			query.append(" WHERE	MNTE_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setInt(1, cost);
			stmt.setString(2, menteeId);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}
	}

	@Override
	public MenteeVO selectOneMentee(MenteeVO menteeVO) {

		loadDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" SELECT	M.MNTE_ID       	     ");
			query.append(" 			, M.MNTE_NM              ");
			query.append(" 			, M.MNTE_PWD             ");
			query.append(" 			, M.MNTE_ADDR            ");
			query.append(" 			, M.PHONE                ");
			query.append(" 			, M.EMAIL                ");
			query.append(" 			, M.GNDR                 ");
			query.append(" 			, M.MNTE_BRTH            ");
			query.append(" 			, M.PNT                  ");
			query.append("			, A.AUTH_ID A_AUTH_ID    ");
			// query.append(" , M.AUTH_ID M_AUTH_ID ");
			query.append(" 			, A.AUTH_NM			     ");
			query.append(" FROM		MENTEE M                 ");
			query.append("			, AUTH A			     ");
			// query.append(" WHERE M.AUTH_ID = A.AUTH_ID(+) ");
			query.append(" WHERE 	M.MNTE_ID = ? 			 ");
			query.append(" AND 		M.MNTE_PWD = ? 			 ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, menteeVO.getMenteeId());
			stmt.setString(2, menteeVO.getMenteePassword());

			rs = stmt.executeQuery();

			// MenteeVO mentee = null;
			if (rs.next()) {
				menteeVO = new MenteeVO();
				menteeVO.setMenteeId(rs.getString("MNTE_ID"));
				menteeVO.setMenteeName(rs.getString("MNTE_NM"));
				menteeVO.setMenteePassword(rs.getString("MNTE_PWD"));
				menteeVO.setMenteeAddress(rs.getString("MNTE_ADDR"));
				menteeVO.setPhone(rs.getString("PHONE"));
				menteeVO.setEmail(rs.getString("EMAIL"));
				menteeVO.setGender(rs.getString("GNDR"));
				menteeVO.setMenteeBirthday(rs.getString("MNTE_BRTH"));
				menteeVO.setPoint(rs.getInt("PNT"));
				menteeVO.getAuthVO().setAuthId(rs.getString("A_AUTH_ID"));
				menteeVO.getAuthVO().setAuthName(rs.getString("AUTH_NM"));
			}
			return menteeVO;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}
	}

	@Override
	public int selectCountByMentoId(String menteeId) {

		loadDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" SELECT	COUNT(1) CNT   	");
			query.append(" FROM		MENTEE           ");
			query.append(" WHERE	MNTE_ID = ?  	");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, menteeId);

			rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("CNT");
			} else {
				return 0;
			}
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
