package com.conv.free.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conv.free.dao.FreeDAO;
import com.conv.free.domain.Free;
import com.conv.free.domain.FreeReply;

@WebServlet("/free/replyupdate")
public class FreeReplyUpdateController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response
							) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String content = request.getParameter("content");

		FreeDAO dao = new FreeDAO();
		
		FreeReply fr = new FreeReply();
		fr.setNo(no);
		fr.setContent(content);
		
		dao.updateBoardReply(fr);
		
		response.sendRedirect("/conv/free/post");
	}
}
