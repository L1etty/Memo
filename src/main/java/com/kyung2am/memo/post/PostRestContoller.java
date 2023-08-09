package com.kyung2am.memo.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kyung2am.memo.post.service.PostService;

@RestController
@RequestMapping("/post")
public class PostRestContoller {

	@Autowired
	private PostService postService;
	
	@PostMapping("/create")
	public Map<String, String> memoCreate(
				@RequestParam("title") String title
				,@RequestParam("content") String content
				,@RequestParam(value = "file", required = false) MultipartFile file
				,HttpSession session
			) {
		
		// 로그인된 사용자의 user id
		
		int userId = (Integer)session.getAttribute("userId");
		
		int count = postService.addPost(userId, title, content, file);
		
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	
}
