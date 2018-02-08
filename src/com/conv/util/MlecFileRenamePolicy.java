package com.conv.util;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MlecFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File f) {
		String parent = f.getParent(); // 경로에서 file명을 뺀걸 가져온다. 즉 실제 파일이 저장될 경로를 가져옴
		String name = f.getName(); // file명을 가져온다. (사용자가 선택한 이름)
		// 확장자는 유지하고 파일의 이름부분을 변경.. 
		// 파일 이름 자체에 확장자가 없는 경우도 있음..
		
		// 사용자가 선택한 파일의 확장자만 가져오기
		String ext = "";
		int index = name.lastIndexOf(".");
		if(index != -1) {
			ext = name.substring(index);
		}
		// 유니크한 id값 뽑아내는 클래스
		String fName = UUID.randomUUID().toString();
		
		               //저장경로, 바꿀 이름 + 확장자
		return new File(parent, fName + ext);
	}

}
