package com.conv.free.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.conv.free.domain.Free;
import com.conv.free.domain.FreeReply;
import com.conv.util.ConnectionPool;
import com.conv.util.JdbcUtil;

public class FreeDAO {
	// 페이징 처리한 리스트
	public List<Free> selectBoardPaging(int pNum) {
		List<Free> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select b.* ");
			sql.append("  from (select rownum rnum, ");
			sql.append("	no, state, title, writer, reg_date, hits ");
			sql.append("  from (select * ");
			sql.append("  from t97_free ");
			sql.append(" order by no desc) a ) b ");
			sql.append(" where rnum between ? and ? ");
			
			stmt = con.prepareStatement(sql.toString());
			int cnt = selectAllBoard().size();
			stmt.setInt(1, 8*pNum - 7);
			if ( 8*pNum <= cnt) {
				stmt.setInt(2, 8*pNum);
			}
			else {
				stmt.setInt(2, cnt);
			}
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Free free = new Free();
				free.setNo(rs.getInt("no"));
				free.setState(rs.getString("state"));
				free.setTitle(rs.getString("title"));
				free.setWriter(rs.getString("writer"));
				free.setRegDate(rs.getDate("reg_date"));
				free.setHits(rs.getInt("hits"));
				list.add(free);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	// 전체 목록 리스트
	public List<Free> selectAllBoard() {
		List<Free> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from t97_free ");
			
			stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Free free = new Free();
				free.setNo(rs.getInt("no"));
				free.setState(rs.getString("state"));
				free.setTitle(rs.getString("title"));
				free.setWriter(rs.getString("writer"));
				free.setRegDate(rs.getDate("reg_date"));
				free.setHits(rs.getInt("hits"));
				list.add(free);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	// 조회수 올리기
		public void hitsCount(int no) {
			Connection con = null;
			PreparedStatement stmt = null;
			
			try {
				con = ConnectionPool.getConnection();
				
				StringBuffer sql = new StringBuffer();
				sql.append("update t97_free ");
				sql.append("   set hits = hits+1 ");
				sql.append(" where no = ? ");
				
				stmt = con.prepareStatement(sql.toString());
				stmt.setInt(1, no);
				stmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(stmt);
				ConnectionPool.releaseConnection(con);
			}
		}
		
	// 상세 페이지
	public Free selectBoardByNo(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select no, state, title, content, ");
			sql.append("	   writer, reg_date, hits, image ");
			sql.append("  from t97_free ");
			sql.append(" where no like ? ");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Free free = new Free();
				free.setNo(rs.getInt("no"));
				free.setState(rs.getString("state"));
				free.setTitle(rs.getString("title"));
				free.setContent(rs.getString("content"));
				free.setWriter(rs.getString("writer"));
				free.setRegDate(rs.getTimestamp("reg_date"));
				free.setHits(rs.getInt("hits"));
				free.setImage(rs.getString("image"));
				
				return free;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	// 글 등록
	public void insertBoard(Free free) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("insert into t97_free ");
			sql.append(" (no, state, title, content, writer, hits, reg_date, image) ");
			sql.append("values ");
			sql.append(" (s_free_no.nextval, ?, ?, ?, ?, 0, sysdate, ?) ");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, free.getState());
			stmt.setString(2, free.getTitle());
			stmt.setString(3, free.getContent());
			stmt.setString(4, free.getWriter());
			stmt.setString(5, free.getImage());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	// 글 수정
	public void updateBoard(Free free) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("update t97_free ");
			sql.append("   set state = ?, ");
			sql.append("       title = ?, ");
			sql.append("       content = ? ");
			sql.append(" where no = ? ");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, free.getState());
			stmt.setString(2, free.getTitle());
			stmt.setString(3, free.getContent());
			stmt.setInt(4, free.getNo());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	// 글 삭제
	public boolean deleteBoard(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("delete ");
			sql.append("  from t97_free ");
			sql.append(" where no = ? ");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			int cnt = stmt.executeUpdate();
			
			if (cnt == 0) return false;
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return false;
	}
	// 게시글 內 댓글 목록
	public List<FreeReply> selectBoardReply(int tNo) {
		List<FreeReply> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("select content, writer, reg_date, no ");
			sql.append("  from t97_free_reply ");
			sql.append(" where t_no = ? ");
			sql.append(" order by reg_date ");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, tNo);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				FreeReply fr = new FreeReply();
				fr.setContent(rs.getString("content"));
				fr.setWriter(rs.getString("writer"));
				fr.setRegDate(rs.getTimestamp("reg_date"));
				fr.setNo(rs.getInt("no"));
				list.add(fr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	// 댓글 등록
	public void insertBoardReply(FreeReply fr) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("insert into t97_free_reply ");
			sql.append(" (t_no, no, writer, content, reg_date) ");
			sql.append("values ");
			sql.append(" (?, s_free_reply_no.nextval, ?, ?, sysdate) ");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, fr.gettNo());
			stmt.setString(2, fr.getWriter());
			stmt.setString(3, fr.getContent());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	// 댓글 수정
	public void updateBoardReply(FreeReply fr) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("update t97_free_reply ");
			sql.append("   set content = ? ");
			sql.append(" where no = ? ");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, fr.getContent());
			stmt.setInt(2, fr.getNo());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	// 댓글 삭제
	public boolean deleteBoardReply(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("delete ");
			sql.append("  from t97_free_reply ");
			sql.append(" where no = ? ");

			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			int cnt = stmt.executeUpdate();
			
			if (cnt == 0) return false;
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return false;
	}
}
