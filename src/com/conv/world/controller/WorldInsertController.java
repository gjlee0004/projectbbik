package com.conv.world.controller;

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

import com.conv.util.MlecFileRenamePolicy;
import com.conv.world.dao.WorldDAO;
import com.conv.world.domain.World;
import com.oreilly.servlet.MultipartRequest;


@WebServlet("/com/conv/world/controller/worldinsertcontroller")
public class WorldInsertController extends HttpServlet {

   @Override
	protected void service(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   	String upload = "C:/java97/server-work/wtpwebapps/conv";
		String path = new SimpleDateFormat("/yyyy/MM/dd/HH/").format(new Date());
		
		File f = new File(upload + path);
		if (!f.exists()) f.mkdirs();
		//if (f.exists() == false) f.mkdirs();
		
		MultipartRequest mRequest = new MultipartRequest(
				request,
				upload + path,  //업로드할 디렉토리 경로
				1024 * 1024 * 30,    // 업로드 최대 사이즈
				"utf-8", //파라미터 인코딩 지정
				new MlecFileRenamePolicy()  //rename 메서드 호출
		);
		HttpSession session = request.getSession();
		Enumeration<String> fNames = mRequest.getFileNames(); 
		while (fNames.hasMoreElements()) {
			String fileName = fNames.nextElement();
			File file = mRequest.getFile(fileName);
			String orgName = mRequest.getOriginalFileName(fileName);
			String systemName = mRequest.getFilesystemName(fileName);
			
			String id= (String)session.getAttribute("user");
			String title=  mRequest.getParameter("title");
	     String content=  mRequest.getParameter("content");
         String photo= mRequest.getParameter("photo");
	   
	   World vo = new World();
	    vo.setId(id);
	    vo.setContent(content);
	    vo.setTitle(title);
        vo.setPhoto(path+systemName);
	   
	   WorldDAO dao = new WorldDAO();
	   dao.insertWorld(vo);
	   response.sendRedirect("/conv/com/conv/world/controller/worldlistcontroller");	
	 
		}
   }
}