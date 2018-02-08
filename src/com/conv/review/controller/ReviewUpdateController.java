package com.conv.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conv.review.dao.ReviewDAO;
import com.conv.review.domain.Review;


@WebServlet("/review/update")
public class ReviewUpdateController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		ReviewDAO dao = new ReviewDAO();
		Review post = dao.selectBoardByNo(no);
		
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		// 사용자 입력
		post.setNo(post.getNo());
		post.setTitle(title);
		post.setContent(content);
		post.setWriter(post.getWriter());
		post.setHit(post.getHit());
		post.setRegDate(post.getRegDate());
		
		dao.updateBoard(post);
		response.sendRedirect("/conv/review/list");
		
	}

}
