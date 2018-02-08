package com.conv.review.controller;

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

import com.conv.util.MlecFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/review/uploadimage")
public class ReviewUploadImageController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// cos.jar를 이용한 파일 업로드 처리
		
		// Multi.. 클래스의 주요작업 (파일 업로드와 관련된 request 처리를 한다)
		// 파라미터 파싱 처리, 파일처리
		
		
		// 1. 파일 저장 경로 설정
		
		// tomcat server가 인식하는 실행위치
		// C:/java97/server-work/wtpwebapps/05_servletjsp/upload
		
		// 이클립스에서 소스 작성하는 위치
		// C:/java97/workspace/05_servletjsp/WebContent
		
		// 보통은 upload 폴더 밑에 다 넣지는 않음.. 그래서 하위폴더를 만든다..
		// upload/모듈명/년/월/일/시간
		// upload/review/2017/09/04/11 ..
		// 근데 여기서 upload 까지는 모든 모듈들의 공통 경로임.
		
		
		String upload ="C:/java97/server-work/wtpwebapps/05_servletjsp/upload";
//		String path = "/2017/09/04/11";
		String path = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date());
		
		// 해당 경로가 없는 경우 디렉토리 생성
		File f = new File(upload + path);
		if(!f.exists()) f.mkdirs();
		
		MultipartRequest mRequest = new MultipartRequest(
				request, 
				upload + path, // 업로드할 디렉토리 경로
				1024 * 1024 * 30, // 업로드 최대 사이즈
				"utf-8", // 파라미터 인코딩 지정
//				new DefaultFileRenamePolicy() // 같은 이름의 파일 이름 변경
				new MlecFileRenamePolicy() // rename 이라는 메서드 호출
		);
		// => request를 파싱해서 upload라는 위치에 사용자가 올린 파일을 저장시킨다.
		//	  파일의 크기는 최대 30메가 까지 받겠다
		
		// 파일의 이름을 바꿔서 저장할 때 어떻게 바꿀지 정책을 정해야함(기준을 정해야함)
		// cos에 이름 바꾸는 정책이 따로 있으니 일단 그걸 쓰겠다..
		
		
		// 톰캣이 보는 경로에 업로드된 파일들을 저장하기로 함.
		// 특징 : a link 통해서 별도의 코드작업 없이 접근 가능.
		// http://localhost:8000/05_servletjsp/upload/%EC%82%BC%EA%B0%81%EA%B9%80%EB%B0%A5.jpg
		
		System.out.println("파일 업로드 성공");
		
		// 날아오는 폼의 형태가 다르기 때문에 getParameter가 안됨..
		// 데이터 베이스에 필요 정보를 저장하기
		// 폼의 데이터 추출하기
		String msg = mRequest.getParameter("msg");
		System.out.println("요청 파라미터 정보");
		System.out.println("msg : " + msg);
		
		
		// 사용자가 파일을 업로드한 경우..
		// 파일 정보 저장하기.....
		// 실제 서버에 저장된 이름
		// 사용자가 올린 이름
		// 서버에 저장된 path 경로
		// 파일의 사이즈
		
//		// 사용자가 type="file" 부분에 첨부했는지 확인
//		// type="file" name="attachFile1" 을 통해 확인한다..
//		String fileName = "attachFile1";

		// 동적으로 name 가져오기..
		Enumeration<String> fNames = mRequest.getFileNames();
		
		while(fNames.hasMoreElements()) {
			String fileName = fNames.nextElement();
			File file = mRequest.getFile(fileName);
			// 사용자가 파일을 첨부한 경우
			if(file != null) {
				System.out.println("파일 사이즈 : " + file.length());
				System.out.println("파일 패스 : " + path);
				String orgName = mRequest.getOriginalFileName(fileName);
				System.out.println("사용자가 올린 파일 이름 : " + orgName);
				String systemName = mRequest.getFilesystemName(fileName);
				System.out.println("서버에 저장된 파일 이름 : " + systemName);
			}
		}
		
		
		
		
		/*
		// 파일 업로드의 경우 request.getParameter 메서드는 적용되지 않는다.
		// => 전송되는 포멧이 다르기 때문.. (이름=값 으로 날아와야하는데.. boundary 범위로 날아오기 때문)
		
		PrintWriter out = response.getWriter();
		
		String msg = request.getParameter("msg");
		out.println("msg : " + msg);
		
		out.close();
		*/
	}

/*	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면에서 넘어오는 파일의 데이터 형태를 파악
		
		// 클라이언트가 보낸 내용 중 바디에 있는 내용을 읽어온다.
		InputStream in = request.getInputStream();
		
		// 한줄씩 읽어오기 편하게..
		Scanner sc = new Scanner(in); 
		
		// 읽어온 다음 브라우저에 다시 보여주기 위해..
		PrintWriter out = response.getWriter();
		
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			out.println(line);
		}
		out.close();
	}
*/	
}
