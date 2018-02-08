package com.conv.pb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conv.pb.dao.PBDAO;
import com.conv.pb.domain.PB;

@WebServlet("/pb/list")
public class PBListController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PBDAO dao = new PBDAO();
		List<PB> list = null;
			list = dao.selectPB();
				
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/pb/pb_list.jsp");
		
		rd.forward(request, response);
		
	
	
	}
	
}
