package com.conv.free.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.conv.free.dao.FreeDAO;

@WebServlet("/free/delete")
public class FreeDeleteController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response
							) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));

		FreeDAO dao = new FreeDAO();
		dao.deleteBoard(no);

		response.sendRedirect("/conv/free/list");
	}
}
