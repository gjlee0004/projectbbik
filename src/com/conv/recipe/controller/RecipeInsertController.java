package com.conv.recipe.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conv.recipe.dao.RecipeDAO;
import com.conv.recipe.domain.Recipe;
import com.conv.util.MlecFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;


@WebServlet("/com/conv/recipe/controller/recipeinsertcontroller")
public class RecipeInsertController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		String upload = "C:/java97/Server-work/wtpwebapps/conv/upload";
		String path = new SimpleDateFormat("/yyyy/MM/dd/HH/").format(new Date());
		
		File f = new File(upload + path);
		
		if(f.exists()==false)f.mkdirs();
		MultipartRequest mRequest = new MultipartRequest(
				request , 
				upload + path, // 업로드할 디렉토리 경로. 
				1024*1024*30,  // 업로드할 최대 크기
				"utf-8" , //파라미터 인코딩 지정
//				new DefaultFileRenamePolicy(), // 같은 이름이 들어오면 숫자를 따서 이름에지정.
				new MlecFileRenamePolicy() // rename 안에 있는 메소드 호출.
				);
		
		String id=  (String)session.getAttribute("user");
		String title=  mRequest.getParameter("title");
		String content=  mRequest.getParameter("content");
		
		Recipe vo= new Recipe();
		vo.setId(id);
		vo.setTitle(title);
		vo.setContent(content);

		Enumeration<String> fNames = mRequest.getFileNames();
		while(fNames.hasMoreElements()) {
		//파일정보가 몇개라도 처리할수 있음.
		String fileName = fNames.nextElement();
		File file = mRequest.getFile(fileName);
		if(file != null) {
			String orgName = mRequest.getOriginalFileName(fileName);
			String systemName = mRequest.getFilesystemName(fileName);
			
			vo.setPhoto(path +systemName);
		
		}
		

		
		RecipeDAO dao = new RecipeDAO();		
		dao.insertRecipe(vo);
		
		
		response.sendRedirect("/conv/com/conv/recipe/controller/recipelistcontroller");	
		 }
		
	}
}
