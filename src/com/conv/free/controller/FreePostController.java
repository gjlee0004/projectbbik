package com.conv.free.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.conv.free.dao.FreeDAO;
import com.conv.free.domain.Free;
import com.conv.free.domain.FreeReply;

@WebServlet("/free/post")
public class FreePostController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response
							) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		FreeDAO dao = new FreeDAO();
		dao.hitsCount(no);
		
		Free post = dao.selectBoardByNo(no);
		List<FreeReply> re = dao.selectBoardReply(no);
		
		request.setAttribute("post", post);
		request.setAttribute("re", re);
		
		RequestDispatcher rd
					= request.getRequestDispatcher("/jsp/free/free_post.jsp");
		
		rd.forward(request, response);
	}
}
