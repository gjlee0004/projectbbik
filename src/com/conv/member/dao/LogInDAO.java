package com.conv.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.conv.member.domain.Member;
import com.conv.util.ConnectionPool;

public class LogInDAO {
	public Member login(Member member) {
		// 반환받은 정보와 DB가 일치하는지 확인하여 회원정보 반환
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnectionPool.getConnection();

			StringBuffer sql = new StringBuffer();
			sql.append("select * from t97_member where id=? and pass=? ");

			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Member m = new Member();
				m.setId(rs.getString("id"));
				m.setPass(rs.getString("pass"));
				m.setEmail(rs.getString("email"));
				
				return m;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
	public void TryLogin(){
		// 로그인
		Scanner sc = new Scanner(System.in);
		Member m = new Member();
		
		System.out.println("로그인하세요.");
		System.out.print("아이디 : ");
		m.setId(sc.nextLine());
		System.out.print("비밀번호: ");
		m.setPass(sc.nextLine());
		LogInDAO dao = new LogInDAO();
		
		Member result = dao.login(m);
		String a = "잘못된 아이디나 비밀번호입니다.";
        if(result!=null) a=m.getId()+"님 환영합니다.";
        System.out.println(a);
        sc.close();
	}

public static boolean check(String id ) {
	Connection con = null;
	PreparedStatement pstmt = null;

	try {
		con = ConnectionPool.getConnection();

		StringBuffer sql = new StringBuffer();
		sql.append("select id from t97_member ");
		
		
		pstmt = con.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			if(rs.getString("id").equals(id)){
				return true;
			}
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		ConnectionPool.releaseConnection(con);
	}
	return false;

	
}


}
