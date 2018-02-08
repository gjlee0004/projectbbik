package com.conv.recipe.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conv.recipe.dao.RecipeDAO;
import com.conv.recipe.domain.Recipe;


@WebServlet("/com/conv/recipe/controller/recipedelcontroller")
public class RecipeDelController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		request.setAttribute("no", no);	
		
		Recipe vo= new Recipe();
		vo.setNo(no);
		
		RecipeDAO dao = new RecipeDAO();
		dao.deleteRecipe(no);
		
		response.sendRedirect("/conv/com/conv/recipe/controller/recipelistcontroller");
		
		
	
		
		
	}
	
	


	
	
}
