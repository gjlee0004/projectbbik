package com.conv.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.conv.free.domain.Free;
import com.conv.recipe.domain.Recipe;
import com.conv.review.domain.Review;
import com.conv.util.ConnectionPool;
import com.conv.world.domain.World;

public class SearchDAO {
	public List<Review> reviewSearch(String keyword) {

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConnectionPool.getConnection();
			// review게시판의 content, title, writer에서 일치하는 부분이 있는지 검색
			StringBuffer sql = new StringBuffer();
			sql.append("select * from t97_review ");
			sql.append("where content like '%" + keyword + "%'  ");
			sql.append("or title like '%" + keyword + "%'  ");
			stmt = con.prepareStatement(sql.toString());

			ResultSet rs = stmt.executeQuery();
			List<Review> reviewSearch = new ArrayList<>();
			while (rs.next()) {

				Review r = new Review();
				r.setNo(rs.getInt("no"));
				r.setTitle(rs.getString("title"));
				r.setContent(rs.getString("content"));
				r.setWriter(rs.getString("writer"));
				r.setRegDate(rs.getDate("reg_Date"));
				reviewSearch.add(r);

			}
			return reviewSearch;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	public List<Free> freeSearch(String keyword) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			// review게시판의 content, title, writer에서 일치하는 부분이 있는지 검색
			StringBuffer sql = new StringBuffer();
			sql.append("select * from t97_free ");
			sql.append("where title like '%" + keyword + "%'  ");
			stmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = stmt.executeQuery();
			List<Free> freeSearch = new ArrayList<>();
			while (rs.next()) {
				
				Free f = new Free();
				f.setNo(rs.getInt("no"));
				f.setTitle(rs.getString("title"));
				f.setContent(rs.getString("content"));
				f.setWriter(rs.getString("writer"));
				f.setRegDate(rs.getDate("reg_Date"));
				freeSearch.add(f);
				return freeSearch;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
	public List<Recipe> recipeSearch(String keyword) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select no, title from t97_recipe ");
			sql.append("where title like '%" + keyword + "%'  ");
			stmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = stmt.executeQuery();
			List<Recipe> recipeSearch = new ArrayList<>();
			while (rs.next()) {
				
				Recipe re = new Recipe();
				re.setNo(rs.getInt("no"));
				re.setTitle(rs.getString("title"));
				recipeSearch.add(re);
				return recipeSearch;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
	public List<World> worldSearch(String keyword) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select no, title from t97_world ");
			sql.append("where title like '%" + keyword + "%'  ");
			sql.append("or content like '%" + keyword + "%'  ");
			stmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = stmt.executeQuery();
			List<World> worldSearch = new ArrayList<>();
			while (rs.next()) {
				
				World w = new World();
				w.setNo(rs.getInt("no"));
				w.setTitle(rs.getString("title"));
				worldSearch.add(w);
				return worldSearch;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}

}
