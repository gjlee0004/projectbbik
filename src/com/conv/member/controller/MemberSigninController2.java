package com.conv.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conv.member.dao.MemberDAO;
import com.conv.member.domain.Member;

@WebServlet("/jsp/member/signin2")
public class MemberSigninController2 extends HttpServlet {
	Member member = new Member();
	MemberDAO dao = new MemberDAO();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		member.setId(session.getAttribute("userId"));
		member.setPass(request.getParameter("pass"));
		member.setPasshint(request.getParameter("passhint"));
		member.setEmail(request.getParameter("email"));
		dao.signIn(member);

		
		System.out.println("signined");

		session.setAttribute("welcome", "가입을 환영합니다. 로그인해주세요.");
		response.sendRedirect("/conv/main");
	}

}
// membercontroller
