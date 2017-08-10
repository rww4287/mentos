package com.ktds.mentos.myClass.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.mentos.myClass.vo.MyClassVO;

public class MyClassDaoImpl implements MyClassDao{
	private String url = "jdbc:oracle:thin:@192.168.201.17:1521:XE";
	
	@Override
	public int insertMyClass(MyClassVO myClassVO) {
		
		oracleDriver();
		Connection conn = null;
		PreparedStatement stmt = null;
	
		try {
			conn = DriverManager.getConnection(url,"MENTOS","mentos");
			StringBuffer query = new StringBuffer();
			
			query.append(" INSERT INTO MYCLASS	(    ");
			query.append(" 						CLS_ID		     ");
			query.append(" 						, STATUS             ");
			query.append(" 						, MNTE_ID		     ");
			query.append(" 						, MNT_ID             ");
            query.append("         				, MNT_NM	         ");
			query.append(" 	) 		                 ");
			query.append(" VALUES				(    ");
			query.append(" 						?    ");
			query.append(" 						, ?  ");
			query.append(" 						, ?  ");
			query.append(" 						, ?  ");
			query.append(" 						, ?  ");
			query.append(" 					)        ");
			
			stmt = conn.prepareStatement(query.toString());
			
			stmt.setString(1, myClassVO.getClassId());
			stmt.setString(2, "요청중");
			stmt.setString(3, myClassVO.getMenteeVO().getMenteeId());
			stmt.setString(4,myClassVO.getMentoVO().getMentoId());
			stmt.setString(5, myClassVO.getMentoVO().getMentoName());
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			close(conn, stmt, null);
		}
	}

