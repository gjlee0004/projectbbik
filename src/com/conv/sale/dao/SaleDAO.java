package com.conv.sale.dao;


	

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.conv.sale.domain.Sale;
import com.conv.util.ConnectionPool;
import com.conv.util.JdbcUtil;

public class SaleDAO {

	
	public List<Sale> selectSale(){
		
		List<Sale> list = new ArrayList<>();		
		Connection con = null ;
		PreparedStatement stmt = null ;
		try {			
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select  productname, imageurl, price, event, convname ");
			sql.append("  from t97_sale ");
			stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Sale sale = new Sale();				
				
				sale.setProductName(rs.getString("productname"));
				sale.setImageURL(rs.getString("imageurl"));
				sale.setPrice(rs.getString("price"));
				sale.setEvent(rs.getString("event"));
				sale.setConvName(rs.getString("convname"));
				
				list.add(sale);	
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}	
		return list;
	}
	
	
}

