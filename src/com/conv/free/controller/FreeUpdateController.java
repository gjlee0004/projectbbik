package com.conv.free.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.conv.free.dao.FreeDAO;
import com.conv.free.domain.Free;

@WebServlet("/free/update")
public class FreeUpdateController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response
							) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String state = request.getParameter("state");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		FreeDAO dao = new FreeDAO();
		Free post = dao.selectBoardByNo(no);
		
		Free free = new Free();
		free.setNo(post.getNo());
		free.setState(state);
		free.setTitle(title);
		free.setContent(content);
		
		dao.updateBoard(free);
		
		response.sendRedirect("/conv/free/list");
	}
}
