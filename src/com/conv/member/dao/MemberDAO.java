package com.conv.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.conv.member.controller.MemberSigninController;
import com.conv.member.domain.Member;
import com.conv.util.ConnectionPool;
import com.conv.util.JdbcUtil;

public class MemberDAO {
	public void signIn(Member member) {
		
		//가입정보를 받아 DB에 저장
		List<Member> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			
			sql.append("insert into t97_member(id, pass, email, passhint) ");
			sql.append("values(?, ?, ?, ?) ");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPass());
			stmt.setString(3, member.getEmail());
			stmt.setString(4, member.getPasshint());
			
			list.add(member);
			int cnt = stmt.executeUpdate();
			if (cnt==1) {
				System.out.println("회원가입 완료");
//				MemberSigninController msc = new MemberSigninController();
			
			}else {System.out.println("회원가입 실패");}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}

    public int login(String id, String pass) {
 
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        String dbPW = "";
        int result = -1;
 
        try {
        	StringBuffer sql = new StringBuffer();
        	sql.append("select pass from t97_member where id= ? ");
 
        	con = ConnectionPool.getConnection();
        	pstmt = con.prepareStatement(sql.toString());
        	pstmt.setString(1, id);
        	rs = pstmt.executeQuery();
        	
        	if (rs.next()) {
        		dbPW = rs.getString("pass");
        		System.out.println(pass);
        		System.out.println(dbPW);
        		if (pass.equals(dbPW)) {
        			System.out.println(dbPW+" 로그인성공");
        			result = 1;
        		}else {
        			result = 0;
        		}        		
        	}else {
        		result = -1;
        	}
        	return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	
            ConnectionPool.releaseConnection(con);
    		JdbcUtil.close(pstmt);
        }
        return result;
    }

	

}

