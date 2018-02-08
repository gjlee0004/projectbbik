package com.conv.world.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.conv.review.domain.Review;
import com.conv.util.ConnectionPool;
import com.conv.util.JdbcUtil;
import com.conv.world.domain.World;


public class WorldDAO {
	
	int no=0;
	
	public List<World> selectWorld() {

		List<World> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select *");
			sql.append("	 from t97_world		");
			sql.append("	order by no desc		");
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				World world = new World();
				world.setId(rs.getString("id"));
				world.setTitle(rs.getString("title"));
				world.setNo(rs.getInt("no"));
				world.setContent(rs.getString("content"));
				world.setPhoto(rs.getString("photo"));

				list.add(world);
			}
			System.out.println(list);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	
	public World selectByNo(int no) {

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			   con = ConnectionPool.getConnection();
			   StringBuffer sql = new StringBuffer();
			   sql.append("	select *	");
			   sql.append("		from t97_world	");
			   sql.append("	where no =?");

			   pstmt = con.prepareStatement(sql.toString());			   
			   pstmt.setInt(1, no);
			   ResultSet rs = pstmt.executeQuery();

			   if(rs.next()) {
				   World world = new World();

				   world.setId(rs.getString("id"));
				   world.setTitle(rs.getString("title"));
				   world.setNo(rs.getInt("no"));
				   world.setContent(rs.getString("content"));
				   world.setPhoto(rs.getString("photo"));

				   return world;
			   }

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
	public void insertWorld(World world) {  //  등록
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			
			   StringBuffer sql = new StringBuffer();
			   sql.append("insert into t97_world(");
			   sql.append("	id,  title, no, content, photo");
			   sql.append(")  values  (");
			   sql.append(" ?,  ? ,s_world_no.nextval, ?, ?	 ");
			   sql.append(") ");
			   
			   pstmt = con.prepareStatement(sql.toString());
			   pstmt.setString(1, world.getId());
			   pstmt.setString(2, world.getTitle());
			   pstmt.setString(3, world.getContent());
			   pstmt.setString(4, world.getPhoto());
			   pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		  JdbcUtil.close(pstmt);
		  ConnectionPool.releaseConnection(con);
		}
		return;
	}

	public void updateWorld(World world) {   //수정
	
			Connection con = null;
			PreparedStatement pstmt=null;
			try {
				con = ConnectionPool.getConnection();
				StringBuffer sql = new StringBuffer();
			
					sql.append("update t97_world");
					sql.append("     set title = ?,   ");
					sql.append("			content = ?, " );
					sql.append("			photo = ? " );
					sql.append("			where no = ? " );
				
					pstmt = con.prepareStatement(sql.toString());
				
					pstmt.setString(1, world.getTitle());
					pstmt.setString(2, world.getContent());
					pstmt.setString(3, world.getPhoto());
					pstmt.setInt(4, world.getNo());
					pstmt.executeUpdate();
			
				}catch (Exception e) {
				e.printStackTrace();
				}finally {
					JdbcUtil.close(pstmt);
					ConnectionPool.releaseConnection(con);
				}
			return;
		}
	
	
	public boolean deleteWorld(int no) {
		Connection con = null;
		PreparedStatement pstmt=null;
		
		try {
			con = ConnectionPool.getConnection();
			
		   StringBuffer sql = new StringBuffer();
		   sql.append("delete ");
		   sql.append("  from t97_world  ");
		   sql.append("  where no = ?  ");
		   
		   pstmt = con.prepareStatement(sql.toString());
		  
		   pstmt.setInt(1, no);
		   
		   int cnt= pstmt.executeUpdate();
		   
		   if (cnt == 1) {
			   return true;
		   }
		   
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			  ConnectionPool.releaseConnection(con);
		}
		return false;			
}
}

