package com.conv.world.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conv.world.dao.WorldDAO;
import com.conv.world.domain.World;

@WebServlet("/com/conv/world/controller/worlddelcontroller")

public class WorldDelController  extends HttpServlet {
	
	   
	   @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      int no = Integer.parseInt(request.getParameter("no"));      
	      World vo= new World();
	      vo.setNo(no);
	      
	      WorldDAO dao = new WorldDAO();
	      dao.deleteWorld(no);
	      
	      response.sendRedirect("/conv/com/conv/world/controller/worldlistcontroller");
	      
	   }     
  }
	   
	  
