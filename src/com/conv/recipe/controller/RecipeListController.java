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

@WebServlet("/com/conv/recipe/controller/recipelistcontroller")
public class RecipeListController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RecipeDAO dao = new RecipeDAO();
		List<Recipe> list =dao.selectRecipe();
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/recipe/recipe_list.jsp");		
		rd.forward(request, response);
		
	}

}
