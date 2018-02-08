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


@WebServlet("/com/conv/recipe/controller/recipeupdatecontroller")
public class RecipeUpdateController extends HttpServlet{

	@Override
	protected void service( HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
		
		int no=  Integer.parseInt(request.getParameter("no"));			
		String title=  request.getParameter("title");
		String content=  request.getParameter("content");
//		String photo=  request.getParameter("photo");
	
		RecipeDAO dao = new RecipeDAO();
		Recipe recipe= dao.detailUpdate(no);		


		request.setAttribute("no", recipe.getNo());
		request.setAttribute("title", recipe.getTitle());
		request.setAttribute("content", recipe.getContent());
//		request.setAttribute("photo", recipe.getPhoto());

		recipe.setNo(no);
//		recipe.setPhoto(photo);
		recipe.setContent(content);
		recipe.setTitle(title);	
		
		dao.updateRecipe(recipe);
		
//		response.sendRedirect("/conv/com/conv/recipe/controller/recipelistcontroller");		
		
	
		RequestDispatcher rd = request.getRequestDispatcher("/com/conv/recipe/controller/recipelistcontroller");		
		rd.forward(request, response);

	}
	
}
