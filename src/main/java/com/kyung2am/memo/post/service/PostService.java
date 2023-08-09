package com.kyung2am.memo.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kyung2am.memo.common.FileManger;
import com.kyung2am.memo.post.domain.Post;
import com.kyung2am.memo.post.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	public int addPost(int userID, String title, String content, MultipartFile file) {
		
		// 파일을 특정 경로에 저장
		// 저장된 파일을 클라이언트에서 접근할 수 있는 경로를 얻어 낸다.
		String imagePath = FileManger.saveFile(userID, file);
		
		// 접근 경로를 table에 저장한다.
		
		
		return postRepository.insertPost(userID, title, content, imagePath);
	}
	
	public List<Post> getPostList(int UserId) {
		
		return postRepository.selectPostList(UserId);
	}
	
	public Post getPost(int id) {
		return postRepository.selectPost(id);
	}
	
}
