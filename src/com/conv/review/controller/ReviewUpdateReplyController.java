package com.conv.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conv.review.dao.ReviewDAO;
import com.conv.review.domain.Reply;

@WebServlet("/review/updatereply")
public class ReviewUpdateReplyController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tNo = Integer.parseInt(request.getParameter("no"));
		int no = Integer.parseInt(request.getParameter("updateno"));
		String content = request.getParameter("content");
		
		// 테스트용
		String writer = request.getParameter("writer");
		
		Reply reply = new Reply();
		// 데이터 베이스 상에서 자동입력
		/*
		review.setNo(no);
		review.setRegDate(regDate);
		 */
		
		// 게시글 no에 따라 자동입력
		reply.settNo(tNo);
		// 사용자 id에 따라 자동입력
		reply.setWriter(writer);
		// 사용자 입력
		reply.setContent(content);
		
		ReviewDAO dao = new ReviewDAO();
		dao.updateReply(reply);
		
		RequestDispatcher rd = request.getRequestDispatcher("/review/post");
		
		rd.forward(request, response);
		
//		response.sendRedirect("/conv/review/post");
	}
}
