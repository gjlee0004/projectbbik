package com.conv.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conv.member.dao.MemberDAO;
import com.conv.member.domain.Member;
import com.conv.util.ConnectionPool;
import com.conv.util.JdbcUtil;

@WebServlet("/jsp/member/signin")
public class MemberSigninController extends HttpServlet{
	Member member = new Member();
	MemberDAO dao = new MemberDAO();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		member.setId(request.getParameter("id"));
//		dao.signIn(member);
		
//		Member m = new Member();
		Connection con = null;
		PreparedStatement stmt = null;
		HttpSession session = request.getSession();
//		session.setAttribute("userId", "");

		try {
			System.out.println("dubchecked");
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			
			sql.append("select id ");
			sql.append("from t97_member ");
			sql.append("where id = ? ");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, request.getParameter("id"));
			
			int cnt = stmt.executeUpdate();
			
			if(cnt==1) {
				member.setId(null);
				session.setAttribute("idDup", request.getParameter("id")+"는 중복된 아이디입니다.");
				response.sendRedirect("/conv/jsp/member/signin.jsp");
			}else {
				session.setAttribute("idDup","사용가능한 아이디입니다.");
				session.setAttribute("userId", member.getId());
				response.sendRedirect("/conv/jsp/member/signin2.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		}

	}
//membercontroller
	
	
