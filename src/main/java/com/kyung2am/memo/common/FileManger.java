package com.kyung2am.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManger {

	private static final String FILE_UPLOAD_PATH = "D:\\kyung2am\\springProject\\upload\\memo";
	
	// 파일 저장 -> 경로 리턴
	public static String saveFile(int userId, MultipartFile file) {
		
		// 같은 이름의 파일이 구분되어서 저장되도록 구성
		// 폴더를 만들어서 파일을 저장
		// userID 값을 폴더 이름에 포함
		// 시간정보를 폴더이름에 포함
		// UNIX TIME : 1970년 1월 1일 부터 흐른 시간을 milli second로 표현한 방식
		// 폴더이름 예시 : 10_24654654569456
		
		String directoryName = "/" + userId + "_" + System.currentTimeMillis() + "/";
		
		// 폴더 생성 (디렉토리생성)
		String directoryPath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(directoryPath);
		
		if(!directory.mkdir()) {
			// 디렉토리 생성 실패
			return null;
		}
		
		// 파일 저장
		try {
			byte[] bytes = file.getBytes();
			
			String filePath = directoryPath + file.getOriginalFilename();
			
			Path path = Paths.get(filePath);
			
			Files.write(path, bytes);
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
			// 파일 저장 실패
			return null;
		}
		
		// 클라이언트에서 접근하는 경로 문자열
		// 경로 규칙 : /images/10_1123123213/test.png
		
		return "/images" + directoryName + file.getOriginalFilename();
		
	}
	
}
