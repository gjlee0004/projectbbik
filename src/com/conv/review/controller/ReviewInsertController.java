package com.conv.review.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conv.review.dao.ReviewDAO;
import com.conv.review.domain.Image;
import com.conv.review.domain.Review;
import com.conv.util.MlecFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;


@WebServlet("/review/insert")
public class ReviewInsertController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String upload ="C:/java97/server-work/wtpwebapps/conv/review_upload";
			String path = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date());
			
			// 해당 경로가 없는 경우 디렉토리 생성
			File f = new File(upload + path);
			if(!f.exists()) f.mkdirs();
			
			MultipartRequest mRequest = new MultipartRequest(
					request, 
					upload + path, // 업로드할 디렉토리 경로
					1024 * 1024 * 30, // 업로드 최대 사이즈
					"utf-8", // 파라미터 인코딩 지정
					new MlecFileRenamePolicy() // rename 이라는 메서드 호출
			);
			
			
			// 톰캣이 보는 경로에 업로드된 파일들을 저장하기로 함.
			// 특징 : a link 통해서 별도의 코드작업 없이 접근 가능.
			// http://localhost:8000/05_servletjsp/upload/%EC%82%BC%EA%B0%81%EA%B9%80%EB%B0%A5.jpg
			
			
			Enumeration<String> fNames = mRequest.getFileNames();
			
			HttpSession session = request.getSession();
			List<Image> list = new ArrayList<>();
			while(fNames.hasMoreElements()) {
				String fileName = fNames.nextElement();
				File file = mRequest.getFile(fileName);
				// 사용자가 파일을 첨부한 경우
				if(file != null) {
					Image image = new Image();
					image.setFilesize(String.valueOf(file.length()));
					image.setPath(path);
					image.setOrgName(mRequest.getOriginalFileName(fileName));
					image.setsName(mRequest.getFilesystemName(fileName));
					list.add(image);
				}
			}
			
			String title = mRequest.getParameter("title");
			String content = mRequest.getParameter("content");
			// 테스트용
			String writer = (String)session.getAttribute("user");
			
			Review review = new Review();
			
			// 사용자 id에 따라 자동입력
			review.setWriter(writer);
			// 사용자 입력
			review.setTitle(title);
			review.setContent(content);
			
			ReviewDAO dao = new ReviewDAO();
			dao.insertBoard(review, list);
			
			
			response.sendRedirect("/conv/review/list");
	}

}
