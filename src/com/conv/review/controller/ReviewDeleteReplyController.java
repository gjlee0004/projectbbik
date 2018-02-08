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

@WebServlet("/review/deletereply")
public class ReviewDeleteReplyController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("deleteno"));
		System.out.println(no);
		ReviewDAO dao = new ReviewDAO();
		dao.deleteReply(no);
		
		RequestDispatcher rd = request.getRequestDispatcher("/review/post");
		
		rd.forward(request, response);
		
//		response.sendRedirect("/conv/review/post");
	}
}
