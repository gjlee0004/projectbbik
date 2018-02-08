package com.conv.free.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conv.free.dao.FreeDAO;
import com.conv.free.domain.Free;
import com.conv.util.MlecFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/free/insert")
public class FreeInsertController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response
							) throws ServletException, IOException {
		String upload = "C:/java97/server-work/wtpwebapps/conv/free_upload";
		String path = new SimpleDateFormat("/yyyy/MM/dd/HH/").format(new Date());
		
		File f = new File(upload + path);
		if (!f.exists()) f.mkdirs();
		MultipartRequest mRequest = new MultipartRequest(
				request,
				upload + path,
				1024*1024*30,
				"utf-8",
				new MlecFileRenamePolicy()
		);
		
		Enumeration<String> fNames = mRequest.getFileNames();
		HttpSession session = request.getSession();
		
		String state = mRequest.getParameter("state");
		String writer = (String)session.getAttribute("user");
		String title = mRequest.getParameter("title");
		String content = mRequest.getParameter("content");
		
		Free free = new Free();
		free.setState(state);
		free.setWriter(writer);
		free.setTitle(title);
		free.setContent(content);
		
		while (fNames.hasMoreElements()) {
			String fileName = fNames.nextElement();
			File file = mRequest.getFile(fileName);
			if (file != null) {
				String orgName = mRequest.getOriginalFileName(fileName);
				String systemName = mRequest.getFilesystemName(fileName);

				free.setImage(path + systemName);
			}
		}
				
		FreeDAO dao = new FreeDAO();
		dao.insertBoard(free);
				
		response.sendRedirect("/conv/free/list");
	}
}
