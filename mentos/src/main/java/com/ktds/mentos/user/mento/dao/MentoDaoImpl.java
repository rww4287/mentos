package com.ktds.mentos.user.mento.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.ktds.mentos.user.mento.vo.MentoSearchVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class MentoDaoImpl implements MentoDao {
	private String url = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

	@Override
	public int insertMento(MentoVO mentoVO) {

		oracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();

			query.append(" INSERT INTO MENTO	(  ");
			query.append("						MNT_ID ");
			query.append("						, MNT_PWD ");
			query.append("						, MNT_NM ");
			query.append("						, MNT_BRTH  ");
			query.append("						, MNT_ADDR  ");
			query.append("						, PHONE  ");
			query.append("						, EMAIL  ");
			query.append("						, CLMBR  ");
			query.append("						, STR_DT  ");
			query.append("						, GNDR  ");
			query.append("						, AUTH_ID  ");
			query.append("						, CTGRY_ID  ");
			query.append("						, CMNT  ");
			query.append("						, PNT ");
			query.append("						, COST ");
			query.append("						, ETC ");
			query.append(" 						) ");
			query.append(" VALUES				( ");
			query.append("						? ");
			query.append("						, ? ");
			query.append("						, ? ");
			query.append("						, ? ");
			query.append("						, ? ");
			query.append("						, ? ");
			query.append("						, ? ");
			query.append("						, ? ");
			query.append("						, ? ");
			query.append("						, ? ");
			query.append("						, 'AT-2017032810-000007' ");
			query.append("						, ? ");
			query.append("						, ? ");
			query.append("						, 0 ");
			query.append("						, ? ");
			query.append("						, ? ");
			query.append("						) ");

			stmt = conn.prepareStatement(query.toString());

			stmt.setString(1, mentoVO.getMentoId());
			stmt.setString(2, mentoVO.getMentoPassword());
			stmt.setString(3, mentoVO.getMentoName());
			stmt.setString(4, mentoVO.getMentoBirth());
			stmt.setString(5, mentoVO.getMentoAddress());
			stmt.setString(6, mentoVO.getPhone());
			stmt.setString(7, mentoVO.getEmail());
			stmt.setInt(8, mentoVO.getMember());
			stmt.setString(9, mentoVO.getStartDate());
			stmt.setString(10, mentoVO.getGender());
			stmt.setString(11, mentoVO.getCategoryVO().getCategoryId());
			stmt.setString(12, mentoVO.getComment());
			stmt.setInt(13, mentoVO.getCost());
			stmt.setString(14, mentoVO.getEtc());

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}
	}

	@Override
	public MentoVO selectOneMento(String mentoId) {
		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	M.MNT_ID ");
			query.append("			, M.MNT_PWD ");
			query.append("			, M.MNT_NM ");
			query.append("			, M.MNT_BRTH  ");
			query.append("			, M.MNT_ADDR  ");
			query.append("			, M.PHONE  ");
			query.append("			, M.EMAIL  ");
			query.append("			, M.CLMBR  ");
			query.append("			, TO_CHAR(M.STR_DT, 'YYYY-MM-DD') M_STR_DT ");
			query.append("			, M.GNDR  ");
			query.append("			, M.AUTH_ID  ");
			query.append("			, M.CTGRY_ID  ");
			query.append("			, M.CMNT  ");
			query.append("			, M.PNT ");
			query.append("			, M.COST ");
			query.append("			, M.ETC ");
			query.append("			, A.AUTH_NM  A_AUTH_NM ");
			query.append("			, C.CTGRY_NM C_CTGRY_NM  ");
			query.append(" FROM		MENTO M ");
			query.append(" 			, AUTH A");
			query.append(" 			, CTGRY C ");
			query.append(" WHERE	M.AUTH_ID = A.AUTH_ID ");
			query.append(" AND		M.CTGRY_ID = C.CTGRY_ID ");
			query.append(" AND		MNT_ID = ? ");

			stmt = conn.prepareStatement(query.toString());

			stmt.setString(1, mentoId);
			rs = stmt.executeQuery();

			MentoVO mentoVO = null;

			if (rs.next()) {
				mentoVO = new MentoVO();

				mentoVO.setMentoId(rs.getString("MNT_ID"));
				mentoVO.setMentoPassword(rs.getString("MNT_PWD"));
				mentoVO.setMentoName(rs.getString("MNT_NM"));
				mentoVO.setMentoBirth(rs.getString("MNT_BRTH"));
				mentoVO.setMentoAddress(rs.getString("MNT_ADDR"));
				mentoVO.setPhone(rs.getString("PHONE"));
				mentoVO.setEmail(rs.getString("EMAIL"));
				mentoVO.setMember(rs.getInt("CLMBR"));
				mentoVO.setStartDate(rs.getString("M_STR_DT"));
				mentoVO.setGender(rs.getString("GNDR"));
				mentoVO.getAuthVO().setAuthId(rs.getString("AUTH_ID"));
				mentoVO.getAuthVO().setAuthName(rs.getString("A_AUTH_NM"));
				mentoVO.setPoint(rs.getInt("PNT"));
				mentoVO.setComment(rs.getString("CMNT"));
				mentoVO.setCost(rs.getInt("COST"));
				mentoVO.setEtc(rs.getString("ETC"));
				mentoVO.getCategoryVO().setCategoryId(rs.getString("CTGRY_ID"));
				mentoVO.getCategoryVO().setCategoryName(rs.getString("C_CTGRY_NM"));
			}
			return mentoVO;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}

	}

	@Override
	public MentoVO selectOneMento(MentoVO mentoVO) {

		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	M.MNT_ID ");
			query.append("			, M.MNT_PWD ");
			query.append("			, M.MNT_NM ");
			query.append("			, M.MNT_BRTH  ");
			query.append("			, M.MNT_ADDR  ");
			query.append("			, M.PHONE  ");
			query.append("			, M.EMAIL  ");
			query.append("			, M.CLMBR  ");
			query.append("			, TO_CHAR(M.STR_DT, 'YYYY-MM-DD') M_STR_DT ");
			query.append("			, M.GNDR  ");
			query.append("			, M.AUTH_ID  ");
			query.append("			, M.CTGRY_ID  ");
			query.append("			, M.CMNT  ");
			query.append("			, M.PNT ");
			query.append("			, M.COST ");
			query.append("			, M.ETC ");
			query.append("			, A.AUTH_NM  A_AUTH_NM ");
			query.append("			, C.CTGRY_NM C_CTGRY_NM  ");
			query.append(" FROM		MENTO M ");
			query.append(" 			, AUTH A");
			query.append(" 			, CTGRY C ");
			query.append(" WHERE	M.AUTH_ID = A.AUTH_ID ");
			query.append(" AND		M.CTGRY_ID = C.CTGRY_ID ");
			query.append(" AND		MNT_ID = ? ");

			stmt = conn.prepareStatement(query.toString());

			stmt.setString(1, mentoVO.getMentoId());
			rs = stmt.executeQuery();

			if (rs.next()) {
				mentoVO = new MentoVO();

				mentoVO.setMentoId(rs.getString("MNT_ID"));
				mentoVO.setMentoPassword(rs.getString("MNT_PWD"));
				mentoVO.setMentoName(rs.getString("MNT_NM"));
				mentoVO.setMentoBirth(rs.getString("MNT_BRTH"));
				mentoVO.setMentoAddress(rs.getString("MNT_ADDR"));
				mentoVO.setPhone(rs.getString("PHONE"));
				mentoVO.setEmail(rs.getString("EMAIL"));
				mentoVO.setMember(rs.getInt("CLMBR"));
				mentoVO.setStartDate(rs.getString("M_STR_DT"));
				mentoVO.setGender(rs.getString("GNDR"));
				mentoVO.getAuthVO().setAuthId(rs.getString("AUTH_ID"));
				mentoVO.getAuthVO().setAuthName(rs.getString("A_AUTH_NM"));
				mentoVO.setPoint(rs.getInt("PNT"));
				mentoVO.setComment(rs.getString("CMNT"));
				mentoVO.setCost(rs.getInt("COST"));
				mentoVO.setEtc(rs.getString("ETC"));
				mentoVO.getCategoryVO().setCategoryId(rs.getString("CTGRY_ID"));
				mentoVO.getCategoryVO().setCategoryName(rs.getString("C_CTGRY_NM"));
			}
			return mentoVO;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}

	}

	@Override
	public List<MentoVO> selectAllMentos(MentoSearchVO mentoSearchVO) {
		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	* ");
			query.append(" FROM		( ");
			query.append("           SELECT ROWNUM RNUM ");
			query.append("                  , RST.* ");
			query.append("           FROM   ( ");
			query.append(" 						SELECT		 ");
			query.append("									M.MNT_ID ");
			query.append("									, M.MNT_PWD ");
			query.append("									, M.MNT_NM ");
			query.append("									, M.MNT_BRTH  ");
			query.append("									, M.MNT_ADDR  ");
			query.append("									, M.PHONE  ");
			query.append("									, M.EMAIL  ");
			query.append("									, M.CLMBR  ");
			query.append("									, TO_CHAR(M.STR_DT, 'YYYY-MM-DD') M_STR_DT  ");
			query.append("									, M.GNDR  ");
			query.append("									, M.AUTH_ID  ");
			query.append("									, M.CTGRY_ID  ");
			query.append("									, M.CMNT  ");
			query.append("									, M.PNT  ");
			query.append("									, M.COST ");
			query.append("									, M.ETC ");
			query.append("									, A.AUTH_NM  A_AUTH_NM ");
			query.append("									, C.CTGRY_NM C_CTGRY_NM  ");
			query.append(" 						FROM		MENTO M ");
			query.append(" 									, AUTH A");
			query.append(" 									, CTGRY C ");
			query.append(" 						WHERE	M.AUTH_ID = A.AUTH_ID ");
			query.append("						AND		M.CTGRY_ID = C.CTGRY_ID ");
			query.append("						ORDER      BY M.MNT_ID ");
			query.append("                 				   ) RST ");
			query.append("                 	   WHERE ROWNUM <= ?  ");
			query.append("       	    )  ");
			query.append(" WHERE				RNUM >= ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setInt(1, mentoSearchVO.getPager().getEndArticleNumber());
			stmt.setInt(2, mentoSearchVO.getPager().getStartArticleNumber());
			rs = stmt.executeQuery();

			MentoVO mentoVO = null;
			List<MentoVO> mentoList = new ArrayList<MentoVO>();

			while (rs.next()) {
				mentoVO = new MentoVO();

				mentoVO.setMentoId(rs.getString("MNT_ID"));
				mentoVO.setMentoPassword(rs.getString("MNT_PWD"));
				mentoVO.setMentoName(rs.getString("MNT_NM"));
				mentoVO.setMentoBirth(rs.getString("MNT_BRTH"));
				mentoVO.setMentoAddress(rs.getString("MNT_ADDR"));
				mentoVO.setPhone(rs.getString("PHONE"));
				mentoVO.setEmail(rs.getString("EMAIL"));
				mentoVO.setMember(rs.getInt("CLMBR"));
				mentoVO.setStartDate(rs.getString("M_STR_DT"));
				mentoVO.setGender(rs.getString("GNDR"));
				mentoVO.getAuthVO().setAuthId(rs.getString("AUTH_ID"));
				mentoVO.getAuthVO().setAuthName(rs.getString("A_AUTH_NM"));
				mentoVO.setComment(rs.getString("CMNT"));
				mentoVO.setPoint(rs.getInt("PNT"));
				mentoVO.setCost(rs.getInt("COST"));
				mentoVO.setEtc(rs.getString("ETC"));
				mentoVO.getCategoryVO().setCategoryId(rs.getString("CTGRY_ID"));
				mentoVO.getCategoryVO().setCategoryName(rs.getString("C_CTGRY_NM"));

				mentoList.add(mentoVO);
			}
			return mentoList;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}

	}

	@Override
	public int updateMento(MentoVO mentoVO) {

		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();
			query.append(" UPDATE MENTO  ");
			query.append(" SET   ");
			query.append("       MNT_PWD  =  ? ");
			query.append("       , MNT_ADDR =  ? ");
			query.append("       , PHONE    = ? ");
			query.append("       , EMAIL    = ? ");
			query.append("       , CLMBR    = ? ");
			query.append("       , STR_DT  = ? ");
			query.append("       , CTGRY_ID = ? ");
			query.append("       , CMNT     = ? ");
			query.append("       , COST     = ? ");
			query.append("       , ETC     = ? ");
			query.append(" WHERE  MNT_ID   = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, mentoVO.getMentoPassword());
			stmt.setString(2, mentoVO.getMentoAddress());
			stmt.setString(3, mentoVO.getPhone());
			stmt.setString(4, mentoVO.getEmail());
			stmt.setInt(5, mentoVO.getMember());
			stmt.setString(6, mentoVO.getStartDate());
			stmt.setString(7, mentoVO.getCategoryVO().getCategoryId());
			stmt.setString(8, mentoVO.getComment());
			stmt.setInt(9, mentoVO.getCost());
			stmt.setString(10, mentoVO.getEtc());
			stmt.setString(11, mentoVO.getMentoId());

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}

	}

	@Override
	public int selectCountByMentoId(String mentoId) {

		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();

			query.append(" SELECT	COUNT(1) CNT   	");
			query.append(" FROM		MENTO           ");
			query.append(" WHERE	MNT_ID = ?  	");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, mentoId);

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

	@Override
	public List<MentoVO> selectMentosByCategoryId(String categoryId) {
		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	 ");
			query.append("			M.MNT_ID ");
			query.append("			, M.MNT_PWD ");
			query.append("			, M.MNT_NM ");
			query.append("			, M.MNT_BRTH  ");
			query.append("			, M.MNT_ADDR  ");
			query.append("			, M.PHONE  ");
			query.append("			, M.EMAIL  ");
			query.append("			, M.CLMBR  ");
			query.append("			, TO_CHAR(M.STR_DT, 'YYYY-MM-DD') M_STR_DT  ");
			query.append("			, M.GNDR  ");
			query.append("			, M.AUTH_ID  ");
			query.append("			, M.CTGRY_ID  ");
			query.append("			, M.CMNT  ");
			query.append("			, M.PNT  ");
			query.append("			, M.COST ");
			query.append("			, M.ETC ");
			query.append("			, A.AUTH_NM  A_AUTH_NM ");
			query.append("			, C.CTGRY_NM C_CTGRY_NM  ");
			query.append(" FROM		MENTO M ");
			query.append(" 			, AUTH A");
			query.append(" 			, CTGRY C ");
			query.append(" WHERE	M.AUTH_ID = A.AUTH_ID ");
			query.append(" AND		M.CTGRY_ID = C.CTGRY_ID ");
			query.append(" AND		M.CTGRY_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, categoryId);
			rs = stmt.executeQuery();

			MentoVO mentoVO = null;
			List<MentoVO> mentoList = new ArrayList<MentoVO>();

			while (rs.next()) {
				mentoVO = new MentoVO();

				mentoVO.setMentoId(rs.getString("MNT_ID"));
				mentoVO.setMentoPassword(rs.getString("MNT_PWD"));
				mentoVO.setMentoName(rs.getString("MNT_NM"));
				mentoVO.setMentoBirth(rs.getString("MNT_BRTH"));
				mentoVO.setMentoAddress(rs.getString("MNT_ADDR"));
				mentoVO.setPhone(rs.getString("PHONE"));
				mentoVO.setEmail(rs.getString("EMAIL"));
				mentoVO.setMember(rs.getInt("CLMBR"));
				mentoVO.setStartDate(rs.getString("M_STR_DT"));
				mentoVO.setGender(rs.getString("GNDR"));
				mentoVO.getAuthVO().setAuthId(rs.getString("AUTH_ID"));
				mentoVO.getAuthVO().setAuthName(rs.getString("A_AUTH_NM"));
				mentoVO.setComment(rs.getString("CMNT"));
				mentoVO.setPoint(rs.getInt("PNT"));
				mentoVO.setCost(rs.getInt("COST"));
				mentoVO.setEtc(rs.getString("ETC"));
				mentoVO.getCategoryVO().setCategoryId(rs.getString("CTGRY_ID"));
				mentoVO.getCategoryVO().setCategoryName(rs.getString("C_CTGRY_NM"));

				mentoList.add(mentoVO);
			}
			return mentoList;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}

	}

	@Override
	public int loginMento(MentoVO mentoVO) {
		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	M.MNT_ID ");
			query.append("			, M.MNT_PWD ");
			query.append("			, M.MNT_NM ");
			query.append("			, M.MNT_BRTH  ");
			query.append("			, M.MNT_ADDR  ");
			query.append("			, M.PHONE  ");
			query.append("			, M.EMAIL  ");
			query.append("			, M.CLMBR  ");
			query.append("			, TO_CHAR(M.STR_DT, 'YYYY-MM-DD') M_STR_DT ");
			query.append("			, M.GNDR  ");
			query.append("			, M.AUTH_ID  ");
			query.append("			, M.CTGRY_ID  ");
			query.append("			, M.CMNT  ");
			query.append("			, M.PNT ");
			query.append("			, M.COST ");
			query.append("			, M.ETC ");
			query.append("			, A.AUTH_NM  A_AUTH_NM ");
			query.append("			, C.CTGRY_NM C_CTGRY_NM  ");
			query.append(" FROM		MENTO M ");
			query.append(" 			, AUTH A");
			query.append(" 			, CTGRY C ");
			query.append(" WHERE	M.AUTH_ID = A.AUTH_ID ");
			query.append(" AND		M.CTGRY_ID = C.CTGRY_ID ");
			query.append(" AND		M.MNT_ID = ? ");
			query.append(" AND		M.MNT_PWD = ? ");

			stmt = conn.prepareStatement(query.toString());

			stmt.setString(1, mentoVO.getMentoId());
			stmt.setString(2, mentoVO.getMentoPassword());

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}
	}

	@Override
	public int updatePoint(String mentoId) {

		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();
			query.append(" UPDATE MENTO  ");
			query.append(" SET   PNT = PNT + COST");
			query.append(" WHERE  MNT_ID   = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, mentoId);

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}

	}

	@Override
	public int selectAllMentoCount(MentoSearchVO mentoSearchVO) {
		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@192.168.201.17:1521:XE";

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" SELECT	COUNT(1) CNT ");
			query.append(" FROM		MENTO       ");

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

	public void oracleDriver() {
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
		} catch (SQLException e1) {
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

	/**
	 * 윤민: review 게시판을 위한 메서드
	 */
	@Override
	public List<MentoVO> selectAllMentees() {
		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	 ");
			query.append("			M.MNT_ID ");
			query.append("			, M.MNT_PWD ");
			query.append("			, M.MNT_NM ");
			query.append("			, M.MNT_BRTH  ");
			query.append("			, M.MNT_ADDR  ");
			query.append("			, M.PHONE  ");
			query.append("			, M.EMAIL  ");
			query.append("			, M.CLMBR  ");
			query.append("			, TO_CHAR(M.STR_DT, 'YYYY-MM-DD') M_STR_DT  ");
			query.append("			, M.GNDR  ");
			query.append("			, M.AUTH_ID  ");
			query.append("			, M.CTGRY_ID  ");
			query.append("			, M.CMNT  ");
			query.append("			, M.PNT  ");
			query.append("			, M.COST ");
			query.append("			, M.ETC ");
			query.append("			, A.AUTH_NM  A_AUTH_NM ");
			query.append("			, C.CTGRY_NM C_CTGRY_NM  ");
			query.append(" FROM		MENTO M ");
			query.append(" 			, AUTH A");
			query.append(" 			, CTGRY C ");
			query.append(" WHERE	M.AUTH_ID = A.AUTH_ID ");
			query.append(" AND		M.CTGRY_ID = C.CTGRY_ID ");

			stmt = conn.prepareStatement(query.toString());

			rs = stmt.executeQuery();

			MentoVO mentoVO = null;
			List<MentoVO> mentoList = new ArrayList<MentoVO>();

			while (rs.next()) {
				mentoVO = new MentoVO();

				mentoVO.setMentoId(rs.getString("MNT_ID"));
				mentoVO.setMentoPassword(rs.getString("MNT_PWD"));
				mentoVO.setMentoName(rs.getString("MNT_NM"));
				mentoVO.setMentoBirth(rs.getString("MNT_BRTH"));
				mentoVO.setMentoAddress(rs.getString("MNT_ADDR"));
				mentoVO.setPhone(rs.getString("PHONE"));
				mentoVO.setEmail(rs.getString("EMAIL"));
				mentoVO.setMember(rs.getInt("CLMBR"));
				mentoVO.setStartDate(rs.getString("M_STR_DT"));
				mentoVO.setGender(rs.getString("GNDR"));
				mentoVO.getAuthVO().setAuthId(rs.getString("AUTH_ID"));
				mentoVO.getAuthVO().setAuthName(rs.getString("A_AUTH_NM"));
				mentoVO.setComment(rs.getString("CMNT"));
				mentoVO.setPoint(rs.getInt("PNT"));
				mentoVO.setCost(rs.getInt("COST"));
				mentoVO.setEtc(rs.getString("ETC"));
				mentoVO.getCategoryVO().setCategoryId(rs.getString("CTGRY_ID"));
				mentoVO.getCategoryVO().setCategoryName(rs.getString("C_CTGRY_NM"));

				mentoList.add(mentoVO);
			}
			return mentoList;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}
	}

	@Override
	public int selectMentoCount() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.201.17:1521:XE", "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();
			query.append("	SELECT	COUNT(1) CNT	");
			query.append("	FROM	MENTO	");

			stmt = conn.prepareStatement(query.toString());

			rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt("CNT");
			}

			return 0;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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

}