	@Override
	public MyClassVO selectOneClass(String classId) {
		
		oracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
			conn = DriverManager.getConnection(url,"MENTOS","mentos");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	CL.CLS_ID ");
			query.append("			, CL.STATUS  ");
			query.append("			, TEE.MNTE_ID ");
			query.append("			, O.MNT_ID  ");
			query.append("			, O.MNT_NM  TO_MNT_NM ");
			query.append(" FROM		MENTO O ");
			query.append(" 			, MENTEE TEE");
			query.append(" 			, MYCLASS CL");
			query.append(" WHERE	O.MNT_ID = CL.MNT_ID " );
			query.append(" AND		TEE.MNTE_ID = CL.MNTE_ID ");
			query.append(" AND		CLS_ID = ? ");
			
			stmt = conn.prepareStatement(query.toString());
			
			stmt.setString(1, classId);
			rs = stmt.executeQuery();
			
			MyClassVO classVO = null;
			
			if (rs.next()){
				classVO = new MyClassVO();
				
				classVO.setClassId(rs.getString("CLS_ID"));
				classVO.setStatus(rs.getString("STATUS"));
				classVO.getMenteeVO().setMenteeId(rs.getString("MNTE_ID"));
				classVO.getMentoVO().setMentoId(rs.getString("MNT_ID"));
				classVO.getMentoVO().setMentoName(rs.getString("TO_MNT_NM"));
				
			}
			return classVO;
		
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			close(conn, stmt, rs);
		}
		
		
	}

	@Override
	public List<MyClassVO> selectAllClass() {
		
		oracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url,"MENTOS","mentos");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	CL.CLS_ID ");
			query.append("			, CL.STATUS  ");
			query.append("			, TEE.MNTE_ID ");
			query.append("			, O.MNT_ID  ");
			query.append("			, O.MNT_NM  TO_MNT_NM ");
			query.append(" FROM		MENTO O ");
			query.append(" 			, MENTEE TEE");
			query.append(" 			, MYCLASS CL");
			query.append(" WHERE	O.MNT_ID = CL.MNT_ID " );
			query.append(" AND		TEE.MNTE_ID = CL.MNTE_ID ");
			
			stmt = conn.prepareStatement(query.toString());
		
			rs = stmt.executeQuery();
			
			MyClassVO classVO = null;
			List<MyClassVO> classList = new ArrayList<MyClassVO>();
			
			while (rs.next()){
				classVO = new MyClassVO();
				
				classVO.setClassId(rs.getString("CLS_ID"));
				classVO.setStatus(rs.getString("STATUS"));
				classVO.getMenteeVO().setMenteeId(rs.getString("MNTE_ID"));
				classVO.getMentoVO().setMentoId(rs.getString("MNT_ID"));
				classVO.getMentoVO().setMentoName(rs.getString("TO_MNT_NM"));
				
				classList.add(classVO);
			}
			return classList;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			close(conn, stmt, rs);
		}
		
	}

	@Override
	public int updateClassInfo(String classId) {
		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" UPDATE	MYCLASS ");
			query.append(" SET		STATUS = ? " );
			query.append(" WHERE	CLS_ID = ? ");
			
			String sucess = "요청완료";
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, sucess);
			stmt.setString(2, classId);

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}
	}

	@Override
	public int deleteClass(String classId) {
		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" DELETE	FROM	MYCLASS ");
			query.append(" WHERE	CLS_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, classId);

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}
	}
	
	
	@Override
	public String generateNewClassId() {

		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();
			query.append(" SELECT  'CL-' || ");
			query.append("			TO_CHAR(SYSDATE, 'YYYYMMDDHH24') ||	");
			query.append("			'-' || ");
			query.append("			 LPAD(CLS_ID_SEQ.NEXTVAL, 6, '0') SEQ ");
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
	public List<MyClassVO> selectMentoClass(String mentoId) {
		oracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url,"MENTOS","mentos");
			
			StringBuffer query = new StringBuffer();
			
			query.append(" SELECT	MC.CLS_ID ");
			query.append("			, MC.STATUS  ");
			query.append("			, TEE.MNTE_ID ");
			query.append("			, TEE.MNTE_NM ");
			query.append("			, O.MNT_ID ");
			query.append("			, O.MNT_NM ");
			query.append(" FROM		MENTO O ");
			query.append(" 			, MENTEE TEE ");
			query.append(" 			, MYCLASS MC ");
			query.append(" WHERE	O.MNT_ID = MC.MNT_ID " );
			query.append(" AND		TEE.MNTE_ID = MC.MNTE_ID ");
			query.append(" AND		MC.MNT_ID = ? ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, mentoId);
			
			rs = stmt.executeQuery();
			
			MyClassVO classVO = null;
			List<MyClassVO> classList = new ArrayList<MyClassVO>();
			
			while (rs.next()){
				classVO = new MyClassVO();
				
				classVO.setClassId(rs.getString("CLS_ID"));
				classVO.setStatus(rs.getString("STATUS"));
				classVO.getMenteeVO().setMenteeId(rs.getString("MNTE_ID"));
				classVO.getMenteeVO().setMenteeName(rs.getString("MNTE_NM"));
				classVO.getMentoVO().setMentoId(rs.getString("MNT_ID"));
				classVO.getMentoVO().setMentoName(rs.getString("MNT_NM"));
				
				classList.add(classVO);
			}
			return classList;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			close(conn, stmt, rs);
		}
	}
	
	@Override
	public int modifyClassInfo(MyClassVO myClassVO) {
		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");

			StringBuffer query = new StringBuffer();

			query.append(" UPDATE	MYCLASS ");
			query.append(" SET		STATUS = ? ");
			query.append(" WHERE	CLS_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, myClassVO.getStatus());
			stmt.setString(2, myClassVO.getClassId());

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}
	}

	@Override
	public List<MyClassVO> selectMenteeClass(String menteeId) {
		oracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url,"MENTOS","mentos");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	CL.CLS_ID ");
			query.append("			, CL.STATUS  ");
			query.append("			, TEE.MNTE_ID ");
			query.append("			, O.MNT_ID  ");
			query.append("			, O.MNT_NM  TO_MNT_NM ");
			query.append("			, CT.CTGRY_NM ");
			query.append(" FROM		MENTO O ");
			query.append(" 			, MENTEE TEE");
			query.append(" 			, MYCLASS CL");
			query.append(" 			, CTGRY CT ");
			query.append(" WHERE	O.MNT_ID = CL.MNT_ID " );
			query.append(" AND		TEE.MNTE_ID = CL.MNTE_ID ");
			query.append(" AND		O.CTGRY_ID = CT.CTGRY_ID ");
			query.append(" AND		TEE.MNTE_ID = ? ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, menteeId);
			
			rs = stmt.executeQuery();
			
			MyClassVO classVO = null;
			List<MyClassVO> classList = new ArrayList<MyClassVO>();
			
			while (rs.next()){
				classVO = new MyClassVO();
				classVO.setClassId(rs.getString("CLS_ID"));
				classVO.setStatus(rs.getString("STATUS"));
				classVO.getMenteeVO().setMenteeId(rs.getString("MNTE_ID"));
				classVO.getMentoVO().setMentoId(rs.getString("MNT_ID"));
				classVO.getMentoVO().setMentoName(rs.getString("TO_MNT_NM"));
				classVO.getMentoVO().getCategoryVO().setCategoryName(rs.getString("CTGRY_NM"));
				classList.add(classVO);
			}
			return classList;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			close(conn, stmt, rs);
		}
	}
	
	@Override
	public List<MyClassVO> countMember() {
		
		oracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url,"MENTOS","mentos");
			StringBuffer query = new StringBuffer();
			                                                       
			query.append(" SELECT COUNT(STATUS) OK_COUNT      ");     
	  		query.append(" 					, CL.MNT_NM       ");
	  		query.append(" 					, O.CLMBR O_CLMBR ");                        
			query.append(" FROM    MYCLASS CL                 ");
			query.append(" 			, MENTO O                     ");       
			query.append(" WHERE    CL.MNT_ID = O.MNT_ID      ");
			query.append(" AND      STATUS IS NOT NULL        ");     
			query.append(" AND      STATUS IN ('요청완료')    ");     	     
			query.append(" GROUP BY STATUS, CL.MNT_NM, CLMBR  ");
			
	        stmt = conn.prepareStatement(query.toString());
	        rs = stmt.executeQuery();
			
	        MyClassVO classVO = null;
	        List<MyClassVO> valiList = new ArrayList<MyClassVO>();
			
			while(rs.next()){
				classVO = new MyClassVO(); 
				
				classVO.setCount(rs.getInt("OK_COUNT"));
				classVO.getMentoVO().setMentoName(rs.getString("MNT_NM"));
				classVO.getMentoVO().setMember(rs.getInt("O_CLMBR"));
				
				valiList.add(classVO);
			}
			return valiList;
			
		
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			close(conn, stmt, rs);
		}
	}
	@Override
	public List<MyClassVO> selectAllClassByStartDate() {
		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT  MNT_ID                      ");
			query.append("         , MNT_NM                    ");
			query.append("         , MNT_ADDR                  ");
			query.append("         , PHONE                     ");
			query.append("         , EMAIL                     ");
			query.append("         , CLMBR                     ");
			query.append("         , TO_CHAR(STR_DT) DT        ");
			query.append("         , COST                      ");
			query.append(" FROM    MENTO                       ");
			query.append(" WHERE   STR_DT >= SYSDATE  ");
			query.append(" ORDER   BY  STR_DT ASC			   ");

			stmt = conn.prepareStatement(query.toString());

			rs = stmt.executeQuery();

			MyClassVO classVO = null;
			List<MyClassVO> classList = new ArrayList<MyClassVO>();

			while (rs.next()) {
				classVO = new MyClassVO();
				classVO.getMentoVO().setMentoId(rs.getString("MNT_ID"));
				classVO.getMentoVO().setMentoName(rs.getString("MNT_NM"));
				classVO.getMentoVO().setMentoAddress(rs.getString("MNT_ADDR"));
				classVO.getMentoVO().setPhone(rs.getString("PHONE"));
				classVO.getMentoVO().setEmail(rs.getString("EMAIL"));
				classVO.getMentoVO().setMember(rs.getShort("CLMBR"));
				classVO.getMentoVO().setStartDate(rs.getString("DT"));
				classVO.getMentoVO().setCost(rs.getInt("COST"));
				classList.add(classVO);
			}
			return classList;

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}
	}

	@Override
	public int selectAcceptedMenteeCount(String mentoId) {
		oracleDriver();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();

			query.append(" SELECT COUNT(1) CNT                ");
			query.append(" FROM   (                           ");
			query.append("         SELECT *                   ");
			query.append("         FROM   MYCLASS             ");
			query.append("         WHERE  MNT_ID = ?		  ");
			query.append("         AND    STATUS = ?	 	  ");
			query.append("         )                          ");

			String status = "요청완료";

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, mentoId);
			stmt.setString(2, status);

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
	
	public void oracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}

	private void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
		try {
			if (rs != null){
				rs.close();
			}
		} catch (SQLException e1) {}
		try {
			if(stmt != null){
				stmt.close();
			}
		} catch (SQLException e) {}
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {}
	}


}
