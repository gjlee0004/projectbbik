package com.conv.free.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conv.free.dao.FreeDAO;
import com.conv.free.domain.FreeReply;

@WebServlet("/free/replyinsert")
public class FreeReplyInsertController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response
							) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int no = Integer.parseInt(request.getParameter("no"));
		String writer = (String)session.getAttribute("user");
		String content = request.getParameter("content");
		
		FreeReply fr = new FreeReply();
		fr.settNo(no);
		fr.setWriter(writer);
		fr.setContent(content);
		
		FreeDAO dao = new FreeDAO();
		dao.insertBoardReply(fr);
		
		RequestDispatcher rd = request.getRequestDispatcher("/free/post");
		
		rd.forward(request, response);
	}
}
