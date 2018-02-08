package com.conv.recipe.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conv.recipe.dao.RecipeDAO;
import com.conv.recipe.domain.Recipe;

@WebServlet("/com/conv/recipe/controller/recipe")
public class RecipeUdateSelectController extends HttpServlet{

	protected void service( HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
		
		int no=  Integer.parseInt(request.getParameter("no"));		
	
		RecipeDAO dao = new RecipeDAO();
		Recipe post= dao.detailUpdate(no);		
		
		request.setAttribute("post" , post);
		
	
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/recipe/recipe_update.jsp");		
		rd.forward(request, response);
//		
		
		
	}
	
}
