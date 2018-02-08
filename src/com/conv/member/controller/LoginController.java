package com.conv.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conv.member.dao.MemberDAO;
import com.conv.member.domain.Member;

@WebServlet("/member/login")
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Member member = new Member();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 들어올 파라미터를 한글로 쓸 수 있도록 함
		request.setCharacterEncoding("utf-8");

		
		// 받아온 파라미터를 vo객체에 담기
		String id = request.getParameter("id");
		String password = request.getParameter("pass");
		member.setId(id);
		member.setPass(password);

		MemberDAO dao = new MemberDAO();
		// 로그인 판정
		int check = dao.login(id, password);
		System.out.println(check);
		System.out.println("입력한아이디 "+id);
		System.out.println("입력한비번 "+password);
//		boolean b = LogIn.login(id, password);
		
		// 성공시 메인으로 보내고 세션에 사용자 정보 저장
		String page = "/main";
		if(check == 1) {	
			HttpSession session = request.getSession();
//			SimpleDateFormat sdf = new SimpleDateFormat(
//					"yyyy-MM-dd HH:mm:ss"
//					);
//			member.setAccessTime(sdf.format(new Date()));
			session.setAttribute("user", id);
			request.setAttribute("logined",id+"님 환영합니다.");
		
		}else if(check==0){	
			request.setAttribute("error","비밀번호를 잘못 입력하셨습니다.");
			page = "/jsp/member/login.jsp";
		}else { //check==-1
			request.setAttribute("error", "아이디를 잘못 입력하셨습니다.");
			page = "/jsp/member/login.jsp";
		}
		RequestDispatcher rd = 
				request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
//membercontroller
	
	
}