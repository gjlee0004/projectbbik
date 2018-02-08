package com.conv.main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conv.free.domain.Free;
import com.conv.main.dao.MainDAO;
import com.conv.main.dao.SearchDAO;
import com.conv.member.dao.MemberDAO;
import com.conv.recipe.domain.Recipe;
import com.conv.review.domain.Review;
import com.conv.world.domain.World;

@WebServlet("/main/search")
public class SearchController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String keyword = request.getParameter("keyword");
		SearchDAO dao = new SearchDAO();

		HttpSession session = request.getSession();
		session.setAttribute("keyword", keyword);
		
		List<Review> reviewSearch = dao.reviewSearch(keyword);      
		List<Free> freeSearch = dao.freeSearch(keyword);      
		List<Recipe> recipeSearch = dao.recipeSearch(keyword);      
		List<World> worldSearch = dao.worldSearch(keyword);
		
		request.setAttribute("reviewSearch", reviewSearch);
		request.setAttribute("freeSearch", freeSearch);
		request.setAttribute("recipeSearch", recipeSearch);
		request.setAttribute("worldSearch", worldSearch);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/main/search.jsp");
		rd.forward(request, response);
	}
}

