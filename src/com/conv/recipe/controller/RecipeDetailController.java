package com.conv.recipe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conv.recipe.dao.RecipeDAO;
import com.conv.recipe.domain.Recipe;

@WebServlet("/conv/detail")
public class RecipeDetailController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no=  Integer.parseInt(request.getParameter("no"));		
		
		RecipeDAO dao = new RecipeDAO();
		Recipe post= dao.detailUpdate(no);
		
		request.setAttribute("post", post);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/recipe/detail.jsp");		
		rd.forward(request, response);
	}

}
