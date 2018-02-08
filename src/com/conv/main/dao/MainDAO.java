package com.conv.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.conv.free.domain.Free;
import com.conv.pb.domain.PB;
import com.conv.recipe.domain.Recipe;
import com.conv.review.domain.Review;
import com.conv.sale.domain.Sale;
import com.conv.util.ConnectionPool;
import com.conv.world.domain.World;

public class MainDAO {
	

	public List<Recipe> mainRecipe() {

		Connection con = null;
		PreparedStatement stmt = null;
		List<Recipe> recipeList = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select rownum, no, title, photo from (select * from t97_recipe order by no desc) ");
			sql.append("where rownum<=4  ");

			stmt = con.prepareStatement(sql.toString());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Recipe r = new Recipe();
				r.setNo(rs.getInt("no"));
				r.setTitle(rs.getString("title"));
				r.setPhoto(rs.getString("photo"));
				recipeList.add(r);
			}
			for(Recipe recipe : recipeList) {
				String s = recipe.getPhoto();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
		return recipeList;
	}

	public List<Review> mainReview() {
		Connection con = null;
		PreparedStatement stmt = null;
		List<Review> reviewList = new ArrayList<>();
		
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();

			sql.append("select rownum, no, title, writer, hit, reg_date from (select * from t97_review order by no desc) ");
			sql.append("where rownum<=4  ");

			stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Review r = new Review();
				r.setNo(rs.getInt("no"));
				r.setTitle(rs.getString("title"));
				r.setWriter(rs.getString("writer"));
				r.setHit(rs.getInt("hit"));
				r.setRegDate(rs.getDate("reg_date"));
				reviewList.add(r);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
		return reviewList;
	}
	
	public List<Free> mainFree(){
		Connection con = null;
		PreparedStatement stmt = null;
		List<Free> freeList = new ArrayList<>();
		
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();

			sql.append("select rownum, no, state, title, writer, reg_date from (select * from t97_free order by no desc) ");
			sql.append("where rownum<=4  ");

			stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Free f = new Free();
		
				f.setNo(rs.getInt("no"));
				f.setState(rs.getString("state"));
				f.setTitle(rs.getString("title"));
				f.setWriter(rs.getString("writer"));
				f.setRegDate(rs.getDate("reg_date"));
				freeList.add(f);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
		return freeList;	
		}
	
	
	public List<Sale> mainSale() {

		Connection con = null;
		PreparedStatement stmt = null;
		List<Sale> saleList = new ArrayList<>();
		
		try {
			Random r = new Random();
			int i = r.nextInt(100)+1;
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select b.* from ( ");
			sql.append("select rownum rnum, a.* from ( ");
			sql.append("select productname, imageurl, price, event  from t97_sale  ");
			sql.append(" order by price desc ) a ) b ");
			sql.append("where rnum between "+i+" and "+(i+5)+" ");
			// 랜덤선택 구문 추가 필요
			stmt = con.prepareStatement(sql.toString());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Sale sale = new Sale();
				sale.setProductName(rs.getString("productname"));
				sale.setImageURL(rs.getString("imageurl"));
				sale.setPrice(rs.getString("price"));
				sale.setEvent(rs.getString("event"));
				saleList.add(sale);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
		return saleList;
	}
	
	
	public List<PB> mainPB() {
		
		Connection con = null;
		PreparedStatement stmt = null;
		List<PB> PBList = new ArrayList<>();
		
		try {
			Random r = new Random();
			int i = r.nextInt(5)+1;
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select b.* from ( ");
			sql.append("select rownum rnum, a.* from ( ");
			sql.append("select productname, imageurl, price, convname from t97_pb  ");
			sql.append(" order by price desc ) a ) b ");
			sql.append("where rnum between "+i+" and "+(i+5)+" ");
			// 랜덤선택 구문 추가 필요
			stmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				PB pb = new PB();
				pb.setProductName(rs.getString("productname"));
				pb.setImageURL(rs.getString("imageurl"));
				pb.setPrice(rs.getString("price"));
				pb.setConvName(rs.getString("convname"));
				PBList.add(pb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
		return PBList;
	}

	
//	public String mainSale() {
//		
//		Connection con = null;
//		PreparedStatement stmt = null;
//		String result = "";
//		
//		try {
//			con = ConnectionPool.getConnection();
//			
//			StringBuffer sql = new StringBuffer();
//			sql.append("select photo from t97_sale ");
//			// 랜덤선택 구문 추가 필요
//			
//			stmt = con.prepareStatement(sql.toString());
//			
//			ResultSet rs = stmt.executeQuery();
//			List<Sale> list = new ArrayList<>();
//			while (rs.next()) {
//				
//				Sale sale = new Sale();
//				sale.setImageURL(rs.getString("photo"));
//				list.add(sale);
//				
//			}
//			for (Sale sale : list) {
//				result += sale.getImageURL()+"<br>";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			ConnectionPool.releaseConnection(con);
//		}
//		return result;
//	}

	public List<World> mainWorld() {

		Connection con = null;
		PreparedStatement stmt = null;
		List<World> worldList = new ArrayList<>();
		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select rownum, title, photo from (select * from t97_world order by no desc) ");
			sql.append("where rownum<=4  ");

			stmt = con.prepareStatement(sql.toString());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				World w = new World();
				w.setTitle(rs.getString("title"));
				w.setPhoto(rs.getString("photo"));
				worldList.add(w);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
		return worldList;
	}
	

	public String reviewSearch(String keyword) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		String reviewSearchList = "";
		
		try {
			con = ConnectionPool.getConnection();
			//review게시판의 content, title, writer에서 일치하는 부분이 있는지 검색
				StringBuffer sql = new StringBuffer();
				sql.append("select * from t97_review ");
				sql.append("where content like '%"+keyword+"%'  ");
				sql.append("or title like '%"+keyword+"%'  ");
				sql.append("or writer like '%"+keyword+"%'  ");
				stmt = con.prepareStatement(sql.toString());
				
				ResultSet rs = stmt.executeQuery();
				List<Review> reviewSearch = new ArrayList<>();
				while (rs.next()) {
					
					Review r = new Review();
					r.setNo(rs.getInt("no"));
					reviewSearch.add(r);
					
				}
				for (Review review : reviewSearch) {
					reviewSearchList += review.getNo()+"<br>";
					System.out.println(review.getNo()); 
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
		return reviewSearchList;
	}
}
	
