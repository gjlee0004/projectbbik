package com.conv.world.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conv.world.dao.WorldDAO;
import com.conv.world.domain.World;

@WebServlet("/com/conv/world/controller/worldupdatecontroller")
public class WorldUpdateController extends HttpServlet{

   
   @Override
   public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	      int no=  Integer.parseInt(request.getParameter("no"));
	      String title=  request.getParameter("title");
	      String content=  request.getParameter("content");

	      WorldDAO dao = new WorldDAO();	      
	      
	      
	      
	      World vo= dao.selectByNo(no);
	      vo.setContent(content);
	      vo.setTitle(title);
	      
	      dao.updateWorld(vo);
	      
	      
	      	response.sendRedirect("/conv/com/conv/world/controller/worldlistcontroller");
	      
      
   }
   
}