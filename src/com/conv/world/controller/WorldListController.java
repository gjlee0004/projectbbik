package com.conv.world.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conv.world.dao.WorldDAO;
import com.conv.world.domain.World;

@WebServlet("/com/conv/world/controller/worldlistcontroller")
public class WorldListController extends HttpServlet{

	@Override
	protected void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WorldDAO dao = new WorldDAO();
		List<World> list = dao.selectWorld();
		//System.out.println(list);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher(
				"/jsp/world/world_list.jsp"
				);
			rd.forward(request, response);
	}
	
}
