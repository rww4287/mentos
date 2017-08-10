package com.ktds.mentos.review.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.mentos.review.vo.ReviewSearchVO;
import com.ktds.mentos.review.vo.ReviewVO;

public class ReviewDaoImpl implements ReviewDao {

	@Override
	public List<ReviewVO> selectAllReviews(ReviewSearchVO reviewSearchVO) {
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

			query.append(" SELECT  * "                                           );
			query.append(" FROM    ( "                                           );
			query.append("             SELECT  ROWNUM AS RNUM "                  );
			query.append("                     , A.* "                           );
			query.append("             FROM    ( "                               );
			query.append("						SELECT		REW_ID	");
			query.append("									,REW_TL	");
			query.append("									,REW_CNTET	");
			query.append("									,RTNG	");
			query.append("									,MNT_NM	");
			query.append("									,TO_CHAR(WRT_DT) WRTITE_DT ");
			query.append("									,MNTE_ID");
			query.append("									,MNT_ID");
			query.append("						FROM		REVIEW	");
			query.append("						ORDER		BY	REW_ID	DESC	");
			query.append("                     ) A "                             );
			query.append("             WHERE     ROWNUM <= ? "                     );
			query.append("         ) "                                           );
			query.append(" WHERE   RNUM >= ? "                                   );

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
				reviewVO.setReviewWriteDate(rs.getString("WRTITE_DT"));
				reviewList.add(reviewVO);
			}

			return reviewList;

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

	@Override
	public int selectAllReviewCount(ReviewSearchVO ReivewSearchVO) {
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
			query.append("	FROM	REVIEW	");


			stmt = conn.prepareStatement(query.toString());
		

			rs = stmt.executeQuery();

			if(rs.next()){
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

	@Override
	public int insertNewReview(ReviewVO reviewVO) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

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
			query.append("							,MNT_NM	");
			query.append("							,WRT_DT	");
			query.append("							,MNTE_ID");
			query.append("							,MNT_ID	");
			query.append("						)	");
			query.append("	VALUES				(	");
			query.append("							'RV-'||TO_CHAR(SYSDATE, 'YYYYMMDDHH24')||'-'||LPAD(REW_ID_SEQ.NEXTVAL,6,'0')	");
			query.append("							,?	");
			query.append("							,?	");
			query.append("							,?	");
			query.append("							,?	");
			query.append("							,TO_DATE(SYSDATE, 'YY-MM-DD:HH24')	");
			query.append("							,?	");
			query.append("							,?	");
			query.append("						)	");
			
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, reviewVO.getReviewTitle());
			stmt.setString(2, reviewVO.getReviewContent());
			stmt.setString(3, reviewVO.getReviewRating());
			stmt.setString(4, reviewVO.getMentoName());
//			stmt.setString(4, reviewVO.getReviewWriteDate());
			stmt.setString(5, reviewVO.getMenteeId());
			//심각: Servlet.service() for servlet [ViewReviewWriteServlet] in context with path [/mentos] threw exception
//			java.lang.RuntimeException: 인덱스에서 누락된 IN 또는 OUT 매개변수:: 6
			stmt.setString(6, reviewVO.getMentoId());
			
			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	@Override
	public ReviewVO selectOneReview(String reviewId) {
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
			

			query.append("						SELECT		REW_ID	");
			query.append("									,REW_TL	");
			query.append("									,REW_CNTET	");
			query.append("									,RTNG	");
			query.append("									,MNT_NM	");
			query.append("									,TO_CHAR(WRT_DT) WRITE_DT	");
			query.append("									,MNTE_ID	");
			query.append("						FROM		REVIEW	");
			query.append("						WHERE		REW_ID = ? ");
			query.append("						ORDER		BY	REW_ID	DESC	");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, reviewId);
			rs = stmt.executeQuery();

			ReviewVO reviewVO = null;
			if (rs.next()) {
				reviewVO = new ReviewVO();
				reviewVO.setReviewId(rs.getString("REW_ID"));
				reviewVO.setReviewTitle(rs.getString("REW_TL"));
				reviewVO.setReviewContent(rs.getString("REW_CNTET"));
				reviewVO.setReviewRating(rs.getString("RTNG"));
				reviewVO.setMentoName(rs.getString("MNT_NM"));
				reviewVO.setMenteeId(rs.getString("MNTE_ID"));
				reviewVO.setReviewWriteDate(rs.getString("WRITE_DT"));
			}

			return reviewVO;

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

	@Override
	public int deleteOneReview(String reviewId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.201.17:1521:XE", "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();
			query.append("	DELETE	FROM	REVIEW	");
			query.append("	WHERE	REW_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, reviewId);
			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
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

	@Override
	public int updateOneReview(ReviewVO reviewVO) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		Connection conn = null;
		PreparedStatement stmt = null;


		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.201.17:1521:XE", "MENTOS", "mentos");
			StringBuffer query = new StringBuffer();
			query.append("	UPDATE	REVIEW	");
			query.append("	SET		REW_TL = ? ");
			query.append("			,REW_CNTET = ? ");
			query.append("			,RTNG = ? ");
			query.append("			,MNT_NM = ? ");
			query.append("			,WRT_DT = TO_DATE(SYSDATE, 'YY-MM-DD') ");
			query.append("	WHERE	REW_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, reviewVO.getReviewTitle());
			
			stmt.setString(2, reviewVO.getReviewContent());
			stmt.setString(3, reviewVO.getReviewRating());
			stmt.setString(4, reviewVO.getMentoName());
			stmt.setString(5, reviewVO.getReviewId());

			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
		
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
