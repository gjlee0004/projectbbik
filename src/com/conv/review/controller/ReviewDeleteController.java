package com.conv.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conv.review.dao.ReviewDAO;
import com.conv.review.domain.Review;


@WebServlet("/review/delete")
public class ReviewDeleteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		ReviewDAO dao = new ReviewDAO();
		dao.deleteBoard(no);
		
		response.sendRedirect("/conv/review/list");
	}
}
