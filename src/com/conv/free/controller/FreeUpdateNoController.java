package com.conv.free.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conv.free.dao.FreeDAO;
import com.conv.free.domain.Free;


@WebServlet("/free/updateno")
public class FreeUpdateNoController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		FreeDAO dao = new FreeDAO();
		Free post = dao.selectBoardByNo(no);
		
		request.setAttribute("post", post);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/free/free_update.jsp");
		
		rd.forward(request, response);			
	}
}
