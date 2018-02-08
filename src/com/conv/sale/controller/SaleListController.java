package com.conv.sale.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conv.sale.dao.SaleDAO;
import com.conv.sale.domain.Sale;

@WebServlet("/sale/list")
public class SaleListController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		SaleDAO dao = new SaleDAO();
		List<Sale> list = null;
			list = dao.selectSale();
				
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/sale/sale_list.jsp");
		
		rd.forward(request, response);
		
	
	
	}
	
}
