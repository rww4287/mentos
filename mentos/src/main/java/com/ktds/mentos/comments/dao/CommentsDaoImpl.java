package com.ktds.mentos.comments.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ktds.mentos.comments.vo.CommentsVO;

public class CommentsDaoImpl implements CommentsDao {

	@Override
	public int insertNewComment(CommentsVO commentsVO) {
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
			query.append("	INSERT INTO	CMNTS	");
			query.append("						(	");
			query.append("							CMNT_ID ");
			query.append("							,MNTE_ID ");
			query.append("							,CMNT_CNTET	");
			query.append("							,CMNT_DT	");
			query.append("							,REW_ID	");
			query.append("						)	");
			query.append("	VALUES				(	");
			query.append(
					"							'CT-'||TO_CHAR(SYSDATE, 'YYYYMMDDHH24')||'-'||LPAD(CMNT_ID_SEQ.NEXTVAL,6,'0')	");
			query.append("							,?	");
			query.append("							,?	");
			query.append("							,TO_DATE(SYSDATE, 'YY-MM-DD:HH24')	");
			query.append("							,?	");
			query.append("						)	");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, commentsVO.getMenteeId());
			stmt.setString(2, commentsVO.getCommentContent());
			// stmt.setString(2, commentsVO.getCommentDate());
			stmt.setString(3, commentsVO.getReviewId());

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
	public int deleteOneComment(String commentId) {
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
			query.append("	DELETE	 FROM	CMNTS	");
			query.append("	WHERE	 CMNT_ID = ?	");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, commentId);

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
	public int updateOneComment(CommentsVO commentsVO) {
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
			query.append("	UPDATE	CMNTS	");
			query.append("	SET		CMNT_CNTET = ? ");
			query.append("			,CMNT_DT = TO_DATE(SYSDATE, 'YY-MM-DD') ");
			query.append("	WHERE	CMNT_ID = ? ");

			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, commentsVO.getCommentContent());
			stmt.setString(2, commentsVO.getCommentId());

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
	public List<CommentsVO> selectAllComments(String reviewId) {
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
			query.append("						SELECT		CT.CMNT_ID	");
			query.append("									,CT.MNTE_ID	");
			query.append("									,CT.CMNT_CNTET	");
			query.append("									,TO_CHAR(CT.CMNT_DT) COMMENT_DT ");
			query.append("									,CT.REW_ID	");
			query.append("						FROM		CMNTS CT	");
			query.append("									,REVIEW RV	");
			query.append("						WHERE		CT.REW_ID = RV.REW_ID	");
			query.append("						AND			CT.REW_ID = ? ");
			query.append("						ORDER		BY	CT.CMNT_ID	DESC	");
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, reviewId);
			rs = stmt.executeQuery();

			List<CommentsVO> commentsList = new ArrayList<CommentsVO>();
			CommentsVO commentsVO = null;
			while (rs.next()) {
				//여기서 안해주면 계속 똑같은거 하나만 출력됨
				commentsVO = new CommentsVO();
				commentsVO.setCommentContent(rs.getString("CMNT_CNTET"));
				commentsVO.setCommentDate(rs.getString("COMMENT_DT"));
				commentsVO.setCommentId(rs.getString("CMNT_ID"));
				commentsVO.setMenteeId(rs.getString("MNTE_ID"));
				commentsVO.setReviewId(rs.getString("REW_ID"));
				commentsList.add(commentsVO);
			}

			return commentsList;

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
	public CommentsVO selectOneComment(String commentId) {
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
			query.append("						SELECT		CMNT_ID	");
			query.append("									,MNTE_ID	");
			query.append("									,CMNT_CNTET	");
			query.append("									,CMNT_DT	");
			query.append("									,REW_ID	");
			query.append("						FROM		CMNTS	");
			query.append("						ORDER		BY	CMNT_ID	DESC	");
			stmt = conn.prepareStatement(query.toString());

			rs = stmt.executeQuery();

			CommentsVO commentsVO = null;
			if (rs.next()) {
				commentsVO = new CommentsVO();
				commentsVO.setCommentContent(rs.getString("CMNT_CNTET"));
				commentsVO.setCommentDate(rs.getString("CMNT_DT"));
				commentsVO.setCommentId(rs.getString("CMNT_ID"));
				commentsVO.setMenteeId(rs.getString("MNTE_ID"));
				commentsVO.setReviewId(rs.getString("REW_ID"));
			}

			return commentsVO;

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
