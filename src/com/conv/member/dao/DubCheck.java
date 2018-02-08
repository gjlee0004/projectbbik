package com.conv.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.conv.member.domain.Member;
import com.conv.util.ConnectionPool;
import com.conv.util.JdbcUtil;

public class DubCheck {
	
	public boolean dubCheck(String id){
	Member m = new Member();
	Connection con = null;
	PreparedStatement stmt = null;
	
	
	try {
		System.out.println("dubchecked");
		con = ConnectionPool.getConnection();
		StringBuffer sql = new StringBuffer();
		
		sql.append("select id ");
		sql.append("from t97_member ");
		sql.append("where id = ? ");
		
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1, id);
		
		int cnt = stmt.executeUpdate();
		
		if(cnt==1) {
			m.setId(null);
			return true;
		}else {
			return false;
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JdbcUtil.close(stmt);
		ConnectionPool.releaseConnection(con);
	}
	return false;
	}
}
