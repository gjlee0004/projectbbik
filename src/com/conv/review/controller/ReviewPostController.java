package com.conv.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conv.review.dao.ReviewDAO;
import com.conv.review.domain.Image;
import com.conv.review.domain.Reply;
import com.conv.review.domain.Review;

@WebServlet("/review/post")
public class ReviewPostController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		ReviewDAO dao = new ReviewDAO();
		Review post = dao.selectBoardByNo(no);
		List<Reply> reply = dao.selectReply(no);
		List<Image> image = dao.selectImage(no);
		int hit = post.getHit();
		post.setHit(++hit);
		dao.updateBoard(post);
		request.setAttribute("post", post);
		request.setAttribute("reply", reply);
		request.setAttribute("image", image);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/review/review_post.jsp");
		
		rd.forward(request, response);
		
	
	
	}
	
}
