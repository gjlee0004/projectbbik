package com.conv.world.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conv.world.dao.WorldDAO;
import com.conv.world.domain.World;

@WebServlet("/conv/post")
public class WorldPostController extends HttpServlet {

	protected void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int no=  Integer.parseInt(request.getParameter("no"));

			WorldDAO dao= new WorldDAO();

			World post = dao.selectByNo(no);
			request.setAttribute("post", post);


			RequestDispatcher rd = request.getRequestDispatcher("/jsp/world/world_post.jsp");

			rd.forward(request, response);
	}
}
